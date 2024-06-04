package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee5;

@Repository
public interface MailRepository extends JpaRepository<Employee5,Integer> {

}
