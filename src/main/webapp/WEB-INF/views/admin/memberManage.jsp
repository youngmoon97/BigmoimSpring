<%@page import="java.util.Vector" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <title>Bigmoim Admin</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFE7EB" topmargin="100">
<%@ include file="top.jsp" %>
<table width="75%" align="center" bgcolor="#FFFF99">
    <tr>
        <td align="center" bgcolor="#FFFFCC">

            <table width="95%" align="center" bgcolor="#FFFF99" border="1">
                <tr align="center" bgcolor="#996600">
                    <td><font color="#FFFFFF">회원아이디</font></td>
                    <td><font color="#FFFFFF">회원이름</font></td>
                    <td><font color="#FFFFFF">회원전화번호</font></td>
                    <td><font color="#FFFFFF">회원자기소개</font></td>
                    <td><font color="#FFFFFF">회원추방</font></td>
                </tr>

                <c:forEach items="${adminDto.memberList}" var="member">
                    <tr align="center">
                        <td>${member.memberId}</td>
                        <td>${member.memberName}</td>
                        <td>${member.memberTel}</td>
                        <td>${member.memberProfile}</td>
                        <td><button onclick="roleDeleteAll('${member.memberId}')"
                               style="color: blue;">추방</button></td>
                    </tr>   <tr></tr><tr></tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
<%@ include file="bottom.jsp" %>
<form name="delete" method="post" action="memberDeleteProc.jsp">
    <input type="hidden" name="memberId">
</form>
<script>

    const roleDeleteAll = (memberId) => {
        fetch("/api/v1/admin/deleteAllRole/" + memberId, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json;charset=utf-8",
            },
        })
            .then((res) => res.json())
            .then((result) => {
                deleteMember(memberId);
            })
            .catch((error) => {
                alert("어드민:회원 모든 권한 삭제 에러가 발생했습니다.");
            });
    };

    const deleteMember = (memberId) => {
        fetch("/api/v1/admin/deleteMember/" + memberId, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json;charset=utf-8",
            },
        })
            .then((res) => res.json())
            .then((result) => {
                init();
            })
            .catch((error) => {
                alert("어드민:회원 추방 에러가 발생했습니다.");
            });
    };

    const init = () =>{
        location.href = "memberManage";
    }
</script>
</body>
</html>
