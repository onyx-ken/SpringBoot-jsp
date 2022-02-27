<%--
  Created by IntelliJ IDEA.
  User: onyx
  Date: 2022-02-27
  Time: 오후 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>상품 목록</h2>
    </div>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary float-end" onclick="location.href='/basic/items/add'" type="button">상품등록</button>
        </div>
    </div>
    <hr class="my-4">
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
                <th>수량</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${itemAllList}">
            <tr>
                <td><a href="/basic/items/detail/${item.itemId}">${item.itemId}</a></td>
                <td><a href="/basic/items/detail/${item.itemId}">${item.itemName}</a></td>
                <td>${item.itemPrice}</td>
                <td>${item.itemQty}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div> <!-- /container -->
</body>
</html>