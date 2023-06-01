<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="../layout/top.jsp" charEncoding="UTF-8">
    <%--    <c:param name="member" value="${mainDto.member}"></c:param>--%>
    <%--    <c:param name="roleList" value="${mainDto.roleList}"></c:param>--%>
</c:import>
<!DOCTYPE html>
<html lang="en">
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
<!-- 상단 -->


<!-- 가입한모임 -->
<c:choose>
    <c:when test="${dto.joinMoimList.size() eq 0}">
        <article>
            <div class="text">
                <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                <p class="join-text">가입한 모임이 아직 없습니다. 주변 모임 추천해드려요~</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.recoMoimList}" var="recoMoim">
                <!-- 가입안하면 본인 지역 모임 전부 출력 -->
                <article class="card">
                    <a href="/moim/moimdetail/${recoMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src="${recoMoim.moimImg}" alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="area-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${recoMoim.moimName}</h4>
                        <h3>${recoMoim.moimNCount} / ${recoMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value="" style="margin-top: 0;">${recoMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${recoMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${recoMoim.moimProfile}</p>
                    </a>
                </article>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <!-- 가입한 모임이 있을때 -->
        <article>
            <div class="text">
                <p class="join-text">가입한 모임</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.joinMoimList}" var="joinmoim">
                <article class="card">
                    <a href="/moim/moimdetail/${joinmoim.moimNum}">
                        <div class="card-wrapper">
                            <img src=${joinmoim.moimImg} alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="joinMoim-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${joinmoim.moimName}</h4>
                        <h3>${joinmoim.moimNCount} / ${joinmoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value="" style="margin-top: 0;">${joinmoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${joinmoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${joinmoim.moimProfile}</p>
                    </a>
                </article>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<hr>

<!-- 찜목록 -->

<!-- 최근본모임 -->

<!-- 업무별 모임 -->
<c:choose>
    <c:when test="${dto.businessMoimList.size() eq 0}">
        <article>
            <div class="text">
                <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                <p class="join-text">업무별 모임이 아직 없습니다. 주변 모임 추천해드려요~</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.recoMoimList}" var="recoMoim">

                <!-- 가입안하면 본인 지역 모임 전부 출력 -->
                <article class="card">
                    <a href="/moim/moimdetail/${recoMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src="${recoMoim.moimImg}" alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="area-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${recoMoim.moimName}</h4>
                        <h3>${recoMoim.moimNCount} / ${recoMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value="" style="margin-top: 0;">${recoMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${recoMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${recoMoim.moimProfile}</p>
                    </a>
                </article>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <!-- 모임이 있을때 -->
        <article>
            <div class="text">
                <p class="join-text">업무별 모임</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.businessMoimList}" var="businessMoim">
                <article class="card">
                    <a href="/moim/moimdetail/${businessMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src=${businessMoim.moimImg} alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="joinMoim-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${businessMoim.moimName}</h4>
                        <h3>${businessMoim.moimNCount} / ${businessMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value=""
                               style="margin-top: 0;">${businessMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${businessMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${businessMoim.moimProfile}</p>
                    </a>
                </article>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<hr>

<!-- 직무별 모임 -->
<c:choose>
    <c:when test="${dto.taskMoimList.size() eq 0}">
        <article>
            <div class="text">
                <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                <p class="join-text">직무별 모임이 아직 없습니다. 주변 모임 추천해드려요~</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.recoMoimList}" var="recoMoim">

                <!-- 가입안하면 본인 지역 모임 전부 출력 -->
                <article class="card">
                    <a href="/moim/moimdetail/${recoMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src="${recoMoim.moimImg}" alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="area-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${recoMoim.moimName}</h4>
                        <h3>${recoMoim.moimNCount} / ${recoMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value=""
                               style="margin-top: 0;">${recoMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${recoMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${recoMoim.moimProfile}</p>
                    </a>
                </article>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <!-- 모임이 있을때 -->
        <article>
            <div class="text">
                <p class="join-text">테마별 모임</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.taskMoimList}" var="taskMoim">
                <article class="card">
                    <a href="/moim/moimdetail/${taskMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src=${taskMoim.moimImg} alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="joinMoim-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${taskMoim.moimName}</h4>
                        <h3>${taskMoim.moimNCount} / ${taskMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value=""
                               style="margin-top: 0;">${taskMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${taskMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${taskMoim.moimProfile}</p>
                    </a>
                </article>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<hr>
<!-- 테마별 모임 -->
<c:choose>
    <c:when test="${dto.themeMoimList.size() eq 0}">
        <article>
            <div class="text">
                <!-- class 이름 알잘딱깔센으로 적어보시길... -->
                <p class="join-text">테마별 모임이 아직 없습니다. 주변 모임 추천해드려요~</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.recoMoimList}" var="recoMoim">

                <!-- 가입안하면 본인 지역 모임 전부 출력 -->
                <article class="card">
                    <a href="/moim/moimdetail/${recoMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src="${recoMoim.moimImg}" alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="area-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${recoMoim.moimName}</h4>
                        <h3>${recoMoim.moimNCount} / ${recoMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value=""
                               style="margin-top: 0;">${recoMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${recoMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${recoMoim.moimProfile}</p>
                    </a>
                </article>

            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <!-- 모임이 있을때 -->
        <article>
            <div class="text">
                <p class="join-text">테마별 모임</p>
            </div>
        </article>
        <div class="card-group">
            <c:forEach items="${dto.themeMoimList}" var="themeMoim">
                <article class="card">
                    <a href="/moim/moimdetail/${themeMoim.moimNum}">
                        <div class="card-wrapper">
                            <img src=${themeMoim.moimImg} alt="Image">
                                <%--<form name="jjimFrm" action="../main/jjimProc.jsp" method="get">
                                    <button class="like-btn" id="joinMoim-like-btn-<%=moimbean.getMoimNum()%>"
                                            onclick="likeBtnChange(<%=moimbean.getMoimNum()%>)" style="color:red; bgcolor: white;">
                                        <i id="heart<%=moimbean.getMoimNum() %>"
                                                <%if(moimMgr.jjimCheck(memberId, moimbean.getMoimNum())){ %>
                                           class = "fas fa-heart"<% } else{%>
                                           class = "far fa-heart"
                                                <%}%>></i>
                                    </button>
                                </form>--%>
                        </div>
                        <h4>${themeMoim.moimName}</h4>
                        <h3>${themeMoim.moimNCount} / ${themeMoim.moimHCount}</h3>
                        <div class="card-nav">
                            <p class="moimArea" name="moimArea" value=""
                               style="margin-top: 0;">${themeMoim.moimArea}</p>
                            <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                            <p class="categoryName" name="categoryName" value=""
                               style="margin-top: 0;">${themeMoim.categoryNum}</p>
                        </div>
                        <p class="moimProfile" name="moimProfile" value=""
                           style="margin-top: 0;">${themeMoim.moimProfile}</p>
                    </a>
                </article>


            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>


<script type="text/javascript">
    //const moreBtn = document.querySelector(".more");
    //const hiddenCategory = document.querySelector(".hidden-category");

    //moreBtn.addEventListener("click", function() {
    //if (hiddenCategory.style.display === "none") {
    // hiddenCategory.style.display = "flex";
    //} else {
    //  hiddenCategory.style.display = "none";
    //}
    //});

    function likeBtnChange(num) {
        //Proc에 보내기
        //document.jjimFrm.submit();
        //alert(num); //정상적으로 나옴
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


</div>
</body>
</html>