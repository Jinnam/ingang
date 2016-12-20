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
	<form id="myform" action='<c:url value="/member/InsertAction.me"/>'method="post">
		<table style="width:600px">
				<tr>
					<td>아이디</td><td><input id="id" type="text" name="id" value="${member.memberId }" readonly="readonly"/><span id="idHelper"></span></td>
				</tr>
				<tr>
					<td>비밀번호</td><td><input id="password" type="password" name="password" /><span id="pwHelper"></span></td>
				</tr>
				<tr>
					<td>비밀번호확인</td><td><input id="pwCheck" type="password" name="pwCheck" /><span id="pwcHelper"></span></td>
				</tr>
				<tr>
					<td>성명</td><td><input id="name" type="text" name="name" value="${member.memberName }"/><span id="nameHelper"></span></td>
				</tr>
				<tr>
					<td>생년월일(ex 990101)</td><td><input id="birth" type="text" maxlength="6" name="birth" value="${member.memberBirth }"/><span id="birthHelper"></span></td>
				</tr>
				<tr>
					<td>휴대전화</td><td><input id="phone1" type="text" name="phone1" maxlength="3" size="3"/>-
										<input id="phone2" type="text" name="phone2" maxlength="4" size="4"/>-
										<input id="phone3" type="text" name="phone3" maxlength="4" size="4"/><span id="phoneHelper"></span></td>
				</tr>
				<tr>
					<td>성별</td><td><input id = "gender1" type="radio" name="gender" value="man"/>남
									<input id="gender2" type="radio" name="gender" value="woman"/>여</td><span id="genderHelper"></span>
				</tr>
				<tr>
					<td>주소(시/군/구)</td><td><input id="addr" type="text" name="addr" maxlength="20" value="${member.memberAddr }"/><span id="addrHelper"></span></td>
				</tr>		
		</table>
		<table>
			<tr>
				<td><input type="button" id="btn" value="가입"/></td>
				<td><input type="reset" value="초기화"/></td>
			</tr>
		</table>
	</form>

</body>
</html>