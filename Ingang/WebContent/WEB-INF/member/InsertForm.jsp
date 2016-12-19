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
	<form action='<c:url value="member/InsertAction.me"/>' method="post">
		<table>
				<tr>
					<td>아이디</td><td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>비밀번호</td><td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>비밀번호확인</td><td><input type="password" name="pwCheck" /></td>
				</tr>
				<tr>
					<td>성명</td><td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>생년월일(ex 990101)</td><td><input type="text" maxlength="6" name="id" /></td>
				</tr>
				<tr>
					<td>휴대전화</td><td><input type="text" name="phoneFirst" maxlength="3" size="3"/>
										<input type="text" name="phoneSecond" maxlength="4" size="4"/>
										<input type="text" name="phoneThird" maxlength="4"/ size="4"></td>
				</tr>
				<tr>
					<td>성별</td><td><input type="radio" name="gender" value="1"/>남
									<input type="radio" name="gender" value="2"/>여</td>
				</tr>
				<tr>
					<td>주소(시/군/구)</td><td><input type="text" maxlength="20"/></td>
				</tr>		
		</table>
	</form>
</body>
</html>