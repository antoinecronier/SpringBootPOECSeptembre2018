package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.database.DBItem;

@Entity
@Table(name="role")
public class Role extends DBItem {

	@Column(name="name")
	private String name;
	
	@ManyToMany(targetEntity=User.class,mappedBy="roles")
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role(String name) {
		this();
		this.name = name;
	}
	
	public Role() {
		super();
		this.users = new ArrayList<User>();
	}
}
