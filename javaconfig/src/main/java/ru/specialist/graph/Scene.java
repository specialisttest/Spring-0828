package ru.specialist.graph;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Scene {
	
	private Scene () {}
	private static Scene instance;
	
	public static synchronized Scene getInstance() {
		if (instance == null)
			instance = new Scene();
		
		return instance;
	}
	
	private List<Shape> objects;

	public List<Shape> getObjects() {
		return objects;
	}

	//@Autowired
	public void setObjects(List<Shape> objects) {
		this.objects = objects;
	}
	
	public void draw() {
		for(var o : getObjects())
			o.draw();
	}
	
	

}
