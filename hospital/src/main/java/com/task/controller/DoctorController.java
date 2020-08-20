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

import com.task.dao.DoctorDAO;
import com.task.model.Doctor;
import com.task.dao.ClinicDAO;
import com.task.model.Clinic;

@Controller
public class DoctorController 
{
	@Autowired
	private DoctorDAO DoctorDAO;
	
	@Autowired
	private ClinicDAO ClinicDAO;
	boolean flag=true;
	@GetMapping("/doctorregistration")
	public String viewUerInfo(Model m) 
	{
			m.addAttribute("Doctor", new Doctor());
			List<Clinic> listClinic=ClinicDAO.getAllClinic();
			m.addAttribute("ClinicID",this.getCategoryList(listClinic));
			flag=true;
		return "doctorRegistration";
	}
	
	 
	 /*@RequestMapping(value="/doctorregistration")
		public String showfood(Model m)
		{
		 Doctor doctor= new Doctor();
		    m.addAttribute("doctor",doctor);
			List<Doctor> foodList=DoctorDAO.listdoctor();
			m.addAttribute("foodList", foodList); 
			List<Clinic> listClinic=ClinicDAO.getAllClinic();
			m.addAttribute("ClinicID",this.getCategoryList(listClinic));
			flag=true;
			return "doctorRegistration";
			
		}*/
	
	 
	 public LinkedHashMap<Integer,String> getCategoryList(List<Clinic> listClinic)
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

	@PostMapping("/doctor/add")
	public String addBooks(@ModelAttribute("Doctor") Doctor doctor,Model m) 
	{ 
		System.out.println("I am here...");
		 	System.out.println("DoctorId="+doctor.getIdNo());
		 	DoctorDAO.add(doctor);
		 		 	
		 	Doctor doctor1= new Doctor();
		    m.addAttribute("doctor",doctor1);
				
		    List<Clinic> listClinic=ClinicDAO.getAllClinic();
			m.addAttribute("ClinicID",this.getCategoryList(listClinic));
			flag=true;
			m.addAttribute("Doctor", new Doctor());
			m.addAttribute("msg", "**Registration Successfully.");
			return "doctorRegistration";
	}
}