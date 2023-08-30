package ru.specialist.xmlconfig;

import java.util.List;

public class Country {
	
	/*private*/ Country() {}
	
	private String title;
	private List<City> cities;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	// factory method
	public static Country getInstance() {
		System.out.println("Country factory method getInstance");
		return new Country();
	}
	
	

}
