<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<%--<c:url var="formUrl" value="/danh-muc-san-pham"></c:url>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đơn hàng</title>
</head>
<body id="home">
    <div class="clearfix"></div>
    <div class="container_fullwidth" style="margin-top: 0px;">
        <div class="container">
            <div class="container shopping-cart">

                        <div class="checkout-page">
                            <ol class="checkout-steps">
                                <li class="steps active"><a href="my_order"><div
                                        class="step-title">01. Đơn Hàng</div></a>
                                    <table class="table table-striped" style="font-size: 15px;">
                                        <thead>
                                        <tr>
                                            <th>Order No.</th>
                                            <th>Tổng tiền</th>
                                            <th>Ngày đặt</th>
                                            <th>Trạng thái</th>
                                            <th>Chi tiết</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${orders}" var="order">
                                            <tr>
                                                <td><a href="#">No. ${order.id}</a></td>
                                                <td style="color: red;"><f:formatNumber
                                                        value="${order.priceTotal}" pattern="#,###" /> đ</td>
                                                <td>${order.buyDate}</td>
                                                <td><c:if test="${order.status == 'PENDING'}">
                                                    <span class="label label-warning">${order.status}</span>
                                                </c:if> <c:if test="${order.status eq 'SUCCESS'}">
                                                    <span class="label label-success">${order.status}</span>
                                                </c:if></td>
                                                <td><a href="chi-tiet-don-hang?ma_don_hang=${order.id}"
                                                       style="color: blue; text-decoration: underline;">Details</a></td>
<%--                                                <td>--%>
<%--                                                    <c:if test="${order.status eq 'PENDING'}">--%>
<%--                                                        <a href=""><i class="material-icons" style="color: #F7544A;">&#xe5c9;</i></a>--%>
<%--                                                    </c:if>--%>

<%--                                                    <c:if test="${order.status eq 'SUCCESS'}">--%>
<%--                                                        <i style='font-size:24px; color: #5CB85C;' class='far'>&#xf058;</i>--%>
<%--                                                    </c:if>--%>
<%--                                                </td>--%>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table></li>
                            </ol>
                        </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</body>
</html>