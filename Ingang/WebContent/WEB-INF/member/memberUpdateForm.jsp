<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<form id="myform" action='<c:url value="/member/memberUpdateAction.me?memberId=${member.memberId }"/>'method="post">
		<table style="width:600px">
				<tr>
					<td>���̵�</td><td><input id="id" type="text" name="id" value="${member.memberId }" readonly="readonly"/><span id="idHelper"></span></td>
				</tr>
				<tr>
					<td>��й�ȣ</td><td><input id="password" type="password" name="password" /><span id="pwHelper"></span></td>
				</tr>
				<tr>
					<td>��й�ȣȮ��</td><td><input id="pwCheck" type="password" name="pwCheck" /><span id="pwcHelper"></span></td>
				</tr>
				<tr>
					<td>����</td><td><input id="name" type="text" name="name" value="${member.memberName }"/><span id="nameHelper"></span></td>
				</tr>
				<tr>
					<td>�������(ex 990101)</td><td><input id="birth" type="text" maxlength="6" name="birth" value="${member.memberBirth }"/><span id="birthHelper"></span></td>
				</tr>
				<tr>
					<td>�޴���ȭ</td><td><input id="phone1" type="text" name="phone1" maxlength="3" size="3" value="${phone1}"/>-
										<input id="phone2" type="text" name="phone2" maxlength="4" size="4" value="${phone2}"/>-
										<input id="phone3" type="text" name="phone3" maxlength="4" size="4" value="${phone3}"/><span id="phoneHelper"></span></td>
				</tr>
				<tr>
					<td>����</td><td><input id = "gender1" type="radio" name="gender" <c:if test="${member.memberGender=='��'}">checked="checked"</c:if> value="man"/>��
									<input id="gender2" type="radio" name="gender" <c:if test="${member.memberGender=='��'}">checked="checked"</c:if> value="woman"/>��</td><span id="genderHelper"></span>
				</tr>
				<tr>
					<td>�ּ�(��/��/��)</td><td><input id="addr" type="text" name="addr" maxlength="20" value="${member.memberAddr }"/><span id="addrHelper"></span></td>
				</tr>		
		</table>
		<table>
			<tr>
				<td><input type="submit" id="btn" value="����"/></td>
			</tr>
		</table>
	</form>
		<input type="btn" id="drop" value="Ż��"/></td>
</body>
</html>