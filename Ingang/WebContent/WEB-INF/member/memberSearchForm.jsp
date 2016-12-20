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
	<form action='<c:url value="/member/SearchAction.me"></c:url>' method="post">
		<table>
			<tr>
				<td>ID</td><td><input type="text" name="searchId"/></td>
			</tr>
			<tr>
				<td>NAME</td><td><input type="text" name="searchName"/></td>
			</tr>
			<tr>
				<td>BIRTH</td><td><input type="date" name="birthStart">~<input type="date" name="birthEnd"/></td>
			</tr>
			<tr>
				<td>PHONE</td><td><input type="text" maxlength="3" size="3" name="phone1"/>-<input type="text" size="4" maxlength="4" name="phone2"/>-<input type="text" size="4" maxlength="4" name="phone3"/></td>
			</tr>
			<tr>
				<td>GENDER</td><td><input type="checkbox" name="gender1"/>남<input type="checkbox" name="gender2"/>여</td>
			</tr>
			<tr>
				<td>ADDR</td><td><input type="text" name="searchAddr"/></td>
			</tr>
			<tr>
				<td>REGISTERED DAY</td><td><input type="date" name="rdStart">~<input type="date" name="rdEnd"/></td>
			</tr>
			<tr>
				<td>LEVEL</td><td><select name="levelSelect">
										<option value="all">모두</option>
										<option value="admin">admin</option>
										<option value="manager">manager</option>
										<option value="member">member</option>
									</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="검색"/></td><td><input type="reset" value="초기화"/></td>
			</tr>
		</table>
	</form>
</body>
</html>