package com.scheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.scheduler.model.User;
import com.scheduler.repository.UserRepo;

@Service
public class UserService {
	
	Logger log = LoggerFactory.getLogger(UserService.class);
	int i=1;
	@Autowired
	private UserRepo userRepo;
	
	@Scheduled(fixedRate = 5000)
	public void add2H2 () {
		User user = new User();
		//user.setId(i++);
		user.setUserName("UserName "+(i++));
		userRepo.save( user);
		System.out.println(" added in H2 "+new Date().toString()+"/n");
		
	}
	
	@Scheduled(cron="0/15 * * * * *")
	public void getAllUser () {
		List<User> users = userRepo.findAll();
		
	
		System.out.println("                                                                                                    "
				 + "  number of users "+users.size()+" ..Date ::"+new Date().toString());
		
		
	}
	

}
