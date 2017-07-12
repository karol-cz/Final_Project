<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	Lista firm:
	</br>
	<br>
	<table>
		<tr>
			<th>NAZWA</th>
			<th>TYP</th>
			<th>EMAIL</th>
			<th>HASŁO</th>
			<th>MIASTO</th>
			<th>ULICA</th>
			<th>KOD POCZTOWY</th>
			<th>TELEFON</th>
		</tr>
		<c:forEach items="${companies}" var="company">
			<tr>
				<td>${company.name}</td>
				<td>${company.serviceType}</td>
				<td>${company.email}</td>
				<td>${company.password}</td>
				<td>${company.address.city}</td>
				<td>${company.address.street}</td>
				<td>${company.address.postalCode}</td>
				<td>${company.phone}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>