package com.sociochat.sociochatbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Blog 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	int blogId;
	
	String blogName;
	String blogContent;
	String username;
	String status;
	int likes;
	
	Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getBlogId() 
	{
		return blogId;
	}
	public void setBlogId(int blogId) 
	{
		this.blogId = blogId;
	}
	public String getBlogName() 
	{
		return blogName;
	}
	public void setBlogName(String blogName) 
	{
		this.blogName = blogName;
	}
	public String getBlogContent() 
	{
		return blogContent;
	}
	public void setBlogContent(String blogContent) 
	{
		this.blogContent = blogContent;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
}
