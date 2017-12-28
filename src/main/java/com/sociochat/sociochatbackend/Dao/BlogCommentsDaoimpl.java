package com.sociochat.sociochatbackend.Dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sociochat.sociochatbackend.model.BlogComments;

public class BlogCommentsDaoimpl implements BlogCommentsDao {
	@Autowired
	SessionFactory sessionFactory;

		public BlogCommentsDaoimpl(SessionFactory sessionFactory) {
this.sessionFactory=sessionFactory;
		}
		
@Transactional
	public boolean saveBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised"+e);
		}
		return false;
	}
	@Transactional
	
	public boolean deleteBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	
	public boolean updateBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	
	public BlogComments getBlogComments(int blogCommentsId) {
		Session session = sessionFactory.openSession();
		BlogComments blogComments = (BlogComments) session.get(BlogComments.class, new Integer(blogCommentsId));
		session.close();
		return blogComments;
	}
	
	public List<BlogComments> getAllBlogComments() {
	
		Session session = sessionFactory.openSession();
		String hql="from BlogComments";
		Query query=session.createQuery(hql);
		session.close();
		return query.list();
		
	}
}