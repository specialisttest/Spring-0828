package ru.specialist.stuff;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("ru.specialist.stuff")
public class AppContext {
	
	@Bean("specialist.ru")
	//@Lazy
	//@Scope("singleton") // by default
	@Scope("prototype")
	public Company specialist() {
		Company s = new Company();
		s.setTitle("Specialist.ru");
		s.setStuffs(size);
		return s;
	}
	
	@Value("#{yandex.stuffs / 10}") // SpEL
	private int size;

	@Bean
	public Company yandex() {
		Company s = new Company();
		s.setTitle("Yandex");
		s.setStuffs(1000);
		return s;
	}
}
