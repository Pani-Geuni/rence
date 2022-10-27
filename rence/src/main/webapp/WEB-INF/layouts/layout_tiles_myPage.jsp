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

<link rel="stylesheet" href="${path}/resources/CSS/common.css" />
<link rel="stylesheet" href="${path}/resources/CSS/login.css" />
<link rel="stylesheet" href="${path}/resources/CSS/header.css" />
<link rel="stylesheet" href="${path}/resources/CSS/footer.css" />

<link rel="stylesheet" href="${path}/resources/CSS/reserve-list.css" />
<link rel="stylesheet" href="${path}/resources/CSS/my-page.css" />
<link rel="stylesheet" href="${path}/resources/CSS/mileage-page.css" />
<link rel="stylesheet" href="${path}/resources/CSS/question-page.css" />

<script src="${path}/resources/JS/jquery-3.6.1.min.js"></script>
<script src="${path}/resources/JS/user_popup.js"></script>
<script src="${path}/resources/JS/header.js"></script>
<script src="${path}/resources/JS/my_page.js"></script>
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
                <img src="../IMG/common/RENCE.svg" class="popup-logo">
            </section>
            <section class="login-popup-input-section">
                <input type="text" id="login-id" class="login-popup-input" placeholder="아이디를 입력하세요." autocomplete="off"/>
                <input type="password" id="login-pw" class="login-popup-input" placeholder="비밀번호를 입력하세요."/>
            </section>
            <section class="login-popup-btn-section">
                <input type="button" id="login-btn" value="로그인">
                <div class="txt-btn-wrap">
                    <span id="go-find-id" class="txt-btn">아이디 찾기</span>
                    <span id="go-find-pw" class="txt-btn">비밀번호 찾기</span>
					<span class="txt-btn login-close">창닫기</span>
                </div>
            </section>
        </div>
        <!-- END LOGIN SECTION -->
        
        <!-- START JOIN SECTION -->
        <div id="join-section" class="blind">
            <section class="join-popup-title-section">
                <span>회원가입</span>
            </section>
            <section class="join-popup-input-section">
                <div class="input-wrap">
                    <div class="input-check">
                        <input type="email" id="join-email" class="join-popup-input-short" placeholder="이메일" autocomplete="off"/>
                        <input type = "button" id="check_email" class="join-popup-check-btn" value="인증하기"/>
                    </div>
                    <span class="warning-text blind">다시 시도해주세요.</span>
                </div>
                <div class="input-wrap">
                    <div class="input-check">
                        <input type="text" id="join-email-code" class="join-popup-input-short" placeholder="인증번호" autocomplete="off"/>
                        <input type = "button" id="check_email-code" class="join-popup-check-btn" value="확인"/>
                    </div>
                    <span class="warning-text blind">다시 시도해주세요.</span>
                </div>
                <div class="input-wrap">
                    <div class="input-check">
                        <input type="text" id="join-id" class="join-popup-input-short" placeholder="아이디" autocomplete="off"/>
                        <input type = "button" id="check_id" class="join-popup-check-btn" value="중복확인"/>
                    </div>
                    <span class="warning-text">이미 아이디가 존재합니다.</span>
                </div>
                <input type="password" id="join-pw" class="join-popup-input" placeholder="비밀번호"/>
                <input type="password" id="join-re-pw" class="join-popup-input" placeholder="비밀번호 재입력"/>
                <input type="text" id="join-name" class="join-popup-input" placeholder="이름" autocomplete="off"/>
                <input type="text" id="join-tel" class="join-popup-input" placeholder="전화번호(-없이 입력)" autocomplete="off"/>
                <input type="text" id="join-birth" class="join-popup-input" placeholder="생년월일(숫자로만 입력)" autocomplete="off"/>
            </section>
            <section class="join-popup-btn-section">
                <input type="button" id="join-btn" value="회원가입">
            </section>
        </div>
        <!-- END LOGIN SECTION -->

        <!-- START FIND-ID SECTION -->
        <div id="find-id-section" class="find-section blind">
            <section class="find-popup-logo-section">
                <span>아이디 찾기</span>
            </section>
            <section class="find-popup-input-section">
                <span class="find-guide-txt">회원가입 시 입력한 이메일을 입력해주세요.</span>
                <input type="email" id="find-id-email" class="find-popup-input" placeholder="이메일을 입력하세요." autocomplete="off"/>
            </section>
            <section class="find-popup-btn-section">
                <input type="button" id="find-id-btn" class="find-btn" value="메일 보내기">
                <input type="button" id="find-id-close" class="p-close" value="창닫기">
            </section>
        </div>
        <!-- END FIND-ID SECTION -->

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
				<span class="logout-txt">로그아웃 하시겠습니까?</span>
			</section>
			<section class="confirm-btn-section">
				<div class="confirm-yesBtn">로그아웃</div>
				<div id="logout-closeBtn" class="confirm-noBtn">닫기</div>
			</section>
		</div>

		<!-- !!! MY PAGE !!! -->
		<!-- START MODIFY-PW SECTION -->
		<div id="modify-pw-section" class="modify-section blind">
			<section class="modify-popup-title-section">
				<span>비밀번호 변경</span>
			</section>
			<section class="modify-popup-input-section">
				<div class="modify-popup-input-list">
					<div class="modify-popup-input-list-title">
						<span class="modify-guide-txt">현재 비밀번호</span> <span
							class="modify-error-txt blind">현재 비밀번호와 일치하지않습니다.</span>
					</div>
					<input type="email" id="modify-pw-now" class="modify-popup-input"
						placeholder="현재 비밀번호를 입력하세요." />
				</div>

				<div class="modify-popup-input-list">
					<div class="modify-popup-input-list-title">
						<span class="modify-guide-txt">새 비밀번호 확인</span> <span
							class="modify-error-txt blind">비밀번호가 일치하지않습니다.</span>
					</div>
					<input type="text" id="modify-pw-new" class="modify-popup-input"
						placeholder="변경할 비밀번호를 입력해 주세요." />
				</div>

				<div>
					<div class="modify-popup-input-list-title">
						<span class="modify-guide-txt">새 비밀번호 확인</span> <span
							class="modify-error-txt blind">비밀번호가 일치하지않습니다.</span>
					</div>
					<input type="text" id="modify-pw-renew" class="modify-popup-input"
						placeholder="변경할 비밀번호를 확인해 주세요." />
				</div>
			</section>
			<section class="modify-popup-btn-section">
				<div id="modify-btn" class="modify-btn">수정</div>
			</section>
		</div>
		<!-- END MODIFY-PW SECTION -->

		<!-- START MODIFY PROFILE IMAGE -->
		<div id="modify-img-section" class="confirm-popup blind">
			<section class="review-upload-section">
				<input type="text" class="review-upload-value" value="" readonly />
				<span class="review-upload-btn"> 이미지 등록 </span> <input type="file"
					class="file">
			</section>
			<section class="confirm-btn-section">
				<div id="modify-img-modifyBtn" class="confirm-yesBtn">수정</div>
				<div id="modify-img-closeBtn" class="confirm-noBtn">닫기</div>
			</section>
		</div>
		<!-- END MODIFY PROFILE IMAGE -->


		<!-- !!! QUESTION PAGE !!! -->
		<!-- START Q-DELETE CONFIRM POPUP -->
		<div id="q-delete-popup" class="confirm-popup blind">
			<section class="confirm-txt-section">
				<span class="logout-txt"> 해당 댓글을 삭제하시겠습니까? </span>
			</section>
			<section class="confirm-btn-section">
				<div class="confirm-yesBtn">예</div>
				<div id="q-delete-closeBtn" class="confirm-noBtn">닫기</div>
			</section>
		</div>

		<!-- START 문의 수정 팝업창 -->
		<div id="question-popup" class="question-popup-wrap blind">
			<span class="question-popup-title">문의 수정하기</span>

			<section class="question-popup-type-select-wrap">
				<span class="question-popup-small-title">문의할 공간 타입</span>

				<!-- select 열 때 open-select추가 -->
				<div class="question-popup-select-val-wrap">
					<span class="question-popup-select-value"> 타입을 선택해 주세요 </span> <img
						src="../IMG/space-introduce/full-dropdown.svg" alt="full-dropdown"
						class="full-dropdown"></img>
				</div>

				<ul class="question-popup-select blind">
					<li class="question-popup-select-li">101호 (1인 데스크)</li>
					<li class="question-popup-select-li">102호 (1인 데스크)</li>
					<li class="question-popup-select-li">103호 (4인 미팅룸)</li>
					<li class="question-popup-select-li">104호 (1인 미팅룸)</li>
				</ul>
			</section>
			<section class="textarea-section">
				<textarea id="question-modify-write" class="question-write"></textarea>
			</section>
			<section class="quest-popup-btn-section">
				<span id="question-modify-btn" class="popup-create-btn">수정</span> <span
					id="question-close-btn" class="popup-close-btn">취소</span>
			</section>
		</div>
		<!-- END 문의 수정 팝업창 -->

	</div>

	<div class="popup-background blind">
		<!-- START SUCCESS CUSTOM ALERT POPUP -->
		<div id="success-alert-popup" class="alert-popup blind">
			<section class="alert-txt-section">
				<span>해당 이메일로 비밀번호를 전송하였습니다.</span>
			</section>
			<section id="success-alert-btn" class="alert-btn-section">
				<span>확인</span>
			</section>
		</div>

		<!-- START FAIL CUSTOM ALERT POPUP -->
		<div id="fail-alert-popup" class="alert-popup blind">
			<section class="alert-txt-section">
				<span>해당 이메일로 가입된 회원이 없습니다.</span>
			</section>
			<section id="fail-alert-btn" class="alert-btn-section">
				<span>확인</span>
			</section>
		</div>
	</div>
</body>
</html>