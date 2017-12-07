package com.sociochat.sociochatbackend.Dao;

import java.util.List;

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
	@Override
	public boolean addUser(UserDetail user) {
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin();
			session.save(user);
			transaction.commit();
			session.close();
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
	@Override
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
		@Override
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
	
@Override
	public List<UserDetail> getAllUsers() {
		Session session = sessionfactory.openSession();
		List<UserDetail> userlist=(List<UserDetail>)session.createQuery("from UserDetail").list();
		session.close();
		return userlist;
	}

@Transactional
	@Override
	public UserDetail getUser(int userId) {
	     Session session=sessionfactory.openSession();
	     UserDetail user=session.get(UserDetail.class,userId);
	     session.close();
	     
			return user;
		}
	@Transactional
	@Override
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
