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
	<form action='<c:url value="/member/FindIdAction.me"></c:url>' method="post">
		<table>
			<tr>
				<td>이름</td><td><input type="text" name="findName"/></td>
			</tr>
			<tr>
				<td>전화전호</td><td><input type="text" name="findPhone"/></td>
			</tr>
		</table>
		<input type="submit" value="아이디찾기"/>
	</form>
	<a href='<c:url value=""></c:url>'>비밀번호찾기</a>
</body>
</html>