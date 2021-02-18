package com.Test.question.service;

import java.util.List;

import com.Test.question.entity.OptionMaster;
import com.Test.question.model.OptionMasterDto;

public interface OptionMasterService {
	
	OptionMaster addOptionMaster(OptionMasterDto optionMasterDto);
	List<OptionMasterDto> getOptionMasterList();
	public void deleteOptionMaster(Integer id);

}
