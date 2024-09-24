package com.talking.clock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.talking.clock.service.ClockService;


@RestController
public class ClockController {
	
	@Autowired 
	private ClockService service;
	
	
	@GetMapping("/time/{time}")
	public Map<String, String> getTimeInWords(@PathVariable String time){
		
		return service.convertTimeToWords(time);
		
	}
	
}


	 
	 

