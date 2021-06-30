<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewSchemes</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body">
	<div class="bg-image"></div>
	<div class="bg-text">
		<div class="contact-form">
			<center>
				<b><h2>All Farmers Details</h2></b>
			</center>
			<table border=1 class="table">
			  <thead>
				<tr class="active">
					<th>USER NAME</th>
					<th>EMAIL</th>
					<th>MOBILE NUMBER</th>
					<th>TAX NAME</th>
					<th>AMOUNT</th>
				</tr>
			   </thead>
			   <tbody>
				<c:forEach var="tax" items="${taxList}">
					<tr class="success">
						<td>${tax.userName}</td>
						<td>${tax.email}</td>
						<td>${tax.mobileNo}</td>
						<td>${tax.taxName}</td>
						<td>${tax.amount}</td>
					</tr>
				</c:forEach>
			   </tbody>
			</table>
		</div>
	</div>
</body>
</html>