package ru.specialist.model;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.specialist.service.HelloService;
// привет -> Доброе утро или Добрый день, или Добрый вечер или Доброй ночи
@Component("userVM")
public class UserVM {
	
	// Properties: userName, hello (read only)
	
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/*public String getHello() {
		
		return (getUserName() == null || getUserName().isEmpty()) ? "Привет!" : 
			String.format("Привет, %s!", getUserName());
	}*/	
	
	public String getHello() {
		return (getUserName() == null || getUserName().isEmpty()) ? 
				helloService.getHello()+"!" : 
				String.format("%s, %s!", helloService.getHello(), getUserName());
	}
	
	@Autowired
	private HelloService helloService;
	
	/*
	@Autowired
	private MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}	
	

	public String getHello() {
		
		//return (getUserName() == null || getUserName().isEmpty()) ? "Привет!" : 
		//	String.format("Привет, %s!", getUserName());
		
		String hello = getMessageSource().getMessage("header_hello", null, Locale.getDefault());
		
		return (getUserName() == null || getUserName().isEmpty() ? hello :
			getMessageSource().getMessage("header_hello_username", 
					new Object[] {getUserName()}, Locale.getDefault()));
		
	}*/
	

}
