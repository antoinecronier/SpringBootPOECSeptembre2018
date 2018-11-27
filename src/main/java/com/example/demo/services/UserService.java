package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.database.UserRepository;
import com.example.demo.database.base.BaseCRUDRepository;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.services.base.BaseService;

@Service
public class UserService extends BaseService<User> {

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User item) {
		//item.setPassword(bCryptPasswordEncoder.encode(item.getPassword()));
		item.setActive(1);
		super.save(item);
	}

	@Override
	protected BaseCRUDRepository<User> getCRUDRepository() {
		return userRepository;
	}

	@Override
	protected List<User> setItemsByCriterias(User item, List<User> result) {
		if (!item.getFirstname().equals("") && !item.getLastname().equals("")) {
			result = this.userRepository.findByFirstnameAndLastname(item.getFirstname(), item.getLastname());
		} else if (!item.getFirstname().equals("")) {
			result = this.userRepository.findByFirstname(item.getFirstname());
		} else if (!item.getLastname().equals("")) {
			result = this.userRepository.findByLastname(item.getLastname());
		}
		return result;
	}
}
