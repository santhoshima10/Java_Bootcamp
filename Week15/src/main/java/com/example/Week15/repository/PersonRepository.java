package com.example.Week15.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.Week15.domain.Person;

@Repository
public class PersonRepository {
	
	
	private Map<Integer,Person> personData = new HashMap<>();
	
	
	public Person save(Person person) {
		
		personData.put(person.getId(), person);
		return person;
		
	}


	public Person findById(Integer personId) {
		return personData.get(personId);
	}


	public List<Person> findAll() {
	return	personData
		.entrySet()
		.stream()
		.map(a -> a.getValue())
		.collect(Collectors.toList());
	}


	public void delete(Integer personId) {
		personData.remove(personId);
		
	}

}
