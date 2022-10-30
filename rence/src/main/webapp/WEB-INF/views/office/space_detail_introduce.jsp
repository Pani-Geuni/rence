<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />	
	
<section class="space-detail-introduce-section">
	<div class="space-detail-introduce-wrap">
		<section class="space-detail-title-section">
			<span class="space-detail-company-name"> 오라운트 </span>
			<span class="space-detail-type">데스크</span>
		</section>
		<section class="space-detail-info-section">
			<div class="space-rating">
				<img src="${path}/resources/IMG/common/grey-star.svg" class="space-rating-icon" alt="space-rating-icon" />
				<span class="space-info-txt">4.32</span>
			</div>
			<div class="space-location">
				<img src="${path}/resources/IMG/common/location-icon.svg" class="space-location-icon" alt="space-location-icon" /> 
				<span class="space-info-txt">경기도 광주시</span>
			</div>
			<div class="space-tags">
				<span class="space-info-txt tag-txt">#경기광주</span> 
				<span class="space-info-txt tag-txt">#스터디룸</span> 
				<span class="space-info-txt tag-txt">#1인데스크</span> 
				<span class="space-info-txt tag-txt">#단독미팅룸</span>
			</div>
		</section>
		<section class="spage-imgs-section">
			<div class="window">
				<ul class="container">
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
					<li class="img">
						<img src="${path}/resources/IMG/common/18.jpg" class="company-img" />
					</li>
				</ul>

				<div class="button-container">
					<span class="prev button-size">&lt;</span>
					<span class="next button-size">></span>
				</div>
			</div>
		</section>
		<section class="dynamic-section">
			<!-- START un-fixed-section -->
			<section class="un-fixed-section">
				<section class="menu-tab-section">
					<ul class="menu-tab">
						<li class="menu click-menu" menu="info">공간 소개</li>
						<li class="menu" menu="qna">문의</li>
						<li class="menu" menu="review">후기</li>
					</ul>
				</section>

				<!-- 공간 소개 -->
				<div class="space-description-wrap">
					<span class="space-description"> 국가는 대외무역을 육성하며, 이를 규제·조정할 수
						있다. 선거운동은 각급 선거관리위원회의 관리하에 법률이 정하는 범위안에서 하되, 균등한 기회가 보장되어야 한다.
						대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 존중함을 기본으로 한다. 모든 국민은 근로의 의무를 진다.
						국가는 근로의 의무의 내용과 조건을 민주주의원칙에 따라 법률로 정한다.<br>
					<br> 국회의원은 국가이익을 우선하여 양심에 따라 직무를 행한다. 대법원장과 대법관이 아닌 법관은 대법관회의의
						동의를 얻어 대법원장이 임명한다. 국민경제자문회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 대통령이 궐위된
						때 또는 대통령 당선자가 사망하거나 판결 기타의 사유로 그 자격을 상실한 때에는 60일 이내에 후임자를 선거한다.<br>
					<br> 국가는 대외무역을 육성하며, 이를 규제·조정할 수 있다. 선거운동은 각급 선거관리위원회의 관리하에
						법률이 정하는 범위안에서 하되, 균등한 기회가 보장되어야 한다. 대한민국의 경제질서는 개인과 기업의 경제상의 자유와
						창의를 존중함을 기본으로 한다. 모든 국민은 근로의 의무를 진다. 국가는 근로의 의무의 내용과 조건을 민주주의원칙에
						따라 법률로 정한다.<br>
					<br> 국회의원은 국가이익을 우선하여 양심에 따라 직무를 행한다. 대법원장과 대법관이 아닌 법관은 대법관회의의
						동의를 얻어 대법원장이 임명한다. 국민경제자문회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 대통령이 궐위된
						때 또는 대통령 당선자가 사망하거나 판결 기타의 사유로 그 자격을 상실한 때에는 60일 이내에 후임자를 선거한다.<br>
					<br>
					</span>

					<div class="option-wrap">
						<label class="section-title"> 옵션 </label>
						<ul class="option-list-wrap">
							<li class="option-list">독서실 책상</li>
							<li class="option-list">4인 미팅룸</li>
							<li class="option-list">전자레인지</li>
							<li class="option-list">독서실 책상</li>
							<li class="option-list">4인 미팅룸</li>
							<li class="option-list">전자레인지</li>
							<li class="option-list">독서실 책상</li>
							<li class="option-list">4인 미팅룸</li>
							<li class="option-list">전자레인지</li>
							<li class="option-list">독서실 책상</li>
							<li class="option-list">4인 미팅룸</li>
							<li class="option-list">전자레인지</li>
						</ul>
					</div>

					<div class="around-info-wrap">
						<label class="section-title"> 주변 시설 </label>
						<ul id="" class="option-list-wrap">
							<li class="option-list">주차장</li>
							<li class="option-list">편의점</li>
						</ul>
					</div>
				</div>

				<!-- 문의 -->
				<div class="question-wrap blind">
					<section class="question-wrap-title">
						<section class="question-left">
							<span class="big-title">문의</span> <span class="small-title">3개</span>
						</section>
						<section id="question-create-btn" class="question-right">
							<span>문의하기</span>
						</section>

						<!-- 문의하기 팝업창 -->
                        <div id="question-popup" class="question-popup-wrap blind">
                            <span class="question-popup-title">문의하기</span>

                            <section class="question-popup-type-select-wrap">
                                <span class="question-popup-small-title">문의할 공간 타입</span>

                                <!-- select 열 때 open-select추가 -->
                                <div class="question-popup-select-val-wrap">
                                    <span class="question-popup-select-value">
                                        타입을 선택해 주세요
                                    </span>
                                    <img src="${path}/resources/IMG/space-introduce/full-dropdown.svg" alt="full-dropdown" class="full-dropdown"></img>
                                </div>

                                <ul class="question-popup-select blind">
                                    <li class="question-popup-select-li">
                                        101호 (1인 데스크)
                                    </li>
                                    <li class="question-popup-select-li">
                                        102호 (1인 데스크)
                                    </li>
                                    <li class="question-popup-select-li">
                                        103호 (4인 미팅룸)
                                    </li>
                                    <li class="question-popup-select-li">
                                        104호 (1인 미팅룸)
                                    </li>
                                </ul>
                            </section>
                            <section class="textarea-section">
                                <textarea id="question-write" class="question-write"></textarea>
                                <div class="txt-length-wrap">
                                    <span class="qna-length">0</span>
                                    <span class="total-length">/ 500</span>
                                </div>
                            </section>
                            <section class="quest-popup-btn-section">
                                <span id="question-create-btn" class="popup-create-btn">등록</span>
                                <span id="question-close-btn" class="popup-close-btn">취소</span>
                            </section>
                        </div>
					</section>

					<section class="quest-list-section">
						<ul class="quest-list-wrap">
							<li class="quest-list">
								<section>
									<img src="${path}/resources/IMG/header/loopy.jpg" alt="write-user-img" class="write-user-img" />
								</section>
								<section class="quest-content-section">
									<ul class="quest-content-wrap">
										<li class="quest-content-list quest-content-writer">팡근</li>
										<li class="quest-content-list quest-content">장기 예약 문의도 가능할까요?</li>
										<li class="quest-content-list quest-content-date">2022.10.21</li>
									</ul>
								</section>
								<section class="answer-section"></section>
							</li>
						</ul>
					</section>
				</div>

				<!-- 후기 -->
				<div id="review-wrap" class="question-wrap blind">
					<section class="question-wrap-title">
						<section class="question-left">
							<span class="big-title">후기</span> <span class="small-title">3개</span>
						</section>
						<section id="review-write-btn" class="question-right">
							<span>후기쓰기</span>
						</section>

						<!-- 후기쓰기 팝업창 -->
                        <div id="review-popup" class="review-popup-wrap blind">
                            <span class="question-popup-title">후기 남기기</span>

                            <section class="question-popup-type-select-wrap">
                                <span class="question-popup-small-title">문의할 공간 타입</span>

                                <!-- select 열 때 open-select추가 -->
                                <div class="question-popup-select-val-wrap">
                                    <span class="question-popup-select-value">
                                        선택했던 타입명
                                    </span>
                                </div>
                            </section>
                            <section class="textarea-section">
                                <textarea id="review-write" class="question-write"></textarea>
                                <div class="txt-length-wrap">
                                    <span class="review-length">0</span>
                                    <span class="review-total-length">/ 500</span>
                                </div>
                            </section>
                            <section class="popup-star-section">
                                <span class="popup-star-title">별점</span>
                                <ul class="popup-star-wrap">
                                    <li class="popup-star-li sample">
                                        <img src="${path}/resources/IMG/common/y-star.svg" alt="후기 리뷰 별점 이미지" class="y-star r-star blind" />
                                        <img src="${path}/resources/IMG/common/star.svg" alt="후기 리뷰 별점 이미지" class="g-star r-star"/>
                                    </li>
                                    <li class="popup-star-li">
                                        <img src="${path}/resources/IMG/common/y-star.svg" alt="후기 리뷰 별점 이미지" class="y-star r-star blind"/>
                                        <img src="${path}/resources/IMG/common/star.svg" alt="후기 리뷰 별점 이미지" class="g-star r-star"/>
                                    </li>
                                    <li class="popup-star-li">
                                        <img src="${path}/resources/IMG/common/y-star.svg" alt="후기 리뷰 별점 이미지" class="y-star r-star blind"/>
                                        <img src="${path}/resources/IMG/common/star.svg" alt="후기 리뷰 별점 이미지" class="g-star r-star"/>
                                    </li>
                                    <li class="popup-star-li">
                                        <img src="${path}/resources/IMG/common/y-star.svg" alt="후기 리뷰 별점 이미지" class="y-star r-star blind"/>
                                        <img src="${path}/resources/IMG/common/star.svg" alt="후기 리뷰 별점 이미지" class="g-star r-star"/>
                                    </li>
                                    <li class="popup-star-li">
                                        <img src="${path}/resources/IMG/common/y-star.svg" alt="후기 리뷰 별점 이미지" class="y-star r-star blind"/>
                                        <img src="${path}/resources/IMG/common/star.svg" alt="후기 리뷰 별점 이미지" class="g-star r-star"/>
                                    </li>
                                </ul>
                            </section>
                            <section class="review-upload-section">
                                <span class="review-upload-btn">
                                    이미지 등록
                                </span>
                                <input type="file" class="file">
                                <input type="text" class="review-upload-value" readonly/>
                            </section>
                            <section class="quest-popup-btn-section">
                                <span id="review-create-btn" class="popup-create-btn">등록</span>
                                <span id="review-close-btn" class="popup-close-btn">취소</span>
                            </section>
                        </div>
					</section>

					<section class="quest-list-section">
						<ul class="quest-list-wrap">
							<li class="quest-list">
								<section>
									<img src="${path}/resources/IMG/header/loopy.jpg" alt="write-user-img" class="write-user-img" />
								</section>
								<section class="quest-content-section">
									<ul class="quest-content-wrap">
										<li class="quest-content-list quest-content-writer">
											<span class="quest-writer">팡근</span> 
											
											<span class="review-star-wrap">
												<img src="${path}/resources/IMG/common/star.svg" class="review-star-img" alt="review-star-img" /> 
												<span class="review-star-num">4</span>
											</span>
										</li>
										<li class="quest-content-list quest-content">혼자 공부할 때 너무 좋아요!</li>
										<li class="quest-content-list quest-content-date">2022.10.21</li>
									</ul>
								</section>
							</li>
						</ul>
					</section>
				</div>
			</section>
			<!-- END un-fixed-section -->

			<!-- START fixed-section -->
			<section class="fixed-section">
				<section class="fixed-popup blind">
					<div class="alert-popup">
						<section class="alert-txt-section">
							<span class="using-time-fail.txt"> 
								해당 시간 예약이 불가능합니다.<br>
								<br>다른 시간대를 선택하여 주십시오.
							</span>
						</section>
						<section id="time-fail-close-btn" class="alert-btn-section">
							<span>확인</span>
						</section>
					</div>
				</section>

				<section class="fixed-section-top">
					<section class="running-time-section">
						<label class="fixed-section-label"> 운영 시간 </label>
						<ul class="running-time-li-wrap">
							<li class="running-time-li">
								<label>일</label> 
								<span>11:00 ~ 24:00</span>
							</li>
							<li class="running-time-li">
								<label>월</label> 
								<span>11:00 ~ 24:00</span>
							</li>
							<li class="running-time-li">
								<label>화</label> 
								<span>11:00 ~ 24:00</span>
							</li>
							<li class="running-time-li">
								<label>수</label> 
								<span>11:00 ~ 24:00</span>
							</li>
							<li class="running-time-li">
								<label>목</label> 
								<span>11:00 ~ 24:00</span>
							</li>
							<li class="running-time-li">
								<label>금</label> 
								<span>11:00 ~ 24:00</span>
							</li>
							<li class="running-time-li">
								<label>토</label> 
								<span>11:00 ~ 24:00</span>
							</li>
						</ul>
					</section>
					<section class="type-location-txt">
						<div class="space-type-loca">
							<label class="fixed-section-label"> 공간 유형 </label> 
							<span class="fixed-section-txt"> 데스크 </span>
						</div>
						<div class="space-type-loca">
							<label class="fixed-section-label"> 위치 </label>
							<div class="fixed-section-loca">
								<img src="${path}/resources/IMG/common/location-icon.svg" class="space-loca-icon" alt="location-icon"> 
								<span class="fixed-section-txt"> 경기도 광주시 </span>
							</div>
						</div>
					</section>
				</section>
				<section class="reserve-type-section">
					<label class="fixed-section-label"> 예약 타입 </label>

					<!-- 타입 셀렉트 열 때 open-select클래스 add해야함 -->
					<!-- 타입 셀렉트 닫을 때 open-select클래스 remove해야함 -->
					<div class="type-border">
						<span class="type-border-txt">타입을 선택해주세요.</span> 
						<img src="${path}/resources/IMG/space-introduce/full-dropdown.svg" alt="full-dropdown" class="full-dropdown"></img>
					</div>

					<!-- CUSTOM SELECT SECTION -->
					<ul class="custom-select-type blind">
						<li class="custom-select-type-list">
							<span class="room-name"> 101호 (1인 데스크) </span> 
							<span class="room-price-unit"> 
								<span class="room-price-big"> 10,000원 </span> 
								<span class="room-unit-small"> /시간 </span> 
							</span>
						</li>
					</ul>
				</section>
				<section class="using-time-section">
					<section class="time-boundary">
						<label class="fixed-section-label"> 체크인 시간 </label>
						<div class="time-select-wrap">
							<input type="text" class="type-border-txt time-input" placeholder="날짜/시간 추가" readonly /> 
							<img src="${path}/resources/IMG/space-introduce/full-dropdown.svg" alt="full-dropdown" class="full-dropdown"></img>
						</div>
					</section>
					<section class="time-boundary">
						<label class="fixed-section-label"> 체크아웃 시간 </label>
						<div class="time-select-wrap">
							<input type="text" class="type-border-txt time-input" placeholder="날짜/시간 추가" readonly /> 
							<img src="${path}/resources/IMG/space-introduce/full-dropdown.svg" alt="full-dropdown" class="full-dropdown"></img>
						</div>
					</section>
				</section>
				<section class="maybe-pay-section blind">
					<label class="fixed-section-label"> 예상 결제 금액 </label> 
					<span class="fixed-section-label"> 40,000원 </span>
				</section>
				<section class="contact-section">
					<div class="contact-wrap">
						<img src="${path}/resources/IMG/space-introduce/tel.svg" alt="contact-img" class="contact-img" /> 
						<span>전화 문의</span>
					</div>
					<div class="contact-wrap">
						<img src="${path}/resources/IMG/space-introduce/mail.svg" alt="contact-img" class="contact-img" />
						<span>메일 문의</span>
					</div>
				</section>
				<section class="btn-section">
					<span>예약 가능 여부 확인하기</span>
				</section>
			</section>
			<!-- END fixed-section -->
		</section>
	</div>
</section>