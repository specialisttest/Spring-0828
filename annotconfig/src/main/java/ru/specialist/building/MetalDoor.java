package ru.specialist.building;

import org.springframework.stereotype.Component;

@Component
public class MetalDoor implements Door {

	@Override
	public void install() {
		System.out.println("Install metal door");

	}

}
