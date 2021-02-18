package com.Test.question.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.question.entity.QuestionMaster;

public interface QuestionMasterRepositry extends JpaRepository<QuestionMaster, Integer>{
	

}
