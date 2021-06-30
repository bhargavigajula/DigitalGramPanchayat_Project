<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap" rel="stylesheet">
<link href="profilecss.css" rel="stylesheet">
</head>
<body>
    <div class="bg-image"></div>
	<div class="bg-text">
		<form action="ProfileForm" method="post">
		   <div class="contact-form">
		       <h2 style="margin-top:-30px;">User Profile</h2>
		       <div class="love">
			   <p>UserName</p><input type="text" name="userName" value="${user.userName}" readonly>
			   
			   <p>email</p> <input type="text" name="email" value="${user.email}">

			   <p>mobileNo</p> <input type="text" name="mobileNo" value="${user.mobileNo}">

			   <p>state</p> <input type="text" name="state" value="${user.state}">

			   <p>city</p> <input type="text" name="city" value="${user.city}">
			   
			   <p>aadharNo</p> <input type="text" name="aadharNo" value="${user.aadharNo}"><br />
			   </div>
			   <input type="submit" value="Edit">
		  </div>
		</form>
	</div>
    
</body>
</html>