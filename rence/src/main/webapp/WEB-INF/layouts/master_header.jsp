<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!-- ******************* -->
<!-- Master Header SECTION -->
<!-- ******************* -->
<section class="headerWrap">
	<div class = "logo-section">
         <img src="${path}/resources/IMG/common/Rence-Master.svg" class="logo-mku">
     	</div>

	<ul class="header-nav-list">
		<li id="nav-item-agree" class="header-nav-item">업체 신청 업무</li>
		<li id="nav-item-delete" class="header-nav-item">업체 탈퇴 업무</li>
		<li class="header-nav-item">
			<button id="btn-logout" class="btn-logout">로그아웃</button>
		</li>
	</ul>
</section>