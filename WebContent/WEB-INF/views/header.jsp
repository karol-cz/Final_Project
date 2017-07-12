<%@ page session="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="header_wrapper">

		<c:set var="userName" value="${sessionScope.userName}" />
		<c:choose>
			<c:when test="${userName==null}">
			${userName}
				<a href="<%=request.getContextPath()%>/home" class="btn btn-default"
					role="button">HOME</a>

				<a href="<%=request.getContextPath()%>/utils/loginChoose"
					class="btn btn-default" role="button">LOG IN</a>
				<br/>

			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/home" class="btn btn-default"
					role="button">HOME</a>

				<a href="<%=request.getContextPath()%>/users/details" class="btn btn-default"
					role="button">Profil</a>
					<a href="<%=request.getContextPath()%>/appointments/showAppointments" class="btn btn-default"
					role="button">Moje zlecena</a>
				<a href="<%=request.getContextPath()%>/users/logout"
					class="btn btn-default" role="button">LOGOUT</a>
    		Zalogowany: <b>${userName}</b>

				<br />
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>