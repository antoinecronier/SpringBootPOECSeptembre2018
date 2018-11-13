package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.User;

public class UserDeleteCriteriaDTO {

	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserDeleteCriteriaDTO() {
		this.users = new ArrayList<User>();
	}
}
