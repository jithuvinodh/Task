package com.niit.TaskBacend.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.TaskBacend.Model.UploadFile;
import com.niit.TaskBacend.Model.UserDetails;

@Repository
public interface FileDao {

	void save(UploadFile uploadFile);
	public List<UploadFile> list();
}
