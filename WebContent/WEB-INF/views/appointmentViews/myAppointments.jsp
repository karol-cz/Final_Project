<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="<c:url value="/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<div>
		<%@	include file="/WEB-INF/views/header.jsp"%>
	</div>
	<div class="table_wrapper">
		<h2>Twoja Lista zamowionych uslug:</h2> 
		<hr>
		<table>
			<tr>
				<th>User</th>
				<th>Company</th>
				<th>Date</th>
				<th>Time</th>
			</tr>
			<c:forEach items="${appointments}" var="appointment">
				<tr>
					<td>${appointment.user.firstName}</td>
					<td>${appointment.company.name}</td>
					<td>${appointment.date}</td>
					<td>${appointment.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>