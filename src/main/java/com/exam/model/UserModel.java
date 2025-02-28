package com.exam.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
	
	private String uuid;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private boolean enable;
	
	private String about;
	
	private String phone;
	
	private String mobile;
	
	private String email;
	
	private Date loginAt;
	
	private String address;
}
