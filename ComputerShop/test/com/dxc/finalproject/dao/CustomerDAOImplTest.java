package com.dxc.finalproject.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dxc.finalproject.model.Customer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dispatcher-servlet-h2.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SuppressWarnings("deprecation")
public class CustomerDAOImplTest {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Before
	public void before() {
        System.out.println("Before");
        
		Customer customer1 = new Customer("test1", new Date(2000,2,25), true, "111 - address", 
				"test@xmail.com", "0909897987");
		customerDAO.addCustomer(customer1);
		
		Customer customer2 = new Customer("test2", new Date(2000,2,26), true, "112 - address", 
				"test@xmail.com", "0909897988");
		customerDAO.addCustomer(customer2);
		
		Customer customer3 = new Customer("test3", new Date(2000,2,27), true, "113 - address", 
				"test@xmail.com", "0909897989");
		customerDAO.addCustomer(customer3);
    }
	

	@Test
	public void testFindAllCustomer() {
		List<Customer> customers = customerDAO.findAllCustomer();
		assertEquals(3, customers.size());
	}

	@Test
	public void testFindCustomerById() {
		Customer customerById = customerDAO.findCustomerById(1);
		assertEquals(1, customerById.getId());
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer("testx", new Date(2000,2,25), true, "111 - address", 
				"testx@xmail.com", "0909897980");
		assertTrue(customer.getId() == 0);
		assertTrue(customerDAO.addCustomer(customer));
		assertTrue(customer.getId() != 0);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customerById = customerDAO.findCustomerById(1);
		customerById.setCustomerName("updated");
		customerDAO.updateCustomer(customerById);
		assertEquals("updated", customerDAO.findCustomerById(1).getCustomerName());
	}

	@Test
	public void testDeleteCustomer() {
		List<Customer> customers = customerDAO.findAllCustomer();
		assertEquals(3, customers.size());
		customerDAO.deleteCustomer(customerDAO.findCustomerById(1));
		List<Customer> customersAfterDeleted = customerDAO.findAllCustomer();
		assertEquals(2, customersAfterDeleted.size());
		Assert.assertNull(customerDAO.findCustomerById(1));
	}

}
