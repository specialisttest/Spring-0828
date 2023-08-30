package springhello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.stuff.AppContext;
import ru.specialist.stuff.Company;
import ru.specialist.stuff.Person;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Before appContext creation");
		ApplicationContext context = 
				//new AnnotationConfigApplicationContext("ru.specialist.stuff");
				new AnnotationConfigApplicationContext(AppContext.class);
				//  ClassPathXmlApplicationContext
		
		System.out.println("After appContext creation");
		
		Person p = context.getBean(Person.class);
		System.out.println(p);
		
		Company yandex = context.getBean("yandex", Company.class);
		System.out.printf("Company title: %s : %d\n", yandex.getTitle(), yandex.getStuffs());

		Company s  = context.getBean("specialist.ru", Company.class);
		Company s2 = context.getBean("specialist.ru", Company.class);
		System.out.printf("Company title: %s : %d\n\n", s.getTitle(), s.getStuffs());
		System.out.println( s == s2 );
		System.out.println( s.hashCode() );
		System.out.println( s2.hashCode() );
		
	}

}
