/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.finalproject.model.Category;

@Repository(value="categoryDAO")
@Transactional(rollbackFor = Exception.class)
public class CategoryImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	


	@Override
	public Category findCategoryByName(String name) {
		String hql = "FROM Category as c WHERE c.categoryName = :categoryName";
		try {
			return sessionFactory.getCurrentSession().createQuery(hql, Category.class).setParameter("categoryName", name).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}




	@Override
	public List<Category> findAllCategory() {
		List<Category> list = new ArrayList<Category>();
		String hql = "FROM Category";
		try {
			list = sessionFactory.getCurrentSession().createQuery(hql, Category.class).getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
