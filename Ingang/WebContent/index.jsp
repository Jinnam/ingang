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
<c:import url="/top.jsp"></c:import>
<%
	//ȸ������
	//response.sendRedirect(request.getContextPath()+"/member/InsertForm.me");
	//�˻�&����Ʈ
	//response.sendRedirect(request.getContextPath()+"/member/SearchForm.me");
	//ȸ������ ����
	//response.sendRedirect(request.getContextPath()+"/member/UpdateForm.me");
 %>
 <br>
<a href="<c:url value='/lecture/ClassListAction.le'/>">6.������û</a>
<a href="">7.����Ұ�</a>
<a href="">8.�����ǽ�</a>
<a href="<c:url value='/lecture/ClassInsertFormAction.le'/>">9.�����߰�</a>
</body>
</html>