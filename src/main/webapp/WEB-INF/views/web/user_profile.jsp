<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/common/taglib.jsp" %>
<%--<c:url var="formUrl" value="/danh-muc-san-pham"></c:url>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thông tin người dùng</title>
</head>
<body id="home">
    <div class="clearfix"></div>
    <div class="container_fullwidth">
        <div class="container">


                    <div class="checkout-page">
                        <ol class="checkout-steps">
                            <li class="steps">
                                <a href="/don-hang"><div class="step-title">01. Đơn Hàng của tôi</div></a>
                            </li>
                            <li class="steps active">
                                <div style="display: flex;">
                                    <span class="step-title">02. Thông tin người dùng </span>
                                    <c:if test="${messageError != null}">
                                                <span
                                                        style="width: 90%; margin-top: 15px; font-size: 15px; color: red;">${messageError}</span>
                                    </c:if>
                                    <c:if test="${messageSuccess != null}">
                                                <span
                                                        style="width: 100%; margin-top: 15px; font-size: 15px; color: green;">${messageSuccess}</span>
                                    </c:if>
                                </div>
                                <div class="step-description">
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6">
                                           <form action="update-profile" method="post">

                                                <div class="your-details">
                                                    <h5>Chi tiết tài khoản</h5>
                                                    <input type="hidden" name="userId"
                                                           value="${user.id}" />
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Email <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="email" class="input namefild" name="email"
                                                                        readonly="readonly" required="required"
                                                                        value="${user.email}" />
                                                    </div>
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Full Name <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="text" class="input namefild"
                                                                        name="fullname" value="${user.fullName}" />
                                                    </div>
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Số điện thoại <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="text" class="input namefild" name="phone"
                                                                        required="required" value="${user.phone}">
                                                    </div>
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Địa chỉ <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="text" class="input namefild" name="address"
                                                                        required="required" value="${user.address}">
                                                    </div>
                                                    <button type="submit">Cập nhật thông tin</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="col-md-6 col-sm-6">
<%--                                            <form action="change-password" method="post">--%>
                                            <form action="change-password" method="post">
                                                <div class="your-details">
                                                    <h5>Thay đổi mật khẩu</h5>
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Mật khẩu cũ <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="password" class="input namefild"
                                                                        name="oldpassword" required="required">
                                                    </div>
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Mật khẩu mới <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="password" class="input namefild"
                                                                        name="newpassword" required="required">
                                                    </div>
                                                    <div class="form-row">
                                                        <label class="lebel-abs"> Xác nhận mật khẩu <strong
                                                                class="red"> * </strong>
                                                        </label> <input type="password" class="input cpass"
                                                                        name="repassword" required="required">
                                                    </div>
                                                    <p class="privacy">
                                                                <span class="text"> Mật khẩu nên nhiều hơn 8 kí tự </span>
                                                    </p>
                                                    <button type="submit">Đổi mật khẩu</button>

                                                </div>
                                                <p style="color: red; margin-top: -20px; margin-left: 3px; margin-bottom: 5px;">${error}</p>
                                                <p style="color: green; margin-top: -20px; margin-left: 3px; margin-bottom: 5px;">${success}</p>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ol>
                    </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="clearfix"></div>
</body>
</html>
