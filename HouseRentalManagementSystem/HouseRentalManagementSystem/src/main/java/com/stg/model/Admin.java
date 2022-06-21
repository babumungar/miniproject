package com.stg.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private int adminId;
	private String adminName;
	private String adminMobileNo;
	private String password;

	@JsonManagedReference(value = "house")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adminRef")
	private Set<House> houseSet;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public Admin(int adminId, String adminName, String adminMobileNo, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminMobileNo = adminMobileNo;
		this.password = password;
	}

	public Admin(int adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.setPassword(password);
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminMobileNo() {
		return adminMobileNo;
	}

	public void setAdminMobileNo(String adminMobileNo) {
		this.adminMobileNo = adminMobileNo;
	}

}
