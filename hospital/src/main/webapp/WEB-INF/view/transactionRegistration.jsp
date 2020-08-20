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

	<c:url var="addAction" value="/Transaction/add"></c:url>

	<form:form action="${addAction}" modelAttribute="Transaction" class="form">
	<div class="frame"><br>

    <label style="width:50%;">Please fill Transaction information</label>
    <label style="width:48%;">${msg}</label><br>
    <hr>
		<label for="transid" style="width:50%;"><b>Transaction ID</b></label> 
		<form:input path="transid" style="width:50%;" readonly="true" size="8" disabled="true" class="input"/><form:hidden path="transid" /><br>
		<label for="patientID" style="width:49%;"><b>Patient Id</b></label> <label for="clinicID" style="width:49%;"><b>Clinic Name</b></label><br>
		<form:select path="patient.patientId" class="input" style="width:50%;"><form:option value="0" label="Select ID"/><form:options items="${PatientID}"/></form:select>
		<form:select path="clinic.clinicId" class="input" style="width:49%;"><form:option value="0" label="Select Name"/><form:options items="${ClinicID}"/></form:select><br>
		<label for="proceduretype" style="width:50%;"><b>proceduretype</b></label> <label for="proceduredate"><b>proceduredate</b></label><br>
				<form:input path="proceduretype" placeholder="proceduretype" style="width:50%;" class="input"/>
				<form:input type="date" path="proceduredate" class="input" style="width:46%;"/> &nbsp
		<label for="prov" style="width:49%;"><b>prov</b></label><label for="amount" style="width:50%;"><b>amount</b></label>
		<form:input path="prov" placeholder="prov" style="width:50%;" class="input"/>
				<form:input path="amount" placeholder="amount" style="width:48%;" class="input"/>
		<input type="submit" class="registerbtn" value="<spring:message text="SUBMIT"/>" />
	</div>
	</form:form>
	
</body>
</html>