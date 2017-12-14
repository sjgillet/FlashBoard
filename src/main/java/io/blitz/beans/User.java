package com.blitz.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="People")
public class User {
	@Id
	@Column(name="userId")
	@SequenceGenerator(sequenceName="user_seq", name="user_seq")
	@GeneratedValue(generator="user_seq", strategy=GenerationType.SEQUENCE)
	private int userId;
	
	@Column(name="username")
	private String username;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(String username) {
		this.username = username;
	}

	public User(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public User() {
		super();
	}
	
	
	
}
