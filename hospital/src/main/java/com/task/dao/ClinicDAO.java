package com.task.dao;

import java.util.List;

import com.task.model.Clinic;
public interface ClinicDAO 
{

	boolean saveClinic(Clinic clinic);

	boolean updateClinic(Clinic clinic);

	boolean deleteClinic(Clinic clinic);

	public Clinic getClinicById(int CliniclId);
	
	public Clinic findByName(String auth);
	
	List<Clinic> getAllClinic();
	
}

