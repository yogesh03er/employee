package com.Test.question.service;

import java.util.List;
import java.util.Map;

import com.Test.question.entity.UserAnswerRelation;
import com.Test.question.model.FinalResponse;
import com.Test.question.model.Response;
import com.Test.question.model.UserAnswerRelationDto;

public interface UserAnswerRelationService {
	
	UserAnswerRelation addUserAnswerRelation(UserAnswerRelationDto userAnswerRelationDto);
	List<UserAnswerRelationDto> getUserAnswerRelationList();
	
	Map<String, List<FinalResponse>> getViewById(Integer userId);
	Map<String, List<Response>> getAll();
}
