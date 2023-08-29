package springhello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.specialist.stuff.Person;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("ru.specialist.stuff");
		
		Person p = context.getBean(Person.class);
		System.out.println(p);

	}

}
