<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div th:fragment="header">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <img src="/template/admin/assets/img/logo-dark.png" alt="Klorofil Logo"
                 class="img-responsive logo">
        </div>
        <div class="container-fluid">
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/admin/home"/>"> <i class="fa fa-home"
                                           style="font-size: 18px;"></i><span> Home</span>
                    </a></li>
                    <li><a href=""> <i class="fa fa-user-circle"
                                           style="font-size: 18px;"></i><span><%=SecurityUtils.getPrincipal().getFullName()%></span>
                    </a></li>
                    <li><a href="<c:url value="/login"/>"> <i class="material-icons"
                                                style="color: red;">&#xe8ac;</i><span>Logout</span>
                    </a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- END NAVBAR -->



