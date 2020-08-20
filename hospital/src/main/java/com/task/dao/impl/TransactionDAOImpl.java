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
import com.task.model.Transaction;
import com.task.dao.AppointmentDAO;
import com.task.dao.TransactionDAO;
@Repository(value = "TransactionDAO")
@Transactional
public class TransactionDAOImpl implements TransactionDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveTransaction(Transaction Transaction) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(Transaction);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean updateTransaction(Transaction Transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTransaction(Transaction Transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transaction getTransactionById(int TransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransaction() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Transaction");
		List<Transaction>  listCategories=query.list();
		session.close();
		return listCategories;
	}
}
