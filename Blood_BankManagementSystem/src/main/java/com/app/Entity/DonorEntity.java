package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donor")
public class DonorEntity implements Serializable 
{
   //Why so we use SerialVersionUID : SerialVersionUID is used to ensure that during deserialization
	//the same class (that was used during serialize process) is loaded
	private static final long serialVersionUID = 1L;
	//The serialization at runtime associates with each serializable class a version number, called a serialVersionUID,
	
	@Column(name="d_username")
	String d_username;
	
	@Column(name="d_password")
	String d_password;
	
	@Id
	@Column(name="d_id")
	@GeneratedValue(generator = "increment")
	int d_id;
	
	@Column(name="d_name")
	String d_name;
	
	@Column(name="d_city")
	String d_city;
	
	@Column(name="d_address")
	String d_address;
	
	@Column(name="d_contact")
	String d_contact;

	@Column(name="d_emailid")
	String emailid;
	
	@Column(name="d_bloodgroup")
	String bloodgroup;
	
	@Column(name="d_age")
	int age;
	
	@Column(name="d_type")
	String type;
	
	


	public String getD_username() {
		return d_username;
	}

	public void setD_username(String d_username) {
		this.d_username = d_username;
	}

	public String getD_password() {
		return d_password;
	}

	public void setD_password(String d_password) {
		this.d_password = d_password;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_city() {
		return d_city;
	}

	public void setD_city(String d_city) {
		this.d_city = d_city;
	}

	public String getD_address() {
		return d_address;
	}

	public void setD_address(String d_address) {
		this.d_address = d_address;
	}

	public String getD_contact() {
		return d_contact;
	}

	public void setD_contact(String d_contact) {
		this.d_contact = d_contact;
	}

	public String getD_emailid() {
		return emailid;
	}

	public void setD_emailid(String d_emailid) {
		this.emailid = d_emailid;
	}

	public String getD_bloodgroup() {
		return bloodgroup;
	}

	public void setD_bloodgroup(String d_bloodgroup) {
		this.bloodgroup = d_bloodgroup;
	}

	public int getD_age() {
		return age;
	}

	public void setD_age(int d_age) {
		this.age = d_age;
	}

	public String getD_type() {
		return type;
	}

	public void setD_type(String d_type) {
		this.type = d_type;
	}

	public DonorEntity()
	{
		
	}

	public DonorEntity(String d_username, String d_password, int d_id, String d_name, String d_city, String d_address,
			String d_contact, String d_emailid, String d_bloodgroup, int d_age, String d_type) {
		super();
		this.d_username = d_username;
		this.d_password = d_password;
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_city = d_city;
		this.d_address = d_address;
		this.d_contact = d_contact;
		this.emailid = d_emailid;
		this.bloodgroup = d_bloodgroup;
		this.age = d_age;
		this.type = d_type;
	}

}
