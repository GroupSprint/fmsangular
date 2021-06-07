package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

	// creating logger object 
	public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	// implementation of add user method
	@Override
	public User addUser(User user) {
		LOG.info("User addUser()");
		return userRepository.save(user);
	}

	// implementation of update user method
	@Override
	public User updateUser(User user) throws UserNotFoundException {
		LOG.info("User updateUser()");
		Optional<User> optionalUser = userRepository.findById(user.getUserId());
		User userFromRepo = optionalUser.orElseThrow(() -> new UserNotFoundException("User Id Not Found."));
		userFromRepo.setEmail(user.getEmail());
		userFromRepo.setMobileNumber(user.getMobileNumber());
		userFromRepo.setPassword(user.getPassword());
		userFromRepo.setUserId(user.getUserId());
		userFromRepo.setUserName(user.getUserName());
		userFromRepo.setUserType(user.getUserType());
		return userRepository.save(userFromRepo);
	}

	// implementation of remove user by id
	@Override
	public void removeUser(BigInteger userId) throws UserNotFoundException {
		LOG.info("User removeUser()");
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.orElseThrow(() -> new UserNotFoundException("User Id Not Found."));
		userRepository.deleteById(userId);
	}

	// implementation of validating user details
	@Override
	public User validateUser(User user) throws UserNotFoundException {
		LOG.info("User validateUser()");
		Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());
		User userFromRepo = optionalUser.orElseThrow(() -> new UserNotFoundException("Please enter valid user id."));
		if(!user.getPassword().equals(userFromRepo.getPassword())) {
			throw new UserNotFoundException("Password does not match.");
		}
			else if (!user.getUserType().equals(userFromRepo.getUserType())) {
				throw new UserNotFoundException("change the type of user");
			}
		
		return userFromRepo;
	}

	// View User by Id
	@Override
	public User getUserById(BigInteger id) {
		LOG.info("User getUserById()");
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	// get All user details
	@Override
	public List<User> getAllUser() {
		LOG.info("List<User> getAllUser()");
		List<User> user = userRepository.findAll();
		return user;
	}
	
	
}