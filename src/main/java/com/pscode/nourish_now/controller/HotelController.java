package com.pscode.nourish_now.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pscode.nourish_now.entity.Users;
import com.pscode.nourish_now.enums.ReviewStatus;
import com.pscode.nourish_now.enums.UserRole;
import com.pscode.nourish_now.exception.custome.UserAlreadyExistException;
import com.pscode.nourish_now.service.UserService;

import java.util.List;


@RestController
@RequestMapping("hotel")
public class HotelController {


	@Autowired
	private UserService service;
	
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/login")
	public ResponseEntity<?> ngoLogin(@RequestBody Users user) {
		return service.loginUser(user);
	}

	@PostMapping("register")
	public ResponseEntity<?> registerHotel(@RequestBody Users users) {	
		users.setRole(UserRole.HOTEL);
		users.setPassword(encoder.encode(users.getPassword()));
		users.setStatus(ReviewStatus.FALSE);
		try {
			return new ResponseEntity<>(service.saveUser(users), HttpStatus.CREATED);
		} catch (UserAlreadyExistException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/")
	public String greetHotel() {
		return new String("Hello Hotel User");
	}

	@GetMapping("get-all-ngo")
	public List<Users> getAllNgo(){
		return service.getAllNgo();
	}

}
