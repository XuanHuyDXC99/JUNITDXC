/*
	Code of me
*/
package com.dxc.finalproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.finalproject.dao.CustomerDAO;
import com.dxc.finalproject.model.Customer;


@RestController
@RequestMapping("/customerr")
public class CustomerRestController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping(value="/allCustomer",headers = "Accept=application/json")
	public List<Customer> listCustomer(){
		List<Customer> list = customerDAO.findAllCustomer();
		return list;
	}
}
