<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>대모임 로그인 페이지</title>
    <link type="text/css" rel="stylesheet" href="/css/login.css" />
    <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <style>

        @import url('https://fonts.googleapis.com/css2?family=Barlow:wght@600&family=Heebo:wght@500&display=swap');
    </style>
</head>
<body>
<div class="main-container">
    <div class="main-wrap">
        <header>
            <div class="logo-wrap">
                <h1>대모임</h1>
            </div>
        </header>
        <form method="post" name=loginFrm class="login-input-section-wrap" action="loginProcs.jsp">
            <div class="login-input-wrap">
                <input name="memberId" id="memberId" placeholder="아이디" value="moon" type="text" style="outline: none;">
            </div>
            <div  class="login-input-wrap password-wrap">
                <input name="memberPw" id="memberPw" placeholder="비밀번호" type="password" style="outline: none;">
            </div>
            <div class="login-button-wrap">
                <a><button id="loginBtn" type="button" onclick = "loginCheck()" >로그인</button></a>
            </div>
            <div class="login-findid-findpw-join">
                    <p><a class="forget-msg-id" href="/auth/idFind" style="color: black">아이디찾기</a></p>
                    <p class="forget-msg-line">|</p>
                <p><a class="forget-msg-pw" href="/auth/pwFind" style="color: black">비밀번호찾기</a></p>
                <p class="forget-msg-line">|</p>
                <p><a href="/auth/signup" class="join-msg" style="color: black">회원가입</a></p>
            </div>
        </form>
        <form type="hidden" class="easy-sgin-in-wrap" name="kakaologin" action="kakaologin.jsp">
            <ui class="sign-button-list">
                <li><button class="kakao-btn" onclick="javascript:loginWithKakao()"><span class="fas fa-kakao">KAKAO</span></button></li>
                <li><button class="facebook-btn"><span class="fab fa-facebook-square">FACEBOOK</span></button></li>
                <li><button class="line-btn"><span class="fab fa-line">NAVER</span></button></li>
            </ui>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">

    document.querySelector("#memberPw").addEventListener("keyup", (event) => {
        if (event.keyCode === 13) {
            requestLogin();
        }
    });
    const validateFields = () => {
        // id속성으로 요소를 가져옴
        const idElement = document.getElementById("memberId");
        const pwElement = document.getElementById("memberPw");

        if (idElement.value === "") {
            alert("아이디를 입력해주세요.");
            idElement.focus();
            return false;
        }

        if (pwElement.value === "") {
            alert("비밀번호를 입력해주세요.");
            pwElement.focus();
            return false;
        }

        return true;
    };
    const loginCheck = () => {

        if(!validateFields()){
            return;
        }
        const idElement = document.getElementById("memberId");
        const pwElement = document.getElementById("memberPw");

        const formTag = document.createElement("form");
        formTag.action = "/login-process";
        formTag.method = "POST";

        // id
        const idInputTag = document.createElement("input");
        idInputTag.type = "hidden";
        idInputTag.name = "memberId";
        idInputTag.value = idElement.value;
        formTag.appendChild(idInputTag);
        // pw
        const pwInputTag = document.createElement("input");
        pwInputTag.type = "hidden";
        pwInputTag.name = "memberPw";
        pwInputTag.value = pwElement.value;
        formTag.appendChild(pwInputTag);

        document.body.appendChild(formTag);
        formTag.submit();
    }
    /* 카카오 로그인 */
    Kakao.init('643edc1cbbeb20af837bf6151e68a9d0'); // 키값 저장
    function loginWithKakao() {
        Kakao.Auth.login({
            success: function (authObj) {
                console.log(authObj); // access토큰 값
                Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
                getInfo();
            },
            fail: function (err) {
                console.log(err);
            }
        });
    }
    function getInfo() {
        Kakao.API.request({
            url: '/v2/user/me',
            success: function (res) {
                var id = res.id;
                var email = res.kakao_account.email;
                var nickname = res.kakao_account.profile.nickname;
                var gender = res.kakao_account.gender;
                f = document.kakaologin;
                f.id.value = id;
                f.email.value = email;
                f.nickname.value = nickname;
                f.gender.value = gender;
                f.submit();
            },
            fail: function (error) {
                alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));
            }
        });
    }
</script>
</html>