package ru.specialist.xmlconfig;

public class CountryFactory {
	
	public Country getCountry() {
		System.out.println("CountryFactory getCountry()");
		return new Country();
	}

}
