package com.example.demo.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.security.services.UserDetailsServiceImpl;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import com.example.demo.validators.UserValidator;

@Controller
public class RegistrationController {

	@Autowired
    private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    private UserValidator userValidator;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "/security/registration";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute() User user, @RequestParam String passwordconfirm, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors() || !user.getPassword().equals(passwordconfirm)) {
            //model.addAttribute("postresult",bindingResult);
        	return "redirect:/registration";
        }

        user.getRoles().add(roleService.findByName("USER"));
        userService.save(user);
        
        userDetailsServiceImpl.autologin(user.getEmail(), user.getPassword());
        
        return "redirect:/";
    }
}
