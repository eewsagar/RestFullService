package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital")
public class HospitalEntity implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="h_id")
	@GeneratedValue(generator = "increment")
	int h_id;
	
	@Column(name="h_username")
	String h_username;
	
	@Column(name="h_password")
	String h_password;
	
	@Column(name="h_city")
	String h_city;
	
	@Column(name="h_address")
	String h_address;
	
	@Column(name="h_name")
	String h_name;


	
	@Column(name="h_contact")
	int h_contact;
	
	@Column(name="h_emailid")
	String h_emailid;

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public String getH_username() {
		return h_username;
	}

	public void setH_username(String h_username) {
		this.h_username = h_username;
	}

	public String getH_password() {
		return h_password;
	}

	public void setH_password(String h_password) {
		this.h_password = h_password;
	}

	public String getH_city() {
		return h_city;
	}

	public void setH_city(String h_city) {
		this.h_city = h_city;
	}

	public String getH_address() {
		return h_address;
	}

	public void setH_address(String h_address) {
		this.h_address = h_address;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public int getH_contact() {
		return h_contact;
	}

	public void setH_contact(int h_contact) {
		this.h_contact = h_contact;
	}

	public String getH_emailid() {
		return h_emailid;
	}

	public void setH_emailid(String h_emailid) {
		this.h_emailid = h_emailid;
	}

	
	
	
	
	
}
