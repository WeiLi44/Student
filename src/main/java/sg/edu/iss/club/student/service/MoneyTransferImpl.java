package sg.edu.iss.club.student.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.club.student.model.Account;
import sg.edu.iss.club.student.repo.AccountRepository;

@Service
public class MoneyTransferImpl implements MoneyTransfer {
	
	@Autowired
	AccountRepository arp;

	@Transactional
	@Override
	public boolean transfer(Account from, Account to, Double amount) {
		arp.debit(from.getAccountNumber(), amount);
		arp.credit(to.getAccountNumber(), amount);
		return true;
	}

}
