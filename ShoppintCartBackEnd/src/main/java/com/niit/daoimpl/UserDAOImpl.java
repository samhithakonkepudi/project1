package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	private static Logger log= LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	//user defined constructor with one parameter i.e sessionFactory
	
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	public boolean saveOrUpdate(User user) {
		log.debug("starting of method saveOrUpdate in UserDAOImpl");
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method saveOrUpdate in UserDAOImpl");
		return true;
	}
	public boolean delete(User user) {
		log.debug("starting of method delete in UserDAOImpl");
		try{
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method delete in UserDAOImpl");
		return true;
	}
	
	
	public List<User> list(){
		return sessionFactory.getCurrentSession().createQuery("from user").list();
	}
	
	public boolean validate(String id, String password) {
		
		log.debug("starting of method validate in UserDAOImpl");
		Query query=	 sessionFactory.getCurrentSession().createQuery(" from User where id = ? and password = ?");
		    //actually the index will start from zero  - will get once exception.
		query.setString(0, id); 
		query.setString(1, password);
		
		 if(  query.uniqueResult()  == null)
		 {
			 //means no row exist i.e., invalid credentials
			 return false;
		 }
		 else
		 {
			 //means row exist i.e., valid credentials
			 return true;
		 }
		
		}

	public User getUserById(String id) {
		
		return 	(User)  sessionFactory.getCurrentSession().get(User.class, id);

	}
	
	
}
