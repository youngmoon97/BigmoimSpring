<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기 페이지</title>
    <link rel="stylesheet" href="/css/idFind.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="login-find-wrapper">
    <div class="login-find-content">
        <div class="login-find-header">
            <h1>아이디 찾기</h1>
        </div>
        <!-- 이름 -->
        <%--<form name="idfind" method="post" action="">--%>
            <div class="login-find-input">
                <div>
                    <h3 class="login-find-title"><label>이름</label></h3>
                    <span class="box string-name">
                            <input type="text" name="memberName" id="memberName" class="string" maxlength="20" value="${memberName}">
                        </span>
                </div>
                <div>
                    <h3 class="login-find-title"><label>전화번호</label></h3>
                    <span class="box string-tel">
                            <input type="text" name="memberTel" id="memberTel" class="string" maxlength="16" value="${memberTel}">
                        </span>
                </div>
            </div>
            <div class="login-find-btn">
                <button type="button" onclick="findId()"> 아이디 찾기</button>
            </div>
        <%--</form>--%>
    </div>
</div>
</body>
<script type="text/javascript">
    const validateFields = () => {
        // id속성으로 요소를 가져옴
        const nameElement = document.getElementById("memberName");
        const telElement = document.getElementById("memberTel");

        if (nameElement.value === "") {
            alert("이름를 입력해주세요.");
            nameElement.focus();
            return false;
        }

        if (telElement.value === "") {
            alert("전화번호를 입력해주세요.");
            telElement.focus();
            return false;
        }



    };




    const findId = () => {
        const memberName = document.getElementById("memberName").value;
        const memberTel = document.getElementById("memberTel").value;

        if (memberName === "") {
            alert("이름를 입력해주세요.");
            memberName.focus();
            return false;
        }

        if (memberTel === "") {
            alert("전화번호를 입력해주세요.");
            memberTel.focus();
            return false;
        }

        console.log(memberName);
        console.log(memberTel);

        $.ajax({
            url: "/memberIdString",
            type: "get",
            // global: false,
            //dataType: "json",
            // async : false,
            //contentType: 'application/json',
            data: {
                memberName: memberName,
                memberTel: memberTel
            },
            success : function(result){
                alert("회원님의 아이디는 " + result.data + " 입니다");
                if (result.code == 0) {
                    location.replace("/auth/login");
                }
            },
            error : function (){
                alert("실패");
            }
        });


        // if(!validateFields()){
        //     return;
        // }
        //
        // const nameElement = document.getElementById("memberName");
        // const telElement = document.getElementById("memberTel");
        // const formTag = document.createElement("form");
        // formTag.action="/login-process";
        // formTag.method="POST"
        //
        // const nameInputTag = document.createElement("input");
        // nameInputTag.type = "hidden";
        // nameInputTag.name = "memberName";
        // nameInputTag.value = nameElement.value;
        // formTag.appendChild(nameInputTag);
        // // pw
        // const telInputTag = document.createElement("input");
        // telInputTag.type = "hidden";
        // telInputTag.name = "memberTel";
        // telInputTag.value = telElement.value;
        // formTag.appendChild(telInputTag);
        //
        // document.body.appendChild(formTag);
        // formTag.submit();
    };
</script>
</html>
