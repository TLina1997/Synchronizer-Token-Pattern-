<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style type="text/css">

body{

	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: #34495;
	
}

.box{

	width: 300px;
	padding: 40px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	background: #191919;
	text-align: center;

}

.box h1{

	color: white;
	text-transform: uppercase;
	font-weight: 500;
}

.box input[type = "text"],.box input[type = "password"]{
	
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s; 
	
}

.box input[type = "text"]:focus,.box input[type = "password"]:focus{

	width: 280px;
	border-color: #2ecc71;
	 
}

.box input[type = "submit"]{

	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #2ecc71;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s; 
	cursor: pointer;
}

.box input[type = "submit"]:hover{

	background: #2ecc71;
}

</style>


</head>
<body>

	<div align="center">
		<h2>Login page</h2>
		<br />
		<form class="box" method="post" action="LoginController">
			<input type="text" placeholder="Username" name="username" />
			<input type="password" placeholder="Password" name="password" />
			<c:if test="${not empty sessionScope.invalidUser}">
				<div id="message" style="color: red;">User not found try
					again.</div>
			</c:if>
			<input type="submit" value="Login">
		</form>
	</div>
	
</body>
</html>