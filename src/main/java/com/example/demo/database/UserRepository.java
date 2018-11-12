package com.example.demo.database;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
