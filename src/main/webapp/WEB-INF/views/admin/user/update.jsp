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
                    <h3 class="panel-title">UPDATE ACCOUNT</h3>
                    <span style="color: red; font-weight: bold; font-size: 18px;">${message}</span>
                </div>
                <form action="update" method="post"
                      enctype="multipart/form-data">
                    <div class="row"
                         style="display: flex; justify-content: space-between;">
                        <table
                                style="margin: auto; margin-left: 45px; margin-right: 50px;"
                                class="col-md-6">
                            <tr>
                                <th>Email:</th>
                                <td><input required="required" type="email"
                                           class="form-control" style="height: 30px;"
                                           placeholder="Your Email..." name="email"
                                           value="${user.email}" readonly="readonly"/>
                                    <input type="hidden" name="userId" value="${user.id}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Full name:</th>
                                <td><input type="text" class="form-control"
                                           style="height: 30px;" placeholder="Your name..."
                                           name="fullName" value="${user.fullName}" /></td>
                            </tr>
                            <tr>
                                <th>Phone number:</th>
                                <td><input required="required" type="text"
                                           class="form-control" style="height: 30px;"
                                           placeholder="Your phone number..." name="phone"
                                           value="${user.phone}" /></td>
                            </tr>
                            <tr>
                                <th>Address:</th>
                                <td><textarea required="required" class="form-control"
                                              placeholder="Your address..." rows="4" name="address">${user.address}</textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td></td>
                            </tr>
                        </table>
                        <table style="margin: auto; margin-right: 30px;"
                               class="col-md-6">
                            <tr>
                                <th>Status:</th>
                                <td><select name="status">
                                    <option value="0">0</option>
                                    <option value="1" selected="selected">1</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th>Password:</th>
                                <td><input type="password"
                                           class="form-control" style="height: 30px;"
                                           placeholder="Your password..." name="password" /></td>
                            </tr>
                            <tr>
                                <th>Re-password:</th>
                                <td><input type="password"
                                           class="form-control" style="height: 30px;"
                                           placeholder="Re-password..." name="repassword" /></td>
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
    </div>
    <!-- END OVERVIEW -->
</div>
</body>
</html>