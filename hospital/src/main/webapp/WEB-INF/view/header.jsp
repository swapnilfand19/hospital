<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online_Hospital</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
.navbar-nav>li {
    float: left;
position: relative;
    display: block;
}

.dropdown {
    position: relative;
}
.dropdown-toggle {
	
    outline: 0 !important;
    margin: 0px 10px;
    padding: 19px 6px;
    border: none;
    background: transparent;
    border: none;
    cursor: pointer;
}
.profile-dd-img1 {
    width: 22px;
    margin-top: 8px;
    height: 22px;
    margin-left: 4px;
    margin-right: 14px;
}
.dropdown-menu a {
    width: 100%;
    color: #000;
    line-height: 2.5;
    padding: 5px 9px;
    text-decoration: none;
    display: inline-flex;
}
  </style>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Online Hospital Services</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="<c:url value="/home"/>">HOME</a></li>
       <li class=""><a href="<c:url value="/clinicregistration"/>">ADD CLINIC</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">DOCTOR<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/doctorregistration"/>">Add Doctor</a></li>
          <li><a href="<c:url value="#"/>">View Doctor's</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">PATIENT<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/patientregistration"/>">Add Patient</a></li>
          <li><a href="<c:url value="/displaypatient"/>">View Patient's</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">APPOINTMENT <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/appointmentregistration"/>">Add Appointment</a></li>
          <li><a href="<c:url value="/displayappointment"/>">List Appointment </a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">TRANSACTION <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/Transactionregistration"/>">Add Transaction</a></li>
          <li><a href="<c:url value="/displaytransaction"/>">List Transaction </a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>

</body>
</html>