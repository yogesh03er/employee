package com.Test.question.service;

import java.util.List;

import com.Test.question.entity.QuestionMaster;
import com.Test.question.model.QuestionMasterDto;

public interface QuestionMasterService {
	
	QuestionMaster addQuestionMaster(QuestionMasterDto questionMasterDto);
	List<QuestionMasterDto> getQuestionMasterList();
	public void deleteQuestionMaster(Integer id);

}
