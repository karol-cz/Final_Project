<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
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
	<div class="header_wrapper">

			<a href="<%=request.getContextPath()%>/users/login" class="btn btn-default">UŻYTKOWNIK</a>
			<a href="<%=request.getContextPath()%>/companies/login" class="btn btn-default">FRIMA</a>
	</div>
</body>
</html>