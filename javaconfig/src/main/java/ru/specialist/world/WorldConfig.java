package ru.specialist.world;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.specialist.world")
public class WorldConfig {
	
	@Bean
	public List<City> cities() {
		List<City> c = new ArrayList<City>();
		c.add(new City("Chicago", "IL", 2853114));
		c.add(new City("Atlanta", "GA", 537958));
		c.add(new City("Dallas" , "TX", 1279910));
		c.add(new City("Houston", "TX", 2242193));
		c.add(new City("Odessa",  "TX", 90943));
		c.add(new City("El Paso", "TX", 613190));
		c.add(new City("Jal",	  "NM", 1996));
		c.add(new City("Las Cruces", "NM", 91865));
	
		return c;
	}

}
