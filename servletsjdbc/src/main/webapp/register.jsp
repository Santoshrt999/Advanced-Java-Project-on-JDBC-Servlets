<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h2>Create an Account</h2>
<form method="post" action="register.do">
<input type="text" title="fullname" placeholder="fullname" name="fullname"/>
<input type="email" title="email" placeholder="email" name="email"/>
<input type="text" title="username" placeholder="username" name="username"/>
<input type="password" title="password" placeholder="password" name="fullname"/>
<input type="password" title="re-password" placeholder="reenter-password" name="confirm-password"/>

<button type = "submit" class="btn">REGISTER</button>
</form>
</div>
</body>
</html>