<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="form-group">
	<label class="control-label col-sm-1">Godzina:</label>
	<div class="col-sm-3">

		<c:forEach items="${slots}" var="slot">

			<input type="radio" name="time" id="time" value="${slot.time}"
				<c:if test="${slot.taken}">disabled</c:if>>${slot.time}<br>

		</c:forEach>
	</div>
</div>



