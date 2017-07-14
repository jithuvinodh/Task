package com.niit.TaskBacend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "file")
@Component
public class UploadFile {
	
	    
	    @Id
	    
	    private String fileName;
	    private byte[] data;
	 
	    
	    public String getFileName() {
	        return fileName;
	    }
	 
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	 
	   
	    public byte[] getData() {
	        return data;
	    }
	 
	    public void setData(byte[] data) {
	        this.data = data;
	    }
}
