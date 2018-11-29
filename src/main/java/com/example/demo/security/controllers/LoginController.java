package com.example.demo.security.controllers;

import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.security.CustomAuthenticationSuccessHandler;

@Controller
public class LoginController {

	public static final String FORM_PASSWORD = "password";
	public static final String FORM_USERNAME = "username";
	private static final String SECURITY_LOGIN = "/security/login";
	public static final String LOGIN = "/login";
	
	@RequestMapping(value = { LOGIN }, method = RequestMethod.GET)
	public String login(Model model, Principal principal, HttpServletRequest request) throws Exception{
		model.addAttribute("form_username",FORM_USERNAME);
		model.addAttribute("form_password",FORM_PASSWORD);
		
		String referer = request.getHeader("Referer"); //Get previous URL before call '/login'
		
		//save referer URL to session, for later use on CustomAuthenticationSuccesshandler
        request.getSession().setAttribute(CustomAuthenticationSuccessHandler.REDIRECT_URL_SESSION_ATTRIBUTE_NAME, referer); 

        //return principal == null ?  SECURITY_LOGIN : "redirect:/"; 
        return SECURITY_LOGIN;
    }
}
