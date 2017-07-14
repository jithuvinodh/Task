package com.niit.TaskBacend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.TaskBacend.Dao.UserDetailsDao;
import com.niit.TaskBacend.Model.UserDetails;



public class UserTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.TaskBacend");
		context.refresh();
		 UserDetailsDao userDetailsDao = (UserDetailsDao) context.getBean("userDetailsDaoImpl");
	        UserDetails userDetails = (UserDetails) context.getBean("userDetails");
	        userDetails.setName("jithu");
	        userDetails.setEmail("email44");
	        userDetails.setPassword("password");
	        userDetails.setMobile("mobile");
	        userDetails.setAddress("address");
	        userDetails.setZipCode(747);
	        userDetailsDao.saveorupdate(userDetails);
	        
	        
			 System.out.println( "Details are created successfully");
	}
}
