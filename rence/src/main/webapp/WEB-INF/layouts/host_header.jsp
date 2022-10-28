<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
    
 <section class ="headerWrap">
     <div class = "logo-section">
         <img src="${path}/resources/IMG/common/RENCE-Host.svg" class="logo-mku">
     </div>
     
     <div class="hostMenu-section ">
     	<c:if test="${user_id eq null}">
	         <!-- 로그인 전 유저 메뉴 -->
	         <section id="before_login" class="">
	             <div id = "before_hostMenu" class ="hostMenu">
	                 <img src="${path}/resources/IMG/header/user_menu.svg" alt="user_menu_img" class="user_menu_img"/>
	                 <img src="${path}/resources/IMG/header/bx_user-circle.png" alt="user_profile_img" class="user_profile_img"/>
	             </div>
	             
	             <!-- CUSTOM SELECT -->
	             <div class = "custom-select-host blind">
	                 <ul class="user-select-wrap">
	                     <li id = "go-login" class="host-select-list">로그인</li>
	                     <li id = "go-backOffice" class="host-select-list">공간등록신청</li>
	                     <li id = "go-user-home" class="host-select-list">Rence 이동</li>
	                 </ul>
	             </div>
	         </section>
     	</c:if>
         
       	<c:if test="${user_id ne null}">
	         <!-- 로그인 후 유저 메뉴 -->
	         <section id="after_login"  class="">
	             <div id = "after_hostMenu" class ="hostMenu">
	                 <img src="${path}/resources/IMG/header/user_menu.svg" alt="user_menu_img" class="user_menu_img"/>
	                 <img src="${path}/resources/IMG/header/loopy.jpg" alt="user_profile_img" class="user_profile_img"/>
	             </div>
	
	             <!-- CUSTOM SELECT -->
	             <div class = "custom-select-host blind">
	                 <ul class="host-select-wrap">
	                     <li id = "go-myPage" class="host-select-list">마이페이지</li>
	                     <li id = "go-backOffice" class="host-select-list">공간등록신청</li>
	                     <li id = "go-logOut" class="host-select-list">로그아웃</li>
	                 </ul>
	             </div>
	         </section>
         </c:if>
     </div>
 </section>