/*
	Code of me
*/
package com.dxc.finalproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.CustomerDAO;
import com.dxc.finalproject.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/allcustomer")
	public ModelAndView customerList() {
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("customers", customerDAO.findAllCustomer());
		mv.addObject("userClickListCustomer", true);
		
		return mv;
	}
	
	@GetMapping("/registerCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("userClickAddCustomer", true);
		return "home";
	}
	@PostMapping("addCustomer")
	public ModelAndView addCustomer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/customer/allcustomer");
		String dateStr = request.getParameter("birthday");
		boolean sex;
		if (request.getParameter("sex").equals("male")) {
			sex = true;
		} else {
			sex = false;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (Exception e) {
			e.getStackTrace();
		}
		Customer c = new Customer(request.getParameter("name"), date,sex, request.getParameter("address"), 
									request.getParameter("email"), request.getParameter("phone"));
		boolean b = customerDAO.addCustomer(c);
		
		return mv;
	}
	
	@GetMapping("/editCustomer/{id}")
	public String editCustomer(@PathVariable("id") String id,Model model) {
			
		model.addAttribute("userClickEditCustomer", true);
		model.addAttribute("customer", customerDAO.findCustomerById(Integer.parseInt(id)));
		return "home";
	}
	
	@PostMapping("/updateCustomer")
	public ModelAndView updateCustomer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/customer/allcustomer");
		boolean sex;
		if(request.getParameter("sex").equals("male")) {
			sex=true;
		} else { sex=false;}
		String dateStr = request.getParameter("birthday");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (Exception e) {
			e.getStackTrace();
		}
		Customer c = new Customer(request.getParameter("name"), date, sex, request.getParameter("address"), 
										request.getParameter("email"), request.getParameter("phone"));
		c.setId(Integer.parseInt(request.getParameter("id")));
		boolean b = customerDAO.updateCustomer(c);
		return mv;
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") String id,Model model, HttpServletRequest request) {
		boolean b = customerDAO.deleteCustomer(customerDAO.findCustomerById(Integer.parseInt(id)));
		return "redirect:/customer/allcustomer";
	}
}
