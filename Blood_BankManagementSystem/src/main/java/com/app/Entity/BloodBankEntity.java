package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodbank")
public class BloodBankEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="b_username")
	String b_username;
	
	@Column(name="b_password")
	String b_password;
	
	@Id
	@Column(name="b_id")
	@GeneratedValue(generator = "increment")
	int b_id;
	
	
	@Column(name="b_name")
	String b_name;
	
	@Column(name="b_city")
	String b_city;
	
	@Column(name="b_address")
	String b_address;
	
	@Column(name="b_emailid")
	String b_emailid;
	
	@Column(name="b_contact")
	String b_contact;

	
	
	
	
	public BloodBankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodBankEntity(String b_username, String b_password, int b_id, String b_name, String b_city,
			String b_address, String b_emailid, String b_contact) {
		super();
		this.b_username = b_username;
		this.b_password = b_password;
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_city = b_city;
		this.b_address = b_address;
		this.b_emailid = b_emailid;
		this.b_contact = b_contact;
	}

	public String getB_username() {
		return b_username;
	}

	public void setB_username(String b_username) {
		this.b_username = b_username;
	}

	public String getB_password() {
		return b_password;
	}

	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_city() {
		return b_city;
	}

	public void setB_city(String b_city) {
		this.b_city = b_city;
	}

	public String getB_address() {
		return b_address;
	}

	public void setB_address(String b_address) {
		this.b_address = b_address;
	}

	public String getB_emailid() {
		return b_emailid;
	}

	public void setB_emailid(String b_emailid) {
		this.b_emailid = b_emailid;
	}

	public String getB_contact() {
		return b_contact;
	}

	public void setB_contact(String b_contact) {
		this.b_contact = b_contact;
	}

	
	
	
	
	

}
