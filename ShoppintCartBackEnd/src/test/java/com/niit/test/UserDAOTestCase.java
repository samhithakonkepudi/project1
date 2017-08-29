package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTestCase {
	@Autowired
	 static AnnotationConfigApplicationContext context;
	
	@Autowired
	static UserDAO userDAO;
	@Autowired
	static User user;
	
	@BeforeClass
     
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
		user=(User)context.getBean("user");
	}
	@Test
	public void createUserTestCase()
	{
		user.setId("5");
		user.setName("sammy");
		user.setPassword("sk");
		user.setContact("1234567891");
		user.setRole("action");
		boolean flag=userDAO.saveOrUpdate(user);
		assertEquals("createUserTestCase", true, flag);
	}
	@Test
	public void validateTestCase()
	{
		boolean flag = userDAO.validate("5", "sk");
		assertEquals(true, flag);
	}

	@Test
	public void listAllUserTestCase() {
		int actualSize = userDAO.list().size();
		assertEquals(2, actualSize);
	}


	
}
