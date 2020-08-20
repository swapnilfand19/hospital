package com.task.model;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Appointment 
{

	@Id
    @Column(name = "AppointmentID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int apptid;
	private String date;
	private int operatory;
	private int provider;
	private String appttime;
	private int apptlength;
	private float amount;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "clinicId")
	private Clinic clinic;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "patientId")
	private Patient patient;

	public int getApptid() {
		return apptid;
	}

	public void setApptid(int apptid) {
		this.apptid = apptid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getOperatory() {
		return operatory;
	}

	public void setOperatory(int operatory) {
		this.operatory = operatory;
	}

	public int getProvider() {
		return provider;
	}

	public void setProvider(int provider) {
		this.provider = provider;
	}

	public String getAppttime() {
		return appttime;
	}

	public void setAppttime(String appttime) {
		this.appttime = appttime;
	}

	public int getApptlength() {
		return apptlength;
	}

	public void setApptlength(int apptlength) {
		this.apptlength = apptlength;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
