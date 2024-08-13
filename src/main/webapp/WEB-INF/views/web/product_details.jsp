<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<%--<c:url var="formUrl" value="/danh-muc-san-pham"></c:url>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết sản phẩm</title>
</head>
<body id="home">
<%--<div class="item active" modelAttribute="model" method="GET"  >--%>
    <section class="py-5">
        <div class="container">
            <div class="row gx-5">
                <aside class="col-lg-5">
                    <div class="border rounded-4 mb-3 d-flex justify-content-center">
<%--                        <c: var="product" items="${model}">--%>
                        <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image" src="<c:url value='/template/web/assets/images/products/${product.image}'/>">
                            <img style="max-width: 400px; max-height: 500px; margin: auto;" class="rounded-4 fit" src="<c:url value='/template/web/assets/images/products/${product.image}'/>" />
                        </a>
<%--                        </c:>--%>
                    </div>
                    <!-- thumbs-wrap.// -->
                    <!-- gallery-wrap .end// -->
                </aside>
                <main class="col-lg-7">
                    <div class="ps-lg-3">

                        <div class="product-short-description">
                            <p style="font-size: 17px; line-height: 1.25;"><span class="product-description"><img class="xz74otr" src="https://static.xx.fbcdn.net/images/emoji.php/v9/te0/1/16/1f31f.png" alt="🌟" width="16" height="16"></span>&nbsp; Mẫu áo travel Arsenal đã về với shop, chất liệu Polyester mềm mịn.</p>
                            <p style="font-size: 17px; line-height: 1.25;"><span class="product-description"><img class="xz74otr" src="https://static.xx.fbcdn.net/images/emoji.php/v9/te0/1/16/1f31f.png" alt="🌟" width="16" height="16"></span>&nbsp; Logo thêu sắc nét, bền đẹp. Đặt cái tâm cho anh em pháo thủ là hàng đầu.</p>
                            <p style="font-size: 17px; line-height: 1.25;"><span class="product-description"><img class="xz74otr" src="https://static.xx.fbcdn.net/images/emoji.php/v9/te0/1/16/1f31f.png" alt="🌟" width="16" height="16"></span>&nbsp; Cam kết giá rẻ nhất thị trường.</p>
                            <p style="font-size: 17px; line-height: 1.25;">Anh em liên hệ fanpage để được tư vấn size và đặt hàng nhanh nhất nhé :&nbsp; <a href="https://www.facebook.com/arsenalstore.coyg.vn">Gooners Store COYG&nbsp;</a></p>

                        </div>

                        <hr />

                        <div class="row mb-4">
                            <div class="col-md-4 col-6">
                                <label class="mb-2">Size</label>
                                <select class="form-select border border-secondary" style="height: 35px;">
                                    <option value="">Chọn một tùy chọn</option><option value="s" class="attached enabled">S</option><option value="m" class="attached enabled">M</option><option value="l" class="attached enabled">L</option><option value="xl" class="attached enabled">XL</option><option value="xxl" class="attached enabled">XXL</option>
                                </tr>
                                </select>
                            </div>
<%--                            <div class="col-md-4 col-6 mb-3">--%>
<%--                                <label class="mb-2 d-block">Quantity</label>--%>
<%--                                <div class="input-group mb-3" style="width: 170px;">--%>
<%--                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1" data-mdb-ripple-color="dark">--%>
<%--                                        <i class="fas fa-minus"></i>--%>
<%--                                    </button>--%>
<%--                                    <input type="text" class="form-control text-center border border-secondary" placeholder="14" aria-label="Example text with button addon" aria-describedby="button-addon1" />--%>
<%--                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2" data-mdb-ripple-color="dark">--%>
<%--                                        <i class="fas fa-plus"></i>--%>
<%--                                    </button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                        </div>

                        <form action="/gio-hang" method="post">
<%--                        <form:form action="${formUrl}" method="post">--%>
                            <div class="wided">
                                <div class="qty">
                                    Qantity &nbsp;&nbsp;: <select name="quantity">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                    <option>11</option>
                                </select> <input type="hidden" name="id"
                                                 value="${product.id}"/>
                                </div>
                                <div class="button_group">

                                    <a href=""><button
                                            class="button">Thêm vào giỏ hàng</button></a>
                                </div>
                            </div>
                        </form>

