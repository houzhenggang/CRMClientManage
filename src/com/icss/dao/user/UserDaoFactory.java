package com.icss.dao.user;

public class UserDaoFactory {
	
    private UserDaoFactory(){
    	
    }
    
    public static UserDao getInstance(){
    	
    	return new UserDaoImpl();
    }
}
