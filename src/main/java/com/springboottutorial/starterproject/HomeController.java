package com.springboottutorial.starterproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@GetMapping("/")
	public String dropdown()
	{
		return "dropdown";
	}

}

