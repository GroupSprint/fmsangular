package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

//creating user service interface
public interface IUserService {

	public User addUser(User user);
	public User validateUser(User user) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	public void removeUser(BigInteger userid) throws UserNotFoundException;
	public User getUserById(BigInteger id);
	public List<User> getAllUser();
}
