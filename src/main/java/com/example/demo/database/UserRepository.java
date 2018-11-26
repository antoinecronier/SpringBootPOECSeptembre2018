package com.example.demo.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.database.base.BaseCRUDRepository;
import com.example.demo.models.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends BaseCRUDRepository<User> {

	User findByEmail(String email);
	List<User> findByFirstname(String firstname);
	List<User> findByLastname(String lastname);
	List<User> findByFirstnameAndLastname(String firstname, String lastname);
}
