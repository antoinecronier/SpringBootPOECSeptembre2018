package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Role;

public class RoleDeleteCriteriaDTO {

	List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setUsers(List<Role> roles) {
		this.roles = roles;
	}

	public RoleDeleteCriteriaDTO() {
		this.roles = new ArrayList<Role>();
	}
}
