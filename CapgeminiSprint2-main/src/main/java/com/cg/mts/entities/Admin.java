package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser {
	@Id
	@GeneratedValue
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Admin(String username, String password, String mobileNumber, String email) {
		super(username, password, mobileNumber, email);
	}

	public Admin() {
		super();
	}
}