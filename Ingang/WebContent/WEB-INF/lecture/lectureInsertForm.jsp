<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>���� ��� ��</h1>
������ : ${classes.className}
	<form action="<c:url value="/lecture/LectureInsertAction.le?classCode=${classes.classCode}"/>" method="post">
		���Ǹ� : <input type="text" name="lectureName"><br>
		�� : <input type="text" name="lectureDetail"><br>
		���� : <input type="file" name="lectureFile"><br>
		<input type="submit" value="���">
	</form>
</body>
</html>