<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="../layout/top.jsp" charEncoding="UTF-8">
    <%--    <c:param name="member" value="${mainDto.member}"></c:param>--%>
    <%--    <c:param name="roleList" value="${mainDto.roleList}"></c:param>--%>
</c:import>
<!DOCTYPE html>
<html lang="kr">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>대모임에 오신걸 환영합니다!</title>
    <link type="text/css" rel="stylesheet" href="/css/main.css"/>
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
<body style="padding-top: 150px">

<!-- 카테고리 -->
<c:import url="../layout/category.jsp">
</c:import>
<!-- 내 모임리스트 -->
<c:choose>
    <c:when test="${dto.myMoimList.size() == 0}"> <!-- 내 모임이 없을때 -->
        <article>
            <div class="text">
                <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                <p class="join-text"> ${dto.member.memberId}님이 개설한 모임이 없습니다 ㅜ</p>
            </div>
        </article>
    </c:when>
    <c:otherwise> <!-- 내 모임이 있을때-->
        <article>
            <div class="text">
                <p class="join-text">${dto.member.memberId}님이 개설한 모임입니다</p>
            </div>
        </article>
        <div class="card-group">
        <c:forEach items="${dto.myMoimList}" var="myMoim"> <!-- 신규모임 출력 -->
            <article class="card">
                <a href="/moim/moimdetail/${myMoim.moimNum}">
                    <div class="card-wrapper">
                        <img src="" alt="Image">
                            <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                        <%if (memberId!="방문자"){%>
                                <button class="like-btn" id="like-btn-<%=moimbean.getMoimNum()%>"
                                        onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                    <i id="heart<%=moimbean.getMoimNum() %>"
                                            <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                       class = "fas fa-heart"<% } else{%>
                                       class = "far fa-heart"
                                            <%}%>></i>
                                </button>
                                        <%} %>
                            </form>--%>
                    </div>
                    <h4>${myMoim.moimName}</h4>
                    <h3>${myMoim.moimNCount} / ${myMoim.moimHCount}</h3>

                    <div class="card-nav">
                        <p class="moimArea" name="moimArea" value=""
                           style="margin-top: 0;">${myMoim.moimArea}</p>
                        <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                        <p class="categoryName" name="categoryName" value=""
                           style="margin-top: 0;">${myMoim.category.categoryName}</p>
                    </div>
                    <p class="moimProfile" name="moimProfile" value="">${myMoim.moimProfile}</p>
                </a>
            </article>
            <input type="hidden" name="jjimNum" value="">
            <input type="hidden" name="memberId" value="">
            <input type="hidden" name="moimNum" value="">
            <input type="hidden" name="classNum" value="">
            </form>
            </div><!--card-group-->
        </c:forEach>
    </c:otherwise>
</c:choose>

<!-- bottom.jsp -->
<c:import url="../layout/bottom.jsp">

</c:import>

</body>
</html>
    