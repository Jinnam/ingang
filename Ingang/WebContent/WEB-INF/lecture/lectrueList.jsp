<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>강의 리스트</h1>

	<h3>과정명 : ${classes.className}</h3><h5> 강사 : ${classes.instructor.instructorName}</h5>

<button onclick="location.href='<c:url value='/lecture/LectureInsertFormAction.le?classCode=${classes.classCode}'/>'">강의등록</button>
${dir}
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
			<td>
				<video width="320" height="240" controls>
						<source src="${dir}\bm.mp4" type="video/mp4">
					</video>
				</td>
			<td>${lec.lectureRd}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>