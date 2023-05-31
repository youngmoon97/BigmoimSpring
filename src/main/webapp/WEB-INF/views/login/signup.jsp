<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <script type="text/javascript" src="../../../../resources/static/js/script.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="../../../../resources/static/css/style.css">

    <link rel="stylesheet" href="../../../../resources/static/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../../../resources/static/css/bootstrap.min.css">

    <!-- Style -->
    <link rel="stylesheet" href="../../../../resources/static/css/style.css">

    <style>
        /*<!-- 사진 추가용 스타일-->*/
        .image-preview-container {
            display: flex;
            align-items: center;
        }

        .file-input-container {
            margin-right: 10px;
        }

        #preview-image {
            max-width: 200px;
            max-height: 200px;
        }

        /*뒤로가기 버튼 수정 css*/
        .back-button {
            display: flex;
            align-items: center;
        }

        .back-button img {
            width: 2em;
            /* 이미지의 너비를 글씨 크기와 동일하게 조절 */
            height: 2em;
            /* 이미지의 높이를 글씨 크기와 동일하게 조절 */
            margin-right: 0.5em;
            /* 이미지와 글씨 사이의 간격 조절 */
            margin-top: -9px;
            /* 원하는 위치만큼의 음수 값을 입력하여 이미지를 높일 수 있습니다. */
            margin-left: -16em;
        }


        .file-input-container {
            background-color: pink;
            /* 분홍색 배경색 적용 */
            color: white;
            /* 글자 색상 변경 (예: 흰색) */
            padding: 10px;
            /* 내부 여백 적용 (예: 10px) */
            cursor: pointer;
            /* 커서 모양 변경 (예: 포인터) */
            border: none;
            border-radius: 5px;
            margin-left: 1em;
        }

        /* 파일 선택 버튼 숨기기 */
        #profile-image {
            display: none;
        }

        .main-container {
            padding: 50px;
            background-color: rgb(255, 231, 235);
            min-width: min-content;
            /* 내용 최소너비를 유지 */
        }

        .main-wrapper {
            max-width: 1300px;
            /* 전체적인 크기를 1300px로 제한 */
            margin: 0 auto;
            /* 가운데 정렬 */
        }

        .category {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
            gap: 20px 56px;
            align-content: center;
        }

        .main-merge {
            max-width: 900px;
            margin: 0 auto;
            /* 가운데 정렬을 위한 margin 설정 */
            width: 85%;
            /* 예시 값 */
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 50px;
            background-color: white;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
        }

    </style>
    <title>회원가입</title>
</head>

