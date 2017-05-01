package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ForumComment extends Error{

	 @Id
	 private int id;
	 private int forumid;
	 private String username;
	 private String forum_comment;
	 private Date comment_date;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getForum_comment() {
		return forum_comment;
	}
	public void setForum_comment(String forum_comment) {
		this.forum_comment = forum_comment;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	 
	 
	 
}