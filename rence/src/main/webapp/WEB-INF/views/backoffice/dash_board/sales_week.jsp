<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="titleSection">
	<h1>정산</h1>
</div>

<div class="boardWrap">
	<div class="boardWrap sales">
		<div class="titleSection sales">
			<h3>주간 정산</h3>
			<ul class="sales-mini-nav">
				<li id="sales-mini-nav-day" class="nav-item"><p>일일</p></li>
				<li id="sales-mini-nav-week" class="nav-item"><p>주간</p></li>
				<li id="sales-mini-nav-month" class="nav-item"><p>월간</p></li>
			</ul>
			<!-- END mini-nav -->
		</div>
		<!-- END titleSection sales -->

		<div id="this-week-sales" class="sales-state">
			<div class="sales-item">
				<p>매출 총이익</p>
				<span id="sales-income" class="sales-price">340000</span>
			</div>
			<div class="sales-item">
				<p>매출액</p>
				<span id="sales-revenue" class="sales-price">410000</span>
			</div>
			<div class="sales-item">
				<p>취소 금액</p>
				<span id="sales-cancel" class="sales-price">70000</span>
			</div>
		</div>
		<!-- END today-sales -->

		<div id="last-week-sales" class="sales-state">
			<div class="sales-item">
				<p>전주 매출 총이익</p>
				<span id="sales-income" class="sales-price">340000</span>
			</div>
			<div class="sales-item">
				<p>전주 매출액</p>
				<span id="sales-revenue" class="sales-price">410000</span>
			</div>
			<div class="sales-item">
				<p>전주 취소 금액</p>
				<span id="sales-cancel" class="sales-price">70000</span>
			</div>
		</div>
		<!-- END today-sales -->

		<div class="sales-state">
			<div class="sales-item">
				<p>매출 차이</p>
				<span>80000</span>
			</div>
		</div>
		<!--  -->
	</div>
	<!-- END boardWrap sales -->

	<div class="boardWrap all-sales-list">
		<div class="titleSection">
			<h3>정산 내역</h3>
		</div>
		<!-- END titleSection sales -->

		<div class="custom-table">
			<div class="ct-header">
				<div class="ct-header-cell">날짜</div>
				<div class="ct-header-cell">대여 공간</div>
				<div class="ct-header-cell">결제 금액</div>
				<div class="ct-header-cell">결제 방식</div>
				<div class="ct-header-cell">정산 여부</div>
			</div>
			<!-- END ct-header -->
			<div class="ct-body">
				<div class="ct-body-row">
					<div class="ct-body-cell">
						2022.10.28 10:00 ~ <br />2022.10.28 14:00
					</div>
					<div class="ct-body-cell">101호 개인 스터디룸</div>
					<div class="ct-body-cell">
						<p class="sales-price">40000</p>
					</div>
					<div class="ct-body-cell">선결제</div>
					<div class="ct-body-cell">
						<button class="ct-body-btn">미완료</button>
					</div>
				</div>
				<!-- END ct-body-row -->
				<div class="ct-body-row">
					<div class="ct-body-cell">
						2022.10.28 10:00 ~ <br />2022.10.28 14:00
					</div>
					<div class="ct-body-cell">101호 개인 스터디룸</div>
					<div class="ct-body-cell">
						<p class="sales-price">40000</p>
					</div>
					<div class="ct-body-cell">선결제</div>
					<div class="ct-body-cell">
						<button class="ct-body-btn">미완료</button>
					</div>
				</div>
				<!-- END ct-body-row -->
			</div>
			<!-- END ct-body -->
		</div>
		<!-- END custom-table -->
	</div>
	<!-- END boardWrap sales-list -->
</div>
<!-- END boardWrap -->