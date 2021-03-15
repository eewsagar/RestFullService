package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="requester")
public class RequesterEntity implements Serializable 
{

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="r_id")
	@GeneratedValue(generator = "increment")
	int r_id;
	
	@Column(name="r_username")
	String r_username;
	
	@Column(name="r_password")
	String r_password;
	
	@Column(name="r_name")
	String r_name;
	
	@Column(name="r_city")
	String r_city;
	
	@Column(name="r_address")
	String r_address;
	
	@Column(name="r_contact")
	String r_contact;
	
	@Column(name="r_emailid")
	String r_emailid;
	
	@Column(name="r_type")
	String r_type;


	

	
	public RequesterEntity() {
		super();
		
	}

	public RequesterEntity(int r_id, String r_username, String r_password, String r_name, String r_city,
			String r_address, String r_contact, String r_emailid, String r_type) {
		super();
		this.r_id = r_id;
		this.r_username = r_username;
		this.r_password = r_password;
		this.r_name = r_name;
		this.r_city = r_city;
		this.r_address = r_address;
		this.r_contact = r_contact;
		this.r_emailid = r_emailid;
		this.r_type = r_type;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_username() {
		return r_username;
	}

	public void setR_username(String r_username) {
		this.r_username = r_username;
	}

	public String getR_password() {
		return r_password;
	}

	public void setR_password(String r_password) {
		this.r_password = r_password;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_city() {
		return r_city;
	}

	public void setR_city(String r_city) {
		this.r_city = r_city;
	}

	public String getR_address() {
		return r_address;
	}

	public void setR_address(String r_address) {
		this.r_address = r_address;
	}

	public String getR_contact() {
		return r_contact;
	}

	public void setR_contact(String r_contact) {
		this.r_contact = r_contact;
	}

	public String getR_emailid() {
		return r_emailid;
	}

	public void setR_emailid(String r_emailid) {
		this.r_emailid = r_emailid;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	
	
	

}
