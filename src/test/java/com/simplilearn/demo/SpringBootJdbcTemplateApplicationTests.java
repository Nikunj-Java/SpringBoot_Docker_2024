package com.simplilearn.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootJdbcTemplateApplicationTests {
	
	@Autowired
	private UserSevice service;
	
	@Test
	@Disabled
	void addUser() {
		User user=new User();
		user.setName("Nikunj");
		user.setCountry("India");
		user.setEmail("nikunj@testmail.com");
		
		Assertions.assertNotNull(service.addUser(user));
	}
	
	@Test
	void getUser() {
		Assertions.assertEquals("Nikunj", service.getuserbyid(9).getName());
	}
	
 
	 
	
	
}
