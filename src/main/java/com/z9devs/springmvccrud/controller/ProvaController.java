package com.z9devs.springmvccrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/prova")
public class ProvaController {

	@RequestMapping("")
	public ModelAndView prova() 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("prova");
		return mv;
	}
}
