package com.example.Week15.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	
	@GetMapping("")
	public String GetWelcomePage(ModelMap map) {
		String firstName = "Vidhya";
		String lastName = "Santhoshima";
		
		map.put("firstName", firstName);
				
		return "welcome";
	}

}
