package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sociochat.sociochatbackend.model.UserDetail;

@Repository

public class UserDaoimpl  implements UserDao{
    
	@Autowired
	public SessionFactory sessionfactory;
	
	public UserDaoimpl(SessionFactory sessionfactory) {
	 this.sessionfactory=sessionfactory;
	}

	@Transactional
	public boolean addUser(UserDetail user) {
		try
		{
			sessionfactory.getCurrentSession().save(user);
			System.out.println("added the user");
			/*System.out.println("1");
		    System.out.println(sessionfactory);

			sessionfactory.getCurrentSession().save(user);*/
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	@Transactional
	public boolean updateOnlineStatus(String status, UserDetail user) {
		try
		{
			user.setIsOnline(status);;
			sessionfactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
			return false;
		}
	}
	
	  @Transactional	
	public boolean updateUser(UserDetail user) {
		
		try{
			sessionfactory.getCurrentSession().saveOrUpdate(user);
			return true;
			}
			catch(Exception e)
			{
			e.printStackTrace();
			return false;
			}
	}
	

	public List<UserDetail> getAllUsers() {
	Session session = sessionfactory.openSession();
	String hql="from UserDetail";
	Query query=session.createQuery(hql);
	session.close();
	return query.list();
	}



	public UserDetail getUser(int userId) {
	     Session session=sessionfactory.openSession();
	     UserDetail user=session.get(UserDetail.class,userId);
	     session.close();
	     
			return user;
		}
	@Transactional
	public boolean deleteUser(UserDetail user) {
		try
		{
			sessionfactory.getCurrentSession().delete(user);
			return true;
			
		}
		catch( Exception e)
		{
			System.out.println("Exception occured"+e);
			return false;
		}
	}

	
}
