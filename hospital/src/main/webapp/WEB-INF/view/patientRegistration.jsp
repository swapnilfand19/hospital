<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Registration</title>
<style>
body
	{
	background-image:url('images/desktopbaby.jpg');
	background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
	}
.form{
padding: 16px 10px 10px 20px;
height=70%;
width=70%;
}
.input
{
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
.registerbtn:hover {
  opacity: 1;
}
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.frame
{
background: rgba(115, 230, 0, 0.45);
	margin-right:22%;
	margin-left:22%;
		padding-bottom:10px;
		padding-left:10px;
		padding-right:10px;
		padding-top:0px;
	
}
</style>
</head>
<body>
<h2 style="text-align:center">Register Yourself</h2>

	<c:url var="addAction" value="/patient/add"></c:url>

	<form:form action="${addAction}" modelAttribute="Patient" class="form">
	<div class="frame"><br>

    <label style="width:50%;">Please fill patient information</label>
    <label style="width:48%;">${msg}</label><br>
    <hr>
		<label for="patient" style="width:50%;"><b>Patient ID</b></label> <label for="PracticeID" style="width:49%;"><b>Practice ID</b></label><br>
		<form:input path="patientId" style="width:50%;" readonly="true" size="8" disabled="true" class="input"/> <form:hidden path="patientId" />
		<form:input path="practiceId" placeholder="PracticeId" style="width:49%;" class="input"/><br>
		<label for="Datientname"><b>Patient Name</b></label><br>
				<form:input path="firstName" placeholder="FirstName" style="width:50%;" class="input" />
				<form:input path="lastName" placeholder="LastName" style="width:48%;" class="input" />
		<label for="Address"><b>Address</b></label><br>
		<form:input path="city" placeholder="City" style="width:50%;" class="input"  />
		<form:input path="state" placeholder="State" style="width:48%;" class="input" /><br>
		<label for="gender"><b>Gender</b></label>
		<form:radiobutton path="gender" value="Male"/> Male 
  		<form:radiobutton path="gender" value="Female"/> Female
   		<form:radiobutton path="gender" value="Other"/> Other<br>
   		
   		<label for="Birthday"><b>Select date of birth : </b></label>
 	   	<form:input type="date" path="date" class="input" />
		<input type="submit" class="registerbtn" value="<spring:message text="SUBMIT"/>" />
	</div>
	</form:form>
	
</body>
</html>