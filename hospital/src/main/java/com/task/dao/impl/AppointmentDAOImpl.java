package com.task.dao.impl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.model.Appointment;
import com.task.model.Clinic;
import com.task.dao.AppointmentDAO;
@Repository(value = "AppointmentDAO")
@Transactional
public class AppointmentDAOImpl implements AppointmentDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@ResponseBody
	public boolean saveAppointment(Appointment Appointment) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(Appointment);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean updateAppointment(Appointment Appointment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAppointment() {
		Session session=sessionFactory.openSession();
		session.beginTransaction(); 
		Query query = session.createQuery("delete Appointment where amount <50 ");
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	

	@Override
	public List<Appointment> getAllAppointment() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Appointment");
		List<Appointment>  listCategories=query.list();
		session.close();
		return listCategories;
	}

	@Override
	public Appointment getAppointmentById(int AppointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> findByYaer(int year) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Appointment where year(date) = :year").setParameter("year",year);
		List<Appointment>  listCategories=query.list();
		session.close();
		return listCategories;

	}

	@Override
	public List<Appointment> findByMonth(int month) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Appointment where  month(date) = :month").setParameter("month", month);
		List<Appointment>  listCategories=query.list();
		session.close();
		return listCategories;

	}

	@Override
	public List<Appointment> findByclinicId(int id) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Appointment u where u.clinic.clinicId = :id").setParameter("id", id);
		List<Appointment>  listCategories=query.list();
		session.close();
		return listCategories;
	}

	
}
