package com.task.controller;

import java.util.LinkedHashMap;
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

import com.task.dao.AppointmentDAO;
import com.task.model.Appointment;
import com.task.dao.ClinicDAO;
import com.task.model.Clinic;
import com.task.dao.PatientDAO;
import com.task.model.Patient;
@Controller
public class AppointmentController 
{
	@Autowired
	private PatientDAO PatientDAO;
	
	@Autowired
	private ClinicDAO ClinicDAO;
	
	@Autowired
	private AppointmentDAO AppointmentDAO;
	boolean flag=true;
	@GetMapping("/appointmentregistration")
	public String viewAppointment(Model m) 
	{
			m.addAttribute("Appointment", new Appointment());
			List<Clinic> listClinic=ClinicDAO.getAllClinic();
			List<Patient> listPatient=PatientDAO.getAllPatient();
			m.addAttribute("ClinicID",this.getClinicList(listClinic));
			m.addAttribute("PatientID",this.getPatientList(listPatient));
			flag=true;
		return "appointmentRegistration";
	}
	
	 public LinkedHashMap<Integer,String> getClinicList(List<Clinic> listClinic)
	 {
		 LinkedHashMap<Integer,String> categoryData=new LinkedHashMap<Integer,String>();
		 int count=0;
		 
		 while(count<listClinic.size())
		 {
			 categoryData.put(listClinic.get(count).getClinicId(), listClinic.get(count).getClinicName());
			 count++;
		 }
		 return categoryData;
	 }

	 public LinkedHashMap<Integer,Integer> getPatientList(List<Patient> listPatient)
	 {
		 LinkedHashMap<Integer,Integer> categoryData=new LinkedHashMap<Integer,Integer>();
		 int count=0;
		 
		 while(count<listPatient.size())
		 {
			 categoryData.put(listPatient.get(count).getPatientId(), listPatient.get(count).getPatientId());
			 count++;
		 }
		 return categoryData;
	 }
	@PostMapping("/appointment/add")
	public String addAppointment(@ModelAttribute("Appointment") Appointment appointment,Model m) 
	{ 
		System.out.println("I am here...");
		 	System.out.println("DoctorId="+appointment.getApptid());
		 	AppointmentDAO.saveAppointment(appointment);
		 		 	
		 	Appointment appointment1= new Appointment();
		    m.addAttribute("doctor",appointment1);
				
		    List<Clinic> listClinic=ClinicDAO.getAllClinic();
			m.addAttribute("ClinicID",this.getClinicList(listClinic));
			List<Patient> listPatient=PatientDAO.getAllPatient();
			m.addAttribute("PatientID",this.getPatientList(listPatient));
			flag=true;
			m.addAttribute("Appointment", new Appointment());
			m.addAttribute("msg", "**Registration Successfully.");
			return "appointmentRegistration";
	}
	
	@RequestMapping("/displayappointment")
	 public String displayAllAppointment(Model m) 
	 {	
		 List<Appointment> AppointmentList=AppointmentDAO.getAllAppointment();
		 m.addAttribute("AppointmentList", AppointmentList); 
		 flag=true;
		 return "displayAppointment";
		 
	 }
	
	@PostMapping("/Appointment/searching")	
	public String searchAppointment(@ModelAttribute("Appointment") @RequestParam("searching") String Name,@RequestParam("value") int value,Model m)
	{
		String S1=Name;
		String S2="Clinic";
		String S3="Year";
		if(S1.equals(S2))
		{
			List<Appointment> AppointmentList=AppointmentDAO.findByclinicId(value);
			m.addAttribute("AppointmentList", AppointmentList); 
			flag=true;
			return "displayAppointment";
		}else if(S1.equals(S3))
		{
			List<Appointment> AppointmentList=AppointmentDAO.findByYaer(value);
			m.addAttribute("AppointmentList", AppointmentList); 
			flag=true;
			return "displayAppointment";
		}else
		{
			List<Appointment> AppointmentList=AppointmentDAO.findByMonth(value);
			m.addAttribute("AppointmentList", AppointmentList); 
			flag=true;
			return "displayAppointment";
		}	
	}
	@RequestMapping("/Appointment/deleteAmt50")	
	public String delectAppointmentless50(@ModelAttribute("Appointment") Appointment appointment,Model m)
	{
		int result=AppointmentDAO.deleteAppointment();
		if(result==0)
		{
			 List<Appointment> AppointmentList=AppointmentDAO.getAllAppointment();
			 m.addAttribute("AppointmentList", AppointmentList); 
			m.addAttribute("msg", "**ALL appointment have amount greater than 50.");
			return "displayAppointment";
		}else
		{
			 List<Appointment> AppointmentList=AppointmentDAO.getAllAppointment();
			 m.addAttribute("AppointmentList", AppointmentList); 
			m.addAttribute("msg", "** Successfully Delete Appointment have amount less than 50.");
			return "displayAppointment";
		}
	}
	
}