<body>
<div class="main-wrapper">
    <div class="main-container">
        <div class="category">
            <div class="main-merge"> <!--main page 간격-->
                <div class="back-button" style="margin-top: 3em">
                    <!--a 태그에 메인 URL 입력해야함-->
                    <a href="javascript:history.back();">
                        <img src="" alt="뒤로가기" style=""/>
                    </a>
                    <h3 style="margin-left: -7.5em"><strong>회원가입</strong></h3>
                </div>
                <form name="signFrm" enctype="multipart/form-data">
                    <div style="width: 500px; font-size: 16px;">

                        <div class="sign-nameHeader">
                            <br>
                            <label>이름(필수)</label>
                            <input type="text" class="form-control" name="memberName" placeholder="이름을 입력해주세요."
                                   id="memberName">
                        </div>

                        <!--버튼이 한줄에 오기위해  부모에 input-button-wrapper 추가후
                                 css 수정-->
                        <div>
                            <div class="sign-nameHeader">
                                <label>아이디(필수)</label>
                                <div class="input-button-wrapper">
                                    <input type="text" class="form-control" name="memberId" id="memberId"
                                           placeholder="아이디를 입력해주세요.">
                                    <button type="button" onclick="idCheck(this.form.memberId.value)"
                                            style="background: pink; color: #fff; border: none; padding: 10px 20px;
                                    cursor: pointer; border-radius: 5px; white-space: nowrap;">
                                        중복확인
                                    </button>
                                </div>
                            </div>

                            <div class="sign-nameHeader">
                                <label>비밀번호(필수)</label>
                                <input type="password" class="form-control" name="memberPw" placeholder="비밀번호를 입력해주세요." id="memberPw">
                            </div>

                            <div class="sign-nameHeader">
                                <label>비밀번호 재확인</label>
                                <input type="password" class="form-control" name="memberPwConfirm" placeholder="비밀번호 재확인" id="memberPwConfirm">
                            </div>

                            <div class="sign-nameHeader">
                                <label>전화번호(필수 *숫자만 입력하세요)</label>
                                <div class="input-button-wrapper">
                                    <input type="text" class="form-control" name="memberTel" placeholder="전화번호를 입력해주세요." id="memberTel">
                                    <button type="button" onclick="phoneOK()"
                                            style="background: pink; color: #fff; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px;">
                                        인증
                                    </button>
                                </div>
                            </div>

                            <!--집주소 zipcode 그대로 사용한다고 가정-->
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="sign-nameHeader">
                                        <label for="memberAddr">집주소(필수)</label>
                                    </div>
                                    <div>
                                        <input name="memberAddrZipcode" size="5" readonly style="height: 40px;" id="memberAddrZipcode">
                                        <input type="button" name="memberAddrBtn" value="우편번호찾기"
                                               onClick="zipSearch(this.name)"
                                               style="background: pink; color: #fff; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px; height: 40px;">
                                    </div>
                                    <div class="sign-nameHeader">
                                        <br>
                                        <input name="memberAddrArea1" id="memberAddrArea1" size="5" readonly>
                                        <input name="memberAddrArea2" id="memberAddrArea2" size="13" readonly>
                                        <input type="hidden" name="memberAddr" id="memberAddr">
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="sign-nameHeader">
                                        <label>직장 주소</label>
                                    </div>
                                    <div>
                                        <input name="memberJobAddrZipcode" size="5" readonly style="height: 40px;" id="memberJobAddrZipcode">
                                        <input type="button" name="memberJobAddrBtn" value="우편번호찾기"
                                               onClick="zipSearch(this.name)"
                                               style="background: pink; color: #fff; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px; height: 40px;">
                                    </div>
                                    <div class="sign-nameHeader">
                                        <br>
                                        <input name="memberJobAddrArea1" id="memberJobAddrArea1" size="5" readonly>
                                        <input name="memberJobAddrArea2" id="memberJobAddrArea2" size="13" readonly>
                                        <input type="hidden" name="memberJobAddr" id="memberJobAddr">
                                    </div>
                                </div>
                            </div>


                            <div class="sign-nameHeader fourth">
                                <label>관심 지역</label>
                                <br>
                            </div>

                            <div class="sign-nameHeader">
                                <div class="form-row">
                                    <div class="col">
                                        <select class="form-control" name="memberLikeArea_area1"
                                                id="memberLikeArea_area1"
                                                onchange="javascript:setArea2List(this.form.memberLikeArea_area1.value)">
                                            <option> </option>

                                            <option value="">

                                            </option>
                                        </select>
                                    </div>

                                    <div class="col">
                                        <select class="form-control" name="memberLikeArea_area2"
                                                id="memberLikeArea_area2">
                                            <option value="">구 / 동</option>

                                            <option value="">
                                            </option>

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="memberLikeArea">

                            <div class="sign-nameHeader">
                                <label for="memberBirth">생일(필수)</label>
                                <br>

                            </div>
                            <div class="sign-nameHeader">
                                <div class="form-row">
                                    <div class="col">
                                        <select class="form-control" name="memberBirth_year" id="memberBirth_year"
                                                onChange="javascript:getYear(this.form.memberBirth_year.value)">
                                            <option value="">연도</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="form-control" name="memberBirth_month" id="memberBirth_month"
                                                onChange="javascript:getMonth(this.form.memberBirth_month.value)">
                                            <option value="">월</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="form-control" name="memberBirth_day" id="memberBirth_day"
                                                onChange="javascript:getDay(this.form.memberBirth_day.value)">
                                            <option value="">일</option>
                                        </select>
                                        <input type="hidden" name="memberBirth" id="memberBirth">
                                    </div>
                                </div>
                            </div>

                            <script>
                                // 연도 옵션 생성
                                var yearSelect = document.getElementById("memberBirth_year");
                                var currentYear = new Date().getFullYear();
                                for (var i = currentYear; i >= 1900; i--) {
                                    var option = document.createElement("option");
                                    option.text = i;
                                    option.value = i;
                                    yearSelect.add(option);
                                }

                                // 월 옵션 생성
                                var monthSelect = document.getElementById("memberBirth_month");
                                for (var i = 1; i <= 12; i++) {
                                    var option = document.createElement("option");
                                    option.text = i;
                                    option.value = i;
                                    monthSelect.add(option);
                                }

                                // 일 옵션 생성
                                var daySelect = document.getElementById("memberBirth_day");
                                for (var i = 1; i <= 31; i++) {
                                    var option = document.createElement("option");
                                    option.text = i;
                                    option.value = i;
                                    daySelect.add(option);
                                }
                            </script>

                            <div class="sign-nameHeader">
                                <label>업종 / 직무 / 테마</label>
                                <br>
                            </div>

                            <div class="sign-nameHeader">
                                <div class="form-row">
                                    <div class="col">
                                        <select class="form-control" name="businessNum"
                                                onChange="javascript:getBusinessNum(this.form.businessNum.value)">
                                            <option value="0">업종</option>
                                            <c:forEach items="${authDto.businessList}" var="business">
                                                <li class="ui-state-default">
                                                    <label>
                                                        <option value="${business.businessNum}">
                                                            ${business.businessName}
                                                        </option>
                                                    </label>
                                                </li>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="form-control" name="taskNum"
                                                onchange="javascript:getTaskNum(this.form.taskNum.value)">
                                            <option value="0">직무</option>
                                            <c:forEach items="${authDto.taskList}" var="task">
                                                <li class="ui-state-default">
                                                    <label>
                                                        <option value="${task.taskNum}">
                                                                ${task.taskName}
                                                        </option>
                                                    </label>
                                                </li>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="form-control" name="themeNum"
                                                onchange="javascript:getThemeNum(this.form.themeNum.value)">
                                            <option value="0">테마</option>
                                            <c:forEach items="${authDto.themeList}" var="theme">
                                                <li class="ui-state-default">
                                                    <label>
                                                        <option value="${theme.themeNum}">
                                                                ${theme.themeName}
                                                        </option>
                                                    </label>
                                                </li>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="sign-nameHeader">
                                <label>성별(필수)</label>
                                <br>
                            </div>
                            <div style="text-align: center;">
                                <div class="d-inline-block" style="margin-right: 50px;">
                                    <input class="form-check-input" type="radio" name="memberSex" id="male"
                                           value="1" checked>
                                    <label class="form-check-label" for="male">남자</label>
                                </div>
                                <div class="d-inline-block" style="margin-left: 50px;">
                                    <input class="form-check-input" type="radio" name="memberSex" id="female"
                                           value="2">
                                    <label class="form-check-label" for="female">
                                        여자
                                    </label>
                                </div>
                            </div>

                            <div class="sign-nameHeader" onchange="">
                                <label>관심사</label>
                                <br>
                            </div>
                            <div class="col">
                                <select class="form-control" name="categoryNum"
                                        onchange="javascript:getCategoryNum(this.form.categoryNum.value)">
                                    <option value="0">관심사 선택</option>
                                    <c:forEach items="${authDto.categoryList}" var="category">
                                        <li class="ui-state-default">
                                            <label>
                                                <option value="${category.categoryNum}">
                                                        ${category.categoryName}
                                                </option>
                                            </label>
                                        </li>
                                    </c:forEach>
                                </select>
                            </div>
                            <br>

                            <div class="sign-nameHeader">
                                <label>회원사진</label>

                                <br>
                            </div>

                            <div class="image-preview-container">
                                <img id="preview-image" src="" alt="Preview Image">
                                <label for="profile-image" class="file-input-container">사진 선택하기</label>
                                <input type="file" class="form-control-file" id="profile-image" name="memberImg"
                                       onchange="showPreviewImage(this)">
                            </div>

                            <script>
                                function showPreviewImage(input) {
                                    var previewImage = document.getElementById('preview-image');
                                    var fileInput = document.getElementById('profile-image');
                                    if (input.files && input.files[0]) {
                                        var reader = new FileReader();
                                        reader.onload = function (e) {
                                            previewImage.src = e.target.result;
                                        }
                                        reader.readAsDataURL(input.files[0]);
                                    } else {
                                        previewImage.src = '';
                                    }
                                }
                            </script>
                        </div>
                    </div>
                </form>

                <br>
                <br>
                <div class="sign-nameHeader">
                    <label for="memberProfile">자기소개</label>
                    <br>
                </div>

                <div class="sign-nameHeader">
                                        <textarea class="form-control" id="memberProfile" name="memberProfile" rows="4"
                                                  maxlength="100" placeholder="자기소개를 해주세요. (100자 이내)"></textarea>
                </div>
                <input type="button" value="가입하기" onclick="inputCheck()"
                       class="btn btn-pill text-white btn-block"
                       style="background-color: pink;">

            </div>
        </div>
        </form>
        <form method="POST" name="hiddenFrm">
            <input type="hidden" name="memberLikeArea_area1">
            <input type="hidden" name="memberName" id="${memberName}">
            <input type="hidden" name="memberId" id="${memberId}">
            <input type="hidden" name="memberPw" id="${memberPw}">
            <input type="hidden" name="memberPwConfirm" id="${memberPwConfirm}">
            <input type="hidden" name="memberTel" id="${memberTel}">

            <input type="hidden" name="memberAddrZipcode" id="${memberAddrZipcode}">
            <input type="hidden" name="memberAddrArea1" id="${memberAddrArea1}">
            <input type="hidden" name="memberAddrArea2" id="${memberAddrArea2}">
            <input type="hidden" name="memberJobAddrZipcode" id="${memberJobAddrZipcode}">
            <input type="hidden" name="memberJobAddrArea1" id="${memberJobAddrArea1}">
            <input type="hidden" name="memberJobAddrArea2" id="${memberJobAddrArea2}">
        </form>
    </div>
