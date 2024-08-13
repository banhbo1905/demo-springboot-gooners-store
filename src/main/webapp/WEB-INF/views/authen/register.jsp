
<body>
<div class="auth-form" style="background-color: white;">
    <form action="register" method="post">
        <div class="auth-form-container">
            <div class="auth-form-header">
                <h3 class="auth-form-title" style="text-align: center; color: red">Register</h3>
            </div>
            <p style="color: red; margin-top: -20px; margin-left: 3px; margin-bottom: 5px;">${error}</p>
            <div class="auth-form-form">
                <div class="auth-form-group">
                    <input class="auth-form-input" type="email" id="email" name="email"
                           placeholder="Email" required="required" value="${email}"/>
                </div>
                <div class="auth-form-group">
                    <input class="auth-form-input" type="text" id="userName" name="userName"
                           placeholder="Username" required="required" value="${userName}"/>
                </div>
                <div class="auth-form-group">
                    <input class="auth-form-input" type="text" id="fullName" name="fullName"
                           placeholder="Fullname" required="required" value="${fullName}"/>
                </div>
                <div class="auth-form-group">
                    <input class="auth-form-input" type="password" id="password" name="password"
                           placeholder="Password" required="required" value="${password}"/>
                </div>
                <div class="auth-form-group">
                    <input class="auth-form-input" type="password" id="repassword" name="repassword"
                           placeholder="Re-password" required="required" value="${repassword}"/>
                </div>
            </div>

            <div class="auth-form-controls">
                <a href="/login" class="btn">Back</a> <button type="submit" style="cursor: pointer;"
                                                              class="btn">Register</button>
            </div>
            <br>
        </div>
    </form>
</div>
</body>
<%--</html>--%>
