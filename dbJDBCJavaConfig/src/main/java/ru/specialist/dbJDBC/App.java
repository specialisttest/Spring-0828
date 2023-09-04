package ru.specialist.dbJDBC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;

public class App 
{
    public static void main( String[] args )
    {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoConfig.class); 
		CourseDAO courseDao = context.getBean(CourseDAO.class);
		
		/*
		Course c = new Course();
		c.setTitle("Spring");
		c.setLength(40);
		c.setDescription("Spring framework");
		System.out.printf("Spring course id before insert: %d\n", c.getId()); // 0
		
		courseDao.insert(c);
		
		System.out.printf("Spring course id after  insert: %d\n", c.getId()); 
		*/
		
		//courseDao.delete(5);
		for(Course c : courseDao.findAll())
			System.out.println(c);
		
		//System.out.println(courseDao.findById(5));
		//for(Course c : courseDao.findByTitle("web"))
		//		System.out.println(c);
		
		context.close();
    }
}
