package ru.specialist.building;

public class Brick implements Material {

	@Override
	public void buildUp() {
		System.out.println("Create wall using bricks");
	}

}
