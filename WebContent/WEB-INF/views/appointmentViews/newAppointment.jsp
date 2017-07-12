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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/js/appointments.js"></script>
<script>
	$(function() {
		$("#date").datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@	include file="/WEB-INF/views/header.jsp"%>
	</div>

	<div class="new_app_wrapper">
		<h2>Nowe zlecenie:</h2>

		</br> <br>
		<div>
			<div class="list_1">

				FIRMA <br /> TYP<br /> EMAIL<br /> MIASTO<br /> ULICA<br /> KOD
				POCZTOWY<br /> TELEFON<br />
			</div>


			<div class="list_2">
				${company.name}<br /> ${company.serviceType}<br /> ${company.email}<br />
				${company.address.city}<br /> ${company.address.street}<br />
				${company.address.postalCode}<br /> ${company.phone}<br />
			</div>

		</div>
		
		<div>
			<form:form class="form-horizontal" method="POST"
				modelAttribute="appointment">
				<form:hidden path="user.id" value="${userId}" />
				<form:hidden path="company.id" value="${companyId}" />

				<div class="form-group">
					<label class="control-label col-sm-1">Data:</label>
					<div class="col-sm-3">
						<form:input path="date" type="text" id="date" value="${date}"
							class="form-control" />
					</div>
				</div>

				<div id="hours"></div>
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-8">
						<input type="submit" value="GO!" class="btn btn-default">
					</div>
				</div>
				
			</form:form>
		</div>
	</div>

</body>
</html>