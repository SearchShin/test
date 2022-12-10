package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/main")
	public ModelAndView main(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}

	@RequestMapping(value="/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/main");
	}

	@RequestMapping(value="/home2")
	public ModelAndView serve(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home2");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}

	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("loginpage");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}
}
