package com.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	

}
