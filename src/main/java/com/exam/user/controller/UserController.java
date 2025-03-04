package com.exam.user.controller;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.common.constant.UrlMapping;
import com.exam.user.dto.UserDto;
import com.exam.user.entity.UserRole;
import com.exam.user.model.UserModel;
import com.exam.user.service.UserService;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(UrlMapping.USERS)
	public ResponseEntity<UserModel> saveUser(@RequestBody UserDto userDto) {
		Set<UserRole> userRole=new HashSet<>();
		
		UserModel userModel = userService.addUser(userDto,userRole);
		return new ResponseEntity<>(userModel, HttpStatus.CREATED);
	}

	@GetMapping(UrlMapping.USER_UUID)
	public ResponseEntity<UserModel> getSingleUser(@RequestParam String userUuid) {
		UserModel userModel = userService.getSingleUser(userUuid);
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}
}
