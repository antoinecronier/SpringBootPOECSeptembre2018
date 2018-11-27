package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.database.UserRepository;
import com.example.demo.models.User;

@Controller
public class Controler1 {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = { "/", "", "/toto" })
	public String showPage1(Model model) {
		model.addAttribute("att1", 2);
		model.addAttribute("user", new User("jean-michel", "toto"));
		model.addAttribute("users", new ArrayList<User>() {
			{
				add(new User("user1", "u1"));
				add(new User("user2", "u2"));
				add(new User("user3", "u3"));
				add(new User("user4", "u4"));
			}
		});
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		String name = securityContext.getAuthentication().getName();
		User user = userRepository.findByEmail(name);

		return "index";
	}

	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "controler1/index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createUser(@RequestParam String firstname, @RequestParam String lastname) {
		this.userRepository.save(new User(firstname, lastname));
		return "redirect:";
	}
	
	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String createUser1(@ModelAttribute User user) {
		this.userRepository.save(user);
		return "redirect:";
	}
}
