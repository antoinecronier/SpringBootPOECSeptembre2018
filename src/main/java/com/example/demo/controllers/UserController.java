package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		
		return "users/index";
	}
	
	@RequestMapping(value= {"/delete/{id}"}, method=RequestMethod.DELETE)
	public String deleteId(Model model) {
		
		return "redirect:users/index";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.GET)
	public String deleteCriteria() {
		return "users/delete";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.POST)
	public String deleteCriteriaSearch(Model model) {
		return "users/delete";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.DELETE)
	public String deleteCriteriaDelete() {
		return "users/delete";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.GET)
	public String findCriteria() {
		return "users/find";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.POST)
	public String findCriteriaSearch(Model model) {
		return "users/find";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.GET)
	public String edit(Model model) {
		return "users/edit";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.POST)
	public String editSave() {
		return "redirect:users/index";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.DELETE)
	public String editDelete() {
		return "redirect:users/index";
	}
}
