package com.bank.sure.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sure.controller.request.AccountRegisterRequest;
import com.bank.sure.domain.Account;
import com.bank.sure.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Map<String,String>> createAccount (@RequestBody AccountRegisterRequest request){
		Account account  = new Account();
		account.setName(request.getName());
		account.setSsn(request.getSsn());
		account.setPhoneNumber(request.getPhoneNumber());
		
		Account savedAccount = accountService.createAccount(account);
		Map <String,String> map = new HashMap<>();
		map.put("Message", "Account successfully created");
		map.put("Success", "true");
		map.put("accountNumber", savedAccount.getAccountNumber().toString());
		
		return new ResponseEntity<>(map,HttpStatus.CREATED);
		
		
	}

}
