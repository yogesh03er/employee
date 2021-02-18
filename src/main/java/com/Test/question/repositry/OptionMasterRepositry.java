package com.Test.question.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.question.entity.OptionMaster;

public interface OptionMasterRepositry extends JpaRepository<OptionMaster, Integer> {

}

