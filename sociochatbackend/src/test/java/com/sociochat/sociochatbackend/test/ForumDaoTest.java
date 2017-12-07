package com.sociochat.sociochatbackend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sociochat.sociochatbackend.Dao.ForumDao;

import com.sociochat.sociochatbackend.model.Forum;

public class ForumDaoTest {

	static ForumDao forumDAO;
	


	@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.sociochat.sociochatbackend");
			context.refresh();
			
			forumDAO=(ForumDao)context.getBean("forumDAO");
		}
	@Ignore
		@Test
		public void addForumTest()
		{
			Forum Forum=new Forum();
			
			Forum.setForumId(1001);
			Forum.setForumName("Core Java");
			Forum.setForumContent("It is based on Simple Java Concept");
			Forum.setUsername("sunil");
			Forum.setStatus("A");
			Forum.setLikes(3);
			Forum.setCreateDate(new java.util.Date());
			
			assertTrue("Problem in Inserting Forum",forumDAO.addForum(Forum));
		
		}
	
	@Ignore
	@Test
	public void UpdateForumTest()
	{
		Forum Forum=(Forum)forumDAO.getForum(1001);
		Forum.setForumContent("OOPS, Exception");
		Forum.setForumName("Java");
		assertTrue("Problem in updating", forumDAO.updateForum(Forum));
	}
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum Forum=(Forum)forumDAO.getForum(1001);
		assertTrue("Problem in deletion", forumDAO.deleteForum(Forum));
	}
		
	@Ignore
		@Test
		public void getAllForumTest()
		{
			List<Forum> ForumList=(List<Forum>)forumDAO.getAllForum();
			assertNotNull("Forum List not found",ForumList.get(0));
			for(Forum Forum:ForumList)
			{
				System.out.println("Forum Id:"+ Forum.getForumId()+":::"+ "Forum Name"+Forum.getForumName());
			}
			
		}
	
		
		@Ignore
		@Test 
		public void approveForum()
		{
			Forum Forum=(Forum)forumDAO.getForum(1001);
			assertTrue("Problem in Approving", forumDAO.approveForum(Forum));
			
			}

		
		@Test 
		public void rejectForum()
		{
			Forum Forum=(Forum)forumDAO.getForum(1001);
			assertTrue("Problem in Approving", forumDAO.rejectForum(Forum));
			
			}
}