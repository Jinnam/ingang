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
<h1>과정 리스트</h1>
<c:if test="${classes.className ne null}">
	<h3>패키지 : ${classes.className}</h3>
</c:if>
<table border='1'>
	<tr>
		<th>과정코드</th>
		<th>강사이름</th>
		<th>과정명</th>
		<th>과정등급</th>
		<th>카테고리</th>
		<th>기간</th>
		<th>가격</th>
		<th>할인율</th>
		<th>강의 수</th>
	</tr>
	<c:forEach items="${list}" var="cl">
		<tr>
			<td>${cl.classCode}</td>
			<td>${cl.instructor.instructorName}</td>
			
			<td><a href="<c:url value="/lecture/LecListAction.le"/>?classCode=${cl.classCode}">${cl.className}</a></td>
			<td>${cl.classLevel}</td>
			<td>${cl.classCategory}</td>
			<td>${cl.classPeoriod}</td>
			<td>${cl.classPrice}</td>
			<td>${cl.discount}</td>
			<td>${cl.classNumber}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>