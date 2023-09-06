package ru.specialist.dbSpringData;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseRepository;
import ru.specialist.dao.DaoConfig;
import ru.specialist.dao.TeacherDao;
import ru.specialist.service.ReportService;

@ComponentScan("ru.specialist.service")
public class App 
{
    public static void main( String[] args )
    {
    	//ClassPathXmlApplicationContext context = 
		//		new ClassPathXmlApplicationContext("applicationContext.xml");
    	AnnotationConfigApplicationContext context = 
    			new AnnotationConfigApplicationContext(DaoConfig.class, App.class);
		
    	CourseRepository r = context.getBean(CourseRepository.class);
		
		//for(Course c : r.findByTitle("web"))
		//	System.out.println(c);
		
		for(Course c : r.findByTitle("web"))
			System.out.println(c);
		
		System.out.printf("Course mediana length: %.2f\n",
				context.getBean(ReportService.class).getMedianaCourseLength());
		System.out.printf("Course mediana length: %.2f\n",
				context.getBean(ReportService.class).getAverageCourseLength());
		
		var tr = context.getBean(TeacherDao.class);
		for(var t : tr.findByName("Иван"))
			System.out.printf("%d %s %s %s\n", t.getId(), t.getName(),
					t.getAddress(), t.getPhone());

		context.close();     
	}
}
