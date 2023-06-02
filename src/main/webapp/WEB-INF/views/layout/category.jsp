<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>대모임에 오신걸 환영합니다!</title>
    <link type="text/css" rel="stylesheet" href="/css/main.css"/>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Barlow:wght@600&family=Heebo:wght@500&display=swap");
    </style>
</head>
<body>
<!-- 카테고리 -->
<div class="main-container">
    <main>

        <div class="category">
            <c:forEach items="${dto.categoryList}" var="category" varStatus="loop">
                <c:if test="${loop.index <= 7}">
                    <a href="/moim/categorymoim/${category.categoryNum}">
                        <input type="hidden" name="categoryNum" value="${category.categoryNum}">
                        <div class="image-wrapper">
                            <img src="${category.categoryImg}" alt=""/>
                            <div class="image-text">${category.categoryName}</div>
                        </div>
                    </a>
                </c:if>
            </c:forEach>
            <div class="hidden-category" style="display: none;">
                <c:forEach items="${dto.categoryList}" var="category" varStatus="loop">
                    <c:if test="${loop.index > 9}">
                        <a href="/moim/categorymoim/${category.categoryNum}">
                            <input type="hidden" name="categoryNum" value="${category.categoryNum}">
                            <div class="image-wrapper">
                                <img src="${category.categoryImg}" alt=""/>
                                <div class="image-text">${category.categoryName}</div>
                            </div>
                        </a>
                    </c:if>
                </c:forEach>
            </div>
            <div class="more-wrapper">
                <a href="#" class="more-btn">더보기</a>
            </div>
        </div>

    </main>
</div>

<script type="text/javascript">
    const moreBtn = document.querySelector('.more-btn');
    const hiddenCategories = document.querySelector('.hidden-category');
    let isHidden = true; // hiddenCategories가 숨겨져 있는 상태

    moreBtn.addEventListener('click', () => {
        if (isHidden) {
            hiddenCategories.style.display = 'flex';
            hiddenCategories.style.flexWrap = 'wrap';
            hiddenCategories.style.justifyContent = 'space-between';
            hiddenCategories.style.alignContent = 'space-between';
            isHidden = false; // hiddenCategories를 보여주는 상태로 변경
        } else {
            hiddenCategories.style.display = 'none';
            isHidden = true; // hiddenCategories를 숨기는 상태로 변경
        }
    });
</script>

</body>
</html>