/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.finalproject.model.User;

@Repository("userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUserById(int id) {

		try {
			return sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public User checkLogin(String userName, String passWord) {
		String hql = "FROM User WHERE userName= :userName and passWord= :passWord";
		User u = new User();
		try {
			return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("userName", userName)
					.setParameter("passWord", passWord).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<User> findAllUser() {
		List<User> list = new ArrayList<>();
		String hql = "FROM User";
		list = sessionFactory.getCurrentSession().createQuery(hql, User.class).getResultList();
		return list;
	}
	
	@Override
	public boolean addUser(User us) {
		try {
			sessionFactory.getCurrentSession().persist(us);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(User us) {
		try {
			sessionFactory.getCurrentSession().update(us);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			User u =session.get(User.class, id);
			session.delete(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void deleteUser(User user) {
		deleteUser(user.getId());
		return;
	}

}
