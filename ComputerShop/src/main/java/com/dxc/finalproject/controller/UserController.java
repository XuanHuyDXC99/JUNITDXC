/*
	Code of me
*/
package com.dxc.finalproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.CategoryDAO;
import com.dxc.finalproject.dao.UserDAO;
import com.dxc.finalproject.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");

		HttpSession session = request.getSession();
		User u = userDAO.checkLogin(userName, passWord);
		if (u != null) {
			session.setAttribute("userId", u.getId());
			session.setAttribute("userRole", u.getUserRole());
			session.setAttribute("firstNameLog", u.getFirstName());
			session.setAttribute("lastNameLog", u.getLastName());
			session.setAttribute("categories", categoryDAO.findAllCategory());
			return "redirect:/home";
		} else {
			return "login";
		}

	}

	@RequestMapping(value = "/alluser", method = RequestMethod.GET)
	public ModelAndView manageUser() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickAllUser", true);
		mv.addObject("users", userDAO.findAllUser());
		return mv;
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.GET)
	public ModelAndView registerUser() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickRegister", true);
		return mv;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/alluser");
		int role, sex;
		if (request.getParameter("role").equals("manager")) {
			role = 1;
		} else {
			role = 2;
		}
		if (request.getParameter("sex").equals("male")) {
			sex = 1;
		} else {
			sex = 0;
		}
		String startDateStr = request.getParameter("startDate");
		String bDayStr = request.getParameter("bday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// surround below line with try catch block as below code throws checked
		// exception
		Date startDate = null;
		Date bDay = null;
		try {
			startDate = sdf.parse(startDateStr);
			bDay = sdf.parse(bDayStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User u = new User();
		u.setFirstName(request.getParameter("firstname"));
		u.setLastName(request.getParameter("lastname"));
		u.setUserName(request.getParameter("name"));
		u.setPassWord(request.getParameter("pass"));
		u.setUserRole(role);
		u.setAddress(request.getParameter("address"));
		u.setPhoneNumber(request.getParameter("phone"));
		u.setBirthday(bDay);
		u.setDayToWork(startDate);
		u.setPeopleId(request.getParameter("identityId"));
		userDAO.addUser(u);
		mv.addObject("addUserSuccess", true);
		return mv;
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		User u = userDAO.getUserById(Integer.parseInt(id));
		mv.addObject("userClickEdit", true);
		mv.addObject("user", u);
		return mv;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/alluser");
		
		  User us = userDAO.getUserById(Integer.parseInt(request.getParameter("id")));
		 
		int role, sex;
		if (request.getParameter("role").equals("manager")) {
			role = 1;
		} else {
			role = 2;
		}
		if (request.getParameter("sex").equals("male")) {
			sex = 1;
		} else {
			sex = 0;
		}
		String startDateStr = request.getParameter("startDate");
		String bDayStr = request.getParameter("bday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// surround below line with try catch block as below code throws checked
		// exception
		Date startDate = null;
		Date bDay = null;
		try {
			startDate = sdf.parse(startDateStr);
			bDay = sdf.parse(bDayStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User u = new User();
		u.setId(us.getId());
		u.setFirstName(request.getParameter("firstname"));
		u.setLastName(request.getParameter("lastname"));
		u.setUserName(request.getParameter("name"));
		u.setPassWord(request.getParameter("pass"));
		u.setUserRole(role);
		u.setAddress(request.getParameter("address"));
		u.setPhoneNumber(request.getParameter("phone"));
		u.setBirthday(bDay);
		u.setDayToWork(startDate);
		u.setPeopleId(request.getParameter("identityId"));
		boolean status = userDAO.updateUser(u);
		return mv;
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/alluser");
		boolean status = userDAO.deleteUser(Integer.parseInt(id));
		return mv;
	}
}
