<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>

<script>
	

</script>

</head>
<body>
<h1>���ο� ���� �߰� ��</h1>
	
	<form action="<c:url value="/lecture/LectureInsertAction.le"/>" method="post">
		<table >
			<tr>
				<td align="right">������ : </td>
				<td><input type="text" name="className" value=""/></td>
			</tr>
			<tr>
				<td align="right">�������� : </td>
				<td><input type="text" name="classLevel" /></td>
			</tr>
			<tr>
				<td align="right">ī�װ� : </td>
				<td><input type="text" name="classCategory" value="�ܰ�" readonly="readonly"/></td>
			</tr>
			<tr>
				<td align="right">�����Ⱓ(30�ϴ���) : </td>
				<td><input type="text" name="classPeoriod" /></td>
			</tr>
			<tr>
				<td align="right">���� : </td>
				<td><input type="text" name="classPrice" /></td>
			</tr>
			<tr>
				<td align="right">������ : </td>
				<td><input type="text" name="discount" /></td>
			</tr>
			<tr>
				<td align="right">�� : </td>
				<td><input type="text" name="classDetail" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="���" />
				</td>
			</tr>		
		</table>
	
	</form>
</body>
</html>