<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="../layout/top.jsp" charEncoding="UTF-8">
<%--    <c:param name="member" value="$.member}"></c:param>--%>
<%--    <c:param name="roleList" value="$.roleList}"></c:param>--%>
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
<c:import url="../layout/category.jsp" charEncoding="UTF-8"/>

<!-- 카드 -->
<!-- 클래스 -->
<c:choose>

    <c:when test="${dto.member.memberId eq null}"><!--방문자일때-->
        ${dto.member.memberId == "방문자"}
        <div class="card-group">
        <c:forEach items="${dto.allMoimList}" var="allMoim"><!--방문자일때 전체모임출력-->
                <article class="card">
                    <a href="../moim/moimdetail/${allMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src=${allMoim.moimImg} alt="Image">
                                <%--                            <form name="jjimFrm" action="jjimProc.jsp" method="get">--%>
                                <%--                                <button class="like-btn" id="like-btn-${allMoim.moimNum}">--%>
                                <%--                                    <onclick--%>
                                <%--                                    ="likeBtnChange('${allMoim.moimNum}')">&lt;%&ndash;style="color:red; bgcolor: white;"&ndash;%&gt;--%>
                                <%--                                    </onclick>--%>
                                <%--                                    <i id="heart${allMoim.moimNum}" &ndash;%&gt;--%>
                                <%--                                        <%if (moimMgr.jjimCheck(memberId, moimbean.getMoimNum())) { %>--%>
                                <%--                                        class = "fas fa-heart">--%>
                                <%--                                        <% } else {%>&ndash;%&gt;--%>
                                <%--                                        class = "far fa-heart">--%>
                                <%--                                        <%}%>></i>--%>
                                <%--                                </button>--%>
                                <%--                            </form>--%>
                            <h4>${allMoim.moimName}</h4>
                            <h3>${allMoim.moimNCount} / ${allMoim.moimHCount}</h3>
                            <div class="card-nav">
                                <p class="moimArea" name="moimArea" value="" style="margin-top: 0; color: black; text-decoration: none;">${allMoim.moimArea}
                                </p>
                                <p class="card-nav-line" style="margin-top: 0; color: black; text-decoration: none;">&nbsp; | &nbsp;</p>
                                <p class="categoryName" name="categoryName" value="" style="margin-top: 0; color: black; text-decoration: none;">${allmoim.categoryNum}
                                </p>
                                <p class="moimProfile" name="moimProfile" value="" style="margin-top: 0; color: black; text-decoration: none;"><${allmoim.moimProfile}
                                </p>
                            </div>
                        </div>
                    </a>
                </article>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise><!--로그인했을때-->
        <c:choose>
            <c:when test="${dto.classList.size() eq 0}"><!-- 주변 클래스 모임이 없을때-->
                <p class="join-text"> ${dto.member.memberId}님 주변 클래스 모임이 아직 없습니다 ㅠ</p>
                <div class="card-group">
                <c:forEach items="${dto.allclassList}" var="allclassMoim">
                    <article class="card">
                        <a href="../moim/moimdetail/${allclassMoim.moimNum}">
                            <div class="card-wrapper">
                                <img src=${allclassMoim.moimImg} alt="Image">
                                    <%--                            <form name="jjimFrm" action="jjimProc.jsp" method="get">--%>
                                    <%--                                <button class="like-btn" id="like-btn-${allMoim.moimNum}">--%>
                                    <%--                                    <onclick--%>
                                    <%--                                    ="likeBtnChange('${allMoim.moimNum}')">&lt;%&ndash;style="color:red; bgcolor: white;"&ndash;%&gt;--%>
                                    <%--                                    </onclick>--%>
                                    <%--                                    <i id="heart${allMoim.moimNum}" &ndash;%&gt;--%>
                                    <%--                                        <%if (moimMgr.jjimCheck(memberId, moimbean.getMoimNum())) { %>--%>
                                    <%--                                        class = "fas fa-heart">--%>
                                    <%--                                        <% } else {%>&ndash;%&gt;--%>
                                    <%--                                        class = "far fa-heart">--%>
                                    <%--                                        <%}%>></i>--%>
                                    <%--                                </button>--%>
                                    <%--                            </form>--%>
                                <h4>${allclassMoim.moimName}</h4>
                                <h3>${allclassMoim.moimNCount}/ ${allclassMoim.moimHCount}</h3>
                                <div class="card-nav">
                                    <p class="moimArea" name="moimArea" value="" style="margin-top: 0; color: black; text-decoration: none;">${allclassMoim.moimArea}
                                    </p>
                                    <p class="card-nav-line" style="margin-top: 0; color: black; text-decoration: none;">&nbsp; | &nbsp;</p>
                                    <p class="categoryName" name="categoryName" value="" style="margin-top: 0; color: black; text-decoration: none;">${allclassMoim.categoryNum}
                                    </p>
                                    <p class="moimProfile" name="moimProfile" value="" style="margin-top: 0; color: black; text-decoration: none;"><${allclassMoim.moimProfile}
                                    </p>
                                </div>
                            </div>
                        </a>
                    </article>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise><!-- 클래스모임 있을때 -->
                <article>
                    <div class="text">
                        <p class="join-text"> ${dto.member.memberId}님! 클래스 모임입니다</p>
                    </div>
                </article>
                <div class="card-group">
                <c:forEach items="${dto.classList}" var="classList">
                        <article class="card">
                            <a href="../moim/moimdetail/${classList.moimNum}">
                                <div class="card-wrapper">-
                                    <img src=${classList.moimImg} alt="Image">
                                        <%--<form name="jjimFrm" action="jjimProc.jsp" method="get">--%>
                                        <%--	<button class="like-btn" id="like-btn-${class.moimNum}">--%>
                                        <%--			<onclick="likeBtnChange(${class.moimNum})" style="color:red; bgcolor: white;">--%>
                                        <%--		<i id="heart${class.moimNum}">--%>
                                        <%--				<%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>--%>
                                        <%--		   class = "fas fa-heart"--%>
                                        <%--		   class = "far fa-heart"--%>
                                        <%--	</button>--%>
                                        <%--</form>--%>
                                </div>
                                <h4>${classList.moimName}</h4>
                                <h3>${classList.moimNCount} / ${classList.moimHCount}</h3>
                                <div class="card-nav">
                                    <p class="moimArea" name="moimArea" value="${classList.moimArea}"
                                       style="margin-top: 0; color: black; text-decoration: none;">${classList.moimArea}</p>
                                    <p class="card-nav-line"
                                       style="margin-top: 0; color: black; text-decoration: none;">&nbsp; | &nbsp;</p>
                                    <p class="categoryName" name="categoryName" value="${classList.categoryNum}"
                                       style="margin-top: 0; color: black; text-decoration: none;">${classList.categoryNum}</p>
                                </div>
                                <p class="moimProfile" name="moimProfile" value="${classList.moimProfile}"
                                   style="margin-top: 0; color: black; text-decoration: none;">${classList.moimProfile}</p>
                            </a>
                        </article>
                        <input type="hidden" name="jjimNum" value="">
                        <input type="hidden" name="memberId" value="">
                        <input type="hidden" name="moimNum" value="">
                        <input type="hidden" name="classNum" value="">
                        </form>
                    </div>
                    <!--card-group-->
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>

<script type="text/javascript">

    const maindto = `${dto.member.memberId}`;
    console.log(maindto);

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
<!-- bottom.jsp -->
<c:import url="../layout/bottom.jsp" charEncoding="UTF-8"/>
</body>
</html>
        
