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
<h1>���� ����Ʈ</h1>
<table border='1'>
	<tr>
		<th>�����ڵ�</th>
		<th>�����ڵ�</th>
		<th>���Ǹ�</th>
		<th>���ǵ��</th>
		<th>ī�װ�</th>
		<th>�Ⱓ</th>
		<th>����</th>
		<th>������</th>
		<th>���� ��</th>
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