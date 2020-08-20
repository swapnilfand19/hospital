<%@include file="header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<div class="container">
<br>
	 <h3 style="text-align:center"></h3><br>
<form action="<c:url value='/Appointment/searching' />" method="post">
	<table style="text-align:center" class="table table-bordered table-dark">
	<tr>
		<th style="text-align:center">Select By</th>
		<th style="text-align:center">Value</th>
		<th></th>
	</tr>
	<tr>
	<td><select name="searching" id="searching">
		<option value="Month" label="Select By"/>
		<option value="Clinic" label="By Clinic"/>  
        <option value="Year" label="By Year"/>  
        <option value="Month" label="By Month"/>    
		</select>
	</td>
	<td><input type="text" name="value" required="required"/></td>
	<td><button type="submit" class="btn btn-primary" style="text-align:center">Submit</button>
	<a href="<c:url value="//Appointment/deleteAmt50"/>" class="btn btn-success" >delete appointment(amount less than 50)</a>
	</td>
	</tr>
	</table>
	</form>
	<label style="width:48%;">${msg}</label><br>
  <h3 style="text-align:center">:: Appointment ::</h3>
  <br/>
<table style="text-align:center" class="table table-bordered">
	<tr>
		<th>Appointment ID</th>
		<th>Patient Id</th>
		<th>clinic Id</th>
		<th>operatory</th>
		<th>provider</th>
		<th>Appointment time</th>
		<th>Appointment length</th>
		<th>Appointment Date</th>
		<th>Amount</th>
		
	</tr>
	<c:forEach items="${AppointmentList}" var="Appointment">
	<tr>
		<td>${Appointment.apptid}</td>
		<td>${Appointment.patient.patientId}</td>
		<td>${Appointment.clinic.clinicId}</td>
		<td>${Appointment.operatory}</td>
		<td>${Appointment.provider}</td>
		<td>${Appointment.appttime}</td>
		<td>${Appointment.apptlength}</td>
		<td>${Appointment.date}</td>
		<td>${Appointment.amount}</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>