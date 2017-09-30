<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div class="container">
    <div class="login_content">
        <div class="input-group login_input">
            <span class="input-group-addon login_text" id="basic-addon1">用户名：</span>
            <input class="form-control login_value" id="userName" placeholder="请输入用户名" aria-describedby="basic-addon1">
        </div>
        <div class="input-group login_input">
            <span class="input-group-addon login_text" id="basic-addon2">密码：</span>
            <input type="password" id="password" class="form-control login_value" placeholder="请输入密码"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group login_input">
            <span class="input-group-addon login_text" id="basic-addon3">手机号码：</span>
            <input id="phoneNum" class="form-control login_value" placeholder="请输入手机号码" aria-describedby="basic-addon1">
        </div>
        <div class="login_btn_verify">
            <button type="button" class="btn btn-primary btn-xs" onclick="getVerify()">点击获取验证码</button>
            <span class="login_phone_result"></span>
        </div>
        <div class="input-group login_input">
            <span class="input-group-addon login_text" id="basic-addon4">验证码：</span>
            <input id="verify" class="form-control login_value" placeholder="请输入收到的验证码" aria-describedby="basic-addon1">
        </div>
        <div class="btn-group login_submit" role="group" aria-label="...">
            <button type="button" class="btn btn-primary" onclick="login()">登录</button>
        </div>
    </div>
</div>

<link rel="stylesheet" type="text/css" href="/source/common/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/source/module/permission/css/login.css"/>
<script src="/source/common/js/jquery.min.js"></script>
<script src="/source/common/js/bootstrap.min.js"></script>
<script src="/source/module/permission/js/login.js"></script>
</body>
</html>