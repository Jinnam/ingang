<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>���� ��� ��</h1>
������ : ${classes.className}
	<form action="<c:url value="/lecture/LectureInsertAction.le?classCode=${classes.classCode}"/>" method="post" enctype="multipart/form-data">
		���Ǹ� : <input type="text" name="lectureName"><br>
		�� : <input type="text" name="lectureDetail"><br>
		���� : <input type="file" name="lectureFile"><br>
		<input type="submit" value="���">
	</form>
</body>
</html>