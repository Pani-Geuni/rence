<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title"></tiles:getAsString></title>
	<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
	
	<link rel="stylesheet" href="${path}/resources/CSS/master-header.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/master-main.css" />
	<link rel="stylesheet" href="${path}/resources/CSS/custom-table.css" />
	
	<script src="${path}/resources/JS/jquery-3.6.1.min.js"></script>
	
</head>
<body class="bodyWrap">
	<tiles:insertAttribute name="header" />
	<section class="pageWrap">
		<tiles:insertAttribute name="content" />
	</section>
	
</body>
</html>