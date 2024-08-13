<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Trang đăng nhập</title>
<%--    <!-- jquery -->--%>
<%--    <script type='text/javascript' src='<c:url value="/template/admin/js/2.1.4/jquery.min.js" />'></script>--%>

<%--    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />--%>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/authen.css' />" />
<%--    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />--%>
<%--    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />--%>
<%--    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">--%>
<%--    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body style="background-image: url(/template/web/assets/images/background_login.jpg); background-size: cover;">
                                    <form action="login" method="post">
                                        <div class="auth-form" style="background-color: white;">
                                            <div class="auth-form-container">
                                                <div class="auth-form-header">
                                                    <h3 class="auth-form-title">Login</h3>
                                                    <a href="authen/register" class="auth-form-subtitle">Register</a>
                                                </div>
                                                <p style="color: red; margin-top: -15px; margin-left: 3px; margin-bottom: 5px;">
                                                    <c:if test="${param.incorrectAccount != null}">
                                                <div class="alert alert-danger">
                                                    Tên đăng nhập hoặc mật khẩu sai!
                                                </div>
                                                </c:if>
                                                <c:if test="${param.accessDenied != null}">
                                                    <div class="alert alert-danger">
                                                        Bạn không có quyền truy cập!
                                                    </div>
                                                </c:if>
                                                <c:if test="${param.sessionTimeout != null}">
                                                    <div class="alert alert-danger">
                                                        Phiên làm việc hết hạn, yêu cầu đăng nhập lại!
                                                    </div>
                                                </c:if>
                                                </p>
                                                <div class="auth-form-form" style="margin-top: 15px;">
                                                    <div class="auth-form-group"  style="margin-left: 10px" >
                                                        <input class="auth-form-input" type="text" id="username" name="username"
                                                               placeholder="Username" required="required" />
                                                    </div>
                                                    <div class="auth-form-group" style="margin-left: 10px" >
                                                        <input class="auth-form-input" type="password" id="password" name="password"
                                                               placeholder="Password" required="required" />
                                                    </div>
                                                    <div class="auth-form-group" style="display: flex; justify-content: space-between; margin-top: -10px; margin-bottom: 15px;">
                                                        <div><input type="checkbox" name="remember" style="cursor: pointer;"/> Remember me</div>
                                                        <div><a href="">Forgot password?</a></div>
                                                    </div>
                                                </div>

                                                <div class="auth-form-controls">
                                                    <a href="/trang-chu" class="btn">Back </a>
                                                    <button type="submit" class="btn" style="cursor: pointer; ">Login</button>
                                                </div>
                                                <br>
                                                <br>
                                            </div>

                                        </div>

                                    </form>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="ISO-8859-1">--%>
<%--    <title>Login</title>--%>
<%--    <style>--%>
<%--        .container {--%>
<%--            display: flex;--%>
<%--            justify-content: center;--%>
<%--            align-items: center;--%>
<%--            height: 100vh;--%>
<%--        }--%>

<%--        .form-container {--%>
<%--            background-color: #fff;--%>
<%--            padding: 30px;--%>
<%--            border-radius: 5px;--%>
<%--            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);--%>
<%--            margin: 10px;--%>
<%--            width: 400px; /* Adjust the width as per your preference */--%>
<%--        }--%>

<%--        h2 {--%>
<%--            text-align: center;--%>
<%--            color: #5e057e;--%>
<%--            font-weight: bold;--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        .form-group {--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        label {--%>
<%--            display: block;--%>
<%--            margin-bottom: 5px;--%>
<%--            color: #5e057e;--%>
<%--            font-weight: bold;--%>
<%--        }--%>

<%--        input[type="text"],--%>
<%--        input[type="text"],--%>
<%--        input[type="password"] {--%>
<%--            width: 100%;--%>
<%--            padding: 10px;--%>
<%--            border: 1px solid #ccc;--%>
<%--            border-radius: 3px;--%>
<%--            font-weight: bold;--%>
<%--        }--%>

<%--        button[type="submit"] {--%>
<%--            background-color: #5e057e;--%>
<%--            color: #fff;--%>
<%--            padding: 10px 20px;--%>
<%--            border: none;--%>
<%--            border-radius: 3px;--%>
<%--            cursor: pointer;--%>
<%--            width: 100%;--%>
<%--            font-weight: bold;--%>
<%--        }--%>

<%--        button[type="submit"]:hover {--%>
<%--            background-color: #c299d0;--%>
<%--        }--%>

<%--        .error-message, .logout-message {--%>
<%--            background-color: #5e057e;--%>
<%--            color: #fff;--%>
<%--            padding: 10px;--%>
<%--            border-radius: 3px;--%>
<%--            text-align: center;--%>
<%--        }--%>



<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container">--%>
<%--    <div class="message" th:if="${param.error}">--%>
<%--        Invalid Username or Password--%>
<%--    </div>--%>
<%--    <div class="message" th:if="${param.logout}">--%>
<%--        Logout Successfuly--%>
<%--    </div>--%>

<%--    <h2>Login</h2>--%>
<%--        <form--%>
<%--                method="post"--%>
<%--                role="form"--%>
<%--                th:action="@{/login}"--%>

<%--        >--%>

<%--            <div class="form-group">--%>
<%--                <label for="username">Username</label>--%>
<%--                <input  type="email" id="username" name="username" placeholder="Enter your username" required>--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label for="password">Password:</label>--%>
<%--                <input  type="password" id="password" name="password" placeholder="Enter your password" required>--%>
<%--            </div>--%>
<%--            <input type="submit" value="Register">--%>
<%--        </form>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>