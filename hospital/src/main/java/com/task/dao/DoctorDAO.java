package com.task.dao;
import java.util.List;

import com.task.model.Doctor;



public interface DoctorDAO 
{
	public boolean add(Doctor doctor);
	public boolean delete(Doctor doctor);
	public boolean update(Doctor doctor);
	public List<Doctor> listdoctor();
	public Doctor getDoctor(int DoctorId);
}
