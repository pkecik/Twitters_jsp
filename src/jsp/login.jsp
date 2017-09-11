<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>Login page</title>
</head>
<body>
Login page



<jsp:include page="hello.jsp"></jsp:include>

<form method="post" action="/com.firstjsp/login">
    <p>Login</p>
    <input type="text" name="login">
    <p>Password</p>
    <input type="text" name="password">

    <input type="submit" value="Login">

	<input type="hidden" name="backUrl" value="${param.backUrl}"/>

	<!-- <input class="btn btn-defuault" type="submit"> -->

</form>
</body>
</html>