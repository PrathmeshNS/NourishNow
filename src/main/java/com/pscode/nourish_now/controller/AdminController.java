package com.pscode.nourish_now.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pscode.nourish_now.entity.Users;
import com.pscode.nourish_now.enums.UserRole;
import com.pscode.nourish_now.exception.custome.UserAlreadyExistException;
import com.pscode.nourish_now.service.AdminService;
import com.pscode.nourish_now.service.UserService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService service;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AdminService adminService;

	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody Users user) {
		user.setRole(UserRole.ADMIN);
		user.setPassword(encoder.encode(user.getPassword()));
		try {
			return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
		} catch (UserAlreadyExistException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody Users user) {
		return service.loginUser(user);

	}

	@GetMapping("/")
	public String ky() {
		return "Hello, There \n There is Admin naaaa...... \n I know You are Admin..... \n I will Detect you!!!";
	}

	@GetMapping("get-all-hotel")
	public List<Users> getAllHotel() {
		return adminService.getAllHotel();
	}

	@GetMapping("get-all-ngo")
	public List<Users> getAllNgo() {
		return adminService.getAllNgo();
	}

	@GetMapping("approve-user/{id}")
	public ResponseEntity<String> checkEmail(@PathVariable("id") Long id) {
		return adminService.approveUser(id);
	}

	@GetMapping("logout")
	public void logoutAdmin() {
		return;
	}

}
