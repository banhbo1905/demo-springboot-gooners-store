<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div th:fragment="category">
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll" style="padding-top: 20px;">
            <nav>
                <ul class="nav">
                    <li><a href="<c:url value="/admin/home"/>" class=""><i class="lnr lnr-home"></i> <span>Home</span></a></li>
                    <li><a href="<c:url value="/admin/category/list"/>" class=""><i class="lnr lnr-list"></i> <span>Category</span></a></li>
                    <li><a href="<c:url value="/admin/product/list"/>" class=""><i class="lnr lnr-gift"></i> <span>Product</span></a></li>
                    <li><a href="<c:url value="/admin/user/list"/>" class=""><i class="lnr lnr-users"></i> <span>User</span></a></li>
                    <li><a href="<c:url value="/admin/order/list"/>" class=""><i class="lnr lnr lnr-dice"></i>
                        <span>Order</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
