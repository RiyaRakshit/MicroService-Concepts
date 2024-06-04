package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee5;
import com.demo.serviceI.EmailServiceI;

@RestController
public class MailController {
	
	@Autowired
	EmailServiceI mailservice;
	
	@PostMapping("save")
	public ResponseEntity<Employee5> Insert(@RequestBody Employee5 emp)
	{
		 Employee5 emp5=mailservice.saveData(emp);
		return new ResponseEntity<Employee5>(emp5,HttpStatus.CREATED);
	}
	
	@GetMapping("/sendSingleMail/{mail}")
	public ResponseEntity<String> sendSingleMail(@PathVariable String mail)
	{
		mailservice.sendSingleMail(mail);
		return new ResponseEntity<String>("Mail Sent successfully",HttpStatus.OK);
	}
	@GetMapping("list")
	public ResponseEntity<String> SendingMultipleMail()
	{
		mailservice.sendMails();
		return new ResponseEntity<String>("Mail Sent successfully",HttpStatus.OK);
	}
	
	

	

}
