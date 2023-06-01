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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function likeBtnChange(num) {
            //Proc에 보내기
            //alert(num)
            let jjimFrm = document.forms["jjimFrm"];
            jjimFrm.moimNum.value = num;
            jjimFrm.submit();

            //색상 변경
            let likeBtn = document.getElementById("heart" + num)
            if (likeBtn.className == "far fa-heart") {//빈 하트면
                likeBtn.className = "fas fa-heart" //꽉찬 하트로
            } else if (likeBtn.className == "fas fa-heart") {//꽉찬 하트면
                likeBtn.className = "far fa-heart"//빈 하트로
            }

            //더보기 버튼 누르면 카테고리 안보이던부분 확장되는 코드
            const moreBtn = document.querySelector(".more");
            const hiddenCategory = document.querySelector(".hidden-category");

            moreBtn.addEventListener("click", function () {
                if (hiddenCategory.style.display === "none") {
                    hiddenCategory.style.display = "flex";
                } else {
                    hiddenCategory.style.display = "none";
                }
            });
        }
    </script>
</head>
<body style="padding-top: 150px">
<!-- 카테고리 -->
<c:import url="../layout/category.jsp">
<%--        <c:param name="category" value="${dto.category}"></c:param>--%>
</c:import>
<!-- 중단 -->
<c:choose>
    <c:when test="${dto.categoryMoimList.size() eq 0}">
        <article>
            <div class="text">
                <p class="join-text"> 이 카테고리에는 아직 모임이 없습니다.</p>
            </div>
        </article>
    </c:when>
        <c:otherwise>
            <article>
                <div class="text">
                    <p class="join-text"> ${dto.categoryName} 별 모임</p>
                </div>
            </article>
            <div class="card-group">
                <c:forEach items="${dto.categoryMoimList}" var="categoryMoim">
                    <article class="card">
                        <a href="/moim/moimdetail/${categoryMoim.moimNum}">
                            <div class="card-wrapper">
                                <img src=${categoryMoim.moimImg} alt="Image">
                                <!-- 찜 버튼 들어가는 자리-->
                            </div>
                            <h4>${categoryMoim.moimName}</h4>
                            <h3>${categoryMoim.moimNCount} / ${categoryMoim.moimHCount}</h3>
                            <div class="card-nav">
                                <p class="moimArea" name="moimArea" value=""
                                   style="margin-top: 0;">${categoryMoim.moimArea}</p>
                                <p class="card-nav-line" style="margin-top: 0;">&nbsp; | &nbsp;</p>
                                <p class="categoryName" name="categoryName" value=""
                                   style="margin-top: 0;">${categoryMoim.categoryNum}</p>
                            </div>
                            <p class="moimProfile" name="moimProfile" value=""
                               style="margin-top: 0;">${categoryMoim.moimProfile}</p>
                        </a>
                    </article>
                    <input type="hidden" name="jjimNum" value="">
                    <input type="hidden" name="memberId" value="">
                    <input type="hidden" name="moimNum" value="">
                    <input type="hidden" name="classNum" value="">
                </c:forEach>
            </div>
        </c:otherwise>
</c:choose>

<!-- bottom.jsp -->

<c:import url="../layout/bottom.jsp">
</c:import>
</body>
</html>
