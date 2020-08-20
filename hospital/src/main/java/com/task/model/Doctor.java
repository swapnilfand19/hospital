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
public class Doctor 
{

	@Id
    @Column(name = "DoctorID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdNo;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "clinicId")
	private Clinic clinic;


	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public int getIdNo() {
		return IdNo;
	}

	public void setIdNo(int idNo) {
		IdNo = idNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
