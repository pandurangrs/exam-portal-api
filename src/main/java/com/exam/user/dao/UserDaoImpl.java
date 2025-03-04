package com.exam.user.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.common.exception.ResourceNotFoundException;
import com.exam.user.entity.User;
import com.exam.user.repo.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private UserRepository userRepository;

	// add User
	@Override
	public User saveUser(User user) {
		logger.info("saving User : {}", user);
		return userRepository.save(user);
	}

	@Override
	public User getUserUsingId(String userUuid) {
		return userRepository.findByUuid(userUuid)
				.orElseThrow(() -> new ResourceNotFoundException("UserName", "UserUuid", userUuid));
	}

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public boolean exitByUserName(String userName) {

		return userRepository.existsByUserName(userName);
	}

}
