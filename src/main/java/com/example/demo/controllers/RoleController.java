package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controllers.base.BaseController;
import com.example.demo.dtos.RoleDeleteCriteriaDTO;
import com.example.demo.models.Role;
import com.example.demo.services.RoleService;
import com.example.demo.services.base.BaseService;

@Controller
@RequestMapping(RoleController.BASE_URL)
public class RoleController extends BaseController<Role> {
	
	public static final String BASE_URL = "/roles";
	private static final String BASE_PAGE_NAME = "Roles";
	
	@Autowired
	private RoleService roleService;

	@Override
	protected BaseService<Role> getBaseService() {
		return roleService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}


}
