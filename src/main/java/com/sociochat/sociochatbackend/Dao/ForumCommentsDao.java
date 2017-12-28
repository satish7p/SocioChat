package com.sociochat.sociochatbackend.Dao;
import java.util.List;

import com.sociochat.sociochatbackend.model.ForumComments;

public interface ForumCommentsDao {
	public boolean saveForumComments(ForumComments forumComments);

	public boolean deleteForumComments(ForumComments forumComments);

	public boolean updateForumComments(ForumComments forumComments);

	public ForumComments getForumComments(int fComments);

	public List<ForumComments> getAllForumComments();
}

