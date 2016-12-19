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
<h1>강의 리스트</h1>
<table border='1'>
	<tr>
		<th>강의코드</th>
		<th>강사코드</th>
		<th>강의명</th>
		<th>강의등급</th>
		<th>카테고리</th>
		<th>기간</th>
		<th>가격</th>
		<th>할인율</th>
		<th>강의 수</th>
	</tr>
	<c:forEach items="${list}" var="cl">
		<tr>
			<td>${cl.classCode}</td>
			<td>${cl.instructorCode}</td>
			<td><a href="/lecture/LecListAction.le">${cl.className}</a></td>
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