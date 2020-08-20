package com.task.controller;

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

import com.task.dao.ClinicDAO;
import com.task.model.Clinic;

@Controller
public class ClinicController 
{
	@Autowired
	private ClinicDAO ClinicDAO;
	
	@GetMapping("/clinicregistration")
	public String viewUerInfo(Model model) 
	{
		model.addAttribute("Clinic", new Clinic());
		return "clinicRegistration";
	}

	@PostMapping("/Clinic/add")
	public String addBooks(@ModelAttribute("Clinic") Clinic Clinic,Model m) 
	{
		
			boolean val=ClinicDAO.saveClinic(Clinic);
			if(val==false)
			{
				m.addAttribute("msg", "This Email_ID is Already Registered.");
				return "clinicRegistration";
			}
			else
			{
				m.addAttribute("Clinic", new Clinic());
				m.addAttribute("msg", "Registration Successfully.");
				return "clinicRegistration";	
			}
	}
}