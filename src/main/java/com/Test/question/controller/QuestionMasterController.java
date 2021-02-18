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
import com.Test.question.entity.QuestionMaster;
import com.Test.question.model.QuestionMasterDto;
import com.Test.question.service.QuestionMasterService;

@RestController
@RequestMapping("/questionMaster")
public class QuestionMasterController {
	
	@Autowired
	private QuestionMasterService questionMasterService;
	
	@PostMapping("/add")
	public QuestionMaster addQuestionMaster(@RequestBody QuestionMasterDto questionMasterDto)
	{
		return questionMasterService.addQuestionMaster(questionMasterDto);
	}
	
	@GetMapping("/listing")
	public List<QuestionMasterDto> getQuestionMasterListing()
	{
		return questionMasterService.getQuestionMasterList();
	}
	
	@DeleteMapping("/delete")
	public void deleteQuestionMaster(@Param("id")int id)
	{
		questionMasterService.deleteQuestionMaster(id);
	}

}
