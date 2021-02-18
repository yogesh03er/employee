package com.Test.question.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Test.question.entity.UserAnswerRelation;
import com.Test.question.model.FinalResponse;
import com.Test.question.model.Response;
import com.Test.question.model.ResponseResult;
import com.Test.question.model.UserAnswerRelationDto;
import com.Test.question.model.UserResultById;
import com.Test.question.repositry.UserAnswerRelationRepositry;
import com.Test.question.service.UserAnswerRelationService;

@Service
public class UserAnswerRelationServiceImpl implements UserAnswerRelationService {

	@Autowired
	private UserAnswerRelationRepositry userAnswerRelationRepositry;

	@Override
	public UserAnswerRelation addUserAnswerRelation(UserAnswerRelationDto userAnswerRelationDto) {

		UserAnswerRelation userAnswerRelation = new UserAnswerRelation();

		userAnswerRelation.setId(userAnswerRelationDto.getId());
		userAnswerRelation.setUserId(userAnswerRelationDto.getUserId());
		userAnswerRelation.setQuestionId(userAnswerRelationDto.getQuestionId());
		userAnswerRelation.setOptionId(userAnswerRelationDto.getOptionId());

		return userAnswerRelationRepositry.save(userAnswerRelation);
	}

	@Override
	public List<UserAnswerRelationDto> getUserAnswerRelationList() {

		List<UserAnswerRelationDto> userAnswerRelationDtoList = new ArrayList<>();
		List<UserAnswerRelation> userAnswerRelationList = userAnswerRelationRepositry.findAll();

		for (UserAnswerRelation userAnswerRelation : userAnswerRelationList) {

			UserAnswerRelationDto userAnswerRelationDto = new UserAnswerRelationDto();

			userAnswerRelationDto.setId(userAnswerRelation.getId());
			userAnswerRelationDto.setUserId(userAnswerRelation.getUserId());
			userAnswerRelationDto.setQuestionId(userAnswerRelation.getQuestionId());
			userAnswerRelationDto.setOptionId(userAnswerRelation.getOptionId());

			userAnswerRelationDtoList.add(userAnswerRelationDto);
		}
		return userAnswerRelationDtoList;
	}

	@Override
	public Map<String, List<FinalResponse>> getViewById(Integer userId) {
		List<UserResultById> userResultByIdlist = userAnswerRelationRepositry.getViewById(userId);
		List<Integer> list = new ArrayList<>();

		for (UserResultById userResultById : userResultByIdlist) {

			list.add(userResultById.getQuestion_id());
		}

		List<ResponseResult> responseResultList = userAnswerRelationRepositry.getViewResultById(list);

		Map<String, List<FinalResponse>> map = new HashMap<>();

		List<FinalResponse> finalResponseList = new ArrayList<>();

		for (UserResultById userResultById : userResultByIdlist) {

			FinalResponse finalResponse = new FinalResponse();

			finalResponse.setQuestion(userResultById.getQuestion());
			finalResponse.setUserAnswer(userResultById.getOptions());

			for (ResponseResult responseResult : responseResultList) {

				if (userResultById.getQuestion_id() == responseResult.getQuestion_id()) {
					finalResponse.setCorrectAnswer(responseResult.getOptions());
				}
			}
			finalResponseList.add(finalResponse);
		}

		map.put(userResultByIdlist.get(0).getName(), finalResponseList);

		return map;
	}

	@Override
	public Map<String, List<Response>> getAll() {

		List<Integer> userList = userAnswerRelationRepositry.getId();
		List<ResponseResult> responseResultList = userAnswerRelationRepositry.getAll();
		List<UserResultById> userResultByIdList = userAnswerRelationRepositry.getUserId(userList);

		Map<String, List<Response>> map = new HashMap<>();
		List<Response> responseList = new ArrayList<>();
		for (Integer userId : userList) {
			
			Response response = new Response();
			List<FinalResponse> finalResponseList = new ArrayList<>();
			for (UserResultById userResultById : userResultByIdList) {
				FinalResponse finalResponse = new FinalResponse();				   
				if (userId == userResultById.getId()) {
										
					response.setUserName(userResultById.getName());
								 							
					finalResponse.setQuestion(userResultById.getQuestion());
					finalResponse.setUserAnswer(userResultById.getOptions());

					for (ResponseResult responseResult : responseResultList) {

						if (userResultById.getQuestion_id() == responseResult.getQuestion_id()) {
							finalResponse.setCorrectAnswer(responseResult.getOptions());
						}
					}
					finalResponseList.add(finalResponse);
				}				
			}	
			response.setQuestionAnswerResponse(finalResponseList);
			responseList.add(response);
		}
		map.put("data", responseList);
		return map;
	}
}