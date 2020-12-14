package com.example.Week15.repository;

import java.util.HashMap;
import java.util.Map;

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

}
