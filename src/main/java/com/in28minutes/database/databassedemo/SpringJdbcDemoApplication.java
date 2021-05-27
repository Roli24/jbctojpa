package com.in28minutes.database.databassedemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databassedemo.jdbc.PersonJdbcDao;


//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	
	@Autowired
	PersonJdbcDao dao;

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//	dao.findAll();
		logger.info("All users->{}"+dao.findAll());
		logger.info("Users id 1001-> {}",dao.findById(1001));
		logger.info("Users location Hyderanad-> {}",dao.findByLocation("Hyderanad",1001));
		
		logger.info("delete id 1002-> {}",dao.deleteById(1002));
	}

}
