<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyFood Admin - <tiles:insertAttribute name="title"/> </title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/datepicker3.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/jquery.timepicker.css"/>" rel="stylesheet">
    <!--Custom Font-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<c:url value="/resources/js/html5shiv.min.js"/>"></script>
    <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    <![endif]-->
</head>
<body>
<tiles:insertAttribute name="navigation" />

<tiles:insertAttribute name="sidebar" />

<tiles:insertAttribute name="content" />

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/chart.min.js"/>"></script>
<script src="<c:url value="/resources/js/chart-data.js"/>"></script>
<script src="<c:url value="/resources/js/easypiechart.js"/>"></script>
<script src="<c:url value="/resources/js/easypiechart-data.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.twbsPagination.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.timepicker.min.js"/>"></script>
<script src="<c:url value="/resources/js/custom.js"/>"></script>
</body>
</html>