<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>강의 리스트</h1>

	<h3>과정명 : ${classes.className}</h3><h5> 강사 : ${classes.instructor.instructorName}</h5>
<button onclick="location.href='www.naver.com'">강의등록</button>
<table border='1'>
	<tr>
		<th>강의코드</th>
		<th>과정코드</th>
		<th>강의명</th>
		<th>상세</th>
		<th>강의</th>
		<th>등록일자</th>
	</tr>
	<c:forEach items="${list}" var="lec">
		<tr>
			<td>${lec.lectureCode}</td>
			<td>${lec.classes.className}</td>
			<td>${lec.lectureName}</td>
			<td>${lec.lectureDetail}</td>
			<td>${lec.lectureFile}</td>
			<td>${lec.lectureRd}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>