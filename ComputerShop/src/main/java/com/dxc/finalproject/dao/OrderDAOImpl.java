/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.finalproject.model.Order;

@Repository("orderDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int getOrderNumber() {
		Session session = sessionFactory.getCurrentSession();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
			Root<Order> root = query.from(Order.class);
			query.select(builder.max(root.get("orderId")));
			int result = (Integer) session.createQuery(query).getSingleResult();
			return result+1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Order> getAllOrder() {
		String hql = "FROM Order";
		try {
			return sessionFactory.getCurrentSession().createQuery(hql, Order.class).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void saveOrder(Order order) {
		try {
			sessionFactory.getCurrentSession().save(order);
		} catch (Exception e) {
			e.getStackTrace();
		}	
	}
	
	
}
