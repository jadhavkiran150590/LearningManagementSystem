package com.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("/coursefallback")
	public String courseFallBack()
	{
		return "Course Service is down please wait!!!!!";
	}
	
	@GetMapping("/studentfallback")
	public String studentFallBack()
	{
		return "Student Service is down please wait!!!!!";
	}
	
	
}
