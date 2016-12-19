<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	window.addEventListener("load", function() {
			var btn=document.querySelector("#btn");
			var idCheck = document.querySelector("#idCheck");
			btn.addEventListener("click", function(){
				if(document.querySelector("#id").value==""){
					document.querySelector("#idHelper").innerHTML="ID�� �Է��ϼ���."
					document.querySelector("#id").focus();
				}else if(document.querySelector("#password").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML="��й�ȣ�� �Է��ϼ���."
					document.querySelector("#password").focus();
				}else if(document.querySelector("#password").value != document.querySelector("#pwCheck").value){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML="��й�ȣ�� �ٸ��ϴ�."
					document.querySelector("#password").innerHTML="";
					document.querySelector("#pwCheck").innerHTML="";
					document.querySelector("#pwCheck").focus();
				}else if(document.querySelector("#name").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML="�̸��� �Է��ϼ���."
					document.querySelector("#name").focus();
				}else if(document.querySelector("#birth").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML="��������� �Է��ϼ���."
					document.querySelector("#birth").focus();
				}else if(document.querySelector("#phone1").value=="" || document.querySelector("#phone2").value=="" || document.querySelector("#phone3").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML=""
					document.querySelector("#phoneHelper").innerHTML="�޴���ȭ ��ȣ�� �Է��ϼ���."
					document.querySelector("#phone1").focus();
				}else if(document.querySelector("#gender1") == "" && document.querySelector("#gender2") ==""){
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML=""
					document.querySelector("#phoneHelper").innerHTML=""
					document.querySelector("#addrHelper").innerHTML=""
					document.querySelector("#genderHelper").innerHTML="������ �Է��ϼ���."
		//			document.querySelector("#gender1").focus();
				}else if(document.querySelector("#addr").value==""){
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML=""
					document.querySelector("#phoneHelper").innerHTML=""
					document.querySelector("#genderHelper").innerHTML=""
					document.querySelector("#addrHelper").innerHTML="�ּҸ� �Է��ϼ���."
					document.querySelector("#addr").focus();
				}else{
					document.querySelector("#myform").submit();
				}
				
			})
	})
	
	
</script>
</head>
<body>
	<form id="myform" action='<c:url value="/member/InsertAction.me"/>'method="post">
		<table style="width:600px">
				<tr>
					<td>���̵�</td><td><input id="id" type="text" name="id" /><span id="idHelper"></span></td>
					<td><input id="idCheck" type="button" value="�ߺ�Ȯ��"/>
				</tr>
				<tr>
					<td>��й�ȣ</td><td><input id="password" type="password" name="password" /><span id="pwHelper"></span></td>
				</tr>
				<tr>
					<td>��й�ȣȮ��</td><td><input id="pwCheck" type="password" name="pwCheck" /><span id="pwcHelper"></span></td>
				</tr>
				<tr>
					<td>����</td><td><input id="name" type="text" name="name" /><span id="nameHelper"></span></td>
				</tr>
				<tr>
					<td>�������(ex 990101)</td><td><input id="birth" type="text" maxlength="6" name="birth" /><span id="birthHelper"></span></td>
				</tr>
				<tr>
					<td>�޴���ȭ</td><td><input id="phone1" type="text" name="phone1" maxlength="3" size="3"/>
										<input id="phone2" type="text" name="phone2" maxlength="4" size="4"/>
										<input id="phone3" type="text" name="phone3" maxlength="4" size="4"/><span id="phoneHelper"></span></td>
				</tr>
				<tr>
					<td>����</td><td><input id = "gender1" type="radio" name="gender" value="man"/>��
									<input id="gender2" type="radio" name="gender" value="woman"/>��</td><span id="genderHelper"></span>
				</tr>
				<tr>
					<td>�ּ�(��/��/��)</td><td><input id="addr" type="text" name="addr" maxlength="20"/><span id="addrHelper"></span></td>
				</tr>		
		</table>
		<table>
			<tr>
				<td><input type="button" id="btn" value="����"/></td>
				<td><input type="reset" value="�ʱ�ȭ"/></td>
			</tr>
		</table>
	</form>
</body>
</html>