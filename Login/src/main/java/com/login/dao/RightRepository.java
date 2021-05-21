package com.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.entities.Right;

@Repository
public interface RightRepository extends JpaRepository<Right, Integer>{

}
