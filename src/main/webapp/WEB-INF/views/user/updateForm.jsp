<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <form>
        <input type="hidden" id="id" value="${principal.user.id}" />
        <div class="form-group">
            <label for="userName">User Name : </label>
            <input type="text" value="${principal.user.userName}" class="form-control" placeholder="Enter User Name" id="userName" readonly>
        </div>
        <c:if test="${empty principal.user.oauth}">
        <div class="form-group">
             <label for="password">Password : </label>
             <input type="password" class="form-control" placeholder="Enter Password" id="password">
        </div>
        </c:if>
        <div class="form-group">
            <label for="email">Email : </label>
            <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter Email" id="email" readonly>
        </div>


    </form>

    <button id="btn-update" class="btn btn-primary">회원 수정 완료</button>

</div>

<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>
