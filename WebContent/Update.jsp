<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Schemes Information</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap"
	rel="stylesheet">
<link href="style6.css" rel="stylesheet">
</head>
<body>
<div class="bg-image"></div>
<div class="bg-text">
   <form action="EditScheme" method = "post">
	<div class="contact-form">
	   <h2>Update Schemes</h2>
	   <p>SchemeName</p><input type="text" name="schemeName" value="${scheme.schemeName}" readonly>
	   <p>Description</p><textarea name="description" rows="10" cols="44">${scheme.description}</textarea>
	   <!-- <input type="textarea" name="description" value="${scheme.description}"> -->
	   <input type="submit" value="Update">
	</div>
   </form>
</div>
</body>
</html>