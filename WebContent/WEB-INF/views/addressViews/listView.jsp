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

	Lista adresow:
	</br>
	<br>
	<table>
		<tr>
			<th>MIASTO</th>
			<th>KOD POCZTOWY</th>
			<th>ULICA</th>
		</tr>
		<c:forEach items="${addresses}" var="address">
			<tr>
				<td>${address.city}</td>
				<td>${address.postalCode}</td>
				<td>${address.street}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>