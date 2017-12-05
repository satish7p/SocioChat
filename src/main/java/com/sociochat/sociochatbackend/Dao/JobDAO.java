package com.sociochat.sociochatbackend.Dao;
import com.sociochat.sociochatbackend.model.Job;

public interface JobDAO {

public boolean addJob(Job job);
public boolean updateJob(Job job);
public boolean deleteJob(Job job);
public Job getJob(int jobId);
}
