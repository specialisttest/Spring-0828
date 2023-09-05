package ru.specialist.bank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
@IdClass(AccountId.class)
public class Account {
	
	@Id
	private String accountNumber;
	
	@Id
	private String accountType;
	
	private double balance;
	
	public Account() {}
	
	public Account(String accountNumber, String accoutType, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accoutType;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccoutType() {
		return accountType;
	}

	public void setAccoutType(String accoutType) {
		this.accountType = accoutType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
