package com.Test.question.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Test.question.entity.User;
import com.Test.question.model.UserDto;
import com.Test.question.repositry.UserRepositry;
import com.Test.question.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositry userRepositry;

	@Override
	public User addUser(UserDto userDto) {
		User user = new User();
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		
		return userRepositry.save(user);
	}

	@Override
	public List<UserDto> getUserList() {
		List<UserDto> userDtoList = new ArrayList<>();
		List<User> userList = userRepositry.findAll();
		
		for (User user : userList) {
			
			UserDto userDto = new UserDto();
			
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public void deleteUser(Integer id) {
		
		userRepositry.deleteById(id);
	}

}
