package com.exam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	private String uuid;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private boolean enable;
	
	@Column(columnDefinition = "TEXT")
	private String about;
	
	private String phone;
	
	private String mobile;
	
	private String email;
	
	private Date loginAt;
	
	@Column(columnDefinition = "TEXT")
	private String address;
	
	
}
