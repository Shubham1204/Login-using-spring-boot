package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entities.Role;
import com.login.service.RoleService;

@RestController
@RequestMapping("/authenticated/roles")
@CrossOrigin("*")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/add")
	@Transactional
	public ResponseEntity<?> addRole(@RequestBody Role role) {
		roleService.addRole(role);
		return ResponseEntity.ok("role added");
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getRoles() {
		List<Role> roles = roleService.getRoles();
		return ResponseEntity.ok(roles);
	}

	@GetMapping("/get/{rName}")
	public ResponseEntity<?> getRoleByName(@PathVariable("rName") String roleName) {
		Role role = roleService.getRoleByRoleName(roleName);
		return ResponseEntity.ok(role);
	}
}