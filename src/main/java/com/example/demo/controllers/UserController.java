package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controllers.base.BaseController;
import com.example.demo.dtos.UserDeleteCriteriaDTO;
import com.example.demo.dtos.base.BaseDeleteCriteriaDTO;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import com.example.demo.services.base.BaseService;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseController<User> {
	
	public static final String BASE_URL = "/users";
	private static final String BASE_PAGE_NAME = "Users";
	
	@Autowired
	private UserService userService;

	@Override
	protected BaseService<User> getBaseService() {
		return userService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}

	@Autowired
	RoleService serviceRole;

	@Override
	protected void setOtherAttributes(Model model) {
		model.addAttribute("roles",serviceRole.findAll());
	}

	@Override
	protected void setupOtherFields(User item) {
		//item.setRole(serviceRole.find(item.getRole().getId()).get());
	}
}
