package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	
	private static Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);
	 
	@Autowired
	private SessionFactory sessionFactory;

	// write user defined constructor with one parameter i.e., sessionFactory

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(Product product) {
		log.debug("Starting of method saveOrUpdate in ProductDAOImpl");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method saveOrUpdate in ProductDAOImpl");
		return true;
	}

	public boolean delete(int id) {
		log.debug("Starting of method saveOrUpdate in ProductDAOImpl");
		try {
			sessionFactory.getCurrentSession().delete(get(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	log.debug("Ending of method saveOrUpdate in ProductDAOImpl");
	return true;
    }

	public List<Product> list()	{
		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
			}
	  
    public Product get(int id)	{
    	return (Product)   sessionFactory.getCurrentSession().get(Product.class, id);
    } 
    
}