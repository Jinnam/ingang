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
	<form>
		<table border="1" width="70%">
			<thead>
				<tr>
					<td>ID</td><td>PW</td><td>NAME</td><td>BIRTH</td>
					<td>PHONE</td><td>GENDER</td><td>ADDR</td>
					<td>REGISTRED DAY</td><td>LEVEL</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${ member}">
					<tr>
						<td>${l.memberId}</td>
						<td>${l.memberPw }</td>
						<td>${l.memberName }</td>
						<td>${l.memberBirth }</td>
						<td>${l.memberPhone}</td>
						<td>${l.memberGender}</td>
						<td>${l.memberAddr}</td>
						<td>${l.memberRd}</td>
						<td>${l.memberLevel}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>