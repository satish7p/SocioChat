package com.sociochat.sociochatbackend.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sociochat.sociochatbackend.Dao.UserDao;
import com.sociochat.sociochatbackend.model.UserDetail;

public class UserDaoTest 
{

	static UserDao UserDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sociochat.sociochatbackend");
		context.refresh();
		
		UserDao=(UserDao)context.getBean("UserDao");
	}
	
	@Test
	public void addUserDetailTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUserId(12);
		user.setRole("user");
		user.setEmailId("abc@gmail.com");
		user.setIsOnline("N");
		user.setPassword("aabb");
		System.out.println("check1");
		System.out.println(UserDao);
		assertTrue("Problem in Inserting User",UserDao.addUser(user));
		System.out.println("check2");
		System.out.println("EmailID:"+user.getEmailId());
		
	
	}
	
}
