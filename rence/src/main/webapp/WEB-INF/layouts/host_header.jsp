<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%
	Cookie[] cookies = request.getCookies(); //client에서 쿠키를 받아옴
	
	String host_image = "";
	
	if(cookies!=null){
	    for(int i=0;i<cookies.length;i++){
	        if(cookies[i].getName().equals("host_image")){
	        	host_image = cookies[i].getValue();
	        }
	    }
	}
%>
    
 <section class ="headerWrap">
     <div class = "logo-section">
         <img src="${path}/resources/IMG/common/RENCE-Host.svg" class="logo-mku">
     </div>
     
     <div class="hostMenu-section ">
     	<c:if test="${backoffice_id eq null}">
	         <!-- 로그인 전 유저 메뉴 -->
	         <section id="before_login" class="">
	             <div id = "before_hostMenu" class ="hostMenu">
	                 <img src="${path}/resources/IMG/header/user_menu.svg" alt="host_menu_img" class="host_menu_img"/>
	                 <img src="${path}/resources/IMG/header/bx_user-circle.png" alt="host_profile_img" class="host_profile_img"/>
	             </div>
	             
	             <!-- CUSTOM SELECT -->
	             <div class = "custom-select-host blind">
	                 <ul class="host-select-wrap">
	                     <li id = "go-login" class="host-select-list">로그인</li>
	                     <li id = "go-backOffice" class="host-select-list">호스트등록신청</li>
	                     <li id = "go-user-home" class="host-select-list">Rence로 이동</li>
	                 </ul>
	             </div>
	         </section>
     	</c:if>
         
       	<c:if test="${backoffice_id ne null}">
	         <!-- 로그인 후 유저 메뉴 -->
	         <section id="after_login"  class="">
	             <div id = "after_hostMenu" class ="hostMenu">
	                 <img src="${path}/resources/IMG/header/user_menu.svg" alt="host_menu_img" class="host_menu_img"/>
	                 <img src="${path}/resources/upload/<%= host_image %>" alt="host_profile_img" class="host_profile_img"/>
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