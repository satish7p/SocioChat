package com.sociochat.sociochatbackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sociochat.sociochatbackend.Dao.BlogCommentsDao;
import com.sociochat.sociochatbackend.Dao.BlogCommentsDaoimpl;
import com.sociochat.sociochatbackend.Dao.BlogDao;
import com.sociochat.sociochatbackend.Dao.BlogDaoimpl;
import com.sociochat.sociochatbackend.Dao.ForumCommentsDao;
import com.sociochat.sociochatbackend.Dao.ForumCommentsDaoimpl;
import com.sociochat.sociochatbackend.Dao.ForumDao;
import com.sociochat.sociochatbackend.Dao.ForumDaoimpl;
import com.sociochat.sociochatbackend.Dao.JobDao;
import com.sociochat.sociochatbackend.Dao.JobDaoimpl;
import com.sociochat.sociochatbackend.Dao.UserDao;
import com.sociochat.sociochatbackend.Dao.UserDaoimpl;
import com.sociochat.sociochatbackend.model.Blog;
import com.sociochat.sociochatbackend.model.BlogComments;
import com.sociochat.sociochatbackend.model.Forum;
import com.sociochat.sociochatbackend.model.ForumComments;
import com.sociochat.sociochatbackend.model.JobDetail;
import com.sociochat.sociochatbackend.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.sociochat.sociochatbackend.*")

public class DBConfig 
{
	   //1.Creating a DataSource Object which is used for LocalSessionFactory
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:socialchat");
			driverManagerDataSource.setUsername("hr");
			driverManagerDataSource.setPassword("hr");
			System.out.println("Oracle Connected");
			return driverManagerDataSource;
		}
		
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle12cDialect");
			return properties;
		}
		
		@Bean
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
			localSessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
			localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
			localSessionFactoryBuilder.addAnnotatedClass(JobDetail.class);
			localSessionFactoryBuilder.addAnnotatedClass(ForumComments.class);
			localSessionFactoryBuilder.addAnnotatedClass(BlogComments.class);
			//
			System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Bean(name="blogDAO")
		public BlogDao getBlogDao(SessionFactory sessionFactory)
		{
			System.out.println("BlogDao object Created");
			return new BlogDaoimpl(sessionFactory);
		}
		@Bean(name="userDAO")
		public UserDao getUserDao(SessionFactory sessionFactory)
		{
			System.out.println("UserDao object Created");
			return new UserDaoimpl(sessionFactory);
		}
		@Bean(name="forumDAO")
		public ForumDao getForumDao(SessionFactory sessionFactory)
		{
			System.out.println("ForumDao object Created");
			return new ForumDaoimpl(sessionFactory);
		}
		@Bean(name="jobDAO")
		public JobDao getJobDao(SessionFactory sessionFactory)
		{
			System.out.println("JobDao object Created");
			return new JobDaoimpl(sessionFactory);
		}
		@Bean("blogCommentsDAO")
		public BlogCommentsDao getBlogCommentsDAO(SessionFactory sessionFactory)
		{
			System.out.println("BlogComments DAO object Created");
			return new BlogCommentsDaoimpl(sessionFactory);
		}
		@Bean("forumCommentsDAO")
		public ForumCommentsDao getForumCommentsDAO(SessionFactory sessionFactory)
		{
			System.out.println("ForumComments DAO object Created");
			return new ForumCommentsDaoimpl(sessionFactory); 
		}
}


