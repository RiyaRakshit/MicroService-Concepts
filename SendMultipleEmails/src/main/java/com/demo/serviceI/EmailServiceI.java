package com.demo.serviceI;

import com.demo.model.Employee5;

public interface EmailServiceI {

	Employee5 saveData(Employee5 emp);

	void sendSingleMail(String mail);

	void sendMails();

}
