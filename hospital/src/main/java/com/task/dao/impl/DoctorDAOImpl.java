package com.task.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.model.Doctor;
import com.task.dao.DoctorDAO;

@Repository(value = "DoctorDAO")
@Transactional
public class DoctorDAOImpl implements DoctorDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@ResponseBody
	public boolean add(Doctor doctor) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(doctor);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean delete(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor getDoctor(int DoctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> listdoctor() {
		// TODO Auto-generated method stub
		return null;
	}

}
