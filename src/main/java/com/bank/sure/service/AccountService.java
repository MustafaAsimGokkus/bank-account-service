package com.bank.sure.service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sure.domain.Account;
import com.bank.sure.repository.AccountRepository;

@Service
public class AccountService {
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account createAccount(Account account) {
		account.setBalance(BigDecimal.valueOf(0.0));
		account.setAccountNumber(getAccountNumber());
		return accountRepository.save(account);
	}
	
	
	private Long getAccountNumber() {
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;
		return ThreadLocalRandom.current().nextLong(smallest,biggest);
	}

}
