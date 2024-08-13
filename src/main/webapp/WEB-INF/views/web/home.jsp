<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ</title>
</head>
<body id="home">

    <div class="hotproduct">
        <div class="category">
            <h2><a href="https://goonerstore.com/danh-muc-san-pham/classic/" target=""><strong>MÙA GIẢI 2023-2024</strong></a></h2>
        </div>
        <br>
        <br>
        <ul id="autoWidth" class="cs-hidden">
            <c:forEach var="product" items="${hotproduct}">
                <li class="item-a">
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
                </li>
            </c:forEach>
        </ul>
    </div>


        <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div class="retro">
        <div class="category">
            <h2><a href="https://goonerstore.com/danh-muc-san-pham/classic/" target=""><strong>ÁO RETRO</strong></a></h2>
        </div>
        <br>
        <br>
        <ul id="autoWidth1" class="cs-hidden">
            <c:forEach var="product" items="${retro}">
                <li class="item-a">
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
                </li>
            </c:forEach>
        </ul>
    </div>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div class="phukien">
        <div class="category">
            <h2><a href="https://goonerstore.com/danh-muc-san-pham/classic/" target=""><strong>PHỤ KIỆN PHÁO THỦ</strong></a></h2>
        </div>
        <br>
        <br>
        <ul id="autoWidth2" class="cs-hidden">
            <c:forEach var="product" items="${phukien}">
                <li class="item-a">
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
                </li>
            </c:forEach>
        </ul>
    </div>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div class="aokhoac">
        <div class="category">
            <h2><a href="https://goonerstore.com/danh-muc-san-pham/classic/" target=""><strong>BỘ SƯU TẬP THU - ĐÔNG</strong></a></h2>
        </div>
        <br>
        <br>
        <ul id="autoWidth3" class="cs-hidden">
            <c:forEach var="product" items="${aokhoac}">
                <li class="item-a">
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
                </li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>
