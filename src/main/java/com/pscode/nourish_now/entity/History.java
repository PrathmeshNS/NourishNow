package com.pscode.nourish_now.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hId;
	private String time;
	private String date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_user_id", referencedColumnName = "id")
	private Users hotelUsers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ngo_user_id", referencedColumnName = "id")
	private Users ngoUsers;

	public Long gethId() {
		return hId;
	}

	public void sethId(Long hId) {
		this.hId = hId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public Users getHotelUsers() {
		return hotelUsers;
	}

	public void setHotelUsers(Users hotelUsers) {
		this.hotelUsers = hotelUsers;
	}

	public Users getNgoUsers() {
		return ngoUsers;
	}

	public void setNgoUsers(Users ngoUsers) {
		this.ngoUsers = ngoUsers;
	}

	@Override
	public String toString() {
		return "History [hId=" + hId + ", time=" + time + ", date=" + date + ", hotelUsers=" + hotelUsers
				+ ", ngoUsers=" + ngoUsers + "]";
	}

}
