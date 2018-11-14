package com.example.demo.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.database.base.BaseCRUDRepository;
import com.example.demo.models.Role;

@org.springframework.stereotype.Repository
public interface RoleRepository extends BaseCRUDRepository<Role> {

	List<Role> findByName(String name);
}