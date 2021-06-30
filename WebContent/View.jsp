<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewSchemes</title>
</head>
<body>
<div class="bg-image"></div>
	<div class="bg-text">
		<center>
			<h2>All Schemes Details</h2>
		</center>
		<table border=2 align=center>
			<tr>
				<th>SCHEME NAME</th>
				<th>DESCRIPTION</th>
				<th>IMAGE</th>
				<th colspan=2>ACTION</th>
			</tr>
			<c:forEach items="${schemeList}" var="schemes" varStatus="loop">
				<tr>
					<td>${schemes.schemeName}</td>
					<td>${schemes.description}</td>
					<td><img src="image/${schemes.imageFileName}"></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewSchemes</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style5.css">
</head>
<body>
<div class="bg-image"></div>
	<div class="bg-text">
			<c:forEach items="${schemeList}" var="schemes" varStatus="loop">
				    <div class="card wow">
				        <img class="card-img-top hello" src="image/${schemes.imageFileName}" alt="Card image">
				        <div class="card-body">
				           <h2 class="card-title">${schemes.schemeName}</h2>
				           <p class="card-text">${schemes.description}</p>
				           <a href="UpdateSchemes?schemeName=${schemes.schemeName}&description=${schemes.description}&imageFileName=${schemes.imageFileName}" class="card-link "><BUTTON class="btn btn-warning but hmm">Edit</BUTTON></a>
				           <a href="DeleteScheme?schemeName=${schemes.schemeName}&description=${schemes.description}&imageFileName=${schemes.imageFileName}" class="card-link "><BUTTON class="btn btn-warning but hmm">Delete</BUTTON></a>
	                    </div>
	                </div>
			</c:forEach>
</body>
</html>