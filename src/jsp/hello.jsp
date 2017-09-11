<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div>
<c:if test="${not empty sessionScope.login}">
	<b>Hello, ${param.pageNumber} ${sessionScope.login}</b>
</c:if>
</div>
