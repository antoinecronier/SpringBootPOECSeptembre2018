package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
