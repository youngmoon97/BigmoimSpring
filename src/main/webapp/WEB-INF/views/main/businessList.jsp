<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
        language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>categoryListTEST</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="categoryList">
                <h1>CATEGORY LIST</h1>
                <hr/>
                <ul id="sortable" class="list-unstyled">
                    <c:forEach items="${businessList}" var="business">
                        <li class="ui-state-default">
                            <label>
                                <span>${business.businessNum}</span>
                                <span>${business.businessName}</span>
                            </label>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
<script>


</script>
</html>
