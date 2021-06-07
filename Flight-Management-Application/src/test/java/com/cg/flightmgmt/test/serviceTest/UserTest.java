package com.cg.flightmgmt.test.serviceTest;
import java.math.BigInteger;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;
import com.cg.flightmgmt.service.IUserService;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	@Autowired 
	IUserService userService;
	@MockBean 
	IUserRepository userRepository;

	
	@Test
	public void addUserValidTest() {
		User user = new User();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userService.addUser(user));
	}
	
	@Test
	public void updateUserValidTest() throws UserNotFoundException {
		User updateUser = new User();
		updateUser.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findById(BigInteger.valueOf(100))).thenReturn(Optional.of(updateUser));
		Mockito.when(userRepository.save(updateUser)).thenReturn(updateUser);
		Assertions.assertDoesNotThrow(() -> userService.updateUser(updateUser));
	}

	@Test
	public void removeUserValidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findById(BigInteger.valueOf(100))).thenReturn(Optional.of(user));
		Assertions.assertDoesNotThrow(() -> userService.removeUser(BigInteger.valueOf(100)));
	}
	
	@Test
	public void validateUserValidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		user.setUserName("sruthi");
		user.setPassword("rakshitha");
		user.setUserType("customer");
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(Optional.of(user));
		Assertions.assertDoesNotThrow(() -> userService.validateUser(user));
	}
	
	@Test
	public void validateUserInvalidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(Optional.empty());
		UserNotFoundException uNFE = Assertions.assertThrows(UserNotFoundException.class,() -> userService.validateUser(user));
		Assertions.assertEquals("Please enter valid user id.", uNFE.getMessage());
	}
}
