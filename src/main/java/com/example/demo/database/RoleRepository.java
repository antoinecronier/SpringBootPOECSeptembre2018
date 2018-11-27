package com.example.demo.database;

import java.util.List;

import com.example.demo.database.base.BaseCRUDRepository;
import com.example.demo.models.Role;

@org.springframework.stereotype.Repository
public interface RoleRepository extends BaseCRUDRepository<Role> {

	Role findByName(String name);
	List<Role> findAllByName(String name);
}