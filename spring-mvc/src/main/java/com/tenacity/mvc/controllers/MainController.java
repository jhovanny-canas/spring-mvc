package com.tenacity.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/home")
	@ResponseBody
	public String goHome(){
		return"Welcome";
	}

}
