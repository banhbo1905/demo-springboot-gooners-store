<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Search List</title>
</head>
<body>

        <div class="main">
            <div class="main-content">

                <div class="container-fluid">
                    <div class="search-container">
                        <form action="search" method = "get" style="position: absolute;  right: 20px">
                            <input type="text" placeholder="Search.." name="keyword">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <br>
                    <br>
                    <!-- OVERVIEW -->

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="panel">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">ORDER LIST</h3>
                                            </div>
                                            <div class="panel-body no-padding">
                                                <table class="table table-striped" style="margin: auto;">
                                                    <thead>
                                                    <tr>
                                                        <th><input type="checkbox" name="all" id="checkAll"
                                                                   style="cursor: pointer;" /></th>
                                                        <th>Order No.</th>
                                                        <th style="width: 20%;'">User</th>
                                                        <th>Amount</th>
                                                        <th>Date &amp; Time</th>
                                                        <th>Status</th>
                                                        <th>Details</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${model.listResult}" var="order" varStatus="loop">
                                                        <tr>
                                                            <td style="vertical-align: middle;"><input
                                                                    class="checkbox" type="checkbox" name="orderId"
                                                                    value="${order.id}" id="${loop.count}"
                                                                    style="cursor: pointer;" /></td>
                                                            <td style="vertical-align: middle;">No.
                                                                    ${order.id}</td>
                                                            <td>${order.userDTO.userName}</td>
                                                            <td>$${order.priceTotal}0</td>
                                                            <td>${order.buyDate}</td>
                                                            <c:if test="${order.status eq 'PENDING'}">
                                                                <td><a href="update?orderId=${order.id}&pageIndex=${pageIndex}
																"><span class="label label-warning">PENDING</span></a></td>
                                                            </c:if>
                                                            <c:if test="${order.status eq 'SUCCESS'}">
                                                                <td><span class="label label-success">SUCCESS</span></td>
                                                            </c:if>
                                                            <td><a href="details?orderId=${order.id}" style="text-decoration: underline;">Details</a></td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <nav aria-label="Page navigation example"
                                             style="margin-top: -30px;">
                                            <ul class="pagination">
                                                <c:forEach begin="1" end="${model.totalPages}" var="i">
                                                    <li class="page-item">
                                                        <a class="page-link" href="search?keyword=${keyword}&pageIndex=${i}"
                                                                <c:if test="${pageIndex == i}">
                                                                    style="background-color: #F0AD4E; color: white;"
                                                                </c:if>
                                                        >${i}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </nav>
                                    </div>
                                    <div id="headline-chart" class="ct-chart"></div>
                                </div>

                </div>
                <!-- END OVERVIEW -->
            </div>
            <!-- END MAIN CONTENT -->
        </div>


</body>
</html>