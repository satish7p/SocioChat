package com.sociochat.sociochatbackend.Dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociochat.sociochatbackend.model.Job;

@Repository("jobDAO")
@Transactional    //all methods are run under transaction
public class JobDaoimpl implements JobDao{

@Autowired
private SessionFactory sessionFactory;

public JobDaoimpl( SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
}

@Override
@Transactional
public boolean addJob(Job job) {
	try {
		sessionFactory.getCurrentSession().save(job);
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
}

@Override
@Transactional
public boolean updateJob(Job job) {
	try{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
}
@Override
@Transactional
public boolean deleteJob(Job job) {
	try
	{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		
	}
	catch( Exception e)
	{
		System.out.println("Exception occured"+e);
		return false;
	}
}


@Override
@Transactional
public Job getJob(int jobId) {
	Session session=sessionFactory.openSession();
    Job job=session.get(Job.class,jobId);
    session.close();
    
		return job;

}

@Override
public List<Job> getAllJob() {
	Session session = sessionFactory.openSession();
	List<Job> jobList=(List<Job>)session.createQuery("from Job").list();
	session.close();
	return jobList;
}


}


