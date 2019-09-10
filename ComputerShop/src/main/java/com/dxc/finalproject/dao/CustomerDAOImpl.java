/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.finalproject.model.Customer;

@Repository("customerDAO")
@Transactional(rollbackFor = Exception.class)
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findAllCustomer() {
		String hql = "FROM Customer";
		try {
			return sessionFactory.getCurrentSession().createQuery(hql, Customer.class).getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	@Override
	public Customer findCustomerById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Customer.class, id);
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	public boolean addCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().persist(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}



	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().update(customer);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	

}
