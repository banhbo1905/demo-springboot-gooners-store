<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
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
                                            <h3 class="panel-title">USER LIST</h3>
                                            <div class="right">
                                                <a href="<c:url value="/admin/user/edit"/>"><span
                                                        class="label label-success" style="font-size: 15px;">Create
															new account</span></a>
                                            </div>
                                        </div>
                                        <div class="panel-body no-padding">
                                            <table class="table table-striped" style="margin: auto;">
                                                <thead>
                                                <tr>
                                                    <th><input type="checkbox" name="all" id="checkAll"
                                                               style="cursor: pointer;" /></th>
                                                    <th>ID</th>
                                                    <th style="padding-left: 20px;">Email</th>
                                                    <th>Full Name</th>
                                                    <th>Phone</th>
                                                    <th style="width: 25%;">Address</th>
                                                    <th style="width: 7%;">Role</th>
                                                    <th style="width: 5%;">Status</th>
                                                    <th>Edit</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${model.listResult}" var="user" varStatus="loop">
                                                    <tr>
                                                        <td style="vertical-align: middle;"><input
                                                                class="checkbox" type="checkbox" name="userId"
                                                                value="${user.id}" id="${loop.count}"
                                                                style="cursor: pointer;" /></td>
                                                        <td style="vertical-align: middle;">${user.id}</td>
                                                        <td style="vertical-align: middle; padding-left: 25px;">${user.email}</td>
                                                        <td style="vertical-align: middle;">${user.fullName}</td>
                                                        <td style="vertical-align: middle;">${user.phone}</td>
                                                        <td style="vertical-align: middle;">${user.address}</td>
                                                        <td style="vertical-align: middle;">USER</td>
                                                        <td style="vertical-align: middle;">${user.status}</td>
                                                        <td style="vertical-align: middle;"><a href="<c:url value="/admin/user/update?userId=${user.id}"/>">
																		<span class="label label-warning"
                                                                              style="font-size: 15px;">Update</span>
                                                        </a></td>

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
                                                    <a class="page-link" href="list?pageIndex=${i}"
                                                            <c:if test="${pageIndex == i}">
                                                                style="background-color: #F0AD4E; color: white;"
                                                            </c:if>
                                                    >${i}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                    </div>

                <!-- END OVERVIEW -->
            </div>
            <!-- END MAIN CONTENT -->
        </div>


</body>
</html>