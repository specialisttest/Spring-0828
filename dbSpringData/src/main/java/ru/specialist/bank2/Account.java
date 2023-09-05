package ru.specialist.bank2;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@EmbeddedId
	private AccountId accountID;
	
	
	private double balance;
	
	public Account() {}
	
	public Account(AccountId accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}
	
	public AccountId getAccountID() {
		return accountID;
	}

	public void setAccountID(AccountId accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String accountNumber()
	{
		return getAccountID().getAccountNumber();
	}
	
	

}
