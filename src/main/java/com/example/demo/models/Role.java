package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.database.DBItem;

@Entity
@Table(name="role")
public class Role extends DBItem {

	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Role() {
		super();
	}
}
