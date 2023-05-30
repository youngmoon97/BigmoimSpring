<%@page import="java.util.Vector" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <title>Bigmoim Admin</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <script
            type="text/javascript"
            src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"
    ></script>
</head>
<body bgcolor="#FFE7EB" topmargin="100">
<%@ include file="top.jsp" %>
<table width="75%" align="center" bgcolor="#FFFF99">
    <tr>
        <td align="center" bgcolor="#FFFFCC">
            <table width="95%" align="center" bgcolor="#FFFF99" border="1">
                <tr align="center" bgcolor="#996600">
                    <td><font color="#FFFFFF">모임번호</font></td>
                    <td><font color="#FFFFFF">모임이름</font></td>
                    <td><font color="#FFFFFF">회장아이디</font></td>
                    <td><font color="#FFFFFF">개설일자</font></td>
                    <td><font color="#FFFFFF">모임삭제</font></td>
                </tr>
                <c:if test="${empty adminDto.moimList}">
                    <tr>
                        <td align="center" colspan="5">등록된 모임이 없습니다.</td>
                    </tr>
                </c:if>

                <c:forEach items="${adminDto.moimList}" var="moim">
                    <tr align="center">
                        <td>${moim.moimNum}</td>
                        <td>${moim.moimName}</td>
                        <td>${moim.memberId}</td>
                        <td>${moim.moimDate}</td>
                        <td><button style="color: blue;" onclick="deleteMoim(${moim.moimNum})">삭제</button></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
<%@ include file="bottom.jsp" %>
<form name="detail" method="post" action="productDetail.jsp">
    <input type="hidden" name="moimNum">
</form>
<script>
    // const deleteMoim = (moimNum) => {
    //     console.log("안녕하세요 딜리트모임");
    //
    //     $.ajax({
    //         url: "/api/v1/admin/deleteMoim/" + moimNum,
    //         type: "DELETE"
    //     })
    //         .done((result) => {
    //             init();
    //         })
    //         .fail((error) => {
    //             alert("어드민:모임 삭제 에러가 발생했습니다.");
    //         });
    // }

    const deleteMoim = (moimNum) => {
        fetch("/api/v1/admin/deleteMoim/" + moimNum, {
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
                alert("어드민:모임 삭제 에러가 발생했습니다.");
            });
    };

    const init = () =>{
        location.href = "moimManage";
    }
</script>
</body>
</html>