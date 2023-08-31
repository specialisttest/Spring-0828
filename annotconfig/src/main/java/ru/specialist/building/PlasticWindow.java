package ru.specialist.building;

import org.springframework.stereotype.Component;

@Component
public class PlasticWindow implements Window {

	@Override
	public void open() {
		System.out.println("Open Plastic window");

	}

}
