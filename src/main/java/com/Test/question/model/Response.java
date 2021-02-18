package com.Test.question.model;

import java.util.List;

public class Response {
	String userName;
	List<FinalResponse> questionAnswerResponse;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<FinalResponse> getQuestionAnswerResponse() {
		return questionAnswerResponse;
	}
	public void setQuestionAnswerResponse(List<FinalResponse> questionAnswerResponse) {
		this.questionAnswerResponse = questionAnswerResponse;
	} 	
}