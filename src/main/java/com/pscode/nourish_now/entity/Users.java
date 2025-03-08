package com.pscode.nourish_now.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pscode.nourish_now.dto.UserDto;
import com.pscode.nourish_now.enums.ReviewStatus;
import com.pscode.nourish_now.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String address;
	private String registrationNo;
	private String dateOfJoining;
	private String contactNo;
	private String website;
	private UserRole role;
	private ReviewStatus status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public ReviewStatus getStatus() {
		return status;
	}

	public void setStatus(ReviewStatus status) {
		this.status = status;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", registrationNo=" + registrationNo + ", dateOfJoining=" + dateOfJoining + ", contactNo="
				+ contactNo + ", website=" + website + ", role=" + role + ", status=" + status + "]";
	}

	
	@JsonIgnore
	public UserDto getUserDto() {
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setAddress(address);
		dto.setRegistrationNo(registrationNo);
		dto.setDateOfJoining(dateOfJoining);
		dto.setContactNo(contactNo);
		dto.setRole(role);
		dto.setStatus(status);
		dto.setWebsite(website);
		return dto;
	}

}
