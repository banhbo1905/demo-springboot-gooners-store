<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
<%--    <body style="background-image: url(/template/admin/assets/img/admin.jpg); background-size: cover;">--%>
    <body>
    <div class="main">
        <div class="bg-img">
<%--            <div class="container-fluid">--%>
<%--                <!-- OVERVIEW -->--%>
<%--                <div class="panel panel-headline">--%>
<%--                    <div class="panel-body">--%>
<%--                                <div class="panel">--%>
<%--                                    <div class="panel-heading">--%>
<%--                                        <h3 class="panel-title">Recent Purchases</h3>--%>
<%--                                        <div class="right">--%>
<%--                                            <button type="button" class="btn-toggle-collapse">--%>
<%--                                                <i class="lnr lnr-chevron-up"></i>--%>
<%--                                            </button>--%>
<%--                                            <button type="button" class="btn-remove">--%>
<%--                                                <i class="lnr lnr-cross"></i>--%>
<%--                                            </button>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="panel-body no-padding">--%>
<%--                                        <table class="table table-striped">--%>
<%--                                            <thead>--%>
<%--                                            <tr>--%>
<%--                                                <th>Order No.</th>--%>
<%--                                                <th>Name</th>--%>
<%--                                                <th>Amount</th>--%>
<%--                                                <th>Date &amp; Time</th>--%>
<%--                                                <th>Status</th>--%>
<%--                                                <th>Details</th>--%>
<%--                                            </tr>--%>
<%--                                            </thead>--%>
<%--                                            <tbody>--%>
<%--                                            <c:forEach items="${orders}" var="order">--%>
<%--                                                <tr>--%>
<%--                                                    <td><a href="#">No. ${order.orderId}</a></td>--%>
<%--                                                    <td>${order.userDTO.email.split("@")[0]}</td>--%>
<%--                                                    <td>$${order.priceTotal}0</td>--%>
<%--                                                    <td>${order.buyDate}</td>--%>
<%--                                                    <c:if test="${order.status eq 'PENDING'}">--%>
<%--                                                        <td><a href="order-updateHome?orderId=${order.orderId}"><span class="label label-warning">PENDING</span></a></td>--%>
<%--                                                    </c:if>--%>
<%--                                                    <c:if test="${order.status eq 'SUCCESS'}">--%>
<%--                                                        <td><span class="label label-success">SUCCESS</span></td>--%>
<%--                                                    </c:if>--%>
<%--                                                    <td><a href="order-details?orderId=${order.orderId}" style="text-decoration: underline;">Details</a></td>--%>
<%--                                                </tr>--%>
<%--                                            </c:forEach>--%>
<%--                                            </tbody>--%>
<%--                                        </table>--%>
<%--                                    </div>--%>
<%--                                    <div class="panel-footer">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col-md-6">--%>
<%--													<span class="panel-note"><i class="fa fa-clock-o"></i>--%>
<%--														Last 24 hours</span>--%>
<%--                                            </div>--%>
<%--                                            <div class="col-md-6 text-right">--%>
<%--                                                <a href="../admin/order-list" class="btn btn-primary">View All Purchases</a>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <!-- END OVERVIEW -->
        </div>
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
<%--    <style>--%>
<%--        .bg-img {--%>
<%--            width:100%;--%>
<%--            height:100%;--%>
<%--        }--%>
<%--    </style>--%>

    </body>
</html>