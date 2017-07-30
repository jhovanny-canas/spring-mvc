package com.tenacity.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tenacity.mvc.data.entities.Project;
import com.tenacity.mvc.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/{projectId}")
	public String findProject(Model model,@PathVariable("projectId") Long projectId ){
		model.addAttribute("project", this.projectService.find(projectId));
		
		return "project";
	}
	
	@RequestMapping(value="/find")
	public String find(Model model){
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add",method =RequestMethod.GET)
	public String addProject(){
		System.out.println("se invoca get methodo");
		return "project_add";
	}

	//* esto es sin la propiedad databinding
	/*
	 * 
	 * 
	 * 	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(){
		System.out.println("se invoca post metodo");
		return "project_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi"})
	public String SaveMultiYearProject(){
		System.out.println("se invoca multiple request params metodo");
		return "project_add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi","special"})
	public String SaveSpecialProject(){
		System.out.println("se invoca multiple request params metodo y special");
		return "project_add";
	}
	*/

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(@ModelAttribute Project project){
		System.out.println("se invoca post metodo");
		System.out.println(project.toString());
		return "project_add";
	}

}
