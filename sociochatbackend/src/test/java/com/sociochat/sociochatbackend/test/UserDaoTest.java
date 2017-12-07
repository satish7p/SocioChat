package com.sociochat.sociochatbackend.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sociochat.sociochatbackend.Dao.UserDao;
import com.sociochat.sociochatbackend.model.UserDetail;

public class UserDaoTest 
{

	static UserDao userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sociochat.sociochatbackend");
		context.refresh();
		
		userDAO=(UserDao)context.getBean("UserDao");
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
		System.out.println(userDAO);
		assertTrue("Problem in Inserting User",userDAO.addUser(user));
		System.out.println("check2");
		System.out.println("EmailID:"+user.getEmailId());
	}
	@Test
	public void getAllUser()
	{
		List<UserDetail> userList=(List<UserDetail>)userDAO.getAllUsers();
		assertNotNull("User not found",userList.get(0));
		for(UserDetail user:userList)
		{
			System.out.println("User Id:"+ user.getUserId()+":::"+ "User Name"+user.getUserName());
		}
		
	}
@Ignore
	@Test
	public void deleteUserTest()
	{
		UserDetail user=(UserDetail)userDAO.getUser(1001);
		assertTrue("Problem in deletion", userDAO.deleteUser(user));
	}

	@Ignore
	@Test
	public void UpdateUserTest()
	{
		UserDetail user=(UserDetail)userDAO.getUser(1001);
		user.setUserName("Shaheer");
		user.setEmailId("shaheerahmed@gmsil.com");
		assertTrue("Problem in updating", userDAO.updateUser(user));
	}

	@Ignore
	@Test 
	public void setOnlineStatus()
	{
		UserDetail user=(UserDetail)userDAO.getUser(1001);
		assertTrue("Problem in Approving", userDAO.updateOnlineStatus("Online", user));
		
		}

	
}


