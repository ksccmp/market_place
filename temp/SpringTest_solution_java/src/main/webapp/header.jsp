<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/css/basic.css" var="css"></c:url>
<link rel="stylesheet" href="${css }">
<c:if test="${not empty loginUser }">
	${loginUser.id }님 로그인되었습니다. <a href="/BoardSpringMVCMybatis/logout.do">로그아웃</a>
</c:if>
<h1>${title }</h1>
	
<script src="<c:url value='/js/jquery-3.3.1.js'/>"></script>