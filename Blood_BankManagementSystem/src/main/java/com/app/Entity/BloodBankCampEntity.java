package com.app.Entity;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodbankcamp")
public class BloodBankCampEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="bloodcamp_id")
	int bloodcamp_id;
	
	
	
	@Column(name="bloodbank_name")
	String bloodbank_name;
	
	@Column(name="bloodcamp_city")
	String bloodcamp_city;
	
	@Column(name="bloodcamp_address")
	String bloodcamp_address;
	
	public int getBloodcamp_id() {
		return bloodcamp_id;
	}

	public void setBloodcamp_id(int bloodcamp_id) {
		this.bloodcamp_id = bloodcamp_id;
	}



	public String getBloodbank_name() {
		return bloodbank_name;
	}

	public void setBloodbank_name(String bloodbank_name) {
		this.bloodbank_name = bloodbank_name;
	}

	public String getBloodcamp_city() {
		return bloodcamp_city;
	}

	public void setBloodcamp_city(String bloodcamp_city) {
		this.bloodcamp_city = bloodcamp_city;
	}

	public String getBloodcamp_address() {
		return bloodcamp_address;
	}

	public void setBloodcamp_address(String bloodcamp_address) {
		this.bloodcamp_address = bloodcamp_address;
	}

	public String getBloodcamp_date() {
		return bloodcamp_date;
	}

	public void setBloodcamp_date(String bloodcamp_date) {
		this.bloodcamp_date = bloodcamp_date;
	}

	@Column(name="bloodcamp_date")
	String bloodcamp_date;
	
	
	
	

	
}
