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
<c:import url="/top.jsp"></c:import>
<%
	//회원가입
	//response.sendRedirect(request.getContextPath()+"/member/InsertForm.me");
	//검색&리스트
	//response.sendRedirect(request.getContextPath()+"/member/SearchForm.me");
	//회원정보 수정
	//response.sendRedirect(request.getContextPath()+"/member/UpdateForm.me");
 %>
 <br>
<a href="<c:url value='/lecture/ClassListAction.le'/>">6.수강신청</a>
<a href="">7.강사소개</a>
<a href="">8.내강의실</a>
<a href="<c:url value='/lecture/ClassInsertFormAction.le'/>">9.강의추가</a>
</body>
</html>