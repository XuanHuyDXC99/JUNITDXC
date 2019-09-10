package com.dxc.finalproject.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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
import com.dxc.finalproject.model.Order;
import com.dxc.finalproject.model.User;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dispatcher-servlet-h2.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SuppressWarnings("deprecation")
public class OrderDAOImplTest2 {

	@Autowired
	private OrderDAO orderDAO;
	@Before
	public void before() {
        System.out.println("Before");
        
		Order order1 = new Order(1,new BigDecimal(22.121455), new Date(2000,2,26),1,3);
		orderDAO.saveOrder(order1);
		Order order2 = new Order(2,new BigDecimal(22.121455), new Date(2000,2,26),1,3);
		orderDAO.saveOrder(order2);
		Order order3 = new Order(3,new BigDecimal(22.121455), new Date(2000,2,26),1,3);
		orderDAO.saveOrder(order3);	
		Order order4 = new Order(3,new BigDecimal(22.121455), new Date(2000,2,26),1,3);
		orderDAO.saveOrder(order4);	
    }
	
	@Test
	public void testSaveOrder() {
		
		Order order5 = new Order(8,new BigDecimal(22.121455), new Date(2000,2,26),1,3);
	    orderDAO.saveOrder(order5);
	    List<Order> order = orderDAO.getAllOrder();
	    assertEquals(5,order.size());
	}
	@Test
	public void testFindAllOrder() {
		List<Order> order = orderDAO.getAllOrder();
		assertEquals(4, order.size());
	}
	

	

}
