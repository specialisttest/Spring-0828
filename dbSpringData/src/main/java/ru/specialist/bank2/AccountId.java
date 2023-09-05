package ru.specialist.bank2;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

// complex primary key

@Embeddable
public class AccountId implements Serializable {
	private String accountNumber;
	private String accountType;
	
	public AccountId() {}
	
	public AccountId(String accountNumber, String accountType) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null || this.getClass() != obj.getClass()) return false;
		
		AccountId o = (AccountId)obj;
		
		return accountNumber.equals(o.accountNumber) &&
				accountType.equals(o.accountType);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType);
	}
	
	
	
}
