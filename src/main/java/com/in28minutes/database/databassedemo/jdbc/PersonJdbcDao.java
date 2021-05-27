package com.in28minutes.database.databassedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databassedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll()
	{
		return jdbcTemplate.query("select *from person",new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id)
	{
		return jdbcTemplate.queryForObject("select *From person where id =?",new Object[] {id}, 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByLocation(String location, int id)
	{
		return (List<Person>) jdbcTemplate.query("select *From person where location =? and id=?",new Object[] {location,id}, 
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete From person where  id=?",new Object[] {id});
	}

}
