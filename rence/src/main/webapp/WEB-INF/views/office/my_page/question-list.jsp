<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="question-list-wrap">
    <section class="page-title-section">
        <span class="page-title">문의한 내역들을 바로 확인해 보세요</span>
    </section>


    <section class="question-history-section">
        <section class="question-history-title-section">
            <div class="list-title-txt-wrap">
                <span class="list-title-txt list-status">처리 상태</span>
                <span class="list-title-txt list-company-name">문의 장소</span>
                <span class="list-title-txt list-content">문의 내용</span>
                <span class="list-title-txt list-date">작성일</span>
            </div>
        </section>
        <section class="question-history-wrap">
            <ul>
            	<c:forEach var = "obj" items="${res.list}">
	                <li class="question-list">
	                    <div class="question-content-wrap">
	                        <span class="list-status 
	                        	<c:if test="${obj.state eq 'Y'}">complete-label</c:if>
	                        	<c:if test="${obj.state eq 'N'}">un-complete-label</c:if>
                        	">
	                        	<c:if test="${obj.state eq 'Y'}">처리</c:if>
	                        	<c:if test="${obj.state eq 'N'}">미처리</c:if>
							</span>
	                        <span class="list-company-name">${obj.company_name}</span>
	                        <span class="list-content">
	                            ${obj.comment_content}
	                        </span>
	                        <span class="list-date">${obj.comment_date}</span>
	                    </div>
	                    <div class="detail-question-wrap blind">
	                        <div class="question-line">
	                            <label class="q_label">Q.</label><br>
	                            <span>${obj.comment_content}</span>
	                        </div>
	                        <div class="answer-line">
	                            <label class="a_label">A.</label><br>
	                            <span>${obj.answer_content}</span>
	                        </div>
	                    </div>
	                </li>
                </c:forEach>
            </ul>
        </section>
    </section>
</div>