package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDAO categoryDAO;
	@Autowired
	static Category category;
	

	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
		//get the category from context
		category = (Category)context.getBean("category");
		
	}
	
	@Test
	public void createCategoryTestCase() {
		category.setId(8);
		category.setCategoryName("mobiles updated");
		category.setDescription("Awesome category! Please buy");
		boolean flag = categoryDAO.saveOrUpdate(category);
		
		assertEquals("createCategoryTestCase", true, flag);
		
	}
	
	
	
	@Test
	public void getCategoryListTestCase() {
		int size = categoryDAO.list().size();
		assertEquals("getCategoryListTestCase", 3, size);
	}
	
	/*@Test
	public void deleteCategoryTestCase() {
		boolean flag = categoryDAO.delete(6);
		assertEquals("getCategoryListTestCase", true, flag);
	}*/
}
