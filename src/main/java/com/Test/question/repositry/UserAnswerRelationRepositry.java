package com.Test.question.repositry;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Test.question.entity.UserAnswerRelation;
import com.Test.question.model.ResponseResult;
import com.Test.question.model.UserResultById;

@Repository
public interface UserAnswerRelationRepositry extends JpaRepository<UserAnswerRelation, Integer>{
	
	@Query(nativeQuery=true, value=" select us.name, qm.question, om.options, uar.question_id "
			+ " from ( ( (user_answer_relation uar inner join user us on uar.user_id=us.id) "
			+ " inner join question_master qm on uar.question_id=qm.id) "
			+ " inner join option_master om on uar.option_id=om.id) "
			+ " where uar.user_id=:userId ")
	List<UserResultById> getViewById(@Param("userId")Integer userId);
	
	@Query(nativeQuery=true, value=" select qa.question_id, om.options "
			+ " from question_answer qa inner join option_master om on qa.option_id=om.id "
			+ " where qa.question_id in (:list) ")
	
	List<ResponseResult> getViewResultById(@Param("list") List<Integer> list);
	
	@Query(nativeQuery=true, value=" select id from user ")
	
	List<Integer>  getId();
	
//@Query(nativeQuery=true, value=" select name from user ")
//	
//	List<String>  getName();
	
	@Query(nativeQuery=true, value=" select om.options, qa.question_id "
			+ " from user_answer_relation uar "
			+ " right join user us on uar.user_id=us.id "
			+ " inner join question_answer qa on uar.option_id=qa.option_id "
			+ " inner join option_master om on qa.option_id=om.id ")
	
	List<ResponseResult> getAll();
	
	@Query(nativeQuery=true, value=" select us.name, qm.question, om.options, uar.question_id, us.id "
			+ " from user_answer_relation uar " 
			+ " right join user us on uar.user_id=us.id "
			+ " left join question_master qm on uar.question_id=qm.id "
			+ " inner join option_master om on uar.option_id=om.id "
			+ " where uar.user_id in (:userList) ")
	
	List<UserResultById> getUserId(@Param("userList") List<Integer> userList);
}
