package com.task.dao;

import java.util.List;

import com.task.model.Patient;
public interface PatientDAO 
{

	boolean savePatient(Patient patient);

	boolean updatePatient(Patient patient);

	boolean deletePatient(Patient patient);

	public Patient getPatientById(int patientId);
	
	public Patient findByName(String auth);
	
	List<Patient> getAllPatient();
	
	List<Patient> getPatientNA();//Show a list of patients with patient details who do not have appointments in the future
	
}

