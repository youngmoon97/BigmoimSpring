<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="../layout/top.jsp" charEncoding="UTF-8">
</c:import>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title name="moimName">${dto.moimDetail.moimName}</title>
    <link type="text/css" rel="stylesheet" href="/css/clubdetail.css">
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

<c:if test="${dto.moimDetail.moimOrClass eq 1}">
    <!-- 클래스모임디테일 -->
    <!-- 메인 -->
    <div class="mainwrapper">
        <div class="clubdetail">
            <div class="category">
                <div class="image-wrapper">
                    <img src="${dto.moimDetail.category.categoryImg}" alt="카테고리이미지"/>
                </div>
            </div>
            <div class="clubdetail-moim">
                <h4 class="clubdetail-moimname" name="moimName">${dto.moimDetail.moimName}
                </h4>
                <ul class="clubdetail-area">
                    <li class="clubdetail-moimarea" name="moimArea">
                            ${dto.moimDetail.moimArea}
                    </li>
                    <li class="moimarea-line">|</li>
                    <li class="clubdetail-membercount" name="moimNCount">멤버&nbsp;${dto.moimMemberList.size()}
                    </li>
                        <%--                    <form name="jjimFrm_class" action="../main/jjimProc.jsp" method="get">--%>
                        <%--                        <button id="detailjjim_class"--%>
                        <%--                                onclick="likeBtnChange_class(${dto.moimDetail.moimNum})"--%>
                        <%--                                style="color : red;--%>
                        <%--	          background-color: transparent;--%>
                        <%--			  border: none;--%>
                        <%--			  font-size: 24px;--%>
                        <%--			  cursor: pointer;--%>
                        <%--			  width: 30px;--%>
                        <%--			  height: 30px;">--%>
                        <%--                            <i id="heart_class_${dto.moimDetail.moimNum}"--%>
                        <%--                                    <%if (moimMgr.jjimCheck(memberId, moimbean.getMoimNum())) { %>--%>
                        <%--                               class="fas fa-heart" style="display: inline-block; width: 100%; height: 100%;"<% } else {%>--%>
                        <%--                               class="far fa-heart" style="display: inline-block; width: 100%; height: 100%;"--%>
                        <%--                                    <%}%>--%>
                        <%--                            ></i>--%>
                        <%--                        </button>--%>
                        <%--                    </form>--%>
                    <c:choose>
                        <c:when test="${dto.member.memberId eq null}">

                        </c:when>
                        <c:when test="${dto.member.memberId eq dto.moimDetail.memberId}">
                            <li>
                                <button type="button" class="moimEditorBtn" onclick="moimUpdate_class()">내클래스관리</button>
                            </li>
                            <li>
                                <button type="button" class="classManageBtn" onclick="memberManage_class()">클래스회원관리
                                </button>
                            </li>
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                    <form>
                        <input type="hidden" name="jjimNum" value="">
                        <input type="hidden" name="memberId" value="">
                        <input type="hidden" name="moimNum" value="">
                    </form>
                </ul>
            </div>
        </div>
        <!-- 클래스 대표 이미지 -->
        <div class="clubdetail-photo">
            <img
                    class="clubdetail-photo-detail"
                    src="${dto.moimDetail.moimImg}"
                    name="moimImg"
            />
        </div>
        <!-- 클래스 소개 -->
        <div class="clubdetail-content">
            <p name="moimProfile">
                <!-- 단락으로 들어올 시 끊어서 받을 수가 없음-->
                    ${dto.moimDetail.moimProfile}
            </p>
        </div>
        <!-- 클래스 일정 -->
        <div class="clubdetail-schedule">
            <div style="display: flex;">
                <h2 class="clubdetail-text" style="margin: 0px;">클래스일정</h2>
                <c:if test="${dto.member.memberId.equals(dto.moimDetail.memberId)}">
                    <a href="makeschedule/${dto.moimDetail.memberId}/${dto.moimDetail.moimNum}">
                        <img alt="모임일정 생성"
                             src="https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/%ED%94%8C%EB%9F%AC%EC%8A%A4%EB%B2%84%ED%8A%BC.png"
                             width="30" height="30" style="margin-left: 10px">
                    </a>
                </c:if>

            </div>
        </div>
        <ul class="meeting_list" style = "position: relative; left: 500px;">
            <c:choose>
                <c:when test="${dto.moimDetail.moimScheduleList.size() eq 0}">
                    <div>
                        <h4>일정이 없습니다.</h4>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${dto.moimDetail.moimScheduleList}" var="moimSchedule">
                        <li>
                            <!-- 요일 / 일 -->
                            <h2 name="msTitle">${moimSchedule.msTitle}
                            </h2>
                            <ul class="mlist_in">
                                <li class="date" name="msTime">${moimSchedule.msDate.substring(0,16)}
                                </li>
                                <li>
                                    <ul class="in_cont">
                                        <li class="ico calendar"
                                            name="msTime">${moimSchedule.msDate.substring(0,16)}
                                        </li>
                                        <li class="ico place" name="msArea">${moimSchedule.msArea}
                                        </li>
                                        <!--<li class="ico cost" name="">${dto.moimDetail.classPrice}
                                        </li>-->
                                        <h4 name="msNCount">
                                            멤버(${moimSchedule.memberList.size()} / ${moimSchedule.msHCount})
                                        </h4>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="btn" id="scheduleJoin">
                            <c:forEach items="${dto.moimMemberList}" var="moimMember">
                                <c:if test="${dto.member.memberId.equals(moimMember.memberId)}">
                                    <c:choose>
                                        <c:when test="${dto.moimMemberList.size() < moimSchedule.msHCount}">
                                            <a href="schedulejoinProc/${moimNum}/${memberId}/${moimSchedule.msNum}"
                                               class="share">
                                                일정<br/><!-- 버튼 실행-->
                                                참여
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a>
                                                인원<br/>
                                                초과
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </li>
                        <div class="member" id="cont_1">
                            <div class="container">
                                <c:choose>
                                    <c:when test="${dto.moimDetail.moimScheduleList.size() eq 0}">
                                        <h4>참여 멤버가 없습니다.</h4>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${moimSchedule.memberList}" var="scheduleMember">
                                            <div class="joinMemberImg">
                                                <img src="${scheduleMember.memberImg}" alt=""/>
                                            </div>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

    <!-- 클래스 멤버 -->
    <div class="tab" style = "position: relative; left: 500px; width: 700px;">
        <c:if test="${dto.moimMemberList.size() ne 0}">
            <!-- 클래스 멤버 탭 부분 -->
            <ul class="tabnav">
                <li class="tab-link current" name="msTime" onclick="change(0)">
                    <a href="javascript:void(0)">전체멤버</a>
                </li>
                <c:if test="${dto.moimDetail.moimScheduleList.size() ne 0}">
                    <c:forEach items="${dto.moimDetail.moimScheduleList}" var="moimSchedule">
                        <li class="tab-link current" name="msTime" onclick="change(${moimSchedule.msNum})">
                            <a href="javascript:void(0)">${moimSchedule.msDate.substring(0,10)}</a>
                        </li>
                    </c:forEach>

                </c:if>
            </ul>
        </c:if>
        <!-- 클래스 멤버 탭에 따른 멤버 출력 -->
        <div class="tabcontent tab0">
            <h3 name="msNCount">클래스멤버(${dto.moimMemberList.size()})</h3>
            <!-- 클래스장 위에 나오는 왕관부분 -->
            <div class="manager"></div>
            <!-- 클래스장 출력 -->
            <ul class="tabcontent-list">
                <li class="tabcontent-list-img " name="memberImg">
                    <!-- TODO 잘못된 값 임시로 넣어놈 -> 로그인한 아이디의 이미지가져옴 -->
                    <img src="${dto.member.memberImg}" class="memberImg"/></li>
                <li>
                    <ul class="tabcontent-list-detail">
                        <li class="tabcontent-list-name" name="memberName">${dto.moimMemberList.get(0).memberId}
                        </li>
                        <li class="tabcontent-list-hello" name="memberProfile">${dto.moimMemberList.get(0).memberId}
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- 모임장을 뺀 클래스 멤버들 -->
            <c:forEach items="${dto.moimMemberList}" var="moimMember" varStatus="status" begin="1">
                <ul class="tabcontent-list">
                    <li class="tabcontent-list-img" name="memberImg"><img
                            src="${moimMember.memberImg}" class="memberImg"/></li>
                    <li>
                        <ul class="tabcontent-list-detail">
                            <li class="tabcontent-list-name" name="memberName">${moimMember.memberId}
                            </li>
                            <li class="tabcontent-list-hello" name="memberProfile">${moimMember.memberId}
                            </li>
                        </ul>
                    </li>
                </ul>
            </c:forEach>
        </div>
        <!-- 일정에 따른 참여멤버 출력 -->
        <c:forEach items="${dto.moimDetail.moimScheduleList}" var="moimSchedule">
            <div class="tabcontent tab${moimSchedule.msNum}" style="display: none">
                <h3 name="msNCount">모임일정멤버(${moimSchedule.memberList.size()})</h3>
                <c:choose>
                    <c:when test="${moimSchedule.memberList.size() eq 0}">
                        <li><h3>참여멤버가 없습니다.</h3></li>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${moimSchedule.memberList}" var="scheduleMember">
                            <ul class="tabcontent-list">
                                <li class="tabcontent-list-img" name="memberImg">
                                    <img src="${scheduleMember.memberImg}" />
                                <li>
                                    <ul class="tabcontent-list-detail">
                                        <li class="tabcontent-list-name" name="memberName">${scheduleMember.memberId}
                                        </li>
                                        <li class="tabcontent-list-hello" name="memberProfile">${scheduleMember.memberId}
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>

    </div>
    </div>
    <!-- 클래스 댓글 -->
    <%--<h2>댓글을 달아보세요</h2>
    <div class="commenttab">
        <%
            if (ccList.isEmpty()) {
                //System.out.print("클래스 : "+ccList);
        %>
        <div class="comments">
            <h3>등록된 댓글이 없습니다.</h3>
        </div>
        <%} else { %>
        <div class="comments">
            <%
                for (int i = 0; i < ccList.size(); i++) {
                    ClassCommentBean ccbean = ccList.get(i);
            %>
            <div class="comment">
                <div class="author"><%=ccbean.getMemberId() %>
                </div>
                <div class="message"><%=ccbean.getCcComment() %>
                </div>
                <div class="date"><%=ccbean.getCcDate() %>
                </div>
            </div>
            <%if (ccbean.getMemberId().equals(memberId)) {%>
            <div class="commentBtn">
                <a href="deleteclasscommentProc.jsp?num=<%=memberId%>&cCnum=<%=ccbean.getCcNum()%>&moimNum=<%=no%>">[삭제]</a>
            </div>
            <%} %>
            <%}%><!-- for -->
        </div>
        <%} %><!-- if else -->
        <form action="moimdetailProc.jsp?num=<%=no%>&memberId=<%=memberId%>" class="comment-form" method="post"
              name="commentFrm" id="ccComment">
            <input type="text" id="ccComment" name="ccComment" placeholder="댓글을 입력하세요."
                   style="width: 610px; outline: none; height: fit-content;"/>
            <button type="button" onclick="commentCheck()" style="width: 52px;">등록</button>
        </form>
    </div>
</div>
</div>--%>
</c:if>

<!-- 하단 -->
<c:if test="${dto.moimDetail.moimOrClass eq 2}">
    <!-- 모임디테일 -->
    <!-- 메인 -->
    <c:import url="../layout/moimdetailtop.jsp"></c:import>
    <div class="mainwrapper">
        <div class="clubdetail">
            <div class="category">
                <div class="image-wrapper">
                    <img src="${dto.moimDetail.category.categoryImg}" alt="카테고리이미지"/>
                </div>
            </div>
            <div class="clubdetail-moim">
                <h4 class="clubdetail-moimname" name="moimName">${dto.moimDetail.moimName}
                </h4>
                <ul class="clubdetail-area">
                    <li class="clubdetail-moimarea" name="moimArea">
                            ${dto.moimDetail.moimArea}
                    </li>
                    <li class="moimarea-line">|</li>
                    <li class="clubdetail-membercount" name="moimNCount">멤버&nbsp;${dto.moimMemberList.size()}
                    </li>
                        <%--                    <form name="jjimFrm_class" action="../main/jjimProc.jsp" method="get">--%>
                        <%--                        <button id="detailjjim_class"--%>
                        <%--                                onclick="likeBtnChange_class(${dto.moimDetail.moimNum})"--%>
                        <%--                                style="color : red;--%>
                        <%--	          background-color: transparent;--%>
                        <%--			  border: none;--%>
                        <%--			  font-size: 24px;--%>
                        <%--			  cursor: pointer;--%>
                        <%--			  width: 30px;--%>
                        <%--			  height: 30px;">--%>
                        <%--                            <i id="heart_class_${dto.moimDetail.moimNum}"--%>
                        <%--                                    <%if (moimMgr.jjimCheck(memberId, moimbean.getMoimNum())) { %>--%>
                        <%--                               class="fas fa-heart" style="display: inline-block; width: 100%; height: 100%;"<% } else {%>--%>
                        <%--                               class="far fa-heart" style="display: inline-block; width: 100%; height: 100%;"--%>
                        <%--                                    <%}%>--%>
                        <%--                            ></i>--%>
                        <%--                        </button>--%>
                        <%--                    </form>--%>
                    <c:choose>
                        <c:when test="${dto.member.memberId eq null}">

                        </c:when>
                        <c:when test="${dto.member.memberId eq dto.moimDetail.memberId}">
                            <li>
                                <button type="button" class="moimEditorBtn" onclick="moimUpdate_class()">내클래스관리</button>
                            </li>
                            <li>
                                <button type="button" class="classManageBtn" onclick="memberManage_class()">클래스회원관리
                                </button>
                            </li>
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                    <form>
                        <input type="hidden" name="jjimNum" value="">
                        <input type="hidden" name="memberId" value="">
                        <input type="hidden" name="moimNum" value="">
                    </form>
                </ul>
            </div>
        </div>
        <!-- 클래스 대표 이미지 -->
        <div class="clubdetail-photo">
            <img
                    class="clubdetail-photo-detail"
                    src="${dto.moimDetail.moimImg}"
                    name="moimImg"
            />
        </div>
        <!-- 클래스 소개 -->
        <div class="clubdetail-content">
            <p name="moimProfile">
                <!-- 단락으로 들어올 시 끊어서 받을 수가 없음-->
                    ${dto.moimDetail.moimProfile}
            </p>
        </div>
        <!-- 클래스 일정 -->
        <div class="clubdetail-schedule">
            <div style="display: flex;">
                <h2 class="clubdetail-text" style="margin: 0px;">클래스일정</h2>
                <c:if test="${dto.member.memberId.equals(dto.moimDetail.memberId)}">
                    <a href="makeschedule/${dto.moimDetail.memberId}/${dto.moimDetail.moimNum}">
                        <img alt="모임일정 생성"
                             src="https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/%ED%94%8C%EB%9F%AC%EC%8A%A4%EB%B2%84%ED%8A%BC.png"
                             width="30" height="30" style="margin-left: 10px">
                    </a>
                </c:if>

            </div>
        </div>
        <ul class="meeting_list">
            <c:choose>
                <c:when test="${dto.moimDetail.moimScheduleList.size() eq 0}">
                    <div>
                        <h4>일정이 없습니다.</h4>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${dto.moimDetail.moimScheduleList}" var="moimSchedule">
                        <li>
                            <!-- 요일 / 일 -->
                            <h2 name="msTitle">${moimSchedule.msTitle}
                            </h2>
                            <ul class="mlist_in">
                                <li class="date" name="msTime">${moimSchedule.msDate.substring(0,16)}
                                </li>
                                <li>
                                    <ul class="in_cont">
                                        <li class="ico calendar"
                                            name="msTime">${moimSchedule.msDate.substring(0,16)}
                                        </li>
                                        <li class="ico place" name="msArea">${moimSchedule.msArea}
                                        </li>
                                        <li class="ico cost" name="">${dto.moimDetail.classPrice}
                                        </li>
                                        <h4 name="msNCount">참여
                                                <%--                                            멤버(${dto.moimDetail.moimScheduleList.memberList.size() }/${dto.moimDetail.moimScheduleList.msHCount}</h4>--%>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="btn" id="scheduleJoin">
                            <c:forEach items="${dto.moimMemberList}" var="moimMember">
                                <c:if test="${dto.member.memberId.equals(moimMember.memberId)}">
                                    <c:choose>
                                        <c:when test="${dto.moimMemberList.size() < moimSchedule.msHCount}">
                                            <a href="schedulejoinProc/${moimNum}/${memberId}/${moimSchedule.msNum}"
                                               class="share">
                                                일정<br/><!-- 버튼 실행-->
                                                참여
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a>
                                                인원<br/>
                                                초과
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </li>
                        <div class="member" id="cont_1">
                            <div class="container">
                                <c:choose>
                                    <c:when test="${dto.moimDetail.moimScheduleList.size() eq 0}">
                                        <h4>참여 멤버가 없습니다.</h4>
                                    </c:when>
                                    <c:otherwise>
                                        <%--<c:forEach items="${dto.moimDetail.moimScheduleList.memberList}" var="scheduleMember">
                                            <div class="joinMemberImg">
                                                <img src="${scheduleMember.memberImg}"/>
                                            </div>
                                        </c:forEach>--%>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

    <!-- 클래스 멤버 -->
    <div class="tab">
        <c:if test="${dto.moimMemberList.size() ne 0}">
            <!-- 클래스 멤버 탭 부분 -->
            <ul class="tabnav">
                <li class="tab-link current" name="msTime" onclick="change(0)">
                    <a href="javascript:void(0)">전체멤버</a>
                </li>
                <c:if test="${dto.moimDetail.moimScheduleList.size() ne 0}">
                    <c:forEach items="${dto.moimDetail.moimScheduleList}" var="moimSchedule">
                        <li class="tab-link current" name="msTime" onclick="change(${moimSchedule.msNum})">
                            <a href="javascript:void(0)">${moimSchedule.msDate.substring(0,10)}</a>
                        </li>
                    </c:forEach>

                </c:if>
            </ul>
        </c:if>
        <!-- 클래스 멤버 탭에 따른 멤버 출력 -->
        <div class="tabcontent tab0">
            <h3 name="msNCount">클래스멤버(${dto.moimMemberList.size()})</h3>
            <!-- 클래스장 위에 나오는 왕관부분 -->
            <div class="manager"></div>
            <!-- 클래스장 출력 -->
            <ul class="tabcontent-list">
                <li class="tabcontent-list-img " name="memberImg">
                    <img src="/bigmoim/image/" class="memberImg"/></li>
                <li>
                    <ul class="tabcontent-list-detail">
                        <li class="tabcontent-list-name" name="memberName">${dto.member.memberId}
                        </li>
                        <li class="tabcontent-list-hello" name="memberProfile">${dto.member.memberId}
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- 모임장을 뺀 클래스 멤버들 -->
            <c:forEach items="${dto.moimMemberList}" var="moimMember">
                <ul class="tabcontent-list">
                    <li class="tabcontent-list-img" name="memberImg"><img
                            src="/bigmoim/image/${moimMember.memberId}" class="memberImg"/></li>
                    <li>
                        <ul class="tabcontent-list-detail">
                            <li class="tabcontent-list-name" name="memberName">${moimMember.memberId}
                            </li>
                            <li class="tabcontent-list-hello" name="memberProfile">${moimMember.memberId}
                            </li>
                        </ul>
                    </li>
                </ul>
            </c:forEach>
        </div>
        <!-- 일정에 따른 참여멤버 출력 -->
        <c:forEach items="${dto.moimDetail.moimScheduleList}" var="moimSchedule">
            <div class="tabcontent tab${moimSchedule.msNum}" style="display: none">
                <h3 name="msNCount">클래스멤버(${moimSchedule.memberList.size()})</h3>
                <c:choose>
                    <c:when test="${moimSchedule.memberList.size() eq 0}">
                        <li><h3>참여멤버가 없습니다.</h3></li>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${moimSchedule.memberList}" var="scheduleMember">
                            <ul class="tabcontent-list">
                                <li class="tabcontent-list-img" name="memberImg"><img
                                        src="/bigmoim/image/${scheduleMember.memberImg}" class="memberImg"/></li>
                                <li>
                                    <ul class="tabcontent-list-detail">
                                        <li class="tabcontent-list-name" name="memberName">${scheduleMember.memrberId}
                                        </li>
                                        <li class="tabcontent-list-hello"
                                            name="memberProfile">${scheduleMember.memberImg}
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>

    </div>
    </div>
    <!-- ---------------------------------------------------게시판------------------------------- -->


    <%--<div class="mainwrapper content2" style="display: none" ;>--%>
    <%--    <div class="main-containera">--%>
    <%--        <div class="categorya">--%>
    <%--            <div class="main-mergea">--%>
    <%--                <div class="uploadb">--%>
    <%--                    <button type="button" onclick="makeboard('${dto.moimDetail.moimNum}' , '${dto.member.memberId}')"--%>
    <%--                            style="background: pink; color: #fff; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px;">--%>
    <%--                        게시글 등록--%>
    <%--                    </button>--%>
    <%--                </div>--%>
    <%--                <br>--%>
    <%--                <% if (boardvlist.isEmpty()) {%>--%>
    <%--                <div>게시글이 없습니다.</div>--%>
    <%--                <%} else    // 게시글이 있는 경우 %>--%>
    <%--                <% for (int i = 0; i < boardvlist.size(); i++) {--%>
    <%--                    // mbBean : 해당 모임의 게시글 리스트--%>
    <%--                    MemberBoardBean mbBean = boardvlist.get(i);--%>
    <%--                    MemberBean memberBean = memberMgr.getMember(memberId);%>--%>
    <%--                <div class="post-containerb">--%>
    <%--                    <div class="post-headerb" style="position: relative;">--%>
    <%--                        <div class="profile-infob">--%>
    <%--                            <p class="author-nameb" style="margin-top: 1em;"> 작성자 : <%=mbBean.getMemberId()%>--%>
    <%--                            </p>--%>
    <%--                        </div>--%>
    <%--                        <%if (mbBean.getMemberId().equals(memberId)) {%>--%>
    <%--                        <a href="javascript:updateFn('<%=mbBean.getMbNum()%>','<%=mbBean.getMemberId() %>','<%=mbBean.getMoimNum()%>')"--%>
    <%--                           style="position: absolute; top: 5px; right: 45px;"> [수정]&nbsp</a>--%>
    <%--                        <a href="deleteboardProc.jsp?num=<%=memberId%>&mbnum=<%=mbBean.getMbNum()%>&moimnum=<%=no%>"--%>
    <%--                           style="position: absolute; top: 5px;; right: 0; margin-right: 5px"> [삭제] </a>--%>
    <%--                        <%}%>--%>
    <%--                        <div class="post-timeb">--%>
    <%--                            <!--올린 날자-->--%>
    <%--                            <p id="mbDate"><%=mbBean.getMbDate()%>--%>
    <%--                            </p>--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                    <div class="post-bodyb">--%>
    <%--                        <div class="post-contentb">--%>
    <%--                            <h3>제목: <%=mbBean.getMbTitle() %>--%>
    <%--                            </h3>--%>
    <%--                            <p><%=mbBean.getMbContent()%>--%>
    <%--                            </p>--%>
    <%--                        </div>--%>
    <%--                        <div class="post-imageb">--%>
    <%--                            <img src="/bigmoim/image/<%=mbBean.getMbImg()%>" width="150" height="150">--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                    <hr>--%>
    <%--                    <!--댓글 라인-->--%>

    <%--                    <div class="post-footerb">--%>
    <%--                        <div class="post-actions" style="display: flex; justify-content: space-between;">--%>
    <%--                            <button class="show-comments" style="position: relative; left: 17cm; bottom: 5px;"--%>
    <%--                                    onclick="showComments(<%=mbBean.getMbNum()%>)">댓글보기--%>
    <%--                            </button>--%>
    <%--                            <br>--%>
    <%--                        </div>--%>

    <%--                        <!-- ---------------------------댓글 폼 보이기 --------------------------->--%>

    <%--                        <script>--%>
    <%--                            function showComments(mbNum) {--%>
    <%--                                var comments = document.querySelector('#comments_' + mbNum);--%>
    <%--                                if (comments.style.display === 'none') {--%>
    <%--                                    comments.style.display = 'block';--%>
    <%--                                } else {--%>
    <%--                                    comments.style.display = 'none';--%>
    <%--                                }--%>
    <%--                            }--%>
    <%--                        </script>--%>


    <%--                        <!-- 댓글 영역에 고유한 ID 할당 -->--%>
    <%--                        <div class="comments" id="comments_<%=mbBean.getMbNum()%>" style="display: none;">--%>
    <%--                            <% Vector<BoardCommentBean> bcvlist = boardcommentMgr.bcList(mbBean.getMbNum());--%>
    <%--                                for (int j = 0; j < bcvlist.size(); j++) {--%>
    <%--                                    BoardCommentBean bcBean = bcvlist.get(j); %>--%>
    <%--                            <li style="list-style-type: none; position: relative; bottom: -10px;">--%>
    <%--                                <div class="comment-info">--%>

    <%--                                    <p class="comment-author" id="memberId"><%=bcBean.getMemberId() %> &nbsp</p>--%>
    <%--                                    <p class="comment-date" id="bcDate"><%=bcBean.getBcDate()%>--%>
    <%--                                    </p>--%>

    <%--                                    <%if (bcBean.getMemberId().equals(memberId)) {%>--%>
    <%--                                    <a href="deletecomment.jsp?memberId=<%=memberId%>&bcNum=<%=bcBean.getBcNum()%>&moimNum=<%=no%> "--%>
    <%--                                       style="margin-left: 15px;">[삭제]</a>--%>

    <%--                                    <%} // 댓글 수정,삭제 버튼%>--%>

    <%--                                </div>--%>
    <%--                                <p class="comment-text" id="bcContent"><%=bcBean.getBcContent()%>--%>
    <%--                                </p>--%>
    <%--                            </li>--%>
    <%--                            <br>--%>

    <%--                            <%}// 댓글 for문%>--%>
    <%--                            <form method="post"--%>
    <%--                                  action="insertboardProc.jsp?mbNum=<%=mbBean.getMbNum()%>&memberId=<%=memberId%>&moimNum=<%=no%>"--%>
    <%--                                  class="comment-form" name="commentFrm" id="commentFrm">--%>
    <%--                                <label for="comment-input"--%>
    <%--                                       style="width: 95px; position: relative; bottom: -20px; left: 20px;"> 댓글 </label>--%>
    <%--                                <input type="text" id="comment-input" name="comment-input">--%>
    <%--                                <button onclick="makeboardcomment()" style="width: 75px;">작성</button>--%>
    <%--                            </form>--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--                <br>--%>
    <%--                <%}// else%>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--</div>--%>
    <!-- ---------------------사진첩 ---------------------------------------------------------------->
    <%--<div class="mainwrapper content3" style="display: none;">--%>
    <%--    <div class="main-container">--%>
    <%--        <div class="categorys">--%>
    <%--            <div class="main-mergea">--%>
    <%--                <div class="upload">--%>
    <%--                    <%--%>

    <%--                        for (int i = 0; i < moimMemberList.size(); i++) {--%>

    <%--                            if (memberId != null && memberId.equals(moimMemberList.get(i).getMemberId())) {--%>
    <%--                    %>--%>
    <%--                    <button type="button" onclick="registerPhoto('<%=memberId %>', '<%=no %>')" value="<%=result%>"--%>
    <%--                            id="photoBtn" name="photoBtn"--%>
    <%--                            style="background: pink; color: #fff; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px; margin-left: 20.5cm;--%>
    <%--                            cm;">사진등록--%>
    <%--                    </button>--%>
    <%--                    <% }--%>
    <%--                    }%>--%>
    <%--                    <script>--%>
    <%--                        function registerPhoto() {--%>
    <%--                            var w = 500; // 창 너비--%>
    <%--                            var h = 750; // 창 높이--%>
    <%--                            var left = (screen.width / 2) - (w / 2); // 중앙에서부터 창의 왼쪽 위치 계산--%>
    <%--                            var top = (screen.height / 2) - (h / 2); // 중앙에서부터 창의 위쪽 위치 계산--%>
    <%--                            window.open("uploadphotos.jsp", "새창 이름", "width=" + w + ",height=" + h + ",top=" + top + ",left=" + left);--%>
    <%--                        }--%>
    <%--                    </script>--%>
    <%--                </div>--%>
    <%--                <br>--%>
    <%--                <div class="image-container">--%>
    <%--                    <%--%>
    <%--                        if (moimphotovlist.size() <= 0) {%>--%>
    <%--                    <div style="text-align: center;">등록된 사진이 없습니다.</div>--%>
    <%--                    <%--%>
    <%--                    } else {--%>
    <%--                        for (int k = 0; k < moimphotovlist.size(); k++) {--%>

    <%--                            MoimPhotosBean photobean = moimphotovlist.get(k);--%>

    <%--                    %>--%>
    <%--                    <div class="image-box"--%>
    <%--                         onclick="showDetail('<%=photobean.getPhotoName()%>', '<%=photobean.getMemberId()%>', '<%=no%>', '<%=photobean.getPhotoNum()%>')">--%>
    <%--                        <img src="/bigmoim/image/<%=photobean.getPhoto()%>" id="photo" width="280" height="200">--%>
    <%--                        <h2 style="text-align: center;"><%=photobean.getPhotoName()%>--%>
    <%--                        </h2>--%>
    <%--                    </div>--%>
    <%--                    <%}%>--%>
    <%--                    <%}%>--%>
    <%--                </div>--%>

    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--</div>--%>

    <%--<%} %><!-- 클래스와 모임 구분 if else -->--%>
    <%--<!-- 가입/탈퇴/로그인 버튼 -->--%>
    <%--<%if (memberId == null) {%>--%>
    <%--<div class="moimdetailBtn" style="bottom: 300px; right: 170px;">--%>
    <%--    <a href="../login/login.html">--%>
    <%--        <p class="moimdetailBtn-txt">로그인하기</p>--%>
    <%--    </a>--%>
    <%--</div>--%>
    <%--<%--%>
    <%--} else {--%>
    <%--    boolean memberChk = sjMgr.moimMemberCheck(no, memberId);--%>
    <%--    System.out.println("memberChk : " + memberChk);--%>
    <%--    Vector<MoimScheduleBean> allmoimScheduleList = sjMgr.allmoimScheduleList();--%>
    <%--    if (memberChk) { //있다 -탈퇴하기--%>
    <%--%>--%>
    <%--<div class="moimdetailBtn" style="bottom: 50px; right: 100px;">--%>
    <%--    <a href="#" onclick="moimQuit();">--%>
    <%--        <p class="moimdetailBtn-txt">탈퇴하기</p>--%>
    <%--    </a>--%>
    <%--</div>--%>

    <%--<%--%>
    <%--} else { // 없다 가입하기--%>
    <%--    boolean mjChk = moimMgr.mjChk(memberId, no);--%>
    <%--    if (!mjChk) { // 모입가입신청안헀으면--%>
    <%--%>--%>
    <%--<div class="moimdetailBtn" style="bottom: 300px; right: 170px;">--%>
    <%--    <a href="joinmoim.jsp?moimNum=<%=no%>&memberId=<%=memberId%>">--%>
    <%--        <p class="moimdetailBtn-txt">가입하기</p>--%>
    <%--    </a>--%>
    <%--</div>--%>
    <%--<%--%>
    <%--        }--%>
    <%--    }--%>
    <%--%>--%>

    <%--<%} %><!-- if else -->--%>
