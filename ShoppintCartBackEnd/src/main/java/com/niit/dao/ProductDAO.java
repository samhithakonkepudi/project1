package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {

	public boolean saveOrUpdate(Product product);


	// delete category
	public boolean delete(int id);

	public List<Product> list();

	public Product get(int id);
	
	
}