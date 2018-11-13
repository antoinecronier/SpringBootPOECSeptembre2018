package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dtos.UserDeleteCriteriaDTO;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("users",this.userService.findAll());
		model.addAttribute("pageName","Users index");
		return "users/index";
	}
	
	@RequestMapping(value= {"/delete/{id}"}, method=RequestMethod.GET)
	public String deleteId(Model model, @PathVariable Integer id) {
		this.userService.deleteById(id);
		return "redirect:/users/index";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.GET)
	public String deleteCriteria(Model model) {
		model.addAttribute("pageName","Users deletion criteria");
		return "users/delete";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.POST)
	public String deleteCriteriaSearch(Model model, @ModelAttribute User user) {
		List<User> users = this.userService.findWithCriteria(user);
		if (users.size() > 0) {
			model.addAttribute("users",users);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName","Users deletion criteria");
		return "users/delete";
	}
	
	@RequestMapping(value= {"/deletecriteria"}, method=RequestMethod.POST)
	public String deleteCriteriaDelete(@ModelAttribute UserDeleteCriteriaDTO form) {
		this.userService.delete(form.getUsers());
		return "redirect:/users/delete";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.GET)
	public String findCriteria(Model model) {
		model.addAttribute("pageName","Users find criteria");
		return "users/find";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.POST)
	public String findCriteriaSearch(Model model, @ModelAttribute User user) {
		List<User> users = this.userService.findWithCriteria(user);
		if (users.size() > 0) {
			model.addAttribute("users",users);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName","Users find criteria");
		return "users/find";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("pageName","User create");
		return "users/edit";
	}
	
	@RequestMapping(value= {"/edit/{id}"}, method=RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id) {
		model.addAttribute("user",this.userService.find(id).get());
		model.addAttribute("pageName","User edit");
		return "users/edit";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.POST)
	public String editSave(@ModelAttribute User user) {
		this.userService.save(user);
		return "redirect:/users/index";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.DELETE)
	public String editDelete() {
		return "redirect:/users/index";
	}
}
