<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="reserve-list-wrap">
    <div class="reserve-list">
        <section class="page-title-section">
            <span class="page-title">현재 나의 예약 현황을 보여드려요</span>
        </section>
        <section class="reserve-list-section">
            <section class="reserve-null blind">
                <div class="null-first-section">
                    <span class="advice-txt">예약 내역이 비어있습니다.</span>
                </div>
                <div class="null-second-section">
                    <span class="advice-txt-small">원하는 공간을 예약하러 갈까요?</span>
                    <input type="button" id="" class="go-home" value="예약하러가기"/>
                </div>
            </section>
            <section class="reserve-not-null">
                <section class="box-section">
                    <div class = "reserve-box">
                        <section class="box-img-section">
                            <img src="../IMG/reserve-list/default-space.svg" alt ="default-space-img" class="space-img" />
                        </section>
                        <section class="box-txt-section">
                            <span class="b-office-name">오라운트</span>
                            <span  class="b-office-location">
                                <img src = "../IMG/reserve-list/location-icon.svg" alt="location-icon" class ="location-icon" />
                                <span class="location-name">경기도 광주시</span>
                            </span>
                            <span class="reserve-time">
                                <span class="reserve-start-time">
                                    2022.10.22 14:00 ~
                                </span>
                                <span class="reserve-end-time">
                                    2022.10.22 16:00
                                </span>
                            </span>
                            <span>
                                <span class="price-label">결제 금액</span>
                                <span class="price">20,000원</span>
                            </span>
                        </section>
                    </div>
                    <div class = "reserve-box">
                        <section class="box-img-section">
                            <img src="../IMG/reserve-list/default-space.svg" alt ="default-space-img" class="space-img" />
                        </section>
                        <section class="box-txt-section">
                            <span class="b-office-name">오라운트</span>
                            <span  class="b-office-location">
                                <img src = "../IMG/reserve-list/location-icon.svg" alt="location-icon" class ="location-icon" />
                                <span class="location-name">경기도 광주시</span>
                            </span>
                            <span class="reserve-time">
                                <span class="reserve-start-time">
                                    2022.10.22 14:00 ~
                                </span>
                                <span class="reserve-end-time">
                                    2022.10.22 16:00
                                </span>
                            </span>
                            <span>
                                <span class="price-label">결제 금액</span>
                                <span class="price">20,000원</span>
                            </span>
                        </section>
                    </div>
                    
                </section>

                <section class="paging-section">
                    <div class="paging-wrap">
                        <span class="paging-box"><<</span>
                        <span class="paging-box"><</span>
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