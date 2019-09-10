/*
	Code of me
*/
package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.Brand;
import com.dxc.finalproject.model.Product;

public interface ProductDAO {
	public Product findProductById(int id);
	public List<Product> findAllProduct();
	public Brand getBrandByName(String name);
	public List<Brand> findAllBrand();
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
}
