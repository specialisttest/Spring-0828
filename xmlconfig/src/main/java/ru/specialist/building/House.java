package ru.specialist.building;

public class House {
	
	private int height;
	private Window window;
	private Material wall;
	
	public House() {}
	
	public House(Window window, int height) {
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

	public void setWall(Material wall) {
		this.wall = wall;
	}

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
