package ru.specialist.building;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WoodDoor implements Door {

	@Override
	public void install() {
		System.out.println("Intall wood door");
	}

}
