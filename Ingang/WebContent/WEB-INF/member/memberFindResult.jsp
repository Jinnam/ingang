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
	아이디는 ${findIdResult } 입니다.<br/>
	
	
	<a href='<c:url value="/login/Login.me"></c:url>'>로그인 화면으로 이동</a><br/>
	<a href='<c:url value=""></c:url>'>비밀번호찾기</a>
</body>
</html>