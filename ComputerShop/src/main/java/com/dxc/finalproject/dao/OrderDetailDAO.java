/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> getAllOrderDetail();
	public List<OrderDetail>  getAllOrderDetailByOrderId(int id);
	public void saveOrderDetail(OrderDetail orderdetail);
}
