package com.Test.question.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Test.question.entity.OptionMaster;
import com.Test.question.model.OptionMasterDto;
import com.Test.question.service.OptionMasterService;

@RestController
@RequestMapping("/optionMaster")
public class OptionMasterController {
	
	@Autowired
	private OptionMasterService optionMasterService;
	
	@PostMapping("/add")
	public OptionMaster addOptionMaster(@RequestBody OptionMasterDto optionMasterDto)
	{
		return optionMasterService.addOptionMaster(optionMasterDto);
	}
	
	@GetMapping("/listing")
	public List<OptionMasterDto> getOptionMasterListing()
	{
		return optionMasterService.getOptionMasterList();
				
	}
	
	@DeleteMapping("/delete")
	public void deleteOptionMaster(@Param("id")int id)
	{
		optionMasterService.deleteOptionMaster(id);
	}
}
