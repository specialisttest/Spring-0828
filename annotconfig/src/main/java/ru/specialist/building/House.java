package ru.specialist.building;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

// Java EE
import javax.inject.Inject;
import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("myhouse")
@Lazy
public class House {
	
	private int height;
	private Window window;
	private Material wall;
	
	private List<Door> doors;
	//private Map<String, Door> doors;
	
	public House() {}
	
	@Autowired
	public House(@Value("#{plasticWindow}") Window window, 
				 @Value("${house.height}") int height) {
		this.window = window;
		this.height = height;
	}
	
	public void ventilate() {
		getWindow().open();
	}

	public Material getWall() {
		return wall;
	}
	
	public void buildWalls() {
		for(int i=1; i <= getHeight(); i++) {
			System.out.printf("Floor %d. ", i);
			getWall().buildUp();
		}
	}
	
	public void installDoors() {
		for(Door door : doors)
			door.install();
	}
	
	public List<Door> getDoors() {
		return doors;
	}

	@Autowired
	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}
	
	
	//@Value("#{brick}")
	//@Autowired // (required = false)
	//@Qualifier("log")
	//@WoodQualifier(value ="ABC")
	//@WoodQualifier("ABC")
	
	//@Inject // @Autowired
	//@Named("brick") // not work
	@Resource(name = "brick")
	public void setWall(Material wall) {
		this.wall = wall;
	}

	/*
	public void installDoors() {
		for(Map.Entry<String, Door> e : doors.entrySet()) {
			System.out.printf("Key : %s. ", e.getKey());
			e.getValue().install();
		}
			
	}
	
	public Map<String, Door> getDoors() {
		return doors;
	}

	public void setDoors(Map<String, Door> doors) {
		this.doors = doors;
	}*/

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void onCreate() {
		System.out.println("Creating house");
	}
	
	public void onDestroy() {
		System.out.println("Destroying house");
	}

}
