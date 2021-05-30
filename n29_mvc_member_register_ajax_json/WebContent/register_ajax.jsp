<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 
Ajax 기술을 적용할 수 있는 가장 대표적인 부분 :: 아이디 중복 확인
onclick 속성 대신에.. onkeyup 속성을 사용
조건 ::
id에 5자 이상의 값이 들어오도록..
5자 미만이 들어오면 id옆에 "아이디는 5자 이상이여야 합니다.."가 뜨도록

5자 이상일때는 ajaxIdCheck()로 연결.. 자바스크립트로 연결됨.
사용 가능한 아이디라면 , id 옆에 "사용 가능 아이디!"
사용 가능한 아이디가 아니라면 , id 옆에 "사용 불가능 아이디!"

만약에 사용 불가능 상태에서 전송버튼을 누르면 전송 안되도록 처리하고..

-->
<body>
<h2 align="center">Register Form....</h2><p>
<form name="regForm" action="member.do" method="post">
<input type="hidden" name="command" value="register">

ID <input type="text" name="id" onkeyup="idCheck()" id="id">
<span id = "idCheckView"></span><p>

PASS <input type="password" name="password"><br><br>
NAME <input type="text" name="name"><br><br>
ADDRESS <input type="text" name="address"><br><br>
<input type="button" value="회원가입" onclick="checkReg()">  
</form>
<script type="text/javascript">

	function checkReg() {
		var f = document.regForm;
		if(f.id.value==""){
			alert("아이디를 입력하세여");
			return;
		}else if(f.password.value==""){
			alert("패스워드를 입력하세여");
			return;
		}else if(f.name.value==""){
			alert("이름을 입력하세여");
			return;
		}else if(f.address.value==""){
			alert("주소를 입력하세여");
			return;
		}else if (checkResult==false){
			alert("아이디 중복체크를 하세여");
			id.value="";
			id.focus();
			return;
		}
		//자바스크립트에서 바로 폼으로 입력된 값을 url로 전송하는 기능..
		f.submit();
	}
	
	//member.do?command=ajaxIdcheck
	var xhr;
	var id, idCheckView;
	var checkResult = false;
	
	function idCheck() {
		//중복확인 버튼 눌렀을때 자동호출되는 함수
		xhr = new XMLHttpRequest();
	
		id = document.getElementById("id");
		idCheckView = document.getElementById("idCheckView")
		if(id.value.length<5) {
			idCheckView.innerHTML = "<font color=red>아이디는 5자 이상!</font>";
			return;
		}
		
		xhr.onreadystatechange = callback;
		var url = "member.do?command=ajaxIdCheck&&id="+id.value;
		xhr.open("POST", url, true);
		xhr.send(null);
	}
	
	var callback = function () {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				var jsonData = JSON.parse(responseText);
				if(jsonData.flag){ //id사용할수 없다.
					idCheckView.innerHTML =
						"<font color = red>사용불가 아이디!</font>"
				}else{//id사용할 수 있다.
					idCheckView.innerHTML =
						"<font color = blue>사용가능 아이디!</font>"
					checkResult = true;
				}
			}
		}
	}
</script>
</body>
</html>