<%--                        <a href="#" class="btn btn-warning shadow-0"> Buy now </a>--%>
<%--                        <a href="#" class="btn btn-primary shadow-0"> <i class="me-1 fa fa-shopping-basket"></i> Add to cart </a>--%>
                    </div>
                </main>
            </div>
        </div>
    </section>
<%--</div>--%>
<style>
    .icon-hover:hover {
        border-color: #3b71ca !important;
        background-color: white !important;
        color: #3b71ca !important;
    }

    .icon-hover:hover i {
        color: #3b71ca !important;
    }
</style>




<%-------------------------------------------------------------2-------------------------------------------------------------------------%>


<%--    <div class="row">--%>
<%--        <div class="col-md-9">--%>
<%--            <div class="products-details">--%>
<%--                <div class="preview_image">--%>
<%--                    <div class="preview-small">--%>
<%--                        <img src="<c:url value='/template/web/ui/images/products/${product.image}'/>" alt=""--%>
<%--                             style="margin-left: 35px; width: 78%; margin-top: 2px;">--%>
<%--                    </div>--%>
<%--                    <div class="thum-image">--%>
<%--                        <ul id="gallery_01" class="prev-thum">--%>
<%--                            <c:forEach begin="1" end="5">--%>
<%--                                <li><a--%>
<%--                                        href="#"> <img--%>
<%--                                        src="<c:url value='/template/web/ui/images/products/${product.image}'/>" alt="">--%>
<%--                                </a></li>--%>
<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                        <a class="control-left" id="thum-prev"--%>
<%--                           href="javascript:void(0);"> <i class="fa fa-chevron-left">--%>
<%--                        </i>--%>
<%--                        </a> <a class="control-right" id="thum-next"--%>
<%--                                href="javascript:void(0);"> <i class="fa fa-chevron-right">--%>
<%--                    </i>--%>
<%--                    </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="products-description">--%>
<%--                    <h5 class="name" style="font-size: 24px;">${product.name}</h5>--%>
<%--                    <p>--%>
<%--                        Availability: <span class=" light-red" > In Stock </span>--%>
<%--                    </p>--%>
<%--                    <p style="padding-top: 3px; font-size: 18px;">${product.description}</p>--%>
<%--                    <hr class="border">--%>
<%--                    <div class="price">--%>
<%--                        Price : <span class="old_price"><sup>--%>
<%--                                                $${product.price}0  </sup> </span>--%>
<%--                    </div>--%>
<%--                    <hr class="border">--%>
<%--                    <form action="add-to-cart" method="post">--%>
<%--                        <div class="wided">--%>
<%--                            <div class="qty">--%>
<%--                                Qantity &nbsp;&nbsp;: <select name="quantity">--%>
<%--                                <option>1</option>--%>
<%--                                <option>2</option>--%>
<%--                                <option>3</option>--%>
<%--                                <option>4</option>--%>
<%--                                <option>5</option>--%>
<%--                            </select> <input type="hidden" name="productId"--%>
<%--                                             value="${product.id}"/>--%>
<%--                            </div>--%>
<%--                            <div class="button_group">--%>

<%--                                <a href="#"><button--%>
<%--                                        class="button">Add To Cart</button></a>--%>
<%--                                <button class="button favorite">--%>
<%--                                    <i class="fa fa-heart-o"> </i>--%>
<%--                                </button>--%>
<%--                                <button class="button favorite">--%>
<%--                                    <i class="fa fa-envelope-o"> </i>--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                    <div class="clearfix"></div>--%>
<%--                    <hr class="border">--%>
<%--                    <img src="<c:url value='/template/web/client/images/products/share.png'/>" alt="" class="pull-right">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="clearfix"></div>--%>
<%--        </div>--%>
<%--        <div class="col-md-3">--%>
<%--            <div th:replace="client/common/special :: special"></div>--%>
<%--            <div class="clearfix"></div>--%>
<%--            <div class="clearfix"></div>--%>
<%--            <div class="others leftbar">--%>
<%--                <h3 class="title">Others</h3>--%>
<%--            </div>--%>
<%--            <div class="clearfix"></div>--%>
<%--            <div class="clearfix"></div>--%>
<%--            <div class="leftbanner">--%>
<%--                <img src="<c:url value='/template/web/client/images/products/vans.jpg'/>" alt="">--%>
<%--            </div>--%>
<%--            <div class="clearfix"></div>--%>
<%--        </div>--%>


<%--&lt;%&ndash;        <div th:replace="client/common/new :: new"></div>&ndash;%&gt;--%>
<%--    </div>--%>

</body>
</html>