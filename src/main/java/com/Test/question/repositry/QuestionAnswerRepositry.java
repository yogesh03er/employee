package com.Test.question.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.question.entity.QuestionAnswer;

public interface QuestionAnswerRepositry extends JpaRepository<QuestionAnswer, Integer>
{

}
