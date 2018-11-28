package com.example.demo.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional()
	public void createFirstAdmin() {
		
		Role role = null;
		if ((role = this.serviceRole.findByName("ADMIN")) == null) {
			role = new Role("ADMIN");
			this.serviceRole.save(role);
		}
		
		User user = null;
		if ((user = this.serviceUser.findByEmail("admin@site.com")) == null) {
			user = new User("admin@site.com", "admin", 1, "myAdmin", "forSite");
			user.getRoles().add(role);
			this.serviceUser.save(user);
		}
	}
}
