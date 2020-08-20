package com.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView indexPage() 
	{	
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring Web MVC");
		return mv;
	}

	/*@RequestMapping(value = {"/doctorregistration"})
	public ModelAndView indexPage1() 
	{	
		ModelAndView mv = new ModelAndView("doctorRegistration");
		mv.addObject("greeting","Welcome to Spring Web MVC");
		return mv;
	}*/
}
