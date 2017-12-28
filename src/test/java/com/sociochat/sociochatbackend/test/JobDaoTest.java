package com.sociochat.sociochatbackend.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sociochat.sociochatbackend.Dao.JobDao;
import com.sociochat.sociochatbackend.model.JobDetail;



public class JobDaoTest {

	static JobDao jobDAO;
	


	@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.sociochat.sociochatbackend");
			context.refresh();
			
			jobDAO=(JobDao)context.getBean("jobDAO");
		}
	
@Test
public  void addJobTest() {
JobDetail job = new JobDetail();
job.setJobdate("22dec2011");
job.setJobprofile("be");
job.setPostdate(new java.util.Date());
job.setQualification("be");
job.setStatus("A");
assertEquals("Failed to add!",true,jobDAO.addJob(job));
} 

@Ignore
@Test
public void updateJobTest(){
//Blog blog = (Blog)blogDAO.getBlog(1);
JobDetail job=(JobDetail)jobDAO.getJob(10);
    job.setQualification("software engineer");
assertTrue("Problem in updation",jobDAO.updateJob(job));
}
@Ignore
@Test
public void deleteJobTest()
{
	JobDetail job=(JobDetail)jobDAO.getJob(10);
	assertTrue("Problem in deletion", jobDAO.deleteJob(job));
}

@Ignore
@Test
public void getAllJob()
{
	List<JobDetail> jobList=(List<JobDetail>)jobDAO.getAllJob();
	assertNotNull("User not found",jobList.get(0));
	for(JobDetail job:jobList)
	{
		System.out.println("Job Id:"+ job.getJobId()+":::"+ "Profile"+job.getJobprofile());
	}
	
}
}