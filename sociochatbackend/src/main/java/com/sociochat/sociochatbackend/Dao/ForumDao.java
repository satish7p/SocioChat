package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import com.sociochat.sociochatbackend.model.Forum;

public interface ForumDao {
public boolean addForum(Forum forum);
public boolean updateForum(Forum forum);
public boolean deleteForum(Forum forum);
public Forum getForum(int forumId);
public List <Forum> getAllForum();
public boolean approveForum(Forum forum);
public boolean rejectForum(Forum forum);

}
