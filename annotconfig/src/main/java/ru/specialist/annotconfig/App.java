package ru.specialist.annotconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.building.House;
import ru.specialist.graph.Circle;
import ru.specialist.graph.Point;
import ru.specialist.graph.Scene;
import ru.specialist.world.Country;




@ComponentScan("ru.specialist.building")
@PropertySource("house.properties")
public class App {

	public static void main(String[] args) {
		/*try(AnnotationConfigApplicationContext context = 
				//new AnnotationConfigApplicationContext("ru.specialist.building"))
				new AnnotationConfigApplicationContext(App.class))*/
		try(ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("appContext.xml"))		
		{
			House h = context.getBean("myhouse", House.class); 
			
			h.buildWalls();
			h.ventilate();
			
			h.installDoors();
			
			Country usa = context.getBean("usa", Country.class);
			System.out.println(usa.getTitle());
			for(var city : usa.getCities())
				System.out.printf("%-20s %s : %d\n", 
						city.getName(), city.getState(), city.getPopulation());
			
			
		}
		
		/*
		 *  @Component – универсальная аннотация, указывающая, что класс
				является компонентом Spring;
			@Controller – указывает, что класс определяет контроллер
				Spring MVC;
			@RestController – указывает, что класс определяет контроллер
				REST сервиса;
			@Repository – указывает, что класс определяет репозиторий дан-
					ных;
			@Service – указывает, что класс определяет службу;
			
			любая пользовательская аннотация, определенная с помощью
					аннотации @Component.
		 * 
		 */
		
		ApplicationContext gc = 
				new AnnotationConfigApplicationContext(GraphConfig.class);
		
		gc.getBean(Scene.class).draw();
		
		for(String name : gc.getBeanDefinitionNames())
			System.out.println(name);
	}

}
