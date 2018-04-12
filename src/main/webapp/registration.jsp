<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="RegistrationServlet">
    Please enter your login
    <br>
    <input type="text" name="login"/>
    <br>
    <span style="font-size: large; color: red; "><c:out value="${requestScope.errMessageMap['login']}"> </c:out></span>
    <br>
    Please enter your password
    <br>
    <input type="text" name="password"/>
    <br>
    <span style="font-size: large; color: red; "><c:out value="${requestScope.errMessageMap['password']}"> </c:out></span>
    <br>
    Please enter your passport
    <br>
    <input type="text" name="passport"/>
    <br>
    <span style="font-size: large; color: red; "><c:out value="${requestScope.errMessageMap['passport']}"> </c:out></span>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
