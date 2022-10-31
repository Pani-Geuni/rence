<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="reserve-list-wrap">
    <div class="reserve-list">
        <section class="page-title-section">
            <span class="page-title">과거에 예약한 내역을 보여드려요</span>
        </section>
        <section class="reserve-list-section">
        	<c:if test="${res.cnt == 0}">
	            <section class="reserve-null">
	                <div class="null-first-section">
	                    <span class="advice-txt">예약 내역이 비어있습니다.</span>
	                </div>
	                <div class="null-second-section">
	                    <span class="advice-txt-small">원하는 공간을 예약하러 갈까요?</span>
	                    <input type="button" id="" class="go-home" value="예약하러가기"/>
	                </div>
	            </section>
        	</c:if>
        	
        	<c:if test="${res.cnt != 0}">
	            <section class="reserve-not-null">
	                <section class="box-section">
						<!-- START forEach -->
						<c:forEach var = "obj" items="${res.list}">
		                    <div class = "reserve-box before" idx="${obj.no}">
		                        <section class="box-img-section">
		                            <img src="${path}/resources/upload/${obj.img}" alt ="default-space-img" class="space-img" />
		                        </section>
		                        <section class="box-txt-section">
		                            <span class="b-office-name">${obj.title}</span>
		                            <span  class="b-office-location">
		                                <img src = "${path}/resources/IMG/reserve-list/location-icon.svg" alt="location-icon" class ="location-icon" />
		                                <span class="location-name">${obj.location}</span>
		                            </span>
		                            <span class="reserve-time">
		                                <span class="reserve-start-time">
		                                    ${obj.s_date} ~
		                                </span>
		                                <span class="reserve-end-time">
		                                    ${obj.e_date}
		                                </span>
		                            </span>
		                            <span>
		                                <span class="price-label">결제 금액</span>
		                                <span class="price">${obj.price}원</span>
		                            </span>
		                        </section>
		                    </div>
		                </c:forEach>
		                <!-- END forEach -->
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
           </c:if>
        </section>
    </div>
</div>