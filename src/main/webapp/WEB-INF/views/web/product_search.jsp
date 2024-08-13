<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tìm kiếm sản phẩm</title>
</head>
<body id="home">
    <div class="container_fullwidth">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="category leftbar">
                        <h3 class="title">Categories</h3>
                        <ul>
                            <c:forEach items="${categories}" var="category">
                                <li><a
                                        href="<c:url value='/danh-muc-san-pham/${category.code}'/>">${category.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>

                    <div class="clearfix"></div>
                    <div class="others leftbar">
                        <h3 class="title">Others</h3>
                    </div>
                    <div class="clearfix"></div>
                    <div class="fbl-box leftbar">
                        <h3 class="title">Facebook</h3>
                        <span class="likebutton"> <a href="#"> <img
                                src="<c:url value='/template/web/assets/images/fblike.png'/>" alt="">
                                </a>
                                </span>
                        <p>12k people like Flat Shop.</p>
                        <ul>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="#"> </a></li>
                        </ul>
                        <div class="fbplug">
                            <a href="#"> <span> <img
                                    src="<c:url value='/template/web/assets/images/fbicon.png'/>" alt="">
                                    </span> Facebook social plugin
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"></div>

                </div>
                <div class="col-md-9">
                    <div class="clearfix"></div>
                    <div class="products-grid">

                        <!-- Tool Bar -->
<%--                        <div class="toolbar">--%>
<%--                            <div class="pager">--%>
<%--                                <a href="#" class="prev-page"> <i class="fa fa-angle-left"> </i>--%>
<%--                                </a>--%>
<%--                                <c:forEach begin="0" end="${totalPage - 1}" var="i">--%>
<%--                                    <a--%>
<%--                                            href="search?pricing=${pricing}&text=${text}&pageIndex=${i}&categoryId=${categoryId}&pageSize=${pageSize}"--%>
<%--                                            <c:if test="${pageIndex == i}">--%>
<%--                                                class="active"--%>
<%--                                            </c:if>>--%>
<%--                                            ${i+1} </a>--%>
<%--                                </c:forEach>--%>

<%--                                <a href="#" class="next-page"> <i class="fa fa-angle-right">--%>
<%--                                </i>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        ------------- product -----------------------------------------------------%>

                        <div class="clearfix"></div>
                        <div class="row">
                            <c:forEach var="product" items="${model.listResult}">
                                <div class="col-md-4 col-sm-6">
                                        <div class="box">
                                            <div class="slide-img">
                                                <img src="<c:url value='/template/web/assets/images/products/${product.image}'/>" alt="Product Image">
                                                <div class="overlay">
                                                    <a href="<c:url value='/chi-tiet-san-pham/${product.code}'/>" class="buy-btn">Mua Ngay</a>
                                                </div>
                                            </div>
                                            <div class="detail-box">
                                                <div class="type">
                                                    <a href="<c:url value='/chi-tiet-san-pham/${product.code}'/>">${product.name}</a>
                                                </div>
                                                <a href="<c:url value='/chi-tiet-san-pham/${product.code}'/>" class="price" style="color:red;"><f:formatNumber
                                                        value="${product.price}" pattern="#,###" /> <u>đ</u>
                                                </a>
                                            </div>
                                        </div>
                                    <br>
                                    <br>
                                </div>
                            </c:forEach>

                            <div class="clearfix"></div>


                            <!-- Tool Bar -->
<%--                            <div class="toolbar">--%>
<%--                                <div class="pager">--%>
<%--                                    <a href="#" class="prev-page"> <i class="fa fa-angle-left"> </i>--%>
<%--                                    </a>--%>
<%--                                    <c:forEach begin="0" end="${totalPage - 1}" var="i">--%>
<%--                                        <a--%>
<%--                                                href="search?pricing=${pricing}&text=${text}&pageIndex=${i}&categoryId=${categoryId}&pageSize=${pageSize}"--%>
<%--                                                <c:if test="${pageIndex == i}">--%>
<%--                                                    class="active"--%>
<%--                                                </c:if>>--%>
<%--                                                ${i+1} </a>--%>
<%--                                    </c:forEach>--%>

<%--                                    <a href="#" class="next-page"> <i class="fa fa-angle-right">--%>
<%--                                    </i>--%>
<%--                                    </a>--%>
<%--                                </div>--%>
<%--                            </div>--%>

                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

                <!-- 			<div th:replace="client/common/ourbands :: ourbands"></div> -->

            </div>
            <nav aria-label="Page navigation example"
                 style="margin-top: -30px; position: absolute;  right: 0px">
                <ul class="pagination">
                    <c:forEach begin="1" end="${model.totalPages}" var="i">
                        <li class="page-item">
                            <a class="page-link" href="<c:url value='/tim-kiem-san-pham?tukhoa=${tukhoa}&pageIndex=${i}'/>"
                                    <c:if test="${pageIndex == i}">
                                        style="background-color: #F0AD4E; color: white;"
                                    </c:if>
                            >${i}</a></li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</body>
</html>