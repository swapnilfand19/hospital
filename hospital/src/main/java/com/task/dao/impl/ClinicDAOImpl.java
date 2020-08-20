package com.task.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.model.Clinic;
import com.task.dao.ClinicDAO;

@Repository(value = "ClinicDAO")
@Transactional
public class ClinicDAOImpl implements ClinicDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@ResponseBody
	public boolean saveClinic(Clinic clinic) 
	{
		try {	
			sessionFactory.getCurrentSession().save(clinic);
			return true;
			}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	}

	public boolean updateClinic(Clinic clinic) {
		try 
		{
		    sessionFactory.getCurrentSession().update(clinic);
			return true;
		} 
		catch (Exception e)
		{
			return false;		
		}
	}

	public boolean deleteClinic(Clinic clinic) {
		try 
		{
		    sessionFactory.getCurrentSession().delete(clinic);
			return true;
		} 
		catch (Exception e)
		{
			return false;		
		}
	}

	public Clinic getClinicById(int CliniclId) {
		Session session=sessionFactory.openSession();
		Clinic clinic = session.get(Clinic.class,CliniclId);
		session.close();
		return clinic;
	}

	public Clinic findByName(String auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clinic> getAllClinic() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Clinic");
		List<Clinic>  listCategories=query.list();
		session.close();
		return listCategories;
	}
	
	
}
