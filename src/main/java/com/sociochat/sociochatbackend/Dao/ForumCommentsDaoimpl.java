package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociochat.sociochatbackend.model.ForumComments;


@Repository("forumCommentsDAO")
@Transactional
public class ForumCommentsDaoimpl implements ForumCommentsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumCommentsDaoimpl(SessionFactory sessionFactory)
	{
        this.sessionFactory=sessionFactory;	
}

	public boolean saveForumComments(ForumComments forumComments) {
		{
			try {
				sessionFactory.getCurrentSession().save(forumComments);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
			}
		}
		return false;
	}

	@Transactional
	
	public boolean deleteForumComments(ForumComments forumComments) {
		try {
			sessionFactory.getCurrentSession().delete(forumComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	
	public boolean updateForumComments(ForumComments forumComments) {
		try{
			sessionFactory.getCurrentSession().update(forumComments);
			return true;
		}catch(Exception e){
			System.out.println("exception arised"+e);

		}
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	
	public ForumComments getForumComments(int fComments) {
		Session session = (Session) sessionFactory.openSession();
		ForumComments forumComments = (ForumComments) ((org.hibernate.Session) session).get(ForumComments.class, new Integer(fComments));
		session.close();
		return forumComments;
		
	}
	@Transactional
	
	public List<ForumComments> getAllForumComments() {
		Session session = sessionFactory.openSession();
		String hql="from ForumComments";
		Query query=session.createQuery(hql);
		session.close();
		return query.list();
	}

}
