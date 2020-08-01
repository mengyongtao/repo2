package com.myt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/index")
	public String test() {
		System.out.println();
//		ModelAndView view = new ModelAndView("index");
		return "index";
	}
}
