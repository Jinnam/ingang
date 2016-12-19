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
					document.querySelector("#idHelper").innerHTML="ID를 입력하세요."
					document.querySelector("#id").focus();
				}else if(document.querySelector("#password").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML="비밀번호를 입력하세요."
					document.querySelector("#password").focus();
				}else if(document.querySelector("#password").value != document.querySelector("#pwCheck").value){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML="비밀번호가 다릅니다."
					document.querySelector("#password").innerHTML="";
					document.querySelector("#pwCheck").innerHTML="";
					document.querySelector("#pwCheck").focus();
				}else if(document.querySelector("#name").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML="이름을 입력하세요."
					document.querySelector("#name").focus();
				}else if(document.querySelector("#birth").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML="생년월일을 입력하세요."
					document.querySelector("#birth").focus();
				}else if(document.querySelector("#phone1").value=="" || document.querySelector("#phone2").value=="" || document.querySelector("#phone3").value==""){
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML=""
					document.querySelector("#phoneHelper").innerHTML="휴대전화 번호를 입력하세요."
					document.querySelector("#phone1").focus();
				}else if(document.querySelector("#gender1") == "" && document.querySelector("#gender2") ==""){
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML=""
					document.querySelector("#phoneHelper").innerHTML=""
					document.querySelector("#addrHelper").innerHTML=""
					document.querySelector("#genderHelper").innerHTML="성별을 입력하세요."
		//			document.querySelector("#gender1").focus();
				}else if(document.querySelector("#addr").value==""){
					document.querySelector("#pwHelper").innerHTML=""
					document.querySelector("#idHelper").innerHTML=""
					document.querySelector("#pwcHelper").innerHTML=""
					document.querySelector("#nameHelper").innerHTML=""
					document.querySelector("#birthHelper").innerHTML=""
					document.querySelector("#phoneHelper").innerHTML=""
					document.querySelector("#genderHelper").innerHTML=""
					document.querySelector("#addrHelper").innerHTML="주소를 입력하세요."
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
					<td>아이디</td><td><input id="id" type="text" name="id" /><span id="idHelper"></span></td>
					<td><input id="idCheck" type="button" value="중복확인"/>
				</tr>
				<tr>
					<td>비밀번호</td><td><input id="password" type="password" name="password" /><span id="pwHelper"></span></td>
				</tr>
				<tr>
					<td>비밀번호확인</td><td><input id="pwCheck" type="password" name="pwCheck" /><span id="pwcHelper"></span></td>
				</tr>
				<tr>
					<td>성명</td><td><input id="name" type="text" name="name" /><span id="nameHelper"></span></td>
				</tr>
				<tr>
					<td>생년월일(ex 990101)</td><td><input id="birth" type="text" maxlength="6" name="birth" /><span id="birthHelper"></span></td>
				</tr>
				<tr>
					<td>휴대전화</td><td><input id="phone1" type="text" name="phone1" maxlength="3" size="3"/>
										<input id="phone2" type="text" name="phone2" maxlength="4" size="4"/>
										<input id="phone3" type="text" name="phone3" maxlength="4" size="4"/><span id="phoneHelper"></span></td>
				</tr>
				<tr>
					<td>성별</td><td><input id = "gender1" type="radio" name="gender" value="man"/>남
									<input id="gender2" type="radio" name="gender" value="woman"/>여</td><span id="genderHelper"></span>
				</tr>
				<tr>
					<td>주소(시/군/구)</td><td><input id="addr" type="text" name="addr" maxlength="20"/><span id="addrHelper"></span></td>
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