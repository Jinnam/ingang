<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action='<c:url value="/login/LoginAction.me"></c:url>' method="post">
		<table>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="loginId"/></td>
			</tr>
			<tr>
				<td>PASSWORD : </td>
				<td><input type="text" name="loginPw"/></td>
			</tr>
		</table>
		<input type="submit" name="로그인" value="로그인"/>
	</form>
</body>
</html>