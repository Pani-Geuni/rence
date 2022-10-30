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
                    <span id="now-mileage" class="mileage-won">{res.mileage_total} 원</span>
                </section>
            </section>
        </section>

        <section class="mileage-list-section">
            <section class="mileage-list-menu">
                <span id = "all" class="menus choice">전체</span>
                <span id = "plus" class="menus un-choice">적립</span>
                <span id = "minus" class="menus un-choice">사용</span>
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
	                  	<!-- START forEach -->
						<c:forEach var = "obj" items="${res.list}">
                            <li class="mileage-list">
                                <span class="list-status <c:if test="${obj.state eq T}">plus-price-label</c:if>">
									<c:if test="${obj.state eq T}">적립</c:if>
									<c:if test="${obj.state eq F}">사용</c:if>
								</span>
                                <span class="list-mileage plus-price">
                                	<c:if test="${obj.state eq T}">+</c:if>
									<c:if test="${obj.state eq F}">-</c:if>
                                	${obj.mileage}
                                </span>
                                <span class="list-content">${obj.room}</span>
                                <span class="list-date">${obj.date}</span>
                            </li>
                       	</c:forEach>
                       	<!-- END forEach -->
                    </ul>
               </section>
               
               <section class="paging-section blind">
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