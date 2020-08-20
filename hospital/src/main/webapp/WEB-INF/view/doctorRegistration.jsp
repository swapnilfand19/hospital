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

	<c:url var="addAction" value="/doctor/add"></c:url>

	<form:form action="${addAction}" modelAttribute="Doctor" class="form">
	<div class="frame"><br>

    <label style="width:50%;">Please fill patient information</label>
    <label style="width:48%;">${msg}</label><br>
    <hr>
		<label for="IdNo" style="width:50%;"><b>Doctor ID</b></label> <label for="clinicID" style="width:49%;"><b>Clinic Name</b></label><br>
		<form:input path="IdNo" style="width:50%;" readonly="true" size="8" disabled="true" class="input"/> <form:hidden path="IdNo" />
		<form:select path="clinic.clinicId" class="input" style="width:49%;"><form:option value="0" label="Select Name"/><form:options items="${ClinicID}"/></form:select><br>
		<label for="Datientname"><b>Doctor's Name</b></label><br>
				<form:input path="firstName" placeholder="FirstName" style="width:50%;" class="input"/>
				<form:input path="lastName" placeholder="LastName" style="width:48%;" class="input"/>
		<label for="Address"><b>Address</b></label><br>
		<form:input path="city" placeholder="City" style="width:50%;" class="input"/>
		<form:input path="state" placeholder="State" style="width:48%;" class="input"/><br>
		<input type="submit" class="registerbtn" value="<spring:message text="SUBMIT"/>" />
	</div>
	</form:form>
	
</body>
</html>