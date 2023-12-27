<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate");
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<h1>Users</h1>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.age}</td>
					<td>${user.city}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="logout">
		<input type="submit" value="logout" />
	</form>
</body>
</html>