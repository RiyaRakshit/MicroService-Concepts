package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
public class Employee5 {

	@Id
	private int id;
	private String name;
	private String email;

}
