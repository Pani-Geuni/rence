<!-- ------------ -->
<!-- @author 전판근 -->
<!-- ------------ -->

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
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	    function sample4_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
 	            	var roadAddr = data.roadAddress; // 도로명 주소 변수
	            	var auto_roadAddr = data.autoRoadAddress; // 도로명 주소 변수
	            	var extraRoadAddr = ''; // 참고 항목 변수

	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                
	                console.log(roadAddr);

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                $('#zipcode').val(data.zonecode);
	                
	                if(roadAddr.length > 0)
	                	$('#roadname_address').val(roadAddr);
	                else
	                	$('#roadname_address').val(auto_roadAddr);
	                	
	                $('#number_address').val(data.jibunAddress);
	
	            }
	        }).open();
	    }
	</script>
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
					<span id="host-login-close" class="txt-btn login-close">창닫기</span>
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
	            id="find-pw-backoffice-code"
	            class="find-popup-input"
	            placeholder="사업자 등록 번호를 입력하세요."
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
	          id="find-pw-close"
	          class="find-pw-close"
	          value="창닫기"
	        />
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