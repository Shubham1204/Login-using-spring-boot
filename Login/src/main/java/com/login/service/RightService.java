package com.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.RightRepository;
import com.login.entities.Right;

@Service
public class RightService {

	@Autowired
	private RightRepository rightRepository;
	
	public Right addRight(Right right) {
		return	rightRepository.save(right);
	}
	
	public List<Right> getRights(){
		return rightRepository.findAll();
	}
}
