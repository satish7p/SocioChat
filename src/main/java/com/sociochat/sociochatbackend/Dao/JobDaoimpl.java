package com.sociochat.sociochatbackend.Dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociochat.sociochatbackend.model.JobDetail;

@Repository("jobDAO")
@Transactional    //all methods are run under transaction
public class JobDaoimpl implements JobDao{

@Autowired
private SessionFactory sessionFactory;

public JobDaoimpl( SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
}


@Transactional
public boolean addJob(JobDetail job) {
	try {
		sessionFactory.getCurrentSession().save(job);
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
}


@Transactional
public boolean updateJob(JobDetail job) {
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

@Transactional
public boolean deleteJob(JobDetail job) {
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




public JobDetail getJob(int jobId) {
	Session session=sessionFactory.openSession();
    JobDetail job=session.get(JobDetail.class,jobId);
    session.close();
    
		return job;

}


public List<JobDetail> getAllJob() {
	Session session = sessionFactory.openSession();
	String hql="from JobDetail";
	Query query=session.createQuery(hql);
	session.close();
	return query.list();
}


}


