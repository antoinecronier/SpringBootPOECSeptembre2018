package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
}
