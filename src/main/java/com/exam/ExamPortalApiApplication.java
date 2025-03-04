package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.exam.common.entity.Role;
import com.exam.common.mapper.Mapper;
import com.exam.user.dto.UserDto;
import com.exam.user.entity.User;
import com.exam.user.entity.UserRole;
import com.exam.user.model.UserModel;
import com.exam.user.service.UserService;

@SpringBootApplication
@PropertySource(value = "classpath:/profiles/${spring.profiles.active}/application.properties")
public class ExamPortalApiApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(ExamPortalApiApplication.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApiApplication.class, args);
		System.out.println("Hellow world....");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Starting exam portal ...............");

		UserDto userDto = new UserDto();
		userDto.setFirstName("Pandurang");
		userDto.setLastName("Shinde");
		userDto.setUserName("pandurangrs");
		userDto.setPassword("Pandurang@190");
		userDto.setEmail("pandurang@gmail.com");
		userDto.setPhone("7083021253");
		userDto.setAddress("Pune");

		User user = mapper.convert(userDto, User.class);
		
		Role role=new Role();
		role.setRoleName("ADMIN");
		
		Set<UserRole> userRole=new HashSet<>();
		UserRole uRole=new UserRole();
		uRole.setRole(role);
		uRole.setUser(user);
		userRole.add(uRole);
		
		
		userDto.setUserRoles(userRole);
		UserModel userModel=userService.addUser(userDto, userRole);
		logger.info("User Added Sucessfully. {}",userModel);
	}

}
