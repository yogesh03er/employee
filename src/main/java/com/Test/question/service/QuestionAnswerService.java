package com.Test.question.service;

import java.util.List;
import com.Test.question.entity.QuestionAnswer;
import com.Test.question.model.QuestionAnswerDto;

public interface QuestionAnswerService {
	
	QuestionAnswer addQuestionAnswer(QuestionAnswerDto questionAnswerDto);
	List<QuestionAnswerDto> getQuestionAnswerList();
	public void deleteQuestionAnswer(Integer id);

}
