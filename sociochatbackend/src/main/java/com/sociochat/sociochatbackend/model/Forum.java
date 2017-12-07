package com.sociochat.sociochatbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
@Component
@Entity

public class Forum {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	int forumId;
	String forumName;
	String forumContent;
	String username;
	String status;
	int likes;
	Date createDate;
	
public int getForumId() {
		return forumId;
}
public void setForumId(int forumId) {
		this.forumId = forumId;
}

public String getForumName() {
return forumName;
}
public void setForumName(String forumName) {
this.forumName = forumName;
}
public String getForumContent() {
return forumContent;
}
public void setForumContent(String forumContent) {
this.forumContent = forumContent;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
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
public Date getCreateDate() {
return createDate;
}
public void setCreateDate(Date createDate) {
this.createDate = createDate;
}

}
