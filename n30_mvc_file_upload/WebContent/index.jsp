<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Single File Upload Test...</h2>
	<p>
		<!--  이거를 한 이유는 나중에 알게됨...-->
		<a href="upload.do?command=fileUpload">파일 업로드 컨트롤러 GO GO!!</a>
	<p>

	<!-- 
	File Upload Form 작성시 주의사항 ::
	1)form 태그를 이용...a 태그는 안먹는다.
	2)전송방식의 속성..method="post" | 값을 넘기는 대상이 단순한 스트링이 아니라
	   파일을 넘기는 것이다...MultipartFile이 넘기는 대상 파일이다.
	3)form의 속성중 enctype="multipart/form-data"가 반드시 들어가야 한다.
	4)빈설정문서에 MultipartFile를 등록해야 한다.....
	5) 라이브러리 추가
	 -->
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="command" value="fileUpload"> 사용자명 :
		<input type="text" name="userName">
		<p>
			<input type="file" name="uploadFile">
		<p>
			<!--폼의 이름을 기억 -->
			<input type="submit" value="파일 업로드">
	</form>
</body>
</html>

<!-- 보통 여기까지 작성했으면... Controller를 작성한다. 하지만
    FileUplaod 프로그램에서는 Controller 작성 이전에 VO를 하나 먼저 작성
    ::
    model > UpdateDataVO
 -->