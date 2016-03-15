package com.example.beans;

import java.util.Date;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class News extends DataSupport {
	//unique defaultValue ignore nullable
	@Column(unique = true, defaultValue = "unknown")
	private int id;
	private String title;
	private String content;
	private Date publishDate;
	private int commentCount;

	public News() {

	}

	public News(String title, String content, Date publishDate, int commentCount) {
		this.title = title;
		this.content = content;
		this.publishDate = publishDate;
		this.commentCount = commentCount;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", publishDate=" + publishDate + ", commentCount=" + commentCount + "]";
	}
	


}
