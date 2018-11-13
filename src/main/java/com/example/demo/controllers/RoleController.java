package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dtos.RoleDeleteCriteriaDTO;
import com.example.demo.models.Role;
import com.example.demo.services.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("roles",this.roleService.findAll());
		model.addAttribute("pageName","Users index");
		return "roles/index";
	}
	
	@RequestMapping(value= {"/delete/{id}"}, method=RequestMethod.GET)
	public String deleteId(Model model, @PathVariable Integer id) {
		this.roleService.deleteById(id);
		return "redirect:/roles/index";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.GET)
	public String deleteCriteria(Model model) {
		model.addAttribute("pageName","Users deletion criteria");
		return "roles/delete";
	}
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.POST)
	public String deleteCriteriaSearch(Model model, @ModelAttribute Role role) {
		List<Role> roles = this.roleService.findWithCriteria(role);
		if (roles.size() > 0) {
			model.addAttribute("roles",roles);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName","Users deletion criteria");
		return "roles/delete";
	}
	
	@RequestMapping(value= {"/deletecriteria"}, method=RequestMethod.POST)
	public String deleteCriteriaDelete(@ModelAttribute RoleDeleteCriteriaDTO form) {
		this.roleService.delete(form.getRoles());
		return "redirect:/roles/delete";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.GET)
	public String findCriteria(Model model) {
		model.addAttribute("pageName","Users find criteria");
		return "roles/find";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.POST)
	public String findCriteriaSearch(Model model, @ModelAttribute Role role) {
		List<Role> roles = this.roleService.findWithCriteria(role);
		if (roles.size() > 0) {
			model.addAttribute("roles",roles);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName","Users find criteria");
		return "roles/find";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("pageName","Role create");
		return "roles/edit";
	}
	
	@RequestMapping(value= {"/edit/{id}"}, method=RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id) {
		model.addAttribute("role",this.roleService.find(id).get());
		model.addAttribute("pageName","Role edit");
		return "roles/edit";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.POST)
	public String editSave(@ModelAttribute Role role) {
		this.roleService.save(role);
		return "redirect:/roles/index";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.DELETE)
	public String editDelete() {
		return "redirect:/roles/index";
	}
}
