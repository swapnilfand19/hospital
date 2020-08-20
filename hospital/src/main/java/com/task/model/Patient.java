package com.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component 
public class Patient 
{
	    @Id
		@GeneratedValue
		int patientId;
	    int practiceId;
	    String firstName;
	    String lastName;
		String city;
		String state;
		String gender;
		String date;
		int age;
		String patientAgeGroup;
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		public int getPracticeId() {
			return practiceId;
		}
		public void setPracticeId(int practiceId) {
			this.practiceId = practiceId;
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
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) 
		{
			this.age = age;
		}
		public String getPatientAgeGroup() {
			return patientAgeGroup;
		}
		public void setPatientAgeGroup(String patientAgeGroup) 
		{
			this.patientAgeGroup = patientAgeGroup;
		}
		
		
}
