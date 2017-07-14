package com.niit.TaskBacend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.TaskBacend.Model.UserDetails;



@Repository("userDetailsDaoImpl")
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao{
@Autowired
private SessionFactory sessionFactory;

public UserDetailsDaoImpl(SessionFactory sessionFactory) {
	try {
		this.sessionFactory = sessionFactory;
	} catch (Exception e) {
		System.out.print(" Unable to connect to db");
		e.printStackTrace();
	}
}
@Transactional
	public List<UserDetails> list() {
		List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
@Transactional
	public UserDetails get(String email) {
		String hql = "from User where email=" + "'"+ email+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
@Transactional
	public void saveorupdate(UserDetails userDetails) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		}
		catch(HibernateException e)
		{
		e.printStackTrace();	
		}
		
	}
		
	
@Transactional
	public void delete(UserDetails userDetails) {
		try
		{
		sessionFactory.getCurrentSession().delete(userDetails);

		}
		catch(HibernateException e)
		{
		e.printStackTrace();
		}

		
	}

}
