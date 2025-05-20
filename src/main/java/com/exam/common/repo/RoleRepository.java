package com.exam.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.common.constant.RoleStatus;
import com.exam.common.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleId(Long roleNormal);

}
