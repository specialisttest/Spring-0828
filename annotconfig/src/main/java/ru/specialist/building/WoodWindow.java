package ru.specialist.building;

import org.springframework.stereotype.Component;

@Component
public class WoodWindow implements Window {

	@Override
	public void open() {
		System.out.println("Open Wood window");

	}

}
