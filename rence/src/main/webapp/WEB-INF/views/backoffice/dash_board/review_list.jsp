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
	<div class="review-list">
		<div class="review-item">
			<div>
				<img class="profile-image" src="${path}/resources/IMG/header/loopy.jpg"
					alt="profile image" />
			</div>
			<!-- END profile Image -->
			<div class="review-main">
				<div class="review-header">
					<p id="user-name" class="user-name">팡근</p>
					<span id="review-point" class="review-point">5</span>
				</div>
				<!-- END review-header -->
				<div class="review-content">
					<pre>
혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !혼자공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !너무좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !너무좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !너무좋아요 !혼자 공부할 때 너무 좋아요 !
              </pre>
				</div>
				<!-- END review-content -->
				<span id="review-date" class="review-date">2022.10.27</span>
			</div>
			<!-- END review-main -->
		</div>
		<!-- END review-item -->

		<div class="review-item">
			<div>
				<img class="profile-image" src="${path}/resources/IMG/header/loopy.jpg"
					alt="profile image" />
			</div>
			<!-- END profile Image -->
			<div class="review-main">
				<div class="review-header">
					<p id="user-name" class="user-name">팡근</p>
					<span id="review-point" class="review-point">5</span>
				</div>
				<!-- END review-header -->
				<div class="review-content">
					<pre>
혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !혼자공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무좋아요 !혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !
              </pre>
				</div>
				<!-- END review-content -->
				<span id="review-date" class="review-date">2022.10.27</span>
			</div>
			<!-- END review-main -->
		</div>
		<!-- END review-item -->

		<div class="review-item">
			<div>
				<img class="profile-image" src="${path}/resources/IMG/header/loopy.jpg"
					alt="profile image" />
			</div>
			<!-- END profile Image -->
			<div class="review-main">
				<div class="review-header">
					<p id="user-name" class="user-name">팡근</p>
					<span id="review-point" class="review-point">5</span>
				</div>
				<!-- END review-header -->
				<div class="review-content">
					<pre>
혼자 공부할 때 너무 좋아요 !혼자 공부할 때 너무 좋아요 !
              </pre>
				</div>
				<!-- END review-content -->
				<span id="review-date" class="review-date">2022.10.27</span>
			</div>
			<!-- END review-main -->
		</div>
		<!-- END review-item -->

		<ul class="pagination blind">
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
	<!-- END review-list -->
</div>