package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.database.RoleRepository;
import com.example.demo.database.UserRepository;
import com.example.demo.database.base.BaseCRUDRepository;
import com.example.demo.models.Role;
import com.example.demo.services.base.BaseService;

@Service
public class RoleService extends BaseService<Role> {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	protected List<Role> setItemsByCriterias(Role item, List<Role> result) {
		if (!item.getName().equals("")) {
			result = this.roleRepository.findByName(item.getName());
		}
		return result;
	}

	@Override
	protected BaseCRUDRepository<Role> getCRUDRepository() {
		return roleRepository;
	}
}
