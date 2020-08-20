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
	<br/>
  <h3 style="text-align:center">:: PATIENT'S ::</h3>
  <br/>
  			<h3 style="text-align:center"><a href="<c:url value="/displaypatient"/>" class="btn btn-success" > All Patient</a> <a href="<c:url value="/displaypatientNA"/>" class="btn btn-success" >Patient who do not have appointments in the future</a></h3>
  			<h3 style="text-align:center">:: ${msg} ::</h3>
	<table style="text-align:center" class="table table-bordered">	
	<tr>
		<th style="text-align:center">Patient ID</th>
		<th style="text-align:center">Practice ID</th>
		<th style="text-align:center">Patient FirstName</th>
		<th style="text-align:center">Patient LastName</th>
		<th style="text-align:center">City</th>
		<th style="text-align:center">State</th>
		<th style="text-align:center">Gender</th>
		<th style="text-align:center">Date of Birth</th>
		<th style="text-align:center">Age</th>
		<th>patient Age Group</th>
	</tr>
	<c:forEach items="${PatientList}" var="Patient">
	<tr>
		<td>${Patient.patientId}</td>
		<td>${Patient.practiceId}</td>
		<td>${Patient.firstName}</td>
		<td>${Patient.lastName}</td>
		<td>${Patient.city}</td>
		<td>${Patient.state}</td>
		<td>${Patient.gender}</td>
		<td>${Patient.date}</td>
		<td>${Patient.age}</td>
		<td>${Patient.patientAgeGroup}</td>
		
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>