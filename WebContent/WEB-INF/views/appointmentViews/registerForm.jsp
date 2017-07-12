<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	NEW SERVICE TYPE:

	<form:form method="POST" modelAttribute="appointment">
		<form:errors path="*" element="div" />
		USER: 
		<form:select path="user.id" items="${users}" itemLabel="name" itemValue="id"/><br>
		<br>
		CAMPANY: 
		<form:select path="company.id" items="${companies}" itemLabel="name" itemValue="id"/><br>
		<br>
		DATA: 
		<form:input path="date" />
		<br>

		<input type="submit" value="Submit">
	</form:form>
</body>
</html>