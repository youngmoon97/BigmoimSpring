<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="../layout/top.jsp" charEncoding="UTF-8">
    <%--    <c:param name="member" value="$.member}"></c:param>--%>
    <%--    <c:param name="roleList" value="$.roleList}"></c:param>--%>
</c:import>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>대모임에 오신걸 환영합니다!</title>
    <link type="text/css" rel="stylesheet" href="/css/moimschedule.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Barlow:wght@600&family=Heebo:wght@500&display=swap");

        footer ul {
            padding-left: 9cm;
        }

        footer p {
            padding-right: 10cm;
        }

    </style>
</head>
<body style="min-height: 100vh; display: flex; flex-direction: column; padding-top: 150px;">
<!-- 카테고리 -->
<c:import url="../layout/category.jsp" charEncoding="UTF-8"/>

<!-- 모임일정 리스트 -->
<div class="container" style="width: 1300px; margin: 0 auto;">
    <c:choose>
        <c:when test="${dto.allMoimScheduleList.size() eq 0}">
            <article>
                <div class="text">
                    <p class="join-text"> 모임 일정이 없습니다. </p>
                </div>
            </article>
        </c:when>
        <c:otherwise>
            <article>
                <div class="text">
                    <p class="join-text"> 모임 일정입니다. </p>
                </div>
            </article>
            <c:forEach items="${dto.allMoimScheduleList}" var="allMs">
                <a href="moimdetail.jsp/${allMs.moimList.get(0).moimNum}">
                    <div class="cards">
                        <div class="wrapper">
                            <div class="moim-image">
                                <img src="${allMs.moimList.get(0).moimImg}" alt="모임 이미지"/>
                            </div>
                            <div class="info">
                                <div class="info-inner">
                                    <div class="title">
                                        <h1 class="msTitle">
                                            <strong>${allMs.msTitle}</strong>
                                        </h1>
                                    </div>
                                    <div class="content" style="line-height: 1.2;">
                                        <p class="msArea">${allMs.msArea}</p>
                                        <p class="msDate">${allMs.msDate}</p>
                                        <p class="msContent">${allMs.msContent}</p>
                                    </div>
                                    <div class="members">
                                        <div class="member-list">
                                            <c:choose>
                                                <c:when test="${allMs.memberList.size() eq 0}">
                                                    <h4>참여 멤버가 없습니다.</h4>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${allMs.memberList}" var="scheduleMember">
                                                        <img src="${scheduleMember.memberImg}" alt="멤버 이미지1"/>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                            <span class="member-count">${allMs.memberList.size()}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>

        </c:otherwise>
    </c:choose>

</div>
<!-- 하단 -->
<c:import url="../layout/bottom.jsp" charEncoding="UTF-8"/>
</body>
</html>