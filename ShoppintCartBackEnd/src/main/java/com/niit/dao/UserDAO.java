package com.niit.dao;

import java.util.List;
import com.niit.model.User;


public interface UserDAO
{
	//create/register/update the user details
	public boolean saveOrUpdate(User user);


	// delete user details
	public boolean delete(User user);
	
    public boolean validate(String id,String password);
    
    //to get all users-list
	public List<User> list();
	
	//get contact details based on userIds
	public User getUserById(String id);
}
