package ru.specialist.stuff;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("Person() ctor");
	}
	
	
	public String getName() {
		return name;
	}
	@Value("Sergey")
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@Value("45")
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %d", getName(), getAge());
	}
	
	

}
