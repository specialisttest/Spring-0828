package ru.specialist.xmlconfig;

import java.io.Closeable;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.building.House;
import ru.specialist.graph.Circle;
import ru.specialist.graph.Point;

/* Labs
 * Coords
 * 	x,y
 * 
 * abstract Shape
 * 	String color
 *  abstract draw()
 *  
 * Point extends Shape
 * 	Coords coords
 *  draw();
 *  setX(), setY()
 * 
 * 
 * Circle extends Shape
 *   Coords center, int radius
 *   draw()
 *   
 *   Beans: Coords, Point, Circle

 * 
 */

public class App {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("appContext.xml"))
		{
			House h = context.getBean(House.class); 
			
			h.buildWalls();
			h.ventilate();
		} //((Closeable)context).close();
		
		ApplicationContext gc = 
				new ClassPathXmlApplicationContext("graphConfig.xml");
		
		gc.getBean("myPoint", Point.class).draw();
		gc.getBean("myCircle", Circle.class).draw();		
		
		// Scopes
		// https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
		
	}

}
