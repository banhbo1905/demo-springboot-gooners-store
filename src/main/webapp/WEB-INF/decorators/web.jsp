<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="<c:url value='/template/web/assets/images/favicon.png'/>">
        <title><sitemesh:write property="title"/></title>
<%--        <title>Welcome to FlatShop</title>--%>
        <link href="<c:url value='/template/web/assets/css/bootstrap.css'/>" rel="stylesheet">
        <link
                href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
                rel='stylesheet' type='text/css'>
        <link href="<c:url value='/template/web/assets/css/font-awesome.min.css'/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/template/web/assets/css/flexslider.css'/>"
              type="text/css" media="screen" />
        <link href="<c:url value='/template/web/assets/css/sequence-looptheme.css'/>" rel="stylesheet"
              media="all" />
        <link href="<c:url value='/template/web/assets/css/style.css'/>" rel="stylesheet">
        <link href="<c:url value='/template/web/assets/css/lightslider.css'/>" rel="stylesheet">
        <script type="text/javascript" src="<c:url value='/template/web/assets/js/Jquery.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/template/web/assets/js/lightslider.js'/>"></script>
<%--        <script type="text/javascript" src="<c:url value='/template/web/client/js/lightslider1.js'/>"></script>--%>

        <!-- Meta -->
<%--        <meta charset="utf-8">--%>
<%--        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">--%>
<%--        <meta name="description" content="">--%>
<%--        <meta name="author" content="">--%>
<%--        <meta name="keywords" content="MediaCenter, Template, eCommerce">--%>
<%--        <meta name="robots" content="all">--%>
<%--        <title>Flipmart premium HTML5 & CSS3 Template</title>--%>

<%--        <!-- Bootstrap Core CSS -->--%>
<%--&lt;%&ndash;        <c:url value='/template/web/ui/images/logo.png'/>&ndash;%&gt;--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/bootstrap.min.css'/>">--%>

<%--        <!-- Customizable CSS -->--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/main.css'/>">--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/blue.css'/>">--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/owl.carousel.css'/>">--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/owl.transitions.css'/>">--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/animate.min.css'/>">--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/rateit.css'/>">--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/bootstrap-select.min.css'/>">--%>

<%--        <!-- Icons/Glyphs -->--%>
<%--        <link rel="stylesheet" href="<c:url value='/template/web/ui/css/font-awesome.css'/>">--%>

<%--        <!-- Fonts -->--%>
<%--        <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>--%>
<%--        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>--%>
<%--        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>--%>
    </head>
    <body class="home">
        <%@ include file="/common/web/header.jsp" %>
            <div class="container_fullwidth">
                <div class="container">
                    <sitemesh:write property="body"/>
                </div>
            </div>
        <%@ include file="/common/web/footer.jsp" %>

        <!-- JS -->
		<script type="text/javascript" src="<c:url value='/template/web/assets/js/jquery-1.10.2.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/template/web/assets/js/jquery.easing.1.3.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/template/web/assets/js/bootstrap.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/template/web/assets/js/jquery.sequence-min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/template/web/assets/js/jquery.carouFredSel-6.2.1-packed.js'/>"></script>
		<script defer src="<c:url value='/template/web/assets/js/jquery.flexslider.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/template/web/assets/js/script.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/template/web/assets/js/script.js'/>"></script>


    </body>
</html>