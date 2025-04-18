package com.pscode.nourish_now.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pscode.nourish_now.dto.UserDto;
import com.pscode.nourish_now.enums.ReviewStatus;
import com.pscode.nourish_now.enums.UserRole;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

	@OneToOne(cascade = CascadeType.ALL)
	private UserProfile profile;

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
