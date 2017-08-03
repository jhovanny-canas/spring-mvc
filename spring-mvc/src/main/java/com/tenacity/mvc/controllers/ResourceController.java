package com.tenacity.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tenacity.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {
	
	@RequestMapping("/add")
	public String add(Model model){
		if(1==1){
			throw new RuntimeException("Hubo un error");
		}
		/*
		model.addAttribute("resource", new Resource());
		List<String> opciones = new LinkedList<>(Arrays.asList(new String[]{
				"Material", "Other","Staff", "Tecnical Equipment"}));
		
		List<String> radios = new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"
		}));
		
		List<String> checks = new LinkedList<>(Arrays.asList(new String[]{
			"Lead Time", "Special Rate", "Requieres Aproval"	
		}));
		model.addAttribute("typeOptions", opciones);
		model.addAttribute("radiosOptions", radios);
		model.addAttribute("checkOptions", checks);*/
		
		return "resource_add";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request){
		return "controller_error";
	}
	
	@ModelAttribute("resource")
	public Resource getResource(){
		return new Resource();
	}
	
	@ModelAttribute("typeOptions")
	public List<String> getOptions()
	{
		return new LinkedList<>(Arrays.asList(new String[]{
				"Material", "Other","Staff", "Tecnical Equipment"}));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios(){
		return new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"
		}));
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks(){
		return new LinkedList<>(Arrays.asList(new String[]{
				"Lead Time", "Special Rate", "Requieres Aproval"	
			}));
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus status){
		System.out.println(resource);
		status.setComplete();
		return "redirect:/resource/add";
	}


	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource){
		System.out.println("invocando a review");
		return "resource_review";
	}
	
	@RequestMapping("/request")
	@ResponseBody
	public String request(@ModelAttribute("resource") Resource resource){
		
		return "the request ha sido aprobada";
	}

}
