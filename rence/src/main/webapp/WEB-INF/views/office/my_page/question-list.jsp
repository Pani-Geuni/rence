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
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap">
                        <div class="question-line">
                            <div class="q-line">
                                <label class="q_label">Q.</label>
                                <div class="question-btn-wrap">
                                    <span class="question-btn">수정</span>
                                    <span class="question-btn">삭제</span>
                                </div>
                            </div>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span class="answer-text">
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status complete-label">처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <label class="q_label">Q.</label><br>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <label class="q_label">Q.</label><br>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <label class="q_label">Q.</label><br>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <label class="q_label">Q.</label><br>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <label class="q_label">Q.</label><br>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <div class="q-line">
                                <label class="q_label">Q.</label>
                            </div>
                            <span>
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
                </li>
                <li class="question-list">
                    <div class="question-content-wrap">
                        <span class="list-status un-complete-label">미처리</span>
                        <span class="list-company-name">오라운트 스터디룸</span>
                        <span class="list-content">
                            문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용 문의내용
                        </span>
                        <span class="list-date">2022.10.22</span>
                    </div>
                    <div class="detail-question-wrap blind">
                        <div class="question-line">
                            <label class="q_label">Q.</label><br>
                            <span class="user-question">
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                                혹시 11월 25일 3시 예약되어있던데 취소되면 바로 하고싶은데 예약걸어놓을 수 있을까요?
                            </span>
                        </div>
                        <div class="answer-line">
                            <label class="a_label">A.</label><br>
                            <span class="host-answer">
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                안녕하세요 고객님 오라운트입니다!<br>
                                문의주신부분 회의 결과 연락처 남겨주시면 우선적으로 연락드리기로 결론이 나서 답변드립니다.
                                아래 번호로 성함과 예약 일시 다시 한 번 남겨주세요^^<br>
                                010-1234-5678
                            </span>
                        </div>
                    </div>
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
</div>