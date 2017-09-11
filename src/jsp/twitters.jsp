<%@ page language="java" contentType="text/html;" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>

<body>

<p> <b>${message} </b></p>

<jsp:include page="hello.jsp">
	<jsp:param value="2" name="pageNumber"/>
</jsp:include>
<h1>Twitter List : </h1>




<c:forEach items="${twitters}" var="twitt">

<p>${twitt.message}</p>
<p>Created by ${twitt.userName}  on ${twitt.dateOfCreation}</p>

<c:if test="${twitt.favouriteTweet == false}">
	<p>Favourite ${twitt.favouriteTweet} 
	<form method="post" action="/com.firstjsp/favourite_tweets">
		<input type="hidden" name="twitt_id" value="${twitt.id}"/>
		<input type="submit" value="Add to favourites" >
	</form>
	</p>
</c:if>
</c:forEach>



</body>


</html>