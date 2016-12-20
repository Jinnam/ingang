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

	<c:if test="${mLogin == null }">
		<a href='<c:url value="/login/Login.me"></c:url>'>�α���</a>&nbsp;&nbsp;
		<a href="">���̵�/��й�ȣ ã��</a>&nbsp;&nbsp;
		<a href='<c:url value="/member/InsertForm.me"></c:url>'>ȸ������</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${mLogin != null }">
		${mLogin.memberName }�� �α����ϼ̽��ϴ�.
		<a href='<c:url value="/login/logoutAction.me"></c:url>'>�α׾ƿ�</a>&nbsp;&nbsp;
		<a href='<c:url value="/member/UpdateForm.me?memberId=${mLogin.memberId }"></c:url>'>ȸ�� ����</a>&nbsp;&nbsp;
		
		<c:if test="${mLogin.memberLevel == 'manager' }">
			<a href='<c:url value="/member/SearchAction.me"></c:url>'>ȸ�����</a>&nbsp;&nbsp;
		</c:if>
		
		<c:if test="${mLogin.memberLevel == 'admin' }">
			<a href='<c:url value="/member/SearchAction.me"></c:url>'>ȸ�����/����</a>&nbsp;&nbsp;
		</c:if>
			<a href="">����������</a>
	</c:if>


</body>
</html>