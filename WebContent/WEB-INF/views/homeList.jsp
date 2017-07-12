<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="userId" value="${sessionScope.userId}" />

<div class="table_wrapper">
<h2>Lista wyników:</h2>
<hr>
	<table>
		<tr>
		<thead>
			<th>FIRMA</th>
			<th>USŁUGA</th>
		</thead>
		</tr>
		<tbody>
		<c:forEach items="${companies}" var="company">
			<tr>
				<td>${company.name}</td>
				<td>${company.serviceType}</td>
				<td><a
					href="<%=request.getContextPath()%>/appointments/makeAppointment?companyId=<c:out value="${company.id}"/>&userId=${userId}"
					class="btn btn-default" role="button">Umów</a>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
