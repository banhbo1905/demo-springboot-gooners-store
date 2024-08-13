<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Giỏ hàng</title>
</head>
<body id="home">
    <div class="clearfix"></div>
    <div class="container_fullwidth">
        <div class="container shopping-cart">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="title">Giỏ Hàng</h3>
                    <div class="clearfix"></div>
                    <table class="shop-table">
                        <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Tổng tiền</th>
                            <th>Xóa</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.cart}" var="cart">
                            <tr>
                                <td><a href="<c:url value='/chi-tiet-san-pham/${cart.value.productDTO.code}'/>"><img style="width: 130px; height: 150px"
                                        src="<c:url value='/template/web/assets/images/products/${cart.value.productDTO.image}'/>"
                                        alt=""></a></td>
                                <td>
                                    <div class="shop-details">
                                        <div class="productname">${cart.value.productDTO.name}</div>
                                    </div>
                                </td>
                                <td>
                                    <h5 style="color: #41B314; font-weight: bold;"><f:formatNumber
                                            value="${cart.value.unitPrice}" pattern="#,###" /> đ</h5>

                                </td>
                                <td>
                                    <form action="gio-hang" method="post">
                                        <select name="quantity" onchange="this.form.submit()">
                                            <c:forEach begin="1" end="11" var="i">
                                                <option
                                                        <c:if test="${cart.value.quantity == i}">
                                                            selected="selected"
                                                        </c:if>
                                                        value="${i}">${i}</option>
                                            </c:forEach>
                                            <input type="hidden"
                                                   value="${cart.value.productDTO.id}"
                                                   name="id" />
                                        </select>
                                    </form>
                                </td>
                                <td>
                                    <h5>
                                        <strong class="red" style="font-weight: bold;"><f:formatNumber
                                                value="${Math.round(cart.value.unitPrice) *
                                                cart.value.quantity}" pattern="#,###" /> đ
                                        </strong>
                                    </h5>
                                </td>
                                <td><a
                                        href="delete?productId=${cart.value.productDTO.id}">
                                    <i style="height: 70px" class="material-icons">&#xe92b;</i>
                                </a></td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-4 col-sm-6">
                            <div class="shippingbox">
                                <h5>Thông tin giao hàng</h5>
                                <label> Địa chỉ * </label> <input type="text" name=""
                                                                  value="${user.address}" style="color: red;"
                                                                  readonly="readonly" /> <label> Số điện thoại * </label> <input
                                    type="text" name="" value="${user.phone}"
                                    style="color: red;" readonly="readonly" /> <label>
                                Thay đổi thông tin giao hàng * </label>
                                <c:if test="${user != null}">
                                    <a href="<c:url value='/thong-tin-nguoi-dung'/>"><button>Thông tin người dùng</button></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="shippingbox">
                                <h5>Mã giảm giá</h5>
                                <form>
                                    <label> Vui lòng nhập mã code giảm giá </label> <input
                                        type="text" name=""
                                        value="Hiện tại chúng tôi chưa có mã nào."
                                        style="color: red;" readonly="readonly" />
                                    <div class="clearfix"></div>
                                    <button>Áp dụng</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="shippingbox">
                                <div class="subtotal">
                                    <h5>Tổng tiền hàng:</h5>
                                    <span><f:formatNumber
                                            value="${subTotal}" pattern="#,###" /> đ</span>
                                </div>
                                <div class="subtotal">
                                    <h5>Phí giao hàng:</h5>
                                    <span> 25,000 đ </span>
                                </div>
                                <div class="grandtotal">
                                    <h5>Thanh toán:</h5>
                                    <span><f:formatNumber
                                            value="${sessionScope.grandTotal}" pattern="#,###" /> đ</span>
                                </div>
                                <c:if test="${user != null}">
                                    <c:if
                                            test="${user.address == null || user.phone == null}">
                                        <a href="/profile-from-cart"><button>Tiến hành thanh toán</button></a>
                                    </c:if>
                                    <c:if
                                            test="${user.address != null && user.phone != null && grandTotal > 1}">
                                        <form action="/checkout" method="post">
                                            <button type="submit">Tiến hành thanh toán</button>
                                        </form>
                                    </c:if>
                                </c:if>
                                <c:if test="${user == null}">
                                    <a href="../login"><button>Tiến hành thanh toán</button></a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
