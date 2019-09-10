/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.User;

public interface UserDAO {
	public User checkLogin(String userName, String passWord);
	public User getUserById(int id);
	public List<User> findAllUser();
	public boolean addUser(User us);
	public boolean updateUser(User us);
	public boolean deleteUser(int i);
	public void deleteUser(User userById);

	
}
