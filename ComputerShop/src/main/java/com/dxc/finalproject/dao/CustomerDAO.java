/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.Customer;

public interface CustomerDAO {
	
	public Customer findCustomerById(int id);
	public List<Customer> findAllCustomer();
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
}
