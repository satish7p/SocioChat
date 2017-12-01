package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociochat.sociochatbackend.model.Blog;

@Repository("blogDAO")
public class BlogDaoimpl implements BlogDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override

	public boolean addBlog(Blog blog) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	
	@Override
	
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}

