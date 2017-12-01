package com.sociochat.sociochatbackend.Dao;

import org.springframework.stereotype.Service;

//import java.util.List;

import com.sociochat.sociochatbackend.model.UserDetail;

@Service
public interface UserDao {

   public boolean addUser(UserDetail user);
   public boolean updateOnlineStatus(String status,UserDetail user);
	 //boolean saveUser(User user);
}