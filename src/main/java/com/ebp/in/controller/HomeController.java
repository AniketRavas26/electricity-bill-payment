package com.ebp.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebp.in.service.UserService;

@Controller
@RequestMapping("/my")
public class HomeController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/home")
	public ModelAndView getHomePage() {
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("mes", "Welcome to Electricity Bill Payment Application");
		
		return mv;
	}

}
