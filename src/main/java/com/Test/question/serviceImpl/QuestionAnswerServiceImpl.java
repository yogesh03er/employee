package com.Test.question.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.question.entity.QuestionAnswer;
import com.Test.question.model.QuestionAnswerDto;
import com.Test.question.repositry.QuestionAnswerRepositry;
import com.Test.question.service.QuestionAnswerService;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	
	@Autowired
	private QuestionAnswerRepositry questionAnswerRepositry;

	@Override
	public QuestionAnswer addQuestionAnswer(QuestionAnswerDto questionAnswerDto) {
		
		QuestionAnswer questionAnswer = new QuestionAnswer();
		
		questionAnswer.setId(questionAnswerDto.getId());
		questionAnswer.setOptionId(questionAnswerDto.getOptionId());
		questionAnswer.setQuestionId(questionAnswerDto.getQuestionId());
		
		return questionAnswerRepositry.save(questionAnswer);
	}

	@Override
	public List<QuestionAnswerDto> getQuestionAnswerList() {
		
		List<QuestionAnswerDto> questionAnswerDtoList = new ArrayList<>();
		List<QuestionAnswer> questionAnswerList = questionAnswerRepositry.findAll();
		
		for (QuestionAnswer questionAnswer : questionAnswerList) {
			
			QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
			
			questionAnswerDto.setId(questionAnswer.getId());
			questionAnswerDto.setOptionId(questionAnswer.getOptionId());
			questionAnswerDto.setQuestionId(questionAnswer.getQuestionId());
			
			questionAnswerDtoList.add(questionAnswerDto);
		}
		
		return questionAnswerDtoList;
	}

	@Override
	public void deleteQuestionAnswer(Integer id) {
		
		questionAnswerRepositry.deleteById(id);
	}

}
