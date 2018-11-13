package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.RoleRepository;
import com.example.demo.database.UserRepository;
import com.example.demo.models.Role;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public void save(Role role) {
		this.roleRepository.save(role);
	}

	public void delete(Role role) {
		this.roleRepository.delete(role);
	}

	public void deleteById(Integer id) {
		this.roleRepository.deleteById(id);
	}

	public Optional<Role> find(Integer id) {
		return this.roleRepository.findById(id);
	}

	public Iterable<Role> findAll() {
		return this.roleRepository.findAll();
	}

	public List<Role> findWithCriteria(Role role) {
		List<Role> result = new ArrayList<Role>();
		if (!role.getName().equals("")) {
			result = this.roleRepository.findByName(role.getName());
		}
		return result;
	}

	public void delete(List<Role> roles) {
		this.roleRepository.deleteAll(roles);
	}
}
