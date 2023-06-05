<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="../layout/top.jsp" charEncoding="UTF-8">
    <%--    <c:param name="member" value="${mainDto.member}"></c:param>--%>
    <%--    <c:param name="roleList" value="${mainDto.roleList}"></c:param>--%>
</c:import>
<!DOCTYPE html>
<html lang="kr">
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

<!-- 카드 -->
<!-- 신규모임 -->
<c:choose>
    <c:when test="${dto.member.memberId ne null}"> <!-- 로그인했을때 -->
        <c:choose>
            <c:when test="${dto.newMoimList.size() == 0}"> <!-- 신규모임이 없을때 -->
                <article>
                    <div class="text">
                        <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                        <p class="join-text"> ${dto.member.memberId}님 주변 신규 모임이 없습니다 ㅜ</p>
                    </div>
                </article>
            </c:when>
            <c:otherwise> <!-- 신규모임이 있을때-->
                <article>
                    <div class="text">
                        <p class="join-text">${dto.member.memberId}님 주변 추천 신규 모임입니다</p>
                    </div>
                </article>
                <div class="card-group">
                <c:forEach items="${dto.newMoimList}" var="newmoim"> <!-- 신규모임 출력 -->
                    <article class="card">
                        <a href="/moim/moimdetail/${newmoim.moimNum}">
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
                            <h4>${newmoim.moimName}</h4>
                            <h3>${newmoim.moimNCount} / ${newmoim.moimHCount}</h3>

                            <div class="card-nav">
                                <p class="moimArea" name="moimArea" value=""
                                   style="margin-top: 0;">${newmoim.moimArea}</p>
                                <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                                <p class="categoryName" name="categoryName" value=""
                                   style="margin-top: 0;">${newmoim.category.categoryName}</p>
                            </div>
                            <p class="moimProfile" name="moimProfile" value="">${newmoim.moimProfile}</p>
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
    </c:when>
    <c:otherwise> <!-- 로그인 안했을때-->
        <article>
            <div class="text">
                <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                <p class="join-text"> 로그인을 하시면 더 많은 정보를 보실 수 있습니다~</p>
            </div>
        </article>
        <div class="card-group">
        <c:forEach items="${dto.allMoimList}" var="allmoim">
            <article class="card">
                <a href="/moim/moimdetail/${allmoim.moimNum}">
                    <div class="image-wrapper">
                        <img src=${allmoim.moimImg} alt="Image">
                    </div>
                    <h4>${allmoim.moimName}</h4>
                    <div class="card-nav">
                        <p class="moimArea" name="moimArea" value="" style="margin-top: 0;">${allmoim.moimArea}</p>
                        <p class="card-nav-line" style="margin-top: 0;" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                        <p class="categoryName" name="categoryName" value=""
                           style="margin-top: 0;">${allmoim.category.categoryName}</p>
                    </div>
                    <p class="moimProfile" name="moimProfile" value="">${allmoim.moimProfile}</p>
                </a>
            </article>
            </div>
            <!--card-group-->
        </c:forEach>
    </c:otherwise>
</c:choose>


<script type="text/javascript">
    function likeBtnChange(num) {
        //Proc에 보내기
        //document.jjimFrm.submit();
        //alert(num)
        let jjimFrm = document.forms["jjimFrm"];
        jjimFrm.moimNum.value = num;
        jjimFrm.submit();
        //$("#jjimFrm").submit();

        //색상 변경
        let likeBtn = document.getElementById("heart" + num)
        if (likeBtn.className == "far fa-heart") {//빈 하트면
            likeBtn.className = "fas fa-heart" //꽉찬 하트로
        } else if (likeBtn.className == "fas fa-heart") {//꽉찬 하트면
            likeBtn.className = "far fa-heart"//빈 하트로
        }
    }

</script>
</div>
<!-- bottom.jsp -->
<c:import url="../layout/bottom.jsp">

</c:import>
</body>
</html>
        