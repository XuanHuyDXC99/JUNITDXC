/*
	Code of me
*/
package com.dxc.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.CategoryDAO;

@Controller
public class PageController {

	@Autowired
	public CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/login" })
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/show/category")
	public ModelAndView showCategory() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("categoies", categoryDAO.findAllCategory());
		return mv;
	}
	
}
