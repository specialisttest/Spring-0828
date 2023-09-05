package ru.specialist.dbJPA;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;
import ru.specialist.dao.DaoConfig;

public class App 
{
    public static void main( String[] args )
    {
    	//ClassPathXmlApplicationContext context = 
		//		new ClassPathXmlApplicationContext("applicationContext.xml");
    	AnnotationConfigApplicationContext context = 
    			new AnnotationConfigApplicationContext(DaoConfig.class);
		CourseDAO courseDao = context.getBean(CourseDAO.class);
		
		/*Course spring = new Course();
		spring.setTitle("Spring");
		spring.setLength(40);
		spring.setDescription("Spring framework");
		courseDao.insert(spring);*/
		//courseDao.delete(9);
		//Course s = courseDao.findById(1);
		//s.setLength(42);
		//courseDao.update(s);
		
		//for(Course c : courseDao.findAll())
		//	System.out.println(c);
		//for(Course c : courseDao.findByTitle("web"))
		//	System.out.println(c);
		System.out.println(courseDao.findById(1));
		System.out.println(courseDao.findById(1));
		
		context.close();    
    }
}
