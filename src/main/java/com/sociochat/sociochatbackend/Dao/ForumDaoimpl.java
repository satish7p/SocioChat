package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sociochat.sociochatbackend.model.Blog;
import com.sociochat.sociochatbackend.model.Forum;
@Repository
public class ForumDaoimpl implements ForumDao{
@Autowired 
SessionFactory sessionFactory;
  public ForumDaoimpl(SessionFactory sessionFactory)
{
this.sessionFactory=sessionFactory;
}

public boolean addForum(Forum forum) {
try
{
sessionFactory.getCurrentSession().save(forum);
return true;
}
catch (Exception e)
{
return false;
}
}


public boolean updateForum(Forum forum) {
// TODO Auto-generated method stub
return false;
}


public boolean deleteForum(Forum forum) {
// TODO Auto-generated method stub
return false;
}


public Forum getForum(int forumId) {
// TODO Auto-generated method stub
return null;
}


public List<Forum> getAllForum() {
// TODO Auto-generated method stub
return null;
}


public boolean approveForum(Forum forum) {
// TODO Auto-generated method stub
return false;
}

}

