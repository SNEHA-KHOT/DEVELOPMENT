package com.scheduler.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class User {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	 @GeneratedValue
	private Integer id;
	
	private String userName;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}

	
	
	

}
