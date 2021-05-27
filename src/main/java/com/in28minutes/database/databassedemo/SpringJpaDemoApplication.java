package com.in28minutes.database.databassedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databassedemo.entity.Person;
import com.in28minutes.database.databassedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Users id 1001-> {}",repository.findById(1001));
		
		logger.info("Inserting 1004- > {}", repository.insert(new Person("Tara1","India",new Date())));
		
		logger.info("Updating 1003- > {}", repository.update(new Person(1003,"New Person 1","India",new Date())));
		
		logger.info("All users -. {}"+repository.findAll());
		
		repository.deleteByid(1003);
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub // dao.findAll(); //
	 * logger.info("All users->{}"+dao.findAll());
	 * //logger.info("Users id 1001-> {}",repository.findById(1001));
	 * 
	 * logger.info("Users location Hyderanad-> {}",dao.findByLocation("Hyderanad",
	 * 1001));
	 * 
	 * logger.info("delete id 1002-> {}",dao.deleteById(1002));
	 * 
	 * }
	 */

}
