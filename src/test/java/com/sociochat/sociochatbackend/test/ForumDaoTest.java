package com.sociochat.sociochatbackend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sociochat.sociochatbackend.Dao.ForumDao;

import com.sociochat.sociochatbackend.model.Forum;

public class ForumDaoTest {

public static final Logger log = Logger.getLogger(ForumDaoTest.class.getName());

private static final Object Forum = null;
public static AnnotationConfigApplicationContext context;
private static ForumDao forumDAO;
private Forum forum;
@BeforeClass
public static void init(){
context =new AnnotationConfigApplicationContext();
context.scan("com.SocialNetworkBackEnd.*");
context.refresh();
forumDAO =(ForumDao) context.getBean("forumDAO");
}
//@Ignore
@Test
public  void addForumTest() {
Forum forum = new Forum();
forum.setForumName("Advance Java");
forum.setForumContent(" Advance java concept");
forum.setStatus("B");
forum.setCreateDate(new Date());
assertEquals("Failed to add user!",true,forumDAO.addForum(forum));
} 

@Ignore
@Test
public void getForumTest(){
Forum forum = forumDAO.getForum(1);
assertNotEquals("forum Not Found", forum);
log.info("Forum Name:"+forum.getForumName());
log.info("Blog Content"+forum.getForumContent());
}
@Ignore
@Test
public void getAllForumTest(){
    
List<Forum> forumList=(List<Forum>)forumDAO.getAllForum();
assertNotNull("Forum List Not Found", forumList.get(0));
for(Forum forum:forumList)
{
log.info("Forum ID"+forum.getForumId()+"::"+"Forum Name:"+forum.getForumName());
assertTrue("Problem in Deletion", forumDAO.deleteForum(forum));
}
}
@Ignore
@Test
public void updateForumTest(){
Forum forum = forumDAO.getForum(1);
forum.setForumContent("wcd");
forum.setForumName("app");
assertTrue("Problem in updation",forumDAO.updateForum(forum));
}
}

