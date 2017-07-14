package com.niit.TaskBacend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.TaskBacend.Model.UploadFile;
import com.niit.TaskBacend.Model.UserDetails;

@Repository("fileDaoimpl")
@Transactional
public class FileDaoimpl implements FileDao{

	@Autowired
	private SessionFactory sessionFactory;

	public FileDaoimpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			System.out.print(" Unable to connect to db");
			e.printStackTrace();
		}
	}
	
	public void save(UploadFile uploadFile) {
		sessionFactory.getCurrentSession().save(uploadFile);
    
		
	}

	public List<UploadFile> list() {
		List<UploadFile> list = (List<UploadFile>) sessionFactory.getCurrentSession()
				.createCriteria(UploadFile.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}
