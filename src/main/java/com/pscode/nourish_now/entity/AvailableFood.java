package com.pscode.nourish_now.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AvailableFood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aId;
	private String dateTime;
	private String description;
	private int approxPersonCanEat;

	@ManyToOne
	@JoinColumn(name = "hotelUserId", referencedColumnName = "id")
	private Users hotelUsers;

	public Long getaId() {
		return aId;
	}

	public void setaId(Long aId) {
		this.aId = aId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getApproxPersonCanEat() {
		return approxPersonCanEat;
	}

	public void setApproxPersonCanEat(int approxPersonCanEat) {
		this.approxPersonCanEat = approxPersonCanEat;
	}

	public Users getHotelUsers() {
		return hotelUsers;
	}

	public void setHotelUsers(Users hotelUsers) {
		this.hotelUsers = hotelUsers;
	}

}
