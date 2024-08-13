<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product List</title>
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
                            <form action="delete" method="get">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="panel">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">PRODUCT LIST</h3>
                                                <p class="demo-button">
                                                    <a class="btn btn-default" href="product-list"
                                                       style="padding: 4px 8px; text-decoration: none; border: none; box-shadow: 2px 2px gray; font-weight: bold;">All
                                                        Product</a>
                                                    <a class="btn btn-success" href="product-list-by-category?categoryId=3"
                                                       style="background-color: #41B314; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px;">Vans
                                                        ERA</a>
                                                    <a class="btn btn-info" href="product-list-by-category?categoryId=2"
                                                       style="background-color: #E4CB10; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">Vans
                                                        classic</a>
                                                    <a class="btn btn-primary" href="product-list-by-category?categoryId=1"
                                                       style="background-color: #00AAFF; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">Vans
                                                        authentic</a>
                                                    <a class="btn btn-warning" href="product-list-by-category?categoryId=4"
                                                       style="background-color: #D9534F; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">Vans
                                                        old skool</a>
                                                    <a class="btn btn-danger" href="product-list-by-category?categoryId=5"
                                                       style="background-color: #5BC0DE; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">Vans
                                                        SK8</a>
                                                    <a class="btn btn-danger" href="product-list-by-category?categoryId=6"
                                                       style="background-color: gray; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">Vans
                                                        slip-on</a>

                                                </p>
                                                <div class="right">

                                                    <button type="submit">
                                                                <span class="label label-danger"
                                                                      style="font-size: 15px; margin-right: 15px;">Delete</span>
                                                    </button>
                                                    <a href="<c:url value="/admin/product/edit"/>"><span
                                                            class="label label-success" style="font-size: 15px;">Create
                                                                    new product</span></a>
                                                </div>
                                            </div>
                                            <div class="panel-body no-padding">
                                                <table class="table" style="margin: auto;">
                                                    <thead>
                                                    <tr>
                                                        <th><input type="checkbox" name="all" id="checkAll" style="cursor: pointer;"/></th>
                                                        <th>ID</th>
                                                        <th>Product Name</th>
                                                        <th>Price</th>
                                                        <th>Quantity</th>
                                                        <th style="width: 10%;">Image</th>
                                                        <th style="width: 22%;">Description</th>
                                                        <th>Edit</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${model.listResult}" varStatus="loop"
                                                               var="product">
                                                        <tr>
                                                            <td style="vertical-align: middle;"><input
                                                                    class="checkbox" type="checkbox" name="productId"
                                                                    value="${product.id}" id="${loop.count}" style="cursor: pointer;"/></td>
                                                            <td style="vertical-align: middle;">${product.id}</td>
                                                            <td style="vertical-align: middle;">${product.name}</td>
                                                            <td style="vertical-align: middle;"><span
                                                                    style="color: #41B314; font-weight: bold;">$${product.price}0</span><br />

                                                            </td>
                                                            <td style="vertical-align: middle;">${product.quantity}</td>

                                                            <td style="vertical-align: middle;"><img
                                                                    style="width: 70%;" src="<c:url value='/template/web/assets/images/products/${product.image}'/>"></td>
                                                            <td style="vertical-align: middle;">${product.description}</td>
                                                            <td style="vertical-align: middle;"><a href="<c:url value="/admin/product/update?productId=${product.id}"/>">
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
                            </form>


                </div>
                <!-- END OVERVIEW -->
            </div>
            <!-- END MAIN CONTENT -->
        </div>


</body>
</html>