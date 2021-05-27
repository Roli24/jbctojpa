package com.in28minutes.database.databassedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.databassedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	
	//connect to database
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> findAll()
	{
		TypedQuery<Person> namedQuery= entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id)
	{
		return entityManager.find(Person.class,id);
	}
	//update and person is same
	public Person update(Person person)
	{
		return entityManager.merge(person);
	}
	
	public Person insert(Person person)
	{
		return entityManager.merge(person);
	}
	
	public void deleteByid(int id)
	{
		Person p = findById(id);
		entityManager.remove(p);
	}

}
