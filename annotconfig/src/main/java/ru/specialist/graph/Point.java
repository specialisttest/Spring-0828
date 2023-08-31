package ru.specialist.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myPoint")
@Scope("prototype")
public class Point extends Shape {
	private Coords coords;
	
	
	public Coords getCoords() {
		return coords;
	}
	public void setCoords(Coords coords) {
		this.coords = coords;
	}
	
	/*@Value("${point.color}")
	@Override
	public void setColor(String color) {
		super.setColor(color);
	}*/
	
	@Autowired
	public Point(Coords coords, @Value("${point.color}") String color) {
		super(color);
		this.coords = coords;
	}
	
	
	public int getX() {
		return getCoords().getX();
	}
	
	@Value("${point.x}")
	public void setX(int y) {
		getCoords().setX(y);
	}
	public int getY() {
		return getCoords().getY();
	}
	@Value("${point.x}")
	public void setY(int y) {
		getCoords().setY(y);
	}
	
	public void draw() {
		System.out.printf("Point (%d, %d) Color: %s\n", 
				getX(), getY(), getColor());
		
	}

}
