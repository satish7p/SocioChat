package com.sociochat.sociochatbackend.Dao;
import java.util.List;

import com.sociochat.sociochatbackend.model.JobDetail;

public interface JobDao {

public boolean addJob(JobDetail job);
public boolean updateJob(JobDetail job);
public boolean deleteJob(JobDetail job);
public JobDetail getJob(int jobId);
List<JobDetail> getAllJob();
}
