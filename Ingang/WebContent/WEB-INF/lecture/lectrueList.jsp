<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<h1>���� ����Ʈ</h1>

	<h3>������ : ${classes.className}</h3><h5> ���� : ${classes.instructor.instructorName}</h5>

<button onclick="location.href='<c:url value='/lecture/LectureInsertFormAction.le?classCode=${classes.classCode}'/>'">���ǵ��</button>
${dir}
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