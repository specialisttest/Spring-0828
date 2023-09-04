package ru.specialist.dbJDBC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;

public class App 
{
    public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDAO courseDao = context.getBean(CourseDAO.class);
		for(Course c : courseDao.findAll())
			System.out.println(c);
		
		//System.out.println(courseDao.findById(5));
		
		context.close();
    }
}
