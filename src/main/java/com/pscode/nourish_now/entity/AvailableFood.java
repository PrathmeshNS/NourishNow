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
	private String date;
	private String description;
	private String time;
	private int approxPersonCanEat;
	
	@ManyToOne
	@JoinColumn(name = "hotelUserId",referencedColumnName = "id")
	private Users hotelUsers;

	public Long getaId() {
		return aId;
	}

	public void setaId(Long aId) {
		this.aId = aId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
