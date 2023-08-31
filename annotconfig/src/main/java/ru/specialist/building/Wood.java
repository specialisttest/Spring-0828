package ru.specialist.building;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("log")
@Scope("prototype")
public class Wood implements Material {

	@Override
	public void buildUp() {
		System.out.println("Create wall using logs");
	}

}
