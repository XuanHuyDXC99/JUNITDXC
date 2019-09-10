/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.Category;

public interface CategoryDAO {
	public Category findCategoryByName(String name);
	public List<Category> findAllCategory();
}
