package com.Test.question.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Test.question.entity.UserAnswerRelation;
import com.Test.question.model.FinalResponse;
import com.Test.question.model.Response;
import com.Test.question.model.UserAnswerRelationDto;
import com.Test.question.service.UserAnswerRelationService;

@RestController
@RequestMapping("/userAnswerRelation")
public class UserAnswerRelationController {
	
	@Autowired
	private UserAnswerRelationService userAnswerRelationService;
	
	@PostMapping("/add")
	public UserAnswerRelation addUserAnswerRelation(@RequestBody UserAnswerRelationDto userAnswerRelationDto)
	{
		return userAnswerRelationService.addUserAnswerRelation(userAnswerRelationDto);
	}
	
	@GetMapping("/listing")
	public List<UserAnswerRelationDto> getUserAnswerRelationList()
	{
		return userAnswerRelationService.getUserAnswerRelationList();
	}
	
	@GetMapping("/finalResult")
	public Map<String, List<FinalResponse>> getAllResult(@Param("userId")int userId)
	{
		return userAnswerRelationService.getViewById(userId);
	}
	
	@GetMapping("/allUser")
	public Map<String, List<Response>> getAll()
	{
		return userAnswerRelationService.getAll();
	}
	
}