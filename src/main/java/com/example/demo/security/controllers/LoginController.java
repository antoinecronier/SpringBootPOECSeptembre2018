package com.example.demo.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	public static final String FORM_PASSWORD = "password";
	public static final String FORM_USERNAME = "username";
	private static final String SECURITY_LOGIN = "/security/login";
	public static final String LOGIN = "/login";

	@RequestMapping(value = { LOGIN }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("form_username",FORM_USERNAME);
		model.addAttribute("form_password",FORM_PASSWORD);
		
		return SECURITY_LOGIN;
	}
}
