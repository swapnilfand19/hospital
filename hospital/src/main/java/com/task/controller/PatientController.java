package com.task.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.dao.PatientDAO;
import com.task.model.Appointment;
import com.task.model.Patient;

@Controller
public class PatientController 
{
	@Autowired
	private PatientDAO PatientDAO;
	int age=0;
	boolean val=true;
	@GetMapping("/patientregistration")
	public String viewUerInfo(Model model) 
	{
		model.addAttribute("Patient", new Patient());
		return "patientRegistration";
	}

	@PostMapping("/patient/add")
	public String addBooks(@ModelAttribute("Patient") Patient Patient,Model m) 
	{
		Patient patient=new Patient();
		patient.setPatientId(Patient.getPatientId());
		patient.setPracticeId(Patient.getPracticeId());
		patient.setFirstName(Patient.getFirstName());
		patient.setLastName(Patient.getLastName());
		patient.setCity(Patient.getCity());
		patient.setGender(Patient.getGender());
		patient.setState(Patient.getState());
		patient.setDate(Patient.getDate());
		age=diffAge(Patient.getDate());
		patient.setAge(age);
		if(this.age>=18)
		{
		patient.setPatientAgeGroup("Adult");
		}
		else{
			patient.setPatientAgeGroup("Minor");
		}
		val=PatientDAO.savePatient(patient);
		if(val==false)
		{
			m.addAttribute("msg", "This Email_ID is Already Registered.");
			return "patientRegistration";
		}
		else
		{
			m.addAttribute("Patient", new Patient());
			m.addAttribute("msg", "Registration Successfully.");
			return "patientRegistration";	
		}
	}
	public int diffAge(String date1)
	{
		String s = date1;
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  Date d=null;
		try 
		{
			d = sdf.parse(s);
		} 
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		  Calendar c = Calendar.getInstance();
		  c.setTime(d);
		  int year = c.get(Calendar.YEAR);
		  int month = c.get(Calendar.MONTH) + 1;
		  int date = c.get(Calendar.DATE);
		  LocalDate l1 = LocalDate.of(year, month, date);
		  LocalDate now1 = LocalDate.now();
		  Period diff1 = Period.between(l1, now1);
		  System.out.println("age:" + diff1.getYears() + "years");
		
		int age = diff1.getYears();
		
		return age;
	}
	
	@RequestMapping("/displaypatient")
	 public String displayAllPatient(Model m) 
	 {	
		 List<Patient> PatientList=PatientDAO.getAllPatient();
		 m.addAttribute("PatientList", PatientList); 
		 m.addAttribute("msg", "All Patient's");
		 return "displayPatient";
	 }
	
	@RequestMapping("/displaypatientNA")
	 public String displayPatient(Model m) 
	 {	
		 List<Patient> PatientList=PatientDAO.getPatientNA();
		 m.addAttribute("PatientList", PatientList); 
		 m.addAttribute("msg", "Patient who do not have appointments in the future");
		 return "displayPatient";
	 }
}