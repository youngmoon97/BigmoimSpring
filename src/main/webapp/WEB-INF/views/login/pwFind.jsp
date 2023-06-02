<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%--<%--%>
<%--/* 		String memberId = request.getParameter("memberId");--%>
<%--		String memberTel = request.getParameter("memberTel");--%>
<%--		String memberPw = mMgr.getPwSearch(memberId, memberTel); */--%>
<%--%>--%>
<!DOCTYPE html>
<html lang = "ko">
    <head>
        <meta charset = "UTF-8">
        <title>아이디 / 비밀번호 수정</title>
        <link rel = "stylesheet" href = "../../../../resources/static/css/pwFind.css">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    </head>
    <body>
        <div class="login-find-wrapper">
            <div class="login-find-content">
                <div id = "login-find-header">
                    <h1>비밀번호 찾기</h1>
                </div>
                <!-- 아이디 -->
                <form name="pwfind" method="post">
                    <div class="login-find-input">
                    <div>
                        <h3 class = "login-find-title"><label>아이디</label></h3>
                        <span class = "box string-id">
                            <input type = "text" id="memberId" name = "memberId" class = "string" maxlength = "20" style="width: 94%;" value="${memberId}">
                        </span>
                    </div>
                    <!-- 전화번호 -->
                    <div>
                        <h3 class = "login-find-title"><label>전화번호</label></h3>
                        <span class = "box string-tel">
                            <input type = "text" id="memberTel" name = "memberTel" class = "string" maxlength = "16" style="width: 94%;"
                                   value="${memberTel}">
                        </span>

                    </div>
                    <div>
                        <h3 class = "login-find-title"><label>새로운 비밀번호</label></h3>
                        <span class = "box string-tel">
                        <input type = "password" id="memberPw" name = "memberPw" class = "string" maxlength = "16" style="width: 94%;" value="${memberPw}">
                    </span>

                    </div>

                    <div>
                        <h3 class = "login-find-title"><label>비밀번호 확인</label></h3>
                        <span class = "box string-tel">
                        <input type = "password" id="memberPwCheck" name = "memberPwCheck" class = "string" maxlength = "16" style="width: 94%;" value="${memberPwCheck}">
                    </span>

                    </div>

                </div>
                    <!-- 비밀번호 찾기 버튼 -->
                    <div class = "login-find-btn">
                        <button type = "button" onclick = "findPw()"> 비밀번호 찾기 </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

    <script>
        const findPw = () => {
            const memberId = document.getElementById("memberId").value;
            const memberTel = document.getElementById("memberTel").value;
            const memberPw = document.getElementById("memberPw").value;
            const memberPwCheck = document.getElementById("memberPwCheck").value;

            if (memberPw != memberPwCheck) {
                alert("비밀번호가 일치하지 않습니다.");
                return;
            }

            if (memberPw.length < 1) {
                alert("비밀번호를 입력해주세요");
                return;
            }

            if (memberPwCheck.length < 1) {
                alert("비밀번호 확인을 입력해주세요");
                return;
            }

            if (memberId.length < 1) {
                alert("아이디를 입력해주세요");
                return;
            }

            if (memberTel.length < 1) {
                alert("전화번호를 입력하주세요");
                return;
            }

            $.ajax({
                url: "/memberPwString",
                type: "put",
                // global: false,
                // dataType: "json",
                // contentType: 'application/json',
                data: {
                    memberId: memberId,
                    memberTel: memberTel,
                    memberPw: memberPw
                },
                success : function (result){
                    alert("비밀번호가 변경되었습니다.");
                    if (result.code == 0) {
                        location.replace("/auth/login");
                    }
                },
                error : function (){
                    alert("실패");
                }
            });
        };
    </script>
</html>