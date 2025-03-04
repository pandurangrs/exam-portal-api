package com.exam.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Data
public class Audit implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column
//	private Long id;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "Created_At", nullable = false, updatable = false)
//	@CreatedDate
//	private Date createdAt;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "Updated_At", nullable = false)
//	@LastModifiedDate
//	private Date updatedAt;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	protected Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created_At", updatable = false)
	@CreatedDate
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Updated_At")
	@LastModifiedDate
	private Date updatedAt;
}
