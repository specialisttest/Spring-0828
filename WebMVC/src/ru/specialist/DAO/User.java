package ru.specialist.DAO;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;


@Entity
@Table(name="users")
public class User implements Serializable {
	private String username;
	private String password;
	private boolean isEnabled;
	
	public User() {}
	public User(String username, String password) {
		this(username, password, true);
	}
	public User(String username, String password, boolean isEnabled) {
		super();
		this.username = username;
		this.password = password;
		this.isEnabled = isEnabled;
	}
	@Id
	@Column (name = "username") 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column (name = "password") 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column (name = "isenabled") 
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
}
