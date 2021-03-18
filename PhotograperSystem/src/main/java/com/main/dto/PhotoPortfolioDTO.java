package com.main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PhotoPortfolioDTO {

    
    
    @GeneratedValue
    @Id
    private String id;
    private String entryDate;
    private String categoryName;
    private String photoDescription;
    private String photoURL;
    private float  rate;
    private Integer photograperId;
    
    private String isActive;
    
    public PhotoPortfolioDTO() {}

	public PhotoPortfolioDTO(String id, String entryDate, String categoryName, String photoDescription, String photoURL,
			float rate, Integer photograperId, String isActive) {
		super();
		this.id = id;
		this.entryDate = entryDate;
		this.categoryName = categoryName;
		this.photoDescription = photoDescription;
		this.photoURL = photoURL;
		this.rate = rate;
		this.photograperId = photograperId;
		this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPhotoDescription() {
		return photoDescription;
	}

	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Integer getPhotograperId() {
		return photograperId;
	}

	public void setPhotograperId(Integer photograperId) {
		this.photograperId = photograperId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "PhotoPortfolioTO [id=" + id + ", entryDate=" + entryDate + ", categoryName=" + categoryName
				+ ", photoDescription=" + photoDescription + ", photoURL=" + photoURL + ", rate=" + rate
				+ ", photograperId=" + photograperId + ", isActive=" + isActive + "]";
	}

   
}
