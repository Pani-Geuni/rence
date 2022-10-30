<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="mileage-list-wrap">
    <div class="reserve-list">
        <section class="page-title-section">
            <span class="page-title">지금까지 쌓인 마일리지를 확인하세요</span>
        </section>

        <section class="mileage-section">
            <section class="mileage-section">
                <section class="mileage">
                    <span class="mileage-label">현재 마일리지</span>
                    <span id="now-mileage" class="mileage-won">4,836 원</span>
                </section>
            </section>
        </section>

        <section class="mileage-list-section">
            <section class="mileage-list-menu">
                <span class="menus choice">전체</span>
                <span class="menus un-choice">적립</span>
                <span class="menus un-choice">사용</span>
                <span class="menus un-choice">예정</span>
            </section>

            <section class="mileage-history-section">
                <section class="mileage-history-title-section">
                    <div class="list-title-txt-wrap">
                        <span class="list-title-txt list-status">상태</span>
                        <span class="list-title-txt list-mileage">마일리지</span>
                        <span class="list-title-txt list-content">내용</span>
                        <span class="list-title-txt list-date">적용일</span>
                    </div>
                </section>
                <section class="mileage-history-wrap">
                    <ul>
                        <li class="mileage-list">
                            <span class="list-status plus-price-label">적립</span>
                            <span class="list-mileage plus-price">+1,000</span>
                            <span class="list-content">오라운트</span>
                            <span class="list-date">2022.10.22</span>
                        </li>
                        <li class="mileage-list">
                            <span class="list-status">사용</span>
                            <span class="list-mileage minus-price">-12,324</span>
                            <span class="list-content">이 곳에는 사용 혹은 적립한 공간의 Title이 들어갈 예정 이 곳에는 사용 혹은 적립한 공간의 Title이 들어갈 예정입니다.</span>
                            <span class="list-date">2022.10.22</span>
                        </li>
                        <li class="mileage-list">
                            <span class="list-status after-label">예정</span>
                            <span class="list-mileage plus-price">+1,000</span>
                            <span class="list-content">오라운트</span>
                            <span class="list-date">2022.10.22</span>
                        </li>
                        <li class="mileage-list">
                            <span class="list-status">사용</span>
                            <span class="list-mileage minus-price">-12,324</span>
                            <span class="list-content">이 곳에는 사용 혹은 적립한 공간의 Title이 들어갈 예정</span>
                            <span class="list-date">2022.10.22</span>
                        </li>
                        <li class="mileage-list">
                            <span class="list-status plus-price-label">적립</span>
                            <span class="list-mileage plus-price">+1,000</span>
                            <span class="list-content">오라운트</span>
                            <span class="list-date">2022.10.22</span>
                        </li>
                        <li class="mileage-list">
                            <span class="list-status">사용</span>
                            <span class="list-mileage minus-price">-12,324</span>
                            <span class="list-content">이 곳에는 사용 혹은 적립한 공간의 Title이 들어갈 예정</span>
                            <span class="list-date">2022.10.22</span>
                        </li>
                    </ul>
                </section>
                <section class="paging-section blind">
                    <div class="paging-wrap">
                        <span class="paging-box">&lt; &lt;</span>
                        <span class="paging-box">&lt;</span>
                        <span class="paging-box paging-num choice sample">1</span>
                        <span class="paging-box paging-num un-choice sample">2</span>
                        <span class="paging-box paging-num un-choice sample">3</span>
                        <span class="paging-box paging-num un-choice sample">4</span>
                        <span class="paging-box">></span>
                        <span class="paging-box">>></span>
                    </div>
                </section>
            </section>
        </section>
    </div>
</div>