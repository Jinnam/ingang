<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>���� ����Ʈ</h1>

	<h3>������ : ${classes.className}</h3><h5> ���� : ${classes.instructor.instructorName}</h5>
<button onclick="location.href='www.naver.com'">���ǵ��</button>
<table border='1'>
	<tr>
		<th>�����ڵ�</th>
		<th>�����ڵ�</th>
		<th>���Ǹ�</th>
		<th>��</th>
		<th>����</th>
		<th>�������</th>
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