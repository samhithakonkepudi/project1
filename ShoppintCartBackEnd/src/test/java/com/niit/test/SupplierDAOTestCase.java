package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		// get the category from context

		supplier = (Supplier) context.getBean("supplier");

	}

	@Test
	public void createSupplierTestCase() {
		supplier.setId(6);
		supplier.setSupplierName("Sangeetha Mobiles");
		supplier.setDescription("Large Collection of Mobiles");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}

	@Test
	public void updateSupplierTestCase() {
		supplier.setId(6);
		supplier.setSupplierName("BigC Mobiles");
		supplier.setDescription("Large Collection of Mobiles");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}

	@Test
	public void listAllSupplierTestCase() {
		int actualSize = supplierDAO.list().size();
		assertEquals(3, actualSize);
	}

}