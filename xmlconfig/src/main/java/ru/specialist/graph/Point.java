package ru.specialist.graph;

public class Point extends Shape {
	private Coords coords;
	
	
	public Coords getCoords() {
		return coords;
	}
	public void setCoords(Coords coords) {
		this.coords = coords;
	}
	public Point(Coords coords) {
		this.coords = coords;
	}
	
	
	public int getX() {
		return getCoords().getX();
	}
	public void setX(int y) {
		getCoords().setX(y);
	}
	public int getY() {
		return getCoords().getY();
	}
	
	public void setY(int y) {
		getCoords().setY(y);
	}
	
	public void draw() {
		System.out.printf("Point (%d, %d) Color: %s\n", 
				getX(), getY(), getColor());
		
	}

}
