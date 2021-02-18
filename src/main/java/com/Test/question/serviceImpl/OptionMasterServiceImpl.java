package com.Test.question.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.question.entity.OptionMaster;
import com.Test.question.model.OptionMasterDto;
import com.Test.question.repositry.OptionMasterRepositry;
import com.Test.question.service.OptionMasterService;

@Service
public class OptionMasterServiceImpl implements OptionMasterService {
	
	@Autowired
	private OptionMasterRepositry optionMasterRepositry;

	@Override
	public OptionMaster addOptionMaster(OptionMasterDto optionMasterDto) {
		
		OptionMaster optionMaster = new OptionMaster();
		
		optionMaster.setId(optionMasterDto.getId());
		optionMaster.setOptions(optionMasterDto.getOptions());
		optionMaster.setQuestionId(optionMasterDto.getQuestionId());
		
		return optionMasterRepositry.save(optionMaster);
		
	}

	@Override
	public List<OptionMasterDto> getOptionMasterList() {
		
		List<OptionMasterDto> optionMasterDtoList = new ArrayList<>();
		List<OptionMaster> optionMasterList = optionMasterRepositry.findAll();
				
		for (OptionMaster optionMaster : optionMasterList) {
			
			OptionMasterDto optionMasterDto = new OptionMasterDto();
			
			optionMasterDto.setId(optionMaster.getId());
			optionMasterDto.setOptions(optionMaster.getOptions());
			optionMasterDto.setQuestionId(optionMaster.getQuestionId());
			
			optionMasterDtoList.add(optionMasterDto);
		}
		
		return optionMasterDtoList;
	}

	@Override
	public void deleteOptionMaster(Integer id) {

		optionMasterRepositry.deleteById(id);		
	}
}