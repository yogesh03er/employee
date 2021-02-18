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

import com.Test.question.entity.QuestionAnswer;
import com.Test.question.model.QuestionAnswerDto;
import com.Test.question.service.QuestionAnswerService;

@RestController
@RequestMapping("/questionAnswer")
public class QuestionAnswerController {
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@PostMapping("/add")
	public QuestionAnswer addQuestionAnswer(@RequestBody QuestionAnswerDto questionAnswerDto)
	{
		return questionAnswerService.addQuestionAnswer(questionAnswerDto);
	}
	
	@GetMapping("/listing")
	public List<QuestionAnswerDto> getQuestionAnswerList()
	{
		return questionAnswerService.getQuestionAnswerList();
	}
	
	@DeleteMapping("/delete")
	public void deleteQuestionAnswer(@Param("id")int id)
	{
		questionAnswerService.deleteQuestionAnswer(id);
	}

}
