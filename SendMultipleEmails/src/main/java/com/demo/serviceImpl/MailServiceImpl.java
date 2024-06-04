package com.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.demo.model.Employee5;
import com.demo.repository.MailRepository;
import com.demo.serviceI.EmailServiceI;
@Service
public class MailServiceImpl implements EmailServiceI
{
	@Autowired
	MailRepository mr;
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private static String from_email;

	@Override
	public Employee5 saveData(Employee5 emp) 
	{
		return mr.save(emp);
	}

	@Override
	public void sendSingleMail(String tomail) {
		
		SimpleMailMessage simpleMail=new SimpleMailMessage();
		simpleMail.setTo(tomail);
		simpleMail.setFrom(from_email);
		simpleMail.setSubject("Subject about Email");
		simpleMail.setText("Welcome to CJC");
		sender.send(simpleMail);
	}

	@Override
	public void sendMails() {
		List<Employee5> list=mr.findAll();
		List<String> Slist=new ArrayList<String>();
		list.forEach(a->Slist.add(a.getEmail()));
		Slist.forEach(b-> sendSingleMail(b));
		
		
	}
	

}
