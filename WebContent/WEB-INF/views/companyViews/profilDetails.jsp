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
		<%@	include file="/WEB-INF/views/headerCompany.jsp"%>
	</div>

	<div class="new_app_wrapper">
		<h2>Dane Twojej firmy:</h2>
		</br> <br>
		<div>
			<div class="list_1">

				Nazwa<br /> Email<br /> Kategoria usług<br /> Miasto<br /> Kod
				pocztowy<br /> Ulica<br /> Telefon<br />

			</div>


			<div class="list_2">
				${company.name}<br /> ${company.email}<br />
				${company.serviceType}<br /> ${company.address.city}<br />
				${company.address.postalCode}<br /> ${company.address.street}<br />
				${company.phone}<br />
			</div>

		</div>
	</div>
</body>
</html>