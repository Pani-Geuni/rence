<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title"></tiles:getAsString></title>
	<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
	
	<!-- crypto library script -->
	<script type="text/javascript" src="${path}/resources/JS/common/core.min.js"></script>
    <script type="text/javascript" src="${path}/resources/JS/common/sha256.min.js"></script>
	
	<link rel="stylesheet" href="${path}/resources/CSS/common/common.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/common/footer.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/common/custom-timepicker.css" />
	
	<link rel="stylesheet" href="${path}/resources/CSS/backoffice/host-login.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/backoffice/host-header.css" />	
	<link rel="stylesheet" href="${path}/resources/CSS/backoffice/host-landing.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/backoffice/host-insert.css" />
	
	<script src="${path}/resources/JS/common/jquery-3.6.1.min.js"></script>
	<script src="${path}/resources/JS/common/jquery.cookie.js"></script>
	<script src="${path}/resources/JS/backoffice/host_header.js"></script>
	<script src="${path}/resources/JS/backoffice/host_popup.js"></script>
	<script src="${path}/resources/JS/backoffice/host_insert.js"></script>
	<script src="${path}/resources/JS/backoffice/custom-image-input.js"></script>

	<!-- timepicker library script -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

</head>
<body>
	<div class="pageWrap">
		<tiles:insertAttribute name="header" />
		<section class="contentWrap">
			<tiles:insertAttribute name="content" />
			<tiles:insertAttribute name="footer" />
		</section>
	</div>

	<div class="popup-background blind">
       <!-- START LOGIN SECTION -->
        <div id="login-section" class="blind">
            <section class="login-popup-logo-section">
                <img src="${path}/resources/IMG/common/RENCE.svg" class="popup-logo">
            </section>
            <section class="login-popup-input-section">
                <input type="text" id="login-id" class="login-popup-input" placeholder="아이디를 입력하세요." autocomplete="off"/>
                <input type="password" id="login-pw" class="login-popup-input" placeholder="비밀번호를 입력하세요."/>
            </section>
            <section class="login-popup-btn-section">
                <input type="button" id="login-btn" value="로그인">
                <div class="txt-btn-wrap">
                    <span id="go-find-pw" class="txt-btn">비밀번호 찾기</span>
					<span class="txt-btn login-close">창닫기</span>
                </div>
            </section>
        </div>
        <!-- END LOGIN SECTION -->
        
        <!-- START FIND-PW SECTION -->
	    <div id="find-pw-section" class="find-section blind">
	      <section class="find-popup-logo-section">
	        <span>비밀번호 찾기</span>
	      </section>
	      <section class="find-popup-input-section">
	        <div class="email-wrap">
	          <span class="find-guide-txt">사업자 이메일을 입력해주세요.</span>
	          <input
	            type="email"
	            id="find-pw-email"
	            class="find-popup-input"
	            placeholder="이메일을 입력하세요."
	          />
	        </div>
	        <div>
	          <span class="find-guide-txt">사업자 등록 번호를 입력해 주세요.</span>
	          <input
	            type="text"
	            id="find-pw-id"
	            class="find-popup-input"
	            placeholder="비밀번호를 입력하세요."
	          />
	        </div>
	      </section>
	      <section class="find-popup-btn-section">
	        <input
	          type="button"
	          id="find-pw-btn"
	          class="find-btn"
	          value="비밀번호 찾기"
	        />
	        <input
	          type="button"
	          id=""
	          class="find-pw-close"
	          value="창닫기"
	        />
	      </section>
	    </div>
	    <!-- END FIND-PW SECTION -->
        

        <!-- START FIND-PW SECTION -->
        <div id="find-pw-section" class="find-section blind">
            <section class="find-popup-logo-section">
                <span>비밀번호 찾기</span>
            </section>
            <section class="find-popup-input-section">
                <div class="email-wrap">
                    <span class="find-guide-txt">회원가입 시 입력한 이메일을 입력해주세요.</span>
                    <input type="email" id="find-pw-email" class="find-popup-input" placeholder="이메일을 입력하세요." autocomplete="off"/>
                </div>
                <div>
                    <span class="find-guide-txt">회원가입 시 입력한 아이디를 입력해 주세요.</span>
                    <input type="text" id="find-pw-id" class="find-popup-input" placeholder="아이디를 입력하세요." autocomplete="off"/>
                </div>
            </section>
            <section class="find-popup-btn-section">
                <input type="button" id="find-pw-btn" class="find-btn" value="비밀번호 찾기">
                <input type="button" id="find-pw-close" class="p-close" value="창닫기">
            </section>
        </div>
        <!-- END FIND-PW SECTION -->

		<!-- START LOGOUT CONFIRM POPUP -->
		<div id="logout-popup" class="confirm-popup blind">
			<section class="confirm-txt-section">
				<span class="logout-txt">
					로그아웃 하시겠습니까?<br><br>
                    로그아웃 시 메인페이지로 이동됩니다.
				</span>
			</section>
			<section class="confirm-btn-section">
                <div id="logout-btn" class="confirm-yesBtn">로그아웃</div>
				<div id="logout-closeBtn" class="confirm-noBtn">닫기</div>
			</section>
		</div>
		<!-- END logout popup -->
		
		<!-- START FAIL CUSTOM ALERT POPUP -->
		<div id="fail-alert-popup" class="alert-popup blind">
			<section class="alert-txt-section">
				<span>올바른 정보를 입력해 주세요.</span>
			</section>
			<section id="fail-alert-btn" class="alert-btn-section">
				<span>확인</span>
			</section>
		</div>
	</div>
	
	<div class="popup-background blind">
    	<!-- START COMMON CUSTOM ALERT POPUP -->
        <div id ="common-alert-popup" class="alert-popup blind">
            <section class="alert-txt-section">
                <span class="common-alert-txt"></span>
            </section>
            <section id = "common-alert-btn" class="alert-btn-section">
                <span>확인</span>
            </section>
        </div>
   	</div>
</body>
</html>