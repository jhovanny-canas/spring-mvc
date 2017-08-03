package com.tenacity.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenacity.mvc.data.entities.Project;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String goHome(Model model){
		Project project = new Project();
		project.setName("Projecto prueba");
		//project.setSponsor("Nasa");
		project.setDescription("projecto de prueba");
		model.addAttribute("project", project);
		
		return "home";
	}

	
	
}
