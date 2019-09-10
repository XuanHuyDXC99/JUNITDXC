package com.dxc.finalproject.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.apache.http.util.Asserts;
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
import com.dxc.finalproject.model.User;
import org.junit.Test;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dispatcher-servlet-h2.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SuppressWarnings("deprecation")
public class UserDAOImplTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Before
	public void before() {
        System.out.println("Before");
        
		User user1 = new User("test1","123",1, "nguyen", 
				"Phan", new Date(2000,2,26),new Date(2000,2,26),"Hoa Thanh - Tay Ninh",false, "424242424");
		 userDAO.addUser(user1);
		User user2 = new User("test2","123",1, "nguyen", 
				"Phan", new Date(2000,2,26),new Date(2000,2,26),"Hoa Thanh - Tay Ninh",false, "424242424");
		userDAO.addUser(user2);
		User user3 = new User("test3","123",1, "nguyen", 
				"Phan", new Date(2000,2,26),new Date(2000,2,26),"Hoa Thanh - Tay Ninh",false, "424242424");
		userDAO.addUser(user3);
		
			
    }
	@Test
	public void testAddCustomer() {
		User user = new User("test1","123",1, "nguyen", 
				"Phan", new Date(2000,2,26),new Date(2000,2,26),"Hoa Thanh - Tay Ninh",false, "424242424");
		assertTrue(user.getId() == 0);
		assertTrue(userDAO.addUser(user));
		assertTrue(user.getId() != 0);
	}
	@Test
	public void testFindAllUser() {
		List<User> users = userDAO.findAllUser();
		assertEquals(3, users.size());
	}
	@Test
	public void testFindUserById() {
		User userById = userDAO.getUserById(1);
		assertEquals(1, userById.getId());
	}
	@Test
	public void testDeleteUser() {
		List<User> customers = userDAO.findAllUser();
		assertEquals(3, customers.size());
		userDAO.deleteUser(userDAO.getUserById(1));             
		List<User> usersAfterDeleted = userDAO.findAllUser();
		Assert.assertNull(userDAO.getUserById(1));
		assertEquals(2, usersAfterDeleted.size());
	}
	
	@Test
	public void testUpdateUser() {
		User userById = userDAO.getUserById(1);
		userById.setUserName("updated");            
		userDAO.updateUser(userById);   
		assertEquals("updated", userDAO.getUserById(1). getUserName());         
		
	}

	

}
