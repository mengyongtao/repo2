package com.myt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myt.entity.User;
import com.myt.service.UserService;
import com.myt.serviceImpl.UserServiceImpl;

public class UserController implements Controller {
	
	private UserService userService;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = context.getBean("userService",UserServiceImpl.class);
		List<User> userList = userService.queryAll();
		ModelAndView modelAndView = new ModelAndView();
		//相当于request的setAttribute，在jsp页面通过list取数据
		modelAndView.addObject("userList", userList);
		//
		modelAndView.setViewName("/WEB-INF/jsp/user.jsp");
		return modelAndView;
	}

}
