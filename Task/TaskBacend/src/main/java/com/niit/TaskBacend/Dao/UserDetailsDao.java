package com.niit.TaskBacend.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.TaskBacend.Model.UserDetails;




@Repository
public interface UserDetailsDao {

	
public List<UserDetails> list();
public UserDetails get(String email);
public void saveorupdate(UserDetails userDetails);
public void delete(UserDetails userDetails);
}
