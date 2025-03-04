package com.exam.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.exam.common.entity.Role;

import lombok.Data;

@Entity
@Data
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;

	// user
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
}
