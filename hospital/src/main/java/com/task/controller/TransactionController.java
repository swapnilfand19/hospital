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

import com.task.dao.TransactionDAO;
import com.task.model.Appointment;
import com.task.dao.ClinicDAO;
import com.task.model.Clinic;
import com.task.dao.PatientDAO;
import com.task.model.Patient;
import com.task.model.Transaction;
@Controller
public class TransactionController 
{
	@Autowired
	private PatientDAO PatientDAO;
	
	@Autowired
	private ClinicDAO ClinicDAO;
	
	@Autowired
	private TransactionDAO TransactionDAO;
	
	boolean flag=true;
	@GetMapping("/Transactionregistration")
	public String viewTransaction(Model m) 
	{
			m.addAttribute("Transaction", new Transaction());
			List<Clinic> listClinic=ClinicDAO.getAllClinic();
			List<Patient> listPatient=PatientDAO.getAllPatient();
			m.addAttribute("ClinicID",this.getClinicList(listClinic));
			m.addAttribute("PatientID",this.getPatientList(listPatient));
			flag=true;
		return "transactionRegistration";
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
	@PostMapping("/Transaction/add")
	public String addAppointment(@ModelAttribute("Transaction") Transaction Transaction,Model m) 
	{ 
		System.out.println("I am here...");
		 	TransactionDAO.saveTransaction(Transaction);
		 		 	
		 	Transaction Transaction1= new Transaction();
		    m.addAttribute("Transaction",Transaction1);
				
		    List<Clinic> listClinic=ClinicDAO.getAllClinic();
			m.addAttribute("ClinicID",this.getClinicList(listClinic));
			List<Patient> listPatient=PatientDAO.getAllPatient();
			m.addAttribute("PatientID",this.getPatientList(listPatient));
			flag=true;
			m.addAttribute("Transaction", new Transaction());
			m.addAttribute("msg", "**Registration Successfully.");
			return "transactionRegistration";
	}
	
	@RequestMapping("/displaytransaction")
	 public String displayAllAppointment(Model m) 
	 {	
		 List<Transaction> TransactionList=TransactionDAO.getTransaction();
		 m.addAttribute("TransactionList", TransactionList); 
		 flag=true;
		 return "displayTransaction";
		 
	 }
	
	
	
}