package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("signup")
	public ResponseEntity<?> signUp(@RequestBody UserReqDTO request) {
		System.out.println("In sign up" + request);
		try {
			return ResponseEntity.ok(userService.addUser(request));

		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("signin")
	public ResponseEntity<?> signInUser(@RequestBody AuthRequest request){
		System.out.println("in sign in" +request);
	  try {
		  return ResponseEntity.ok(userService.authenticateUser(request));
		  
	  }catch(RuntimeException e) {
		  System.out.println(e);
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		  
	  }
	}
	
}
