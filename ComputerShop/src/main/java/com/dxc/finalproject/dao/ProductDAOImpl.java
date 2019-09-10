/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.dxc.finalproject.model.Brand;
import com.dxc.finalproject.model.Product;

@Repository("productDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Brand> findAllBrand() {
		String hql = "FROM Brand";
		List<Brand> list = new ArrayList<Brand>();
		try {
			list = sessionFactory.getCurrentSession().createQuery(hql, Brand.class).getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Product findProductById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Product> findAllProduct() {
		String hql = "FROM Product";
		List<Product> list = new ArrayList<Product>();
		try {
			list = sessionFactory.getCurrentSession().createQuery(hql, Product.class).getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Brand getBrandByName(String name) {
		String hql = "FROM Brand as b WHERE b.brandName = :brandName ";
		return sessionFactory.getCurrentSession().createQuery(hql, Brand.class).setParameter("brandName", name)
				.getSingleResult();
	}

}
