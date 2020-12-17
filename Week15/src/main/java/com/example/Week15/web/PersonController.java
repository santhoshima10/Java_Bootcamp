package com.example.Week15.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Week15.domain.Person;
import com.example.Week15.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public String GetWelcomePage(ModelMap map) {
		Person person = new Person();
		
		map.put("person", person);
				
		return "people";
	}
	
	@PostMapping("/persons")
	public String PostWelcomePage(Person person) {
		
		personService.save(person);
		System.out.println(person);
		return "redirect:/persons";
	}
	
	@GetMapping("/persons/{personId}")
	public String getPersonById(@PathVariable Integer personId, ModelMap map) {
		Person savedPerson = personService.findById(personId);
		map.put("person", savedPerson);
		return "people";
	}
	
	@PostMapping("/persons/{personId}")
    public String postPerson(Person person) {
		Person savedPerson = personService.save(person);
		 return "redirect:/persons/"+savedPerson.getId();
		
		
	}
	
	
}
