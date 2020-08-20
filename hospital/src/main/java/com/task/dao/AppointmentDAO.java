package com.task.dao;

import java.util.List;

import com.task.model.Appointment;
public interface AppointmentDAO 
{

	boolean saveAppointment(Appointment Appointment);

	boolean updateAppointment(Appointment Appointment);

	int deleteAppointment();

	public Appointment getAppointmentById(int AppointmentId);
	
	public List<Appointment> findByYaer(int year);
	public List<Appointment> findByMonth(int month);
	public List<Appointment> findByclinicId(int id);
	
	List<Appointment> getAllAppointment();
	
}

