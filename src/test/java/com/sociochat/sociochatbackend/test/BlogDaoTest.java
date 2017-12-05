package com.sociochat.sociochatbackend.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sociochat.sociochatbackend.Dao.BlogDao;
import com.sociochat.sociochatbackend.model.Blog;

public class BlogDaoTest 
{

	static BlogDao blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sociochat.sociochatbackend");
		context.refresh();
		
		blogDAO=(BlogDao)context.getBean("blogDAO");
	}
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("Core Java");
		blog.setBlogContent("It is based on Simple Java Concept");
		blog.setUsername("sunil");
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}
	@Ignore
	@Test
	public void UpdateBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(1001);
		blog.setBlogContent("OOPS, Exception");
		blog.setBlogName("Java");
		assertTrue("Problem in updating", blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(2);
	
		assertTrue("Problem in deletion", blogDAO.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void getAllBlogTest()
	{
		List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("Blog List not found",blogList.get(0));
		for(Blog blog:blogList)
		{
			System.out.println("Blog Id:"+ blog.getBlogId()+":::"+ "Blog Name"+blog.getBlogName());
		}
	}
		
		@Test 
		public void approveBlog()
		{
			Blog blog=(Blog)blogDAO.getBlog(1001);
			assertTrue("Problem in Approving", blogDAO.approveBlog(blog));
			
			}

	@Ignore	
		@Test 
		public void rejectBlog()
		{
			Blog blog=(Blog)blogDAO.getBlog(1001);
			assertTrue("Problem in Approving", blogDAO.rejectBlog(blog));
			
			}
	
	}
	


