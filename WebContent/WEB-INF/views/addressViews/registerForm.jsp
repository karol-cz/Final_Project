<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@	include file="/WEB-INF/views/header.jsp"%>
	</div>

	NEW COMPANY:

	<form:form method="POST" modelAttribute="address">
		<form:errors path="*" element="div" />
		MIASTO
		<form:select path="city.id" items="${cities}" itemLabel="name" itemValue="id"/><br>
		<br>
		KOD POCZTOWY 		
		<form:input path="postalCode" />
		<br>
		ULICA 		
		<form:input path="street" />
		<br>

		<input type="submit" value="Submit">
	</form:form>
</body>
</html>