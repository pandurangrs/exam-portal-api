package com.exam.user.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Transient;

import com.exam.common.entity.Audit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends Audit {

	private static final long serialVersionUID = 1L;

	private String uuid;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private boolean enabled = true;

	private String about;

	private String phone;

	private String email;

	private Date loginAt;

	@Column(columnDefinition = "TEXT")
	private String address;

	// user has many Roles
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	private Set<UserRole> userRoles = new HashSet<>();



}
