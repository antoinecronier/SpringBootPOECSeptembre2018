package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.UserRepository;
import com.example.demo.models.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		this.userRepository.save(user);
	}

	public void delete(User user) {
		this.userRepository.delete(user);
	}

	public void deleteById(Integer id) {
		this.userRepository.deleteById(id);
	}

	public Optional<User> find(Integer id) {
		return this.userRepository.findById(id);
	}

	public Iterable<User> findAll() {
		return this.userRepository.findAll();
	}

	public List<User> findWithCriteria(User user) {
		List<User> result = new ArrayList<User>();
		if (!user.getFirstname().equals("") && !user.getLastname().equals("")) {
			result = this.userRepository.findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
		} else if (!user.getFirstname().equals("")) {
			result = this.userRepository.findByFirstname(user.getFirstname());
		} else if (!user.getLastname().equals("")) {
			result = this.userRepository.findByLastname(user.getLastname());
		}
		return result;
	}

	public void delete(List<User> users) {
		this.userRepository.deleteAll(users);
	}
}
