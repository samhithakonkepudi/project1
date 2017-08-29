package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface CategoryDAO {
	
	public boolean saveOrUpdate(Category category);
	public boolean delete(int id);
	public List<Category> list();
	public Category get(int id);
}