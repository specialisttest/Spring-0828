package ru.specialist.graph;

import java.util.List;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Scene  
{
	
	private List<Shape> objects;

	public List<Shape> getObjects() {
		return objects;
	}

	@Autowired
	public void setObjects(List<Shape> objects) {
		this.objects = objects;
	}
	
	public void draw() {
		for(var o : getObjects())
			o.draw();
	}

	

}
