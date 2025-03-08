package com.pscode.nourish_now.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pscode.nourish_now.entity.Users;
import com.pscode.nourish_now.enums.ReviewStatus;
import com.pscode.nourish_now.enums.UserRole;
import com.pscode.nourish_now.repository.UserRepository;
import com.pscode.nourish_now.utility.PreDefineMessage;

@Service
public class AdminService {

	@Autowired
	private UserRepository repository;

	public ResponseEntity<String> approveUser(Long id) {
		if (repository.approveUser(ReviewStatus.TRUE, id)>0) {
			return ResponseEntity.status(HttpStatus.OK).body(PreDefineMessage.USER_APPROVED_SUCCESSFULLY);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PreDefineMessage.SOMETHING_WENT_WRONG);
	}

	public List<Users> getAllHotel() {
		return repository.findAll().stream()
				.filter(hotel -> hotel.getRole().equals(UserRole.HOTEL))
				.collect(Collectors.toList());
	}
		
	public List<Users> getAllNgo() {
		return repository.findAll().stream()
				.filter(ngo -> ngo.getRole().equals(UserRole.NGO))
				.collect(Collectors.toList());
	}

}
