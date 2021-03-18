package com.main.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "BookingDTO")
public class BookingDTO {

   @Id
   @GeneratedValue
    private String id;
    private String photoCategory;
    private Integer photoId;
    private Integer userID;
    private Integer photographerID;
    private Date bookingDate;
    private float Rate;
    private String status;
    private String isActive;
    
    public BookingDTO() {

    }
    
    

	public BookingDTO(String id, String photoCategory, Integer photoId, Integer userID, Integer photographerID,
			Date bookingDate, float rate, String status, String isActive) {
		super();
		this.id = id;
		this.photoCategory = photoCategory;
		this.photoId = photoId;
		this.userID = userID;
		this.photographerID = photographerID;
		this.bookingDate = bookingDate;
		Rate = rate;
		this.status = status;
		this.isActive = isActive;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhotoCategory() {
		return photoCategory;
	}

	public void setPhotoCategory(String photoCategory) {
		this.photoCategory = photoCategory;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getPhotographerID() {
		return photographerID;
	}

	public void setPhotographerID(Integer photographerID) {
		this.photographerID = photographerID;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public float getRate() {
		return Rate;
	}

	public void setRate(float rate) {
		Rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "BookingDTO [id=" + id + ", photoCategory=" + photoCategory + ", photoId=" + photoId + ", userID="
				+ userID + ", photographerID=" + photographerID + ", bookingDate=" + bookingDate + ", Rate=" + Rate
				+ ", status=" + status + ", isActive=" + isActive + "]";
	}

   
}
