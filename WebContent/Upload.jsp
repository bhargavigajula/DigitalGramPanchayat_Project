<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload image</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap"
	rel="stylesheet">
<link href="style4.css" rel="stylesheet">
</head>
<body>
	<div class="bg-image"></div>
	<div class="bg-text">
		<form action="SchemeUpload" method="post" enctype="multipart/form-data">
			<div class="contact-form">
				<h2>Upload Schemes</h2>
				<p>SchemeName</p><input type="text" name="schemeName">
				<p>Description</p><input type="text" name="description">
				<p>Image</p><input type="file" name="image"> 
				<input type="submit" value="Upload">
			</div>
		</form>
	</div>
</body>
</html>