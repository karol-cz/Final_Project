<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<div class="login_wrapper">

		<form:form class="form-horizontal" method="POST" modelAttribute="company">
			<form:errors path="*" element="div" />

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<h3>Logowanie firmy:</h3>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-3">
					<form:input path="email" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-3">
					<form:input path="password" type="password" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<a href="<%=request.getContextPath()%>/companies/add">Załóż
						Konto</a>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<input type="submit" value="Login" class="btn btn-default">
				</div>
			</div>
			
		</form:form>
	</div>


</body>
</html>