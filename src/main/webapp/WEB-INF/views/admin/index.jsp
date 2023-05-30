<%@page import="javax.tools.DocumentationTool.Location"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:choose>
<c:when test="${dto.member.memberId eq null}">
	<c:redirect url="../auth/login" />
</c:when>
<c:otherwise>
	<html>
	<head>
		<title>Bigmoim Admin</title>
		<link href="/css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body bgcolor="#FFE7EB" topmargin="100">
	<%@ include file="top.jsp" %>
	<table width="75%" align="center" bgcolor="#FFFF99">
		<tr bordercolor="#FFFF99">
			<td height="190" align="center">대모임 관리자 화면입니다.</td>
		</tr>
		<td>관리자 이름:${dto.member.memberId}</td>
	</table>
	<%@ include file="bottom.jsp" %>
	</body>
	</html>
</c:otherwise>
</c:choose>