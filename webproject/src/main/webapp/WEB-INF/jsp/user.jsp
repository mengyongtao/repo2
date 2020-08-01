<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user</title>
</head>
<body>
	<table width="200">
		<tr><td>用户名</td><td>密码</td></tr>
	
	<c:forEach items="${userList}" var="user">
		<tr><td>${user.userName}</td><td>${user.userPwd}</td></tr>
	</c:forEach>
	</table>
</body>
</html>