/*
	Code of me
*/
package com.dxc.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.CustomerDAO;
import com.dxc.finalproject.dao.OrderDAO;
import com.dxc.finalproject.dao.ProductDAO;

@Controller
public class OrderController {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@GetMapping("/order")
	public ModelAndView orderPage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickOrder", true);
		mv.addObject("orderNo", orderDAO.getOrderNumber());
		mv.addObject("products",productDAO.findAllProduct());
		mv.addObject("customers", customerDAO.findAllCustomer());
		return mv;
	}
}
