package ru.specialist.building;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // brick
@Scope("prototype")
public class Brick implements Material {

	@Override
	public void buildUp() {
		System.out.println("Create wall using bricks");
	}

}
