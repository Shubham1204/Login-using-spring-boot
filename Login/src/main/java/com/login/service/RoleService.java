package com.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.RoleRepository;
import com.login.entities.Right;
import com.login.entities.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public String addRole(Role role) {
		roleRepository.savequery(role.getRoleName(),role.getRoleDescription());
		for (Right right : role.getRights()) {
			
			roleRepository.mapRoleRight(role.getRoleName(),right.getRightName());
		}
			return  "role added";
	}
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}

	public Role getRoleByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}
