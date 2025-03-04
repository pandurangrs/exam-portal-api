package com.exam.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUuid(String userUuid);

	boolean existsByUserName(String userName);

}
