package com.sociochat.sociochatbackend.Dao;

import java.util.List;

import com.sociochat.sociochatbackend.model.BlogComments;

public interface BlogCommentsDao {
	public boolean saveBlogComments(BlogComments blogComments);

	public boolean deleteBlogComments(BlogComments blogComments);

	public boolean updateBlogComments(BlogComments blogComments);

	public BlogComments getBlogComments(int blogCommentsId);

	public List<BlogComments> getAllBlogComments();
}

