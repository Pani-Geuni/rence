<!-- ------------ -->
<!-- @author κΉμμ -->
<!--------------- -->
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
	
	<link rel="stylesheet" href="${path}/resources/CSS/common/common.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/office/header.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/common/footer.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/office/login.css" />
	
	
	<link rel="stylesheet" href="${path}/resources/CSS/office/my-page.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/office/mileage-page.css" />
	
	<script type="text/javascript" src="${path}/resources/JS/common/core.min.js"></script>
	<script type="text/javascript" src="${path}/resources/JS/common/sha256.min.js"></script>
	
	<script src="${path}/resources/JS/common/jquery-3.6.1.min.js"></script>
	<script src="${path}/resources/JS/common/jquery.cookie.js"></script>
	<script src="${path}/resources/JS/office/header.js"></script>
	<script src="${path}/resources/JS/office/user_popup.js"></script>
	
	<script src="${path}/resources/JS/office/my_page.js"></script>
	<script src="${path}/resources/JS/office/mileage_list.js"></script>
	
	<c:if test="${res.page eq 'reserve-list'}">
		<link rel="stylesheet" href="${path}/resources/CSS/office/reserve-list.css" />
		<script src="${path}/resources/JS/office/reserve_list.js"></script>
	</c:if>
	<c:if test="${res.page eq 'review'}">
		<link rel="stylesheet" href="${path}/resources/CSS/office/review-page.css" />
		<script src="${path}/resources/JS/office/review_page.js"></script>
	</c:if>
	<c:if test="${res.page eq 'question_list'}">
		<link rel="stylesheet" href="${path}/resources/CSS/office/question-page.css" />
		<script src="${path}/resources/JS/office/question_page.js"></script>
	</c:if>
	
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
                <input type="text" id="login-id" class="login-popup-input" placeholder="μμ΄λλ₯Ό μλ ₯νμΈμ." autocomplete="off"/>
                <input type="password" id="login-pw" class="login-popup-input" placeholder="λΉλ°λ²νΈλ₯Ό μλ ₯νμΈμ."/>
            </section>
            <section class="login-popup-btn-section">
                <input type="button" id="login-btn" value="λ‘κ·ΈμΈ">
                <div class="txt-btn-wrap">
                    <span id="go-find-id" class="txt-btn">μμ΄λ μ°ΎκΈ°</span>
                    <span id="go-find-pw" class="txt-btn">λΉλ°λ²νΈ μ°ΎκΈ°</span>
					<span class="txt-btn login-close">μ°½λ«κΈ°</span>
                </div>
            </section>
        </div>
        <!-- END LOGIN SECTION -->
        
        <!-- START JOIN SECTION -->
        <div id="join-section" class="blind">
            <section class="join-popup-title-section">
                <span>νμκ°μ</span>
            </section>
            <section class="join-popup-input-section">
                <div class="input-wrap">
                    <div class="input-check">
                        <input type="email" id="join-email" class="join-popup-input-short" placeholder="μ΄λ©μΌ" autocomplete="off"/>
                        <input type = "button" id="check_email" class="join-popup-check-btn" value="μΈμ¦νκΈ°"/>
                    </div>
                    <span class="warning-text blind">λ€μ μλν΄μ£ΌμΈμ.</span>
                </div>
                <div class="input-wrap">
                    <div class="input-check">
                        <input type="text" id="join-email-code" class="join-popup-input-short" placeholder="μΈμ¦λ²νΈ" autocomplete="off"/>
                        <input type = "button" id="check_email-code" class="join-popup-check-btn" value="νμΈ"/>
                    </div>
                    <span class="warning-text blind">λ€μ μλν΄μ£ΌμΈμ.</span>
                </div>
                <div class="input-wrap">
                    <div class="input-check">
                        <input type="text" id="join-id" class="join-popup-input-short" placeholder="μμ΄λ(μλ¬Έμ, μ«μλ§ μλ ₯ = 5~10μ))" autocomplete="off"/>
                        <input type = "button" id="check_id" class="join-popup-check-btn" value="μ€λ³΅νμΈ"/>
                    </div>
                    <span class="warning-text blind">μ΄λ―Έ μμ΄λκ° μ‘΄μ¬ν©λλ€.</span>
                </div>
                <div class="input-wrap">
                    <input type="password" id="join-pw" class="join-popup-input" placeholder="λΉλ°λ²νΈ(μλ¬Έ+μ«μ+νΉμλ¬Έμ = 8~10κΈμ)"/>
                    <span class="warning-text blind">λ€μ μλν΄μ£ΌμΈμ.</span>
                </div>
                <div class="input-wrap">
                    <input type="password" id="join-re-pw" class="join-popup-input" placeholder="λΉλ°λ²νΈ μ¬μλ ₯"/>
                    <span class="warning-text blind">λ€μ μλν΄μ£ΌμΈμ.</span>
                </div>
                <div class="input-wrap">
                    <input type="text" id="join-name" class="join-popup-input" placeholder="μ΄λ¦" autocomplete="off"/>
                </div>
                <div class="input-wrap">
                    <input type="text" id="join-tel" class="join-popup-input" placeholder="μ νλ²νΈ(-μμ΄ μλ ₯)" autocomplete="off"/>
                    <span class="warning-text blind">-μμ΄ μλ ₯νμΈμ.</span>
                </div>
                <div class="input-wrap">
                    <input type="text" id="join-birth" class="join-popup-input" placeholder="μλμμΌ(μ«μλ‘λ§ μλ ₯)" autocomplete="off"/>
                    <span class="warning-text blind">μ«μλ‘λ§ μλ ₯κ°λ₯ν©λλ€.</span>
                </div>
            </section>
            <section class="join-popup-btn-section">
                <input type="button" id="join-btn" value="νμκ°μ">
            </section>
        </div>
        <!-- END JOIN SECTION -->

        <!-- START FIND-ID SECTION -->
        <div id="find-id-section" class="find-section blind">
            <section class="find-popup-logo-section">
                <span>μμ΄λ μ°ΎκΈ°</span>
            </section>
            <section class="find-popup-input-section">
                <span class="find-guide-txt">νμκ°μ μ μλ ₯ν μ΄λ©μΌμ μλ ₯ν΄μ£ΌμΈμ.</span>
                <input type="email" id="find-id-email" class="find-popup-input" placeholder="μ΄λ©μΌμ μλ ₯νμΈμ." autocomplete="off"/>
            </section>
            <section class="find-popup-btn-section">
                <input type="button" id="find-id-btn" class="find-btn" value="λ©μΌ λ³΄λ΄κΈ°">
                <input type="button" id="find-id-close" class="p-close" value="μ°½λ«κΈ°">
            </section>
        </div>
        <!-- END FIND-ID SECTION -->

        <!-- START FIND-PW SECTION -->
        <div id="find-pw-section" class="find-section blind">
            <section class="find-popup-logo-section">
                <span>λΉλ°λ²νΈ μ°ΎκΈ°</span>
            </section>
            <section class="find-popup-input-section">
                <div class="email-wrap">
                    <span class="find-guide-txt">νμκ°μ μ μλ ₯ν μ΄λ©μΌμ μλ ₯ν΄μ£ΌμΈμ.</span>
                    <input type="email" id="find-pw-email" class="find-popup-input" placeholder="μ΄λ©μΌμ μλ ₯νμΈμ." autocomplete="off"/>
                </div>
                <div>
                    <span class="find-guide-txt">νμκ°μ μ μλ ₯ν μμ΄λλ₯Ό μλ ₯ν΄ μ£ΌμΈμ.</span>
                    <input type="text" id="find-pw-id" class="find-popup-input" placeholder="μμ΄λλ₯Ό μλ ₯νμΈμ." autocomplete="off"/>
                </div>
            </section>
            <section class="find-popup-btn-section">
                <input type="button" id="find-pw-btn" class="find-btn" value="λΉλ°λ²νΈ μ°ΎκΈ°">
                <input type="button" id="find-pw-close" class="p-close" value="μ°½λ«κΈ°">
            </section>
        </div>
        <!-- END FIND-PW SECTION -->

		<!-- START LOGOUT CONFIRM POPUP -->
		<div id="logout-popup" class="confirm-popup blind">
			<section class="confirm-txt-section">
				<span class="logout-txt">
					λ‘κ·Έμμ νμκ² μ΅λκΉ?<br><br>
                    λ‘κ·Έμμ μ λ©μΈνμ΄μ§λ‘ μ΄λλ©λλ€.
				</span>
			</section>
			<section class="confirm-btn-section">
                <div id="logout-btn" class="confirm-yesBtn">λ‘κ·Έμμ</div>
				<div id="logout-closeBtn" class="confirm-noBtn">λ«κΈ°</div>
			</section>
		</div>

		<!-- !!! MY PAGE !!! -->
		<!-- START MODIFY-PW SECTION -->
        <div id="modify-pw-section" class="modify-section blind">
            <section class="modify-popup-title-section">
                <span>λΉλ°λ²νΈ λ³κ²½</span>
            </section>
            <section class="modify-popup-input-section">
                <div class="modify-popup-input-list">
                    <div class="modify-popup-input-list-title">
                        <span class="modify-guide-txt">νμ¬ λΉλ°λ²νΈ</span>
                        <span class="modify-error-txt blind">νμ¬ λΉλ°λ²νΈμ μΌμΉνμ§μμ΅λλ€.</span>
                    </div>
                    <div class="modify-now-pw-check-section">
                        <input type="email" id="modify-pw-now" class="modify-popup-input-short" placeholder="νμ¬ λΉλ°λ²νΈλ₯Ό μλ ₯νμΈμ."/>
                        <input type="button" id="check-now-pw" class="modify-popup-check-btn" value="νμΈ"/>
                    </div>
                </div>

                <div class="modify-popup-input-list">
                    <div class="modify-popup-input-list-title">
                        <span class="modify-guide-txt">μ λΉλ°λ²νΈ νμΈ</span>
                        <span class="modify-error-txt blind">λΉλ°λ²νΈ μ‘°κ±΄μ μΌμΉνμ§μμ΅λλ€.</span>
                    </div>
                    <input type="password" id="modify-pw-new" class="modify-popup-input" placeholder="λΉλ°λ²νΈ(μλ¬Έ+μ«μ+νΉμλ¬Έμ = 8~10κΈμ)"/>
                </div>

                <div>
                    <div class="modify-popup-input-list-title">
                        <span class="modify-guide-txt">μ λΉλ°λ²νΈ νμΈ</span>
                        <span class="modify-error-txt blind">λΉλ°λ²νΈκ° μΌμΉνμ§μμ΅λλ€.</span>
                    </div>
                    <input type="password" id="modify-pw-renew" class="modify-popup-input" placeholder="λ³κ²½ν  λΉλ°λ²νΈλ₯Ό νμΈν΄ μ£ΌμΈμ."/>
                </div>
            </section>
            <section class="modify-popup-btn-section">
                <div id="modify-btn" class="modify-btn">μμ </div>
                <div id="modify-close-btn" class="modify-btn">λ«κΈ°</div>
            </section>
        </div>
        <!-- END MODIFY-PW SECTION -->

		<!-- START MODIFY PROFILE IMAGE -->
		<form action="/rence/user_img_updateOK" method="post" enctype="multipart/form-data">
			<div id="modify-img-section" class="confirm-popup blind">
				<section class="review-upload-section">
					<input type="text" class="review-upload-value" value="" readonly />
					<span class="review-upload-btn"> μ΄λ―Έμ§ λ±λ‘ </span> 
					<input type="file" class="file" name="multipartFile">
				</section>
				<section class="confirm-btn-section">
					<input type="submit" id="modify-img-modifyBtn" class="confirm-yesBtn" value="μμ ">
					<div id="modify-img-closeBtn" class="confirm-noBtn">λ«κΈ°</div>
				</section>
			</div>
		</form>
		<!-- END MODIFY PROFILE IMAGE -->
		
		<!-- START USER_DELETE CUSTOM CONFIRM POPUP -->
        <div id ="user-delete-confirm-popup" class="confirm-popup blind">
            <section class="confirm-txt-section">
                <span class="common-confirm-txt">νμ νν΄νμκ² μ΅λκΉ?</span>
            </section>
            <section class="confirm-btn-section">
                <div id="user-delete" class="confirm-yesBtn">νμΈ</div>
                <div id="user-delete-popup-close" class="confirm-noBtn">λ«κΈ°</div>
            </section>
        </div>


		<!-- !!! QUESTION PAGE !!! -->
		<!-- START Q-DELETE CONFIRM POPUP -->
        <div id ="q-delete-popup" class="confirm-popup blind">
            <section class="confirm-txt-section">
                <span class="logout-txt">
                    ν΄λΉ λκΈμ μ­μ νμκ² μ΅λκΉ?
                </span>
            </section>
            <section class="confirm-btn-section">
                <div id="q-delete-btn" class="confirm-yesBtn">μ</div>
                <div id="q-delete-closeBtn" class="confirm-noBtn">λ«κΈ°</div>
            </section>
        </div>
		
		<!-- START R-DELETE CONFIRM POPUP -->
		<div id="r-delete-popup" class="confirm-popup blind">
			<section class="confirm-txt-section">
				<span class="logout-txt"> ν΄λΉ νκΈ°λ₯Ό μ­μ νμκ² μ΅λκΉ? </span>
			</section>
			<section class="confirm-btn-section">
				<div id="r-delete-btn" class="confirm-yesBtn">μ</div>
				<div id="r-delete-closeBtn" class="confirm-noBtn">λ«κΈ°</div>
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
                <span>νμΈ</span>
            </section>
        </div>
        
		<!-- START SUCCESS CUSTOM ALERT POPUP -->
		<div id="success-alert-popup" class="alert-popup blind">
			<section class="alert-txt-section">
				<span>ν΄λΉ μ΄λ©μΌλ‘ λΉλ°λ²νΈλ₯Ό μ μ‘νμμ΅λλ€.</span>
			</section>
			<section id="success-alert-btn" class="alert-btn-section">
				<span>νμΈ</span>
			</section>
		</div>

		<!-- START FAIL CUSTOM ALERT POPUP -->
		<div id="fail-alert-popup" class="alert-popup blind">
			<section class="alert-txt-section">
				<span>ν΄λΉ μ΄λ©μΌλ‘ κ°μλ νμμ΄ μμ΅λλ€.</span>
			</section>
			<section id="fail-alert-btn" class="alert-btn-section">
				<span>νμΈ</span>
			</section>
		</div>
	</div>
</body>
</html>