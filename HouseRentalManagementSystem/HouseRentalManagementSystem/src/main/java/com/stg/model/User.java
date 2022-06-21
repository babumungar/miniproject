package com.stg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private int userId;
	private String userName;
	private String password;
	private String userMobileNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_house_id")
	@JsonBackReference
	private House house;

//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
//	@JsonManagedReference
//	private House UserHouse;

	public User() {
		super();

	}

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.setPassword(password);

	}

	public User(int userId, String userName, String password, String userMobileNo, int houseId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userMobileNo = userMobileNo;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

}
