package com.tenacity.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenacity.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("resource", new Resource());
		List<String> opciones = new LinkedList<>(Arrays.asList(new String[]{
				"Material", "Other","Staff", "Tecnical Equipment"}));
		model.addAttribute("typeOptions", opciones);
		
		List<String> radios = new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"
		}));
		
		List<String> checks = new LinkedList<>(Arrays.asList(new String[]{
			"Lead Time", "Special Rate", "Requieres Aproval"	
		}));
		
		model.addAttribute("radiosOptions", radios);
		model.addAttribute("checkOptions", checks);
		return "resource_add";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource){
		System.out.println(resource);
		return "redirect:/resource/add";
	}



}
