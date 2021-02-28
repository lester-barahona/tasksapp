package com.startCMS.core.models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



public class Task {
	
	@NotNull
	private Integer id;
	
	@NotBlank(message = "The description can't are empty.")
	@Size(min=5,max=255,message = "The name must be between {min} and {max} characters")
	private String name;
	
	@NotBlank(message = "The description can't are empty.")
	@Size(min=5,max=255,message = "The name must be between {min} and {max} characters")
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date date;
	
	@NotNull
	private boolean complete;
	
	public Task() {}
	
	public Task(Integer id, String name, String description, Date date,boolean complete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.complete=complete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", complete="
				+ complete + "]";
	}


}
