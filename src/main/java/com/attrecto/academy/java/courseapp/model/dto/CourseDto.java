package com.attrecto.academy.java.courseapp.model.dto;

import java.util.List;

public class CourseDto {
	private Integer id;
	private String title;
	private String description;
	private String url;
	private Integer authorId;
	private List<MinimalUserDto> students;

	public List<MinimalUserDto> getStudents() {
		return students;
	}
	public void setStudents(List<MinimalUserDto> students) {
		this.students = students;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}
