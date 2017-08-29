package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	private static Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);

	
	@Autowired
	private SessionFactory sessionFactory;

	// write user defined constructor with one parameter i.e., sessionFactory

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(Category category) {
		log.debug("Starting of method saveOrUpdate in CategoryDAOImpl");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method saveOrUpdate in CategoryDAOImpl");
		return true;
		
	}

	public boolean delete(int id) {
		log.debug("Starting of method saveOrUpdate in CategoryDAOImpl");
		try {
			sessionFactory.getCurrentSession().delete(get(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method saveOrUpdate in CategoryDAOImpl");
		return true;
		
	}

	public List<Category> list() {
		log.debug("Starting of method list in CategoryDAOImpl");
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category get(int id) {
		log.debug("Starting of method saveOrUpdate in CategoryDAOImpl");
		//return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = ?").setInteger(0, id).uniqueResult();
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}
	
}
