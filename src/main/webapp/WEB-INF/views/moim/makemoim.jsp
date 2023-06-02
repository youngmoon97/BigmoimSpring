<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/favicon.ico" type="image/x-icon">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="../fonts/icomoon/style.css">

    <link rel="stylesheet" href="../css/owl.carousel.min.css">


    <link rel="stylesheet" href="../css/bootstrap.min.css">


    <link rel="stylesheet" href="../css/style.css">


    <style>
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

        /*모임 대표 이미지 관련 css*/
        #preview-image {
            max-width: 200px;
            /* 변경된 부분: 최대 너비를 200px로 설정 */
            max-height: 200px;
            /* 변경된 부분: 최대 높이를 200px로 설정 */
        }

        .file-input-container {
            background-color: pink;
            color: white;
            padding: 10px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            margin-left: 15px;
            /* 해당 버튼의 margin-left 값을 조정하여 간격 조절 가능 */
        }

        .file-input-container input[type=file] {
            position: absolute;
            top: 10px;
            /* 파일 선택 버튼을 부모 요소의 오른쪽 상단에 위치시킴 */
            margin-top: 20px;
            /* 버튼과 상위 요소 간의 간격을 20px로 지정함 */
        }

        /* 파일 선택 버튼 숨기기 */
        #profile-image {
            display: none;
        }
    </style>
    <title>모임 개설</title>
