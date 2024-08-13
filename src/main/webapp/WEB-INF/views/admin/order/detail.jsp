<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Details</title>
</head>
<body>

        <div class="main">
            <div class="main-content">

                <div class="container-fluid">
                    <!-- OVERVIEW -->
                    <div class="panel-heading">
                        <h3 class="panel-title">ORDER DETAILS</h3>
                    </div>
                    <div class="panel-body no-padding">
                        <table class="shop-table" style="padding: 30px;">
                            <thead>
                            <tr>
                                <th>Image</th>
                                <th>Details</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total Amount</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${items}" var="item">
                                <tr>
                                    <td><img style="width: 130px; height: 150px"
                                            src="/template/web/assets/images/products/${item.productDTO.image}" alt=""></td>
                                    <td>
                                        <div class="shop-details">
                                            <div class="productname">${item.productDTO.name}</div>
                                            <p>${product.description}</p>
                                            <p>
                                                Product Code : <strong class="pcode">${item.productDTO.id}</strong>
                                            </p>
                                        </div>
                                    </td>
                                    <td>

                                            <p
                                                    style="font-size: 16px; padding-top: 7px; text-decoration: line-through;">$${item.productDTO.price}0</p>
                                    </td>
                                    <td><select name="quantity" style="color: red;">
                                        <option value="${item.quantity}">${item.quantity}</option>
                                        <input type="hidden" value="${item.productDTO.id}"
                                               name="productId" />
                                    </select></td>
                                    <td>
                                        <h5>
                                            <strong class="red" style="color: red;"> $${item.unitPrice *
                                                    item.quantity}0 </strong>
                                        </h5>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6"><span class="pull-left">Sub Total: <span style="color: red;">$${order.priceTotal - 5}0</span></span><br /> <span
                                        class="pull-left">Fee: <span style="color: red;">$5.00</span></span><br /> <span
                                        class="pull-left" style="font-size: 22px;">Grand
												Total: <span style="color: red;">$${order.priceTotal}0</span>
										</span>
                                    <p class="pull-right" style="display: flex; border: none;">
                                        <i class="material-icons"
                                           style="margin-top: -35px; color: #00ACC1; margin-right: 1px;">&#xe0c8;</i>
                                        <i class="title"
                                           style="font-size: 17px; color: #00ACC1; font-weight: bold; margin-top: -30px;">
                                            ${order.userDTO.fullName} * ${order.userDTO.address} *
                                            ${order.userDTO.phone}</i><br/>
                                    </p>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
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