package ru.specialist.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCircle")
@Scope("prototype")
public class Circle extends Shape {
	private Coords center;
	private int r;
	
	
	public Coords getCenter() {
		return center;
	}
	public void setCenter(Coords center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Circle(Coords center) {
		this(center, 0, DEFAULT_COLOR);
	}
	@Autowired
	public Circle(Coords center, 
			@Value("#{new java.util.Random().nextInt(100)}") int r,
			@Value("${circle.color}") String color) {
		super(color);
		this.center = center;
		this.r = r;
	}
	
	public int getX() {
		return getCenter().getX();
	}
	@Value("${circle.x}")
	public void setX(int y) {
		getCenter().setX(y);
	}
	public int getY() {
		return getCenter().getY();
	}
	@Value("#{myPoint.y}")
	public void setY(int y) {
		getCenter().setY(y);
	}
	
	public void draw() {
		System.out.printf("Circle (%d, %d) R: %d Color: %s\n", 
				getX(), getY(), getR(), getColor());
		
	}
}
