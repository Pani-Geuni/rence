<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- START aside-menu -->
<aside class="asideWrap">
	<div class="logo-section">
		<img src="${path}/resources/IMG/common/RENCE-Host.svg" class="logo-mku">
	</div>

	<!-- START menuWrap -->
	<div class="menuWrap">
		<div id="menu-home" class="menu-item">
			<img src="${path}/resources/IMG/dash-board/ico-host-board.svg" alt="Dash Board" />
			<p>대시보드</p>
		</div>
		<div id="menu-space" class="menu-item">
			<img src="${path}/resources/IMG/dash-board/ico-host-room.svg" alt="room" />
			<p>공간관리</p>
		</div>
		<div id="menu-reserve" class="menu-item">
			<img src="${path}/resources/IMG/dash-board/ico-host-time.svg" alt="time" />
			<p>예약 관리</p>
		</div>
		<div id="menu-sales" class="menu-item">
			<img src="${path}/resources/IMG/dash-board/ico-host-reciept.svg" alt="Reciept" />
			<p>정산</p>
		</div>
		<div id="menu-settings" class="menu-item">
			<img src="${path}/resources/IMG/dash-board/ico-host-settings.svg" alt="Settings" />
			<p>환경설정</p>
		</div>
	</div>
	<!-- END menuWrap -->
</aside>
<!-- END aside-menu -->