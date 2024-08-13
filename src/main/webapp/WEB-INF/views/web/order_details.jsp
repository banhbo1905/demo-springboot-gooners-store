<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<%--<c:url var="formUrl" value="/danh-muc-san-pham"></c:url>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết đơn hàng</title>
</head>
<body id="home">
    <div class="clearfix"></div>
    <div class="container_fullwidth">
        <div class="container shopping-cart">
            <div class="row">
                <div class="col-md-12">
                    <div style="display: flex; justify-content: space-between;">
                        <h4 class="title">Chi tiết đơn hàng</h4>
                    </div>
                    <div class="clearfix"></div>
                    <table class="shop-table">
                        <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Tổng tiền</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${items}" var="item">
                            <tr>
                                <td><a href="<c:url value='/chi-tiet-san-pham/${item.productDTO.code}'/>"><img style="width: 130px; height: 150px"
                                                                                                                     src="<c:url value='/template/web/assets/images/products/${item.productDTO.image}'/>"
                                                                                                                     alt=""></a></td>
                                <td>
                                    <div class="shop-details">
                                        <div class="productname">${item.productDTO.name}</div>
                                    </div>
                                </td>
<%--                                <td><a--%>
<%--                                        href="product-details?productId=${item.productDTO.productId}"><img--%>
<%--                                        src="../download?image=${item.productDTO.image}" alt=""></a></td>--%>
<%--                                <td>--%>
<%--                                    <div class="shop-details">--%>
<%--                                        <div class="productname">${item.productDTO.productName}</div>--%>
<%--                                        <p>--%>
<%--                                            <img alt="" src="../resource/client/images/star.png">--%>
<%--                                            <a class="review_num" href="#"> 02 Review(s) </a>--%>
<%--                                        </p>--%>

<%--                                        <p>${product.description}</p>--%>
<%--                                        <p>--%>
<%--                                            Sale : <strong class="pcode">-${item.productDTO.saleDTO.salePercent}%</strong>--%>
<%--                                        </p>--%>
<%--                                        <p>--%>
<%--                                            Product Code : <strong class="pcode">${item.productDTO.productId}</strong>--%>
<%--                                        </p>--%>
<%--                                    </div>--%>
<%--                                </td>--%>
                                <td>
                                    <h5 style="color: #41B314; font-weight: bold;"><f:formatNumber
                                            value="${item.unitPrice}" pattern="#,###" /> đ</h5>

                                </td>
                                <td><select name="quantity">
                                    <option value="${item.quantity}">${item.quantity}</option>
<%--                                    <input type="hidden" value="${item.productDTO.id}"--%>
<%--                                           name="productId" />--%>
                                </select></td>
                                <td>
                                    <h5>
                                        <strong class="red"><f:formatNumber
                                                value="${item.unitPrice *
                                                item.quantity}" pattern="#,###" /> đ</strong>
                                    </h5>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="6">
                                <p class="pull-right" style="display: flex; border: none;">
                                    <i class="material-icons"
                                       style="margin-top: -5px; color: #00ACC1; margin-right: 1px;">&#xe0c8;</i>
                                    <i class="title"
                                       style="font-size: 17px; color: #00ACC1; font-weight: bold;">
                                        ${sessionScope.user.fullName} *
                                        ${sessionScope.user.address} * ${sessionScope.user.phone}</i>
                                </p></td>
                        </tr>
                        </tfoot>
                    </table>
                    <div class="subtotal" style="margin-top: -10px;">
                        <h5>Tổng tiền hàng:</h5>
                        <span><f:formatNumber
                                value="${requestScope.subTotal}" pattern="#,###" /> đ</span>
                    </div>
                    <div class="subtotal" style="margin-top: 5px;">
                        <h5>Phí giao hàng:</h5>
                        <span> 25,000 đ </span>
                    </div>
                    <div class="grandtotal" style="margin-top: 5px;">
                        <h5>Thanh toán:</h5>
                        <span><f:formatNumber
                                value="${requestScope.grandTotal}" pattern="#,###" /> đ</span>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>