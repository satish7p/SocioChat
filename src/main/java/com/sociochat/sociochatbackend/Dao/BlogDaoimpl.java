package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.hibernate.Session;
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
	
	
	@Transactional
	@Override
	public boolean updateBlog(Blog blog)  {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			}
			catch(Exception e)
			{
			e.printStackTrace();
			return false;
			}
	}

		

	
	@Transactional
	public boolean deleteBlog(Blog blog) {
		{
			try
			{
				sessionFactory.getCurrentSession().delete(blog);
				return true;
				
			}
			catch( Exception e)
			{
				System.out.println("Exception occured"+e);
				return false;
			}
		}
	}

	
	@Transactional
	@Override
	public Blog getBlog(int blogId)
	  {
     Session session=sessionFactory.openSession();
     Blog blog=session.get(Blog.class,blogId);
     session.close();
     
		return blog;
	}

	

	@Override
	public List<Blog> getAllBlogs() 
	{
		Session session = sessionFactory.openSession();
		List<Blog> blogList=(List<Blog>)session.createQuery("from Blog").list();
		session.close();
		return blogList;
	}
	
	@Transactional
	@Override
		public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
			return false;
		}
	
	}
	@Transactional
	@Override
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("N");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occured"+e);
			
		}
		return false;
	}

}

