package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociochat.sociochatbackend.model.Forum;
@Repository
public class ForumDaoimpl implements ForumDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public ForumDaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
    @Transactional
	public boolean addForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().save(forum);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
    @Transactional
	public boolean updateForum(Forum forum) {

   try
   {
	   sessionFactory.getCurrentSession().saveOrUpdate(forum);
	   return true;
	  
   }
   catch(Exception e)
   {
	   System.out.println("Exception occured:"+e);
   }
		return false;
	}

	@Transactional
	public boolean deleteForum(Forum  forum) {
		{
			try
			{
				sessionFactory.getCurrentSession().delete(forum);
				return true;
				
			}
			catch( Exception e)
			{
				System.out.println("Exception occured"+e);
				return false;
			}
		}
	}

	public Forum getForum(int forumId)
	  {
     Session session=sessionFactory.openSession();
     Forum forum=session.get(Forum.class,forumId);
     session.close();
     
		return forum;
	}
	
	public List<Forum> getAllForum() {
		Session session = sessionFactory.openSession();
		String hql="from Forum";
		Query query=session.createQuery(hql);
		session.close();
		return query.list();
	
	}
	  @Transactional
	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
			return false;
		}
	
	}
	  @Transactional
	public boolean rejectForum(Forum forum) {
		try
		{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occured"+e);
			
		}
		return false;
	}

	
}

	