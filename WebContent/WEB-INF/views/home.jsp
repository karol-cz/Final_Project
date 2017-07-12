<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="<c:url value="/css/styles.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<%@	include file="header.jsp"%>


	<div class="home_wrapper">
		<div class="title">
			<h1>JAKIEJ USŁUGI POTRZEBUJESZ?</h1>
		</div>
		<div>

			<select id="services" class="btn btn-default">
				<option value="" disabled selected>Select Service</option>
				<c:forEach var="s" items="${serviceTypes}">
					<option value="${s.id}">${s.name}</option>
				</c:forEach>
		</div>
		<p>WYBIERZ MIASTO:</p>
		<div class="col-md-2 control-label">
			</select> <select id="cities" class="btn btn-default">
				<option value="" disabled selected>Select City</option>
				<c:forEach var="c" items="${cities}">
					<option value="${c.id}">${c.name}</option>
				</c:forEach>
			</select>
			<button type="button" class="btn btn-default">Suchen!</button>
		</div>

		<div class="header_wrapper"></div>


	<div id="lista"></div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/import.js"></script>
</body>
</html>