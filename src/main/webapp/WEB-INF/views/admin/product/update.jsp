<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Update</title>
</head>
<body>
<!-- MAIN CONTENT -->
<div class="main">
    <div class="main-content">
        <div class="container-fluid">
            <!-- OVERVIEW -->
            <div class="panel panel-headline">
                <div class="panel-heading"
                     style="display: flex; justify-content: space-between;">
                    <h3 class="panel-title">UPDATE PRODUCT</h3>
                </div>
                <form action="update" method="post"
                      enctype="multipart/form-data">
                    <div class="row"
                         style="display: flex; justify-content: space-between;">
                        <table style="margin: auto; margin-left: 60px;" class="col-md-6">
                            <tr>

                                <th>Category:</th>
                                <td><select name="categoryId">
                                    <c:forEach items="${categories}" var="category">
                                        <option
                                                <c:if test="${product.categoryCode == category.code}">
                                                    selected="selected"
                                                </c:if>
                                                value="${category.id}">${category.code}</option>
                                    </c:forEach>
                                </select></td>
                            </tr>
                            <tr>
                                <th>Product name:</th>
                                <td><input type="text" class="form-control"
                                           required="required" style="height: 30px;"
                                           placeholder="Enter product name..." name="productName"
                                           value="${product.name}" />
                                    <input type="hidden" name="productId" value="${product.id}">
                                </td>
                            </tr>
                            <tr>
                                <th>Description:</th>
                                <td><textarea required="required" class="form-control"
                                              placeholder="Enter product description..." rows="4"
                                              name="description">${product.description}</textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td></td>
                            </tr>
                        </table>
                        <table
                                style="margin: auto; margin-left: 50px; margin-right: -40px;"
                                class="col-md-6">
                            <tr>
                                <th>Price:</th>
                                <td><input type="text" class="form-control"
                                           style="height: 30px; width: 230px;"
                                           placeholder="$${product.price}0" name="newPrice" />
                                    <input type="hidden" name="oldPrice" value="${product.price}">
                                </td>
                            </tr>
                            <tr>
                                <th>Quantity:</th>
                                <td><input type="text" class="form-control"
                                           required="required" style="height: 30px; width: 230px;"
                                           placeholder="0" name="quantity" value="${product.quantity}" /></td>
                            </tr>
                            <tr>
                                <th>Image:</th>
                                <td><img src="<c:url value='/template/web/assets/images/products/${product.image}'/>"
                                         style="width: 20%; margin-top: -20px;"> <input
                                        type="hidden" name="image" value="${product.image}" />
                                    <input type="file" name="imageFile" />
                                    <input type="hidden" name="image" value="${product.image}">
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <button type="submit" class="btn btn-primary"
                                            style="font-weight: bold;">UPDATE</button>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>

        </div>
        <div id="headline-chart" class="ct-chart"></div>
    </div>

    <!-- END OVERVIEW -->
</div>
</body>
</html>