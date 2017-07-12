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
	<select>
		<c:forEach var="s" items="${serviceTypes}">
			<option value="${s.id}">${s.name}</option>
		</c:forEach>
	</select>
	<select>
		<c:forEach var="c" items="${cities}">
			<option value="${c.id}">${c.name}</option>
		</c:forEach>
	</select>
	
	
	<button type="button">Suchen!</button>
	<div id="lista">
	
	</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/import.js"></script>
</body>
</html>