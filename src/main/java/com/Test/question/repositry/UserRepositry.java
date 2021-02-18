package com.Test.question.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Test.question.entity.User;

public interface UserRepositry extends JpaRepository<User, Integer> {
	
}
