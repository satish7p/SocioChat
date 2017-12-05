package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

//import java.util.List;

import com.sociochat.sociochatbackend.model.UserDetail;

@Service
public interface UserDao {

	   public boolean addUser(UserDetail user);
	   public boolean updateOnlineStatus(String status,UserDetail user);
	   public boolean updateUser(UserDetail user);
	public List<UserDetail> getAllUsers();
	public UserDetail getUser(int userId);
	public boolean deleteUser(UserDetail user);
	}