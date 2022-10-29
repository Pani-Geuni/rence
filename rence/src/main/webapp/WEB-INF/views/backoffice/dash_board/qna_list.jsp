<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />


<div class="titleSection">
	<h1>공간 관리</h1>
	<button id="btn-room-add" class="btn-room-add">추가</button>
	<ul class="mini-nav">
		<li><p id="mini-nav-list" class="nav-item" id="room-list">리스트</p></li>
		<li><p id="mini-nav-qna" class="nav-item" id="qna-list">문의</p></li>
		<li><p id="mini-nav-review" class="nav-item" id="review-list">후기</p></li>
	</ul>
	<!-- END mini-nav -->
</div>
<!-- END titleSection -->

<div class="boardWrap review">
	<div class="custom-table review">
		<div class="ct-header review">
			<div class="ct-header-cell review">처리 상태</div>
			<div class="ct-header-cell review">문의 공간</div>
			<div class="ct-header-cell review">문의 내용</div>
			<div class="ct-header-cell review">작성일</div>
			<div class="ct-header-cell review">답변</div>
		</div>
		<!-- END ct-header -->

		<div class="ct-body-row review">
			<div class="ct-body-cell review">
				<p class="review-process true">처리</p>
			</div>
			<div class="ct-body-cell review">
				<p>101호 개인 스터디름</p>
			</div>
			<div class="ct-body-cell review">
				<p>문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용문의내용 문의내용 문의내용 문의내용 문의내용
					문의내용 문의내용문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용문의내용 문의내용 문의내용 문의내용 문의내용
					문의내용 문의내용문의내용 문의내용 문의내용 문의내용</p>
			</div>
			<div class="ct-body-cell review">
				<p>2022.10.27</p>
			</div>
			<div class="ct-body-cell review">
				<button class="ct-body-btn review-edit">답변 수정</button>
			</div>
			<!-- END ct-body-cell -->
		</div>
		<!-- END ct-body-row -->
		<div class="ct-body-row review">
			<div class="ct-body-cell review">
				<p class="review-process false">미처리</p>
			</div>
			<div class="ct-body-cell review">
				<p>101호 개인 스터디름</p>
			</div>
			<div class="ct-body-cell review">
				<p>문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용문의내용 문의내용 문의내용 문의내용 문의내용
					문의내용 문의내용문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용문의내용 문의내용 문의내용 문의내용 문의내용
					문의내용 문의내용문의내용 문의내용 문의내용 문의내용</p>
			</div>
			<div class="ct-body-cell review">
				<p>2022.10.26</p>
			</div>
			<div class="ct-body-cell review">
				<button class="ct-body-btn review-add">답변 달기</button>
			</div>
			<!-- END ct-body-cell -->
		</div>
		<!-- END ct-body-row -->

		<!-- END custom-table -->

		<ul class="pagination">
			<li class="page-item">
				<button>
					<img src="${path}/resources/IMG/dash-board/ico-double-left.svg" alt="-10" />
				</button>
			</li>
			<li class="page-item">
				<button>
					<img src="${path}/resources/IMG/dash-board/ico-left.svg" alt="-1" />
				</button>
			</li>
			<li class="page-item"><button>1</button></li>
			<li class="page-item"><button>2</button></li>
			<li class="page-item"><button>3</button></li>
			<li class="page-item"><button>4</button></li>
			<li class="page-item"><button>5</button></li>
			<li class="page-item">
				<button>
					<img src="${path}/resources/IMG/dash-board/ico-right.svg" alt="+1" />
				</button>
			</li>
			<li class="page-item">
				<button>
					<img src="${path}/resources/IMG/dash-board/ico-double-right.svg" alt="+10" />
				</button>
			</li>
		</ul>
		<!-- END pagination -->
	</div>
</div>
<!-- END boardWrap review -->