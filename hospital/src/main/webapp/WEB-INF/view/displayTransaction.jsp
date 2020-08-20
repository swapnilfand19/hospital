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
  <h3 style="text-align:center">:: Transaction's ::</h3>
  <br/>
  			
<table style="text-align:center" class="table table-bordered">
		
	<tr >
		<th style="text-align:center">Transaction ID</th>
		<th style="text-align:center">Patient Id</th>
		<th style="text-align:center">Clinic id</th>
		<th style="text-align:center">Procedure Type</th>
		<th style="text-align:center">Procedure Date</th>
		<th style="text-align:center">Provider</th>
		<th style="text-align:center">amount</th>
	</tr>
	<c:forEach items="${TransactionList}" var="Transaction">
	<tr>
		<td>${Transaction.transid}</td>
		<td>${Transaction.patient.patientId}</td>
		<td>${Transaction.clinic.clinicId}</td>
		<td>${Transaction.proceduretype}</td>
		<td>${Transaction.proceduredate}</td>
		<td>${Transaction.prov}</td>
		<td>${Transaction.amount}</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>