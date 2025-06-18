package com.exam.user.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exam.common.dao.CommonDao;
import com.exam.common.entity.Role;
import com.exam.common.exception.CustomException;
import com.exam.common.mapper.Mapper;
import com.exam.user.dao.UserDao;
import com.exam.user.dto.UserDto;
import com.exam.user.entity.User;
import com.exam.user.entity.UserRole;
import com.exam.user.model.UserModel;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private Mapper mapper;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CommonDao commonDao;

	// add User
	@Override
	public UserModel addUser(UserDto userDto, Set<UserRole> userRole) {
		logger.info("calling addUser Service {}", userDto);

		if (userDao.exitByUserName(userDto.getUserName())) {
			logger.info("User already exist this name :  {}", userDto.getUserName());
			throw new CustomException("User already there !!", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			User user = mapper.convert(userDto, User.class);

			for (UserRole ur : userRole) {
				Role saveRole = commonDao.saveRole(ur.getRole());
				ur.setUser(user);
			}
			
			
			user.setUserRoles(userRole);
			user.setUuid(UUID.randomUUID().toString());
			return mapper.convert(userDao.saveUser(user), UserModel.class);
		}

	}

	// get Single User
	@Override
	public UserModel getSingleUser(String userUuid) {
		return mapper.convert(userDao.getUserUsingId(userUuid), UserModel.class);
	}

	// get user List
	@Override
	public List<UserModel> getUserList() {
		return mapper.convertToList(userDao.getUserList(), UserModel.class);
	}

	// update USer
	@Override
	public UserModel updateUser(UserDto UserDto, String userUuid) {
		User user = userDao.getUserUsingId(userUuid);
		updateUserData(user, UserDto);
		return mapper.convert(user, UserModel.class);
	}

	private void updateUserData(User user, UserDto userDto) {
		user.setUserName(userDto.getUserName());
		user.setPhone(userDto.getPhone());
		user.setPassword(userDto.getPassword());
		user.setLastName(userDto.getLastName());
		user.setFirstName(userDto.getFirstName());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setAbout(userDto.getAbout());

	}

	// delete User
	@Override
	public void deleteUser(String userUuid) {
		userDao.getUserUsingId(userUuid);
	}

}
