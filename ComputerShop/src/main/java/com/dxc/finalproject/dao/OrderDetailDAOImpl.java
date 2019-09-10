/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.finalproject.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderDetailDAOImpl implements OrderDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		String hql = "FROM OrderDetail";
		try {
			return sessionFactory.getCurrentSession().createQuery(hql, OrderDetail.class).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<OrderDetail> getAllOrderDetailByOrderId(int id) {
		String hql = "FROM OrderDetail as od WHERE od.orderId = :orderId";
		try {
			return sessionFactory.getCurrentSession().createQuery(hql, OrderDetail.class).setParameter("orderId", id).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void saveOrderDetail(OrderDetail orderdetail) {
		try {
			sessionFactory.getCurrentSession().save(orderdetail);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}
	
}