</head>
<body>
<div class="main-wrapper">
    <div class="main-container">
        <div class="category">
            <div class="main-merge"> <!--main page 간격-->
                <div class="back-button" style="margin-top: 3em">
                    <!--a 태그에 메인 URL 입력해야함-->
                    <a href="#" onclick="window.history.back(); return false;">
                        <img src="../../image/back-button.png" alt="뒤로가기">
                    </a>
                    <h3 style="margin-left: -7.5em"><strong>모임 개설</strong></h3>
                </div>
                <div style="display:flex; justify-content:center; gap:20px;">
                    <br>
                    <br>
                    <button type="button" class="btn btn-primary mr-2 btn-col" id="moimBtn" value="1"
                            style="background-color: pink; border: none; width: 250px;" onclick="change('모임')">모임 개설
                    </button>

                    <button type="button" class="btn btn-primary btn-col" id="classBtn" value="2"
                            style="background-color: pink; border: none; width: 250px;" onclick="change('클래스')">클래스 개설
                    </button>
                </div>

                <form action="makemoimProc.jsp" method="post" name="frm" id="frm" enctype="multipart/form-data">
                    <input type="hidden" value="2" name="moimOrClass" id="moimOrClass">
                    <div style="width: 500px; font-size: 16px;">
                        <div class="image-preview-container">
                            <div>
                                <label>
                                    <br>
                                    모임 대표 이미지
                                    <br>
                                </label>
                            </div>
                            <img id="preview-image" src="" alt="Preview Image">
                            <label for="profile-image" class="file-input-container" style="margin-top: 6em">사진
                                변경하기</label>
                            <input type="file" class="form-control-file" id="profile-image" name="moimImg"
                                   onchange="showPreviewImage(this)">
                        </div>

                        <div>
                            <label>모임 명</label>
                            <input type="text" class="form-control" id="moimName" name="moimName" rows="1"
                                   maxlength="30"
                                   placeholder="모임 이름을 적어주세요">
                            <br>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>모임주소</label>
                                <br>
                                <input name="moimZipcode" size="5" readonly style="height: 40px;" value="48057">
                                <input type="button" name="memberAddrBtn" value="우편번호찾기"
                                       onClick="zipSearch(this.name)"
                                       style="background: pink; color: #fff; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px; height: 40px;">
                                <br>
                                <br>
                                <input id="moimArea1" name="moimArea1" size="7" value="부산" readonly>
                                <input id="moimArea2" name="moimArea2" size="10" value="해운대구" readonly>
                                <input type="hidden" name="moimArea" id="moimArea" value="부산 해운대구">
                            </div>

                            <div class="col-md-6">
                                <label>모임 종류</label>
                                <select class="form-control" name="categoryNum" id="categoryNum"
                                        onchange="javascript:getCategoryNum(this.form.categoryNum.value)">
                                    <option value="0">관심사 선택</option>
                                    <c:forEach items="${dto.categoryList}" var="category">
                                        <option value="${category.categoryNum}">
                                                ${category.categoryName}
                                        </option>
                                    </c:forEach>
                                </select>
                                <br>
                                <select class="form-control" name="businessNum" id="businessNum"
                                        onChange="javascript:getBusinessNum(this.form.businessNum.value)">
                                    <option value="0">업종</option>
                                    <c:forEach items="${dto.businessList}" var="business">
                                        <option value="${business.businessNum}">
                                                ${business.businessName}
                                        </option>
                                    </c:forEach>
                                </select>
                                <br>
                                <select class="form-control" name="taskNum" id="taskNum"
                                        onchange="javascript:getTaskNum(this.form.taskNum.value)">
                                    <option value="0">직무</option>
                                    <c:forEach items="${dto.taskList}" var="task">
                                        <option value="${task.taskNum}">
                                                ${task.taskName}
                                        </option>
                                    </c:forEach>
                                </select>
                                <br>
                                <select class="form-control" name="themeNum" id="themeNum"
                                        onchange="javascript:getThemeNum(this.form.themeNum.value)">
                                    <option value="0">테마</option>
                                    <c:forEach items="${dto.themeList}" var="theme">
                                        <option value="${theme.themeNum}">
                                                ${theme.themeName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div>

                            <label for="moimHCount">정원 (1~300)</label>
                            <br>
                            <textarea class="form-control" id="moimHCount" name="moimHCount" rows="2" maxlength="3"
                                      placeholder="300"></textarea>
                            <br>
                        </div>
                        <div>
                            <label>모임 소개</label>
                            <br>
                            <textarea class="form-control" id="moimProfile" name="moimProfile" rows="5"
                                      maxlength="500" placeholder="모임 소개를 작성해주세요"></textarea>
                            <br>
                        </div>

                        <div>
                            <label>카카오톡 오픈채팅방</label>
                            <textarea class="form-control" id="moimKakao" name="moimKakao" rows="2"
                                      maxlength="30" placeholder="카카오톡 오픈채팅 주소를 입력해주세요."></textarea>
                            <br>
                        </div>

                        <div id="addHtml"></div>

                        <input type="button" value="모임 만들기" class="btn btn-pill text-white btn-block"
                               style="background-color: pink;" onclick="makeMoim()">
                        <br>
                        <input type="hidden" id="memberId" name="memberId" value="${dto.member.memberId}">
                    </div>
                </form>
                <%--<form method="GET" name="hiddenFrm">
                    <input type="hidden" name="memberLikeArea_area1">
                    <input type="hidden" name="moimName" value="${moimName}">
                    <input type="hidden" name="moimKakao" value="${moimKakao}">
                    <input type="hidden" name="moimImg" value="${moimImg}">
                    <input type="hidden" name="moimProfile" value="${moimProfile}">
                    <input type="hidden" name="memberAddrZipcode" value="${memberAddrZipcode}">
                    <input type="hidden" name="memberAddrArea1" value="${memberAddrArea1}">
                    <input type="hidden" name="memberAddrArea2" value="${memberAddrArea2}">
                </form>--%>

            </div>
        </div>
    </div>
</div>
</body>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/main.js"></script>
<script type="text/javascript">
    const validateFields = () => {
        // id 속성을 이용해서 해당하는 요소를 가져온다.
        const moimArea1 = document.getElementById("moimArea1");
        const moimArea2 = document.getElementById("moimArea2");
        const nameElement = document.getElementById("moimName");
        const areaElement = moimArea1.value + " " + moimArea2.value;
        const HCountElement = document.getElementById("moimHCount");

        // 값들이 비어있는지 확인
        if (nameElement.value === "") {
            alert("모임명을 입력해주세요.");
            nameElement.focus();
            return false;
        }

        if (areaElement.value === "") {
            alert("모임주소를 입력해주세요.");
            areaElement.focus();
            return false;
        }

        if (HCountElement.value === "") {
            alert("모임 정원을 입력해주세요.");
            HCountElement.focus();
            return false;
        }
        return true;
    };

    const makeMoim = () => {
        if (!validateFields()) {
            return;
        }
        const nameElement = document.getElementById("moimName");
        const imgElement = document.getElementById("moimImg");
        const HCountElement = document.getElementById("moimHCount");
        const profileElement = document.getElementById("moimProfile");
        const kakaoElement = document.getElementById("moimKakao");
        const moimArea1 = document.getElementById("moimArea1");
        const moimArea2 = document.getElementById("moimArea2");
        const categoryNum = document.getElementById("categoryNum");
        const businessNum = document.getElementById("businessNum");
        const taskNum = document.getElementById("taskNum");
        const themeNum = document.getElementById("themeNum");
        const memberId = document.getElementById("memberId");
        // const moimArea = document.getElementById("moimArea");
        const moimOrClass = document.getElementById("moimOrClass");
        // const classprice = document.getElementById("classprice").value;

        const moim = {
            moimName: nameElement.value,
            moimArea: moimArea1.value + " " +moimArea2.value,
            moimHCount: HCountElement.value,
            memberId: memberId.value,
            moimKakao: kakaoElement.value,
            categoryNum: categoryNum.value,
            //moimImg: imgElement.value,
            moimProfile: profileElement.value,
            businessNum: businessNum.value,
            taskNum: taskNum.value,
            themeNum: themeNum.value,
            //classPrice: classprice.value,
            moimOrClass: moimOrClass.value,
        }

        console.log(moim);

        fetch("/api/v1/moim/makemoim", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(moim),
        })
            .then(res => res.json())
            .then(result => {
                alert(result.message);
                if (result.code == 0) {
                    location.replace("/main");
                }
            })
            .catch(error => {
                console.log(error);
            })
    };

    // 카테고리 이름으로 카테고리번호 보내기
    function getCategoryNum(categoryNum) {
        document.frm.categoryNum.value = categoryNum;
    }

    // 비지니스 이름으로 비지니스 번호 보내기
    function getBusinessNum(businessNum) {
        document.frm.businessNum.value = businessNum;
    }

    // 테스크 이름으로 테스크 번호 보내기
    function getTaskNum(taskNum) {
        document.frm.taskNum.value = taskNum;
    }

    // 테마 이름으로 테마 번호 보내기
    function getThemeNum(themeNum) {
        document.frm.themeNum.value = themeNum;
    }


    function zipSearch(name) { //우편번호 검색
        url = "zipSearch.jsp?search=n&type=" + name;
        window.open(url, "bigmoim 우편번호 검색", "width=500, height=300, top=100, left=300, scrollbar=yes");
    }


    /*모임대표사진 불러오기*/
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


    // 클래스 개설시 price 추가 모임개설시 삭제

    const moimBtn = document.getElementById("#moimBtn");
    const classBtn = document.getElementById("#classBtn");
    const moimOrclass = document.getElementById("#moimtype");

    moimBtn.addEventListener("click", () => {
        const addHtml = document.getElementById("#addHtml");
        //alert("모임개설");
        while (addHtml.hasChildNodes()) {
            addHtml.removeChild(addHtml.lastChild);
        }
        moimOrclass.value = 2;
        /*         	addHtml.insertAdjacentHTML(
                        "beforeend",
                        "<input id='aa' type='text' placeholder='1번'>"
                    ); */
    });

    // 193번째 줄로 이동

    classBtn.addEventListener("click", () => {
        const addHtml = document.getElementById("#addHtml");

        while (addHtml.hasChildNodes()) {
            addHtml.removeChild(addHtml.lastChild);
        }
        ;

        // console.log(moimOrclass);

        moimOrclass.value = "1";

        addHtml.insertAdjacentHTML(
            "beforeend",
            "<lable>클래스 회비</lable><br><textarea class = 'form-control' id='classprice' row = '2' name = 'classprice' >"
        );
    });


    const change = (name) => {
        const content = document.getElementById("#frm");
        const labelList = content.querySelectorAll("label");
        for (const el of labelList) {
            if (name == "클래스") {
                console.log(1);
                el.innerText = el.innerText.replace("모임", "클래스");
            } else if (name == "모임") {
                el.innerText = el.innerText.replace("클래스", "모임");
                console.log(1);
            }
        }
    }

</script>
</html>