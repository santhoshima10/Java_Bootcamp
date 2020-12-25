package com.example.Week15.service;

import java.util.List;

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
	
	if(person.getId()==null)
	{	
	    person.setId(personCount++);
	}
	return personRepo.save(person);
		
	}



public Person findById(Integer personId) {
	
	return personRepo.findById(personId);
}



public List<Person> findAll() {
	// TODO Auto-generated method stub
	return personRepo.findAll();
}



public void delete(Integer personId) {
	personRepo.delete(personId);
	
}

}
