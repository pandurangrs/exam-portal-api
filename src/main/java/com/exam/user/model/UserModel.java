package com.exam.user.model;

import java.util.Date;
import java.util.Set;

import com.exam.user.entity.Authority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel{

	private String uuid;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private boolean enabled;

	private String about;

	private String phone;

	private String email;

	private Date loginAt;

	private String address;
	
	private String profile;
	
	private Set<Authority> authorities;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	private boolean accountNonExpired;

}