</div>
</div>
</div>
</div>
</div>
</div>
<script type="text/javascript">
    function idCheck(id) {
        if (id == "") {
            alert("아이디를 입력하세요.");
            document.signFrm.id.focus();
            return;//이후에 코드를 실행이 안됨. 함수를 빠져나감.
        }
        url = "idCheck.jsp?id=" + id;
        window.open(url, "ID 중복체크", "width=300, height=150, top=100, left=300");
    }

    function phoneOK() {

    }

    function setArea2List(memberLikeArea_area1) {
        document.hiddenFrm.memberLikeArea_area1.value = memberLikeArea_area1;
        document.hiddenFrm.memberName.value = document.signFrm.memberName.value;
        document.hiddenFrm.memberId.value = document.signFrm.memberId.value;
        document.hiddenFrm.memberPw.value = document.signFrm.memberPw.value;
        document.hiddenFrm.memberPwConfirm.value = document.signFrm.memberPwConfirm.value;
        document.hiddenFrm.memberTel.value = document.signFrm.memberTel.value;

        document.hiddenFrm.memberAddrZipcode.value = document.signFrm.memberAddrZipcode.value;
        document.hiddenFrm.memberAddrArea1.value = document.signFrm.memberAddrArea1.value;
        document.hiddenFrm.memberAddrArea2.value = document.signFrm.memberAddrArea2.value;
        document.hiddenFrm.memberJobAddrZipcode.value = document.signFrm.memberJobAddrZipcode.value;
        document.hiddenFrm.memberJobAddrArea1.value = document.signFrm.memberJobAddrArea1.value;
        document.hiddenFrm.memberJobAddrArea2.value = document.signFrm.memberJobAddrArea2.value;
        document.hiddenFrm.submit();
    }

    function zipSearch(name) { //우편번호 검색
        url = "zipSearch.jsp?search=n&type=" + name;
        window.open(url, "zipSearchwindow", "width=500, height=300, top=100, left=300, scrollbar=yes");
    }

    //선택된 값들을 가져와서 세팅
    function getYear(memberBirth_year) {
        document.signFrm.memberBirth_year.value = memberBirth_year;
    }

    function getMonth(memberBirth_month) {
        document.signFrm.memberBirth_month.value = memberBirth_month;
    }

    function getDay(memberBirth_day) {
        document.signFrm.memberBirth_day.value = memberBirth_day;
    }

    function getCategoryNum(categoryNum) {
        document.signFrm.categoryNum.value = categoryNum;
    }

    function getBusinessNum(businessNum) {
        document.signFrm.businessNum.value = businessNum;
    }

    function getTaskNum(taskNum) {
        document.signFrm.taskNum.value = taskNum;
    }

    function getThemeNum(themeNum) {
        document.signFrm.themeNum.value = themeNum;
    }
</script>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/main.js"></script>
</body>

</html>