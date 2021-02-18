package com.Test.question.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.question.entity.QuestionMaster;
import com.Test.question.model.QuestionMasterDto;
import com.Test.question.repositry.QuestionMasterRepositry;
import com.Test.question.service.QuestionMasterService;

@Service
public class QuestionMasterServiceImpl implements QuestionMasterService {
	
	@Autowired
	private QuestionMasterRepositry questionMasterRepositry;

	@Override
	public QuestionMaster addQuestionMaster(QuestionMasterDto questionMasterDto) {
		
		QuestionMaster questionMaster = new QuestionMaster();
		
		questionMaster.setId(questionMasterDto.getId());
		questionMaster.setQuestion(questionMasterDto.getQuestion());
		
		return questionMasterRepositry.save(questionMaster);
	}

	@Override
	public List<QuestionMasterDto> getQuestionMasterList() {
			
		List<QuestionMasterDto> questionMasterDtoList = new ArrayList<>();
		List<QuestionMaster> questionMasterList = questionMasterRepositry.findAll();
		
		for (QuestionMaster questionMaster : questionMasterList) {
			
			QuestionMasterDto questionMasterDto = new QuestionMasterDto();
			
			questionMasterDto.setId(questionMaster.getId());
			questionMasterDto.setQuestion(questionMaster.getQuestion());
			
			questionMasterDtoList.add(questionMasterDto);
		}
				
		return questionMasterDtoList;
	}

	@Override
	public void deleteQuestionMaster(Integer id) {
		
		questionMasterRepositry.deleteById(id);

	}

}
