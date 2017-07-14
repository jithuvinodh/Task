package com.niit.TaskBacend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.TaskBacend.Dao.FileDao;
import com.niit.TaskBacend.Dao.UserDetailsDao;
import com.niit.TaskBacend.Model.UploadFile;
import com.niit.TaskBacend.Model.UserDetails;

public class FileTest {

	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.TaskBacend");
		context.refresh();
		 FileDao fileDao = (FileDao) context.getBean("fileDaoimpl");
	       UploadFile fileuplo = (UploadFile) context.getBean("uploadFile");
	       fileuplo.setFileName("fileName");
	    fileuplo.setData(null);
	      fileDao.save(fileuplo);
	        
			 System.out.println( "Details are created successfully");
}
}
