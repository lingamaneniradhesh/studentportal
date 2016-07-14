<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">

<link rel="stylesheet" href="../resources/css/sportal.css">
<link rel="stylesheet"
	href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../webjars/bootstrap-social/4.12.0/bootstrap-social.css">
<link rel="stylesheet"
	href="../webjars/font-awesome/4.6.1/css/font-awesome.css">

<script src="../resources/js/sportal.js"></script>
<script src="../webjars/jquery/2.2.3/jquery.min.js"></script>
<script src="../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
</script>
<title><fmt:message key="app.title" /></title>
</head>
<body class="container">
	<%@ include file="header.jsp"%>
	<%@ include file="menu.jsp"%>
	<br>