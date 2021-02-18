package com.Test.question.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Test.question.entity.User;
import com.Test.question.model.UserDto;
import com.Test.question.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public User addUser(@RequestBody UserDto userDto)
	{
		return userService.addUser(userDto);
	}
	
	@GetMapping("/listing")
	public List<UserDto> addUserListing()
	{
		return userService.getUserList();
	}
	
	@DeleteMapping("/delete")
	public void deleteUser(@Param("id")int id)
	{
		userService.deleteUser(id);
	}

}
