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
<h1>새로운 강의 추가 폼</h1>
	
	<form action="<c:url value="/lecture/LectureInsertAction.le"/>" method="post">
		<table >
			<tr>
				<td align="right">과정명 : </td>
				<td><input type="text" name="className" value=""/></td>
			</tr>
			<tr>
				<td align="right">과정레벨 : </td>
				<td><input type="text" name="classLevel" /></td>
			</tr>
			<tr>
				<td align="right">카테고리 : </td>
				<td><input type="text" name="classCategory" value="단과" readonly="readonly"/></td>
			</tr>
			<tr>
				<td align="right">수강기간(30일단위) : </td>
				<td><input type="text" name="classPeoriod" /></td>
			</tr>
			<tr>
				<td align="right">가격 : </td>
				<td><input type="text" name="classPrice" /></td>
			</tr>
			<tr>
				<td align="right">할인율 : </td>
				<td><input type="text" name="discount" /></td>
			</tr>
			<tr>
				<td align="right">상세 : </td>
				<td><input type="text" name="classDetail" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록" />
				</td>
			</tr>		
		</table>
	
	</form>
</body>
</html>