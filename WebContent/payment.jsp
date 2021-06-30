<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pay Taxes</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap" rel="stylesheet">
<link href="Pay.css" rel="stylesheet">
</head>
<body>
	<div class="bg-image"></div>
	<div class="bg-text">
		<form action="PaymentForm" method="post">
		   <div class="contact-form">
		       <img alt="" class="avatar" src="https://i.postimg.cc/zDyt7KCv/a1.jpg">
		       <h2>Payment Form</h2>
			   <p>Name</p><input type="text" name="userName">
			   <p>email</p> <input type="text" name="email">
			   <p>mobileNo</p> <input type="text" name="mobileNo">
			   <p>TaxName</p><input type="text" name="taxName">
			   <p>amount</p> <input type="text" name="state" value="1000" readonly>
			   <input type="submit" value="Pay">
		  </div>
		</form>
	</div>
</body>
</html>