</c:if>

<script type=text/javascript>
    const moimdetail = `${dto.moimDetail.moimNum}`;
    console.log(moimdetail);


    //탈퇴하기
    function moimQuit() {//예
        if (confirm("정말 탈퇴하시겠습니까?")) {
            location.href = "quitMoimProc.jsp?memberId=${dto.member.memberId}&moimNum=${dto.moimDetail.moimNum}";
            return true;

        } else {//아니오

            return false;
        }
    }

    // 멤버관리
    function memberManage_moim() {
        document.jjimFrm_moim.action = "moimMemberManage.jsp";
        document.jjimFrm_moim.submit();
    }

    function memberManage_class() {
        document.jjimFrm_class.action = "moimMemberManage.jsp";
        document.jjimFrm_class.submit();
    }

    //찜목록
    function moimUpdate_moim() {//모임정보 수정 페이지로 감(모임)
        document.jjimFrm_moim.action = "moimupdate.jsp";
        document.jjimFrm_moim.submit();
    }

    function moimUpdate_class() {//모임정보 수정 페이지로 감(클래스)
        document.jjimFrm_class.action = "moimupdate.jsp";
        document.jjimFrm_class.submit();
    }

    //////////////////////////////////////////////
    function likeBtnChange_moim(num) {
        //Proc에 보내기
        let jjimFrm_moim = document.forms["jjimFrm_moim"];
        jjimFrm_moim.moimNum.value = num;
        jjimFrm_moim.submit();

        //색상 변경
        let likeBtn = document.getElementById("heart_moim_" + num)
        if (likeBtn.className == "far fa-heart") {//빈 하트면
            likeBtn.className = "fas fa-heart" //꽉찬 하트로
        } else if (likeBtn.className == "fas fa-heart") {//꽉찬 하트면
            likeBtn.className = "far fa-heart"//빈 하트로
        }
    }

    function likeBtnChange_class(num) {
        //Proc에 보내기
        let jjimFrm_class = document.forms["jjimFrm_class"];
        jjimFrm_class.moimNum.value = num;
        jjimFrm_class.submit();

        //색상 변경
        let likeBtn = document.getElementById("heart_class_" + num)
        if (likeBtn.className == "far fa-heart") {//빈 하트면
            likeBtn.className = "fas fa-heart" //꽉찬 하트로
        } else if (likeBtn.className == "fas fa-heart") {//꽉찬 하트면
            likeBtn.className = "far fa-heart"//빈 하트로
        }
    }

    //모임 및 클래스 js
    //모임 및 클래스 멤버들 탭js
    const change = (num) => {
        const tabList = document.querySelectorAll(".tabcontent");
        tabList.forEach((el) => (el.style.display = "none"));
        const nowTab = document.querySelector(".tab" + num);
        nowTab.style.display = "block";
    };

    function row_scroll() {
        $(".container .joinMemberImg").on('mousewheel', function (e) {
            var wheelDelta = e.originalEvent.wheelDelta;
            if (wheelDelta > 0) {
                $(this).scrollLeft(-wheelDelta + $(this).scrollLeft());
            } else {
                $(this).scrollLeft(-wheelDelta + $(this).scrollLeft());
            }
        });
    }

    row_scroll();

    //클래스 댓글 미입력시 js
    function commentCheck() {
        if (document.commentFrm.ccComment.value == "") {
            alert("댓글을 입력해주세요!");
            document.commentFrm.ccComment.focus();
            return;
        }
        document.commentFrm.submit();
    }

    //게시판 js
    function updateFn(num, memberId, moimNum) {

        url = "updateboard.jsp?num=" + num + "&memberId=" + memberId + "&moimNum=" + moimNum;

        window.open(url, "Board Update", "width=540, height=600");
    }

    //게시글 댓글 공백 체크 및 내용 submit
    function makeboardcomment() {
        const commentFrm = document.commentFrm;
        if (commentFrm.comment - input.value.length < 1) {
            alert("댓글을 작성해주세요");
            return;
        }
        commentFrm.submit();
    }

    //게시글 등록 창 띄우기
    function makeboard(no, memberId) {
        //    url = "makeboard.jsp?num=" + no + "&memberId=" + memberId;
        //        window.open(url,"Board MAKE","width=700, height=800");

        var w = 500; // 창 너비
        var h = 850; // 창 높이
        var left = (screen.width / 2) - (w / 2); // 중앙에서부터 창의 왼쪽 위치 계산
        var top = (screen.height / 2) - (h / 2); // 중앙에서부터 창의 위쪽 위치 계산
        window.open("makeboard.jsp?num=" + no + "&memberId=" + memberId, "새창 이름", "width=" + w + ",height=" + h + ",top=" + top + ",left=" + left);


    }

    // 사진 js
    function registerPhoto(memberId, no) {
        //		url = "uploadphotos.jsp?memberId=" + memberId + "&moimNum=" + no;
        //  	window.open(url,"Board MAKE","width=700, height=800");

        var w = 500; // 창 너비
        var h = 750; // 창 높이
        var left = (screen.width / 2) - (w / 2); // 중앙에서부터 창의 왼쪽 위치 계산
        var top = (screen.height / 2) - (h / 2); // 중앙에서부터 창의 위쪽 위치 계산
        window.open("uploadphotos.jsp?memberId=" + memberId + "&moimNum=" + no, "새창 이름", "width=" + w + ",height=" + h + ",top=" + top + ",left=" + left);
    }

    function showDetail(imageUrl, memberId, no, photoNum) {
        window.location.href = "photodetail.jsp?image=" + encodeURIComponent(imageUrl) + "&memberId=" + memberId + "&moimNum=" + no + "&photoNum=" + photoNum;
    }

</script>
<!-- bottom.jsp -->
<c:import url="../layout/bottom.jsp">

</c:import>
</body>
</html>