package com.exam.common.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.common.constant.AppConstant;
import com.exam.common.constant.RoleStatus;
import com.exam.common.entity.Role;
import com.exam.common.repo.RoleRepository;

@Repository
public class CommonDaoImpl implements CommonDao {

	Logger logger = LoggerFactory.getLogger(CommonDaoImpl.class);

	@Autowired
	private RoleRepository roleRepository;

	public Role saveRole(Role userRole) {
		return roleRepository.save(userRole);
	}
	
	public Role getRole() {
		return roleRepository.findByRoleId(AppConstant.ROLE_NORMAL);
	}

}
