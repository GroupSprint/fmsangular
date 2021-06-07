package com.cg.flightmgmt.test.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.controller.UserController;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.UserService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	@InjectMocks UserController control;
	@Mock UserService service;
	
	@Test
	public void addUser()
	{
		User user = new User();
		Mockito.when(service.addUser(user)).thenReturn(user);
		assertEquals(control.addUser(user).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void updateUser() throws UserNotFoundException
	{
		User user = new User();
		Mockito.when(service.updateUser(user)).thenReturn(user);
		assertEquals(control.updateUser(user).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void validateUser() throws UserNotFoundException
	{
		User user = new User();
		user.setUserName("Harsh");
		user.setPassword("123456");
		user.setUserType("customer");
		Mockito.when(service.validateUser(user)).thenReturn(user);
		assertEquals(control.validateUser("Harsh", "123456", "customer").getStatusCode(), HttpStatus.OK);
	}
}
