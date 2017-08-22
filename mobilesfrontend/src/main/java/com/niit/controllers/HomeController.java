package com.niit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "home";
		
	
	}
	
	@RequestMapping("/home")
	public String homepage() {
		return "home";
		
	}
	
	@RequestMapping("/aboutus")
	public String aboutUs() {
		return "aboutus";
	}

	@RequestMapping("/addcat")
	public String addcategory()
	{
		return "addCategory";

		}
	@RequestMapping("/reg")
	public String register()
	{
		return "register";
	}

	@RequestMapping("/log")
	public String login()
	{
		return "login";
	}
	}

