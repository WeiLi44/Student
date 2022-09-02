package sg.edu.iss.club.student.service;

import sg.edu.iss.club.student.model.Account;

public interface MoneyTransfer {
	
	public boolean transfer(Account from, Account to, Double amount);

}
