package ru.specialist.model;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component("userVM")
public class UserVM {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Value("#{myMessageSource}")
	private MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}	
	

	public String getHello() {
		
		
		String hello = getMessageSource().getMessage("header_hello", null, Locale.getDefault());
		
		return (getUserName() == null || getUserName().isEmpty() ? hello :
			getMessageSource().getMessage("header_hello_username", 
					new Object[] {getUserName()}, Locale.getDefault()));
		
	}
	

}
