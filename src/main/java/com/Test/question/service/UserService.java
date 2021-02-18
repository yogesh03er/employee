package com.Test.question.service;

import java.util.List;
import com.Test.question.entity.User;
import com.Test.question.model.UserDto;

public interface UserService {
	
	User addUser(UserDto userDto);
	List<UserDto> getUserList();
	public void deleteUser(Integer id);

}
