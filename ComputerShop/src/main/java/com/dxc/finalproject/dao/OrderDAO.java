/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.Order;

public interface OrderDAO {
	public int getOrderNumber();
	public List<Order> getAllOrder();
	public void saveOrder(Order order);
}
