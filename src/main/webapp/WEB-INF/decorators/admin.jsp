
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><sitemesh:write property="title"/></title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/css/style.css'/>"/>
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/vendor/bootstrap/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/vendor/font-awesome/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/vendor/linearicons/style.css'/>"/>
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/vendor/chartist/css/chartist-custom.css'/>"/>
    <!-- MAIN CSS -->
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/css/main.css'/>"/>
    <link rel="stylesheet"
          href="<c:url value='/template/admin/assets/css/demo.css'/>"/>
    <!-- GOOGLE FONTS -->
    <link
            href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
            rel="stylesheet">

    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76"
          href="<c:url value='/template/admin/assets/img/apple-icon.png'/>"/>
    <link rel="icon" type="image/png" sizes="96x96"
          href="<c:url value='/template/admin/assets/img/favicon.png'/>"/>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

<%--    <link rel="stylesheet" type="text/css"--%>
<%--          href="<c:url value='/template/css/style.css'/>">--%>

<%--    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/pagination.css' />" />--%>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/css/style.css'/>">

    <script src="<c:url value='/template/admin/js/paging/jquery.twbsPagination.js' />"></script>

    <sitemesh:write property="head"/>
</head>
<body>
<!-- WRAPPER -->
    <div id="wrapper">
        <!-- Header -->
        <jsp:include page="/common/admin/header.jsp"></jsp:include>
        <!-- End Header -->

        <!-- Begin menu -->
        <%@ include file="/common/admin/category.jsp" %>
        <!-- End menu -->

        <!-- MAIN -->
            <sitemesh:write property="body"/>
        <!-- END MAIN -->

        <!-- Begin footer -->
        <div class="clearfix"></div>
        <jsp:include page="/common/admin/footer.jsp"></jsp:include>
        <!-- end footer -->
    </div>


<!-- END WRAPPER -->
<!-- Header -->

<%--<!-- Javascript -->--%>


</body>
</html>
