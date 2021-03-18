package com.main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class PhotgrapherDTO {

	@GeneratedValue
	@Id
	private Integer id;

	private String firstName;
	private String lastName;
	private String emaild;
	private String contact;
	private String username;
	private String password;
	private String isActive;
	private String city;
	private String skill;
	private float rate;

	public PhotgrapherDTO() {
	}

	public PhotgrapherDTO(Integer id, String firstName, String lastName, String emaild, String contact, String username,
			String password, String isActive, String city, String skill, float rate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emaild = emaild;
		this.contact = contact;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.city = city;
		this.skill = skill;
		this.rate = rate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmaild() {
		return emaild;
	}

	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		skill = skill;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "PhotgrapherDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emaild=" + emaild
				+ ", contact=" + contact + ", username=" + username + ", password=" + password + ", isActive="
				+ isActive + ", city=" + city + ", skill=" + skill + ", rate=" + rate + "]";
	}

}
