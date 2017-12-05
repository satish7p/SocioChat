package com.sociochat.sociochatbackend.Dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociochat.sociochatbackend.model.Job;

@Repository("jobDAO")
@Transactional    //all methods are run under transaction
public class JobDaoimpl implements JobDAO{

@Autowired
private SessionFactory SessionFactory;

public JobDaoimpl(SessionFactory sessionFactory) {
	this.SessionFactory=sessionFactory;
	// TODO Auto-generated constructor stub
}

public boolean addJob(Job job) {
	try {
		SessionFactory.getCurrentSession().save(job);
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
}

public boolean updateJob(Job job) {
	try{
		SessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
	return false;
		}
}

public boolean deleteJob(Job job) {
	try{
		SessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Occured"+e);
	return false;
		}	
}

public Job getJob(int jobId) {
	Session session = SessionFactory.openSession();
	Job job = session.get(Job.class, jobId);
	session.close();
	return job;

	}


}


