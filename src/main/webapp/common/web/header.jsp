<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-sm-2">
                <div class="logo" style="margin-top: 13%">
                    <a href="<c:url value='/trang-chu'/>"><img
                            src="<c:url value='/template/web/assets/images/gunners_logo.png'/>" alt=""></a>
                </div>
            </div>
            <div class="col-md-10 col-sm-10">
                <div class="header_top">
                    <div class="row">
                        <div class="col-md-3">
                            <ul class="option_nav">
                                <li class="dorpdown"><a href="#">Eng</a></li>
                                <li class="dorpdown"><a href="#">Viet</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6">
                            <ul class="topmenu">
                                <li><a href="<c:url value='/trang-chu'/>">Trang chủ</a></li>
                                <li><a href="#">Giới thiệu</a></li>
                                <li><a href="#">Dịch vụ</a></li>
                                <li><a href="#">Liên hệ</a></li>
                                <li><a href="#">Hỗ trợ</a></li>
                                <li><a href="#">Tin tức</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3">
                            <c:if test="${isLogin == false}">
                                <ul class="usermenu">
                                    <li><a href="/login" class="log">Đăng nhâp</a></li>
                                    <li><a href="authen/register" class="reg">Đăng ký</a></li>
                                </ul>
                            </c:if>

                            <c:if test="${isLogin == true}">
                                <ul class="usermenu">
                                    <li><a href="<c:url value='/thong-tin-nguoi-dung'/>" class="log"> <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
                                    <li><i
                                            style="font-size: 22px; margin-top: -2px; color: #F7544A;"
                                            class="fa">&#xf011;</i> <a
                                            style="position: absolute; margin-left: -18px;"
                                            href="<c:url value='/logout'/>">Đ.Xuất</a>
                                    </li>
                                </ul>
<%--                                <ul class="usermenu" style="display: flex;">--%>
<%--                                    <li>--%>
<%--                                        <a href="profile"><img class="log"--%>
<%--                                                               style="width: 26px; margin-top: -4px;">--%>
<%--                                        </a>--%>
<%--                                        <a href="profile" style="margin-left: -22px;"><span style="margin-left: 5px; color: white; font-size: 14px;"><%=SecurityUtils.getPrincipal().getFullName()%></span></a></li>--%>
<%--                                    <li><i--%>
<%--                                            style="font-size: 22px; margin-top: -2px; color: #F7544A;"--%>
<%--                                            class="fa">&#xf011;</i> <a--%>
<%--                                            style="position: absolute; margin-left: -18px;"--%>
<%--                                            href="<c:url value="/logout"/>">Logout</a></li>--%>
<%--                                </ul>--%>
                            </c:if>

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="header_bottom">
                    <ul class="option">
                        <li id="search" class="search">
                            <form action="<c:url value='/tim-kiem-san-pham'/>" method="get">
                                <input class="search-submit" type="submit" value=""><input
                                    class="search-input" placeholder="Enter your search term..."
                                    type="text" value="" name="tukhoa">
                            </form>
                        </li>

                        <li class="option-cart"><a href="<c:url value='/cart'/>"
                                                    class="cart-icon">cart <span class="cart_no">${sessionScope.totalQuantity}</span></a></li>


                        <!--                            <li class="option-cart" sec:authorize="isAuthenticated()">
                          <a th:href="@{/client/cart-load}" class="cart-icon">cart <span class="cart_no">02</span></a>
                       </li>
                        -->
                    </ul>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle"
                                data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span><span
                                class="icon-bar"></span><span class="icon-bar"></span><span
                                class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="navbar-collapse">
                        <ul class="nav">
<%--                            <li><a style="text-transform: none;" href="<c:url value='/trang-chu'/>">HOME</a></li>--%>
                            <c:forEach items="${categories}" var="category">
                                <li><a style="text-transform: none;"
                                       href="<c:url value='/danh-muc-san-pham/${category.code}'/>">${category.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>