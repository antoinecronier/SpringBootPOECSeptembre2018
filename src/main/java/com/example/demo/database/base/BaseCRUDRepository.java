package com.example.demo.database.base;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.database.DBItem;

public interface BaseCRUDRepository<T extends DBItem> extends CrudRepository<T, Integer>  {
	
}
