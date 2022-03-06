<%--
  Created by IntelliJ IDEA.
  User: onyx
  Date: 2022-02-27
  Time: 오후 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 560px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="py-5 text-center">
        <h2>상품 등록 폼</h2>
    </div>
    <h4 class="mb-3">상품 입력</h4>
    <form action="/basic/items/add" method="post" id="itemVO">
        <spring:hasBindErrors name="itemVO">
            <c:if test="${errors.hasFieldErrors('itemPrice') }">
                <strong>${errors.getFieldError( 'itemPrice' ).defaultMessage }</strong>
            </c:if>
        </spring:hasBindErrors>
        <div>
            <label for="itemName">상품명</label>
            <input type="text" id="itemName" name="itemName" class="form-control" placeholder="이름을 입력하세요" value="${itemVO.itemName}">
            <spring:hasBindErrors name="itemVO">
            <c:if test="${errors.hasFieldErrors('itemName') }">
                <strong>${errors.getFieldError( 'itemName' ).defaultMessage }</strong>
            </c:if>
            </spring:hasBindErrors>

        </div>
        <div>
            <label for="itemPrice">가격</label>
            <input type="text" id="itemPrice" name="itemPrice" class="form-control" placeholder="가격을 입력하세요" value="${itemVO.itemPrice}">
            <spring:hasBindErrors name="itemVO">
            <c:if test="${errors.hasFieldErrors('itemPrice') }">
                <strong>${errors.getFieldError( 'itemPrice' ).defaultMessage }</strong>
            </c:if>
            </spring:hasBindErrors>
        </div>
        <div>
            <label for="itemQty">수량</label>
            <input type="text" id="itemQty" name="itemQty" class="form-control" placeholder="수량을 입력하세요">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">상품 등록</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg"
                        onclick="location.href='/basic/items'" type="button">취소</button>
            </div>
        </div>
    </form>
</div> <!-- /container -->
</body>
</html>