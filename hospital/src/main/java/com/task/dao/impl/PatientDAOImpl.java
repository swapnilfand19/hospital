package com.task.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.model.Appointment;
import com.task.model.Clinic;
import com.task.model.Patient;
import com.task.dao.PatientDAO;

@Repository(value = "PatientDAO")
@Transactional
public class PatientDAOImpl implements PatientDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@ResponseBody
	public boolean savePatient(Patient patient) {
		try {	
			sessionFactory.getCurrentSession().save(patient);
			return true;
			}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean updatePatient(Patient patient) 
	{
		try 
		{
		    sessionFactory.getCurrentSession().update(patient);
			return true;
		} 
		catch (Exception e)
		{
			return false;		
		}
	}

	@Override
	public boolean deletePatient(Patient patient) {
		try 
		{
		    sessionFactory.getCurrentSession().delete(patient);
			return true;
		} 
		catch (Exception e)
		{
			return false;		
		}
	}

	@Override
	public Patient getPatientById(int patientId) {
		Session session=sessionFactory.openSession();
		Patient patient = session.get(Patient.class,patientId);
		session.close();
		return patient;
	}

	@Override
	public Patient findByName(String name) {
		return (Patient) this.sessionFactory.getCurrentSession().createQuery(
			    "from Patient u where u.patientName = :patientName").setParameter("patientName", name).getSingleResult();
	}

	@Override
	public List<Patient> getAllPatient() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Patient");
		List<Patient>  listCategories=query.list();
		session.close();
		return listCategories;
	}

	@Override
	public List<Patient> getPatientNA() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Patient where patientId IN (select patient.patientId from Appointment u where datediff(date,current_date) <= 0)");
		List<Patient>  listCategories=query.list();
		session.close();
		return listCategories;
	}

}
