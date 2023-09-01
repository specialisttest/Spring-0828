package ru.specialist.building;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
//@ComponentScan("ru.specialist.building")
@PropertySource("house.properties")
//@EnableTransactionManagement // transaction support (db)
//@EnableWebMvc // web mvc support
public class BuilderConfig {

	//@Value("${house.height}")
	//private int houseHeight;
	
	@Autowired
	private Environment env;
	
	@Bean // id = bricks
	@Scope("prototype")
	public Material bricks() {
		return new Brick();
	}
	
	@Bean("mybrick")
	@Scope("prototype")
	public Material myBricks() {
		return new Brick();
	}
	
	@Bean("log")
	@Scope("prototype")
	public Material logs() {
		return new Wood();
	}
	
	@Bean("woodFrame")
	public Window woodFrameWindow() {
		return new WoodWindow();
	}
	
	@Bean("plasticFrame")
	public Window plasticFrameWindow() {
		return new PlasticWindow();
	}
	
	@Bean
	@Scope("prototype")
	public Door woodDoor() {
		return new WoodDoor();
	}
	
	@Bean
	public Door metalDoor() {
		System.out.println("metalDoor()");
		return new MetalDoor();
	}
	
	
	@Bean
	@Lazy
	public House house(@Value("${house.innerDoorsNumber}") int innerDoorCount) {
		Door m1 = metalDoor();
		Door m2 = metalDoor();
		System.out.println(m1);
		System.out.println(m2);
		
		House house = new House( woodFrameWindow(),
				env.getProperty("house.height", Integer.class, 3)
				//houseHeight
				);
		
		//house.setWall(bricks());
		
		house.setDoors(new HashMap<String, Door>());
		house.getDoors().put("A", metalDoor());
		
		for(int i = 0; i < innerDoorCount; i++)
			house.getDoors().put(String.valueOf((char)('B'+i)), woodDoor());
		
		return house;
		
	}
	
	

}
