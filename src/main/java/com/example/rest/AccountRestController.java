package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.UserAccountForm;
import com.example.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	AccountService accservice;
	
	@PostMapping( value ="/user" ,consumes = {"application/xml", "application/json"},produces = {"text/plain"})

	public ResponseEntity<String> createAccount(@RequestBody UserAccountForm form)
	{
		System.out.println(form);
		boolean status = accservice.createUserAccount(form);
		if(status=true)
		{
			return new ResponseEntity<>("Account Created",HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("Account Creation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

}
