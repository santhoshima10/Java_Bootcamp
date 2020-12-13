package com.example.Week15.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Week15.domain.Person;

@Controller
public class WelcomeController {
	
	
	@GetMapping("")
	public String GetWelcomePage(ModelMap map) {
		Person person = new Person();
		
		map.put("person", person);
				
		return "welcome";
	}
	
	@PostMapping("")
	public String PostWelcomePage(Person person) {
		
		System.out.println(person);
		return "redirect:/";
	}

}
