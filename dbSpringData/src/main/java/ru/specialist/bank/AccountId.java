package ru.specialist.bank;

import java.io.Serializable;
import java.util.Objects;

// complex primary key

public class AccountId implements Serializable {
	private String accountNumber;
	private String accountType;
	
	public AccountId() {}
	
	public AccountId(String accountNumber, String accountType) {
		this.accountNumber = accountNumber;
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
		return Objects.hash( accountNumber, accountType);
	}
	
	
	
}
