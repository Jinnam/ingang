<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>강의 등록 폼</h1>
과정명 : ${classes.className}
	<form action="<c:url value="/lecture/LectureInsertAction.le?classCode=${classes.classCode}"/>" method="post" enctype="multipart/form-data">
		강의명 : <input type="text" name="lectureName"><br>
		상세 : <input type="text" name="lectureDetail"><br>
		파일 : <input type="file" name="lectureFile"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>