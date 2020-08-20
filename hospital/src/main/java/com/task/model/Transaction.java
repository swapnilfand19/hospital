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
public class Transaction 
{

	@Id
    @Column(name = "AppointmentID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transid;
	private String proceduretype;
	private String proceduredate;
	private int prov;
	private float amount;
	
	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public String getProceduretype() {
		return proceduretype;
	}

	public void setProceduretype(String proceduretype) {
		this.proceduretype = proceduretype;
	}

	public String getProceduredate() {
		return proceduredate;
	}

	public void setProceduredate(String proceduredate) {
		this.proceduredate = proceduredate;
	}

	public int getProv() {
		return prov;
	}

	public void setProv(int prov) {
		this.prov = prov;
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

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "clinicId")
	private Clinic clinic;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "patientId")
	private Patient patient;
	
}
