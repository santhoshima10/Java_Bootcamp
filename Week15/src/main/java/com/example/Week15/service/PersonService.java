package com.example.Week15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Week15.domain.Person;
import com.example.Week15.repository.PersonRepository;

@Service
public class PersonService {
	
@Autowired
	private PersonRepository personRepo;
    private Integer personCount = 1;

	
	
public Person save(Person person) {
	
	person.setId(personCount++);
	return personRepo.save(person);
		
	}



public Person findById(Integer personId) {
	
	return personRepo.findById(personId);
}

}
