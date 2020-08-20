<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h2>Register Yourself</h2>
<h3>${msg}</h3>
	<c:url var="addAction" value="/Clinic/add"></c:url>

	<form:form action="${addAction}" modelAttribute="Clinic">
		<table>
				<tr>
					<td><form:label path="clinicId">
							<spring:message text="clinicId" />
						</form:label></td>
					<td><form:input path="clinicId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="clinicId" /></td>
				</tr>
			<tr>
				<td><form:label path="clinicName">
						<spring:message text="clinicName" />
					</form:label></td>
				<td><form:input path="clinicName" /></td>
			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message text="city" />
					</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="state">
						<spring:message text="state" />
					</form:label></td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"> 
					<input type="submit" value="<spring:message text="SUBMIT"/>" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>