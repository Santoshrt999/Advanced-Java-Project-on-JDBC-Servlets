<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String validationData = null;
String admin=null;
String location=null;
if(request.getAttribute("validationInfo")!=null){
	validationData=request.getAttribute("validationInfo").toString();	
}
if(request.getAttribute("City")!=null){
	validationData=request.getAttribute("City").toString();	
}
if(request.getAttribute("ADMIN-DETAILS")!=null){
	validationData=request.getAttribute("ADMIN-DETAILS").toString();	
}

out.println(validationData);
out.println(admin);
out.println(location);

%>
<a href="/servletsjdbc/login.jsp">Login</a>
</body>
</html>