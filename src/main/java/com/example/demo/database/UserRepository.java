package com.example.demo.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByFirstname(String firstname);
	List<User> findByLastname(String lastname);
	List<User> findByFirstnameAndLastname(String firstname, String lastname);
}
