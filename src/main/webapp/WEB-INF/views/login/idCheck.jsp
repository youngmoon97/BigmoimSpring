<%@ page import="com.bigmoim.module.member.controller.AuthController" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
	<title>대모임 ID 중복체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor=#FFE7EB>
<div align="center">
<br/><strong id="memberId">
	아이디들어가는칸</strong><br>
	<button onclick="checkId(memberId)">확인ㄱ</button><br>
<a href="#" onclick="self.close()">닫기</a>
</div>
<script>
	let memberId = opener.document.getElementById("memberId").value;
	document.getElementById("memberId").innerHTML=memberId;
	document.getElementById("memberId").value=memberId;

	const checkId = (memberId) => {
		console.log("idCheck.jsp : checkId 호출")
		fetch("/api/v1/auth/signup/checkId/" + memberId, {
			method: "POST",
			headers: {
				"Content-Type": "application/json;charset=utf-8",
			},
			body: JSON.stringify(memberId),
		})
				.then((res) => res.json())
				.then((result) => {
					if(result==1){
						document.getElementById("memberId").innerHTML=memberId + "는 이미 존재하는 아이디입니다.";
					}else if(result==0){
						document.getElementById("memberId").innerHTML=memberId + "는 사용 가능한 아이디입니다.";
					}
				})
				.catch((error) => {
					alert("아이디 중복확인 에러가 발생했습니다.");
				});
	};
</script>
</body>
</html>