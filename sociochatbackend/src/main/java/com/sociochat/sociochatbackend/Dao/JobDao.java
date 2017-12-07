package com.sociochat.sociochatbackend.Dao;
import java.util.List;

import com.sociochat.sociochatbackend.model.Job;

public interface JobDao {

public boolean addJob(Job job);
public boolean updateJob(Job job);
public boolean deleteJob(Job job);
public Job getJob(int jobId);
List<Job> getAllJob();
}
