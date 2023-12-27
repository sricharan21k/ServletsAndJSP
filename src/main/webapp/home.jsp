<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("user")== null){
			response.sendRedirect("login.jsp");
		}
	%>
	<h1>Home</h1>
	
	<a href="users"><button>Show People</button></a>
		
	<form action="logout">
		<input type="submit" value="logout"/>
	</form>
	
</body>
</html>