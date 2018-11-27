package com.example.demo.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Service
public class PreLaunchService {
	@Autowired
	private RoleService serviceRole;
	
	@Autowired
	private UserService serviceUser;
	
	public void createFirstAdmin() {
		
//		Role role = new Role("ADMIN");
//		
//		this.serviceRole.save(role);
//		
//		User user = new User("admin@admin.admin", "admin", 1, "antoine", "cronier");
//		user.getRoles().add(role);
//		this.serviceUser.save(user);
	}
}
