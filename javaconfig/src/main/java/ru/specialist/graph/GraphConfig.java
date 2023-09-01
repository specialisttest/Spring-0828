package ru.specialist.graph;

import java.util.ArrayList;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("graph.properties")
public class GraphConfig implements ApplicationContextAware {
	
	@Bean
	@Scope("prototype")
	public Coords coords() {
		return new Coords();
	}
	
	@Value("${point.color}")
	private String pointColor;
	@Value("${point.x}")
	private int pointX;
	@Value("${point.y}")
	private int pointY;
	
	
	@Bean("myPoint")
	@Scope("prototype")
	public Point point() {
		Point p = new Point(coords());
		p.setColor(pointColor);
		p.setX(pointX);
		p.setY(pointY);
		return p;
	}
	
	@Autowired
	private Environment env;
	
	//@Value("#{new java.util.Random().nextInt(100)}")
	//private int radius;
	
	@Bean("myCircle")
	@Scope("prototype")
	public Circle circle(@Value("#{new java.util.Random().nextInt(100)}") int radius) {
		Circle c = new Circle(coords(), radius);
		c.setColor(env.getProperty("circle.color", Shape.DEFAULT_COLOR));
		c.setX(env.getProperty("circle.x", Integer.class, 0));
		c.setY(env.getProperty("circle.y", Integer.class, 0));
		return c;
	}	
	
	@Bean
	@Lazy
	public Scene scene(@Value("${point.numbers}") int pointNumber, 
					   @Value("${circle.numbers}")int circleNumber) {
		Scene s = Scene.getInstance();
		s.setObjects(new ArrayList<Shape>());
		for(int i=0; i < pointNumber; i++)
			s.getObjects().add(point());
		for(int i=0; i < circleNumber; i++)
			s.getObjects().add(context.getBean("myCircle", Circle.class));
		
		return s;
	}
	
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		
	}

}
