//执行登录
function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var verify = $("#verify").val();
    $.ajax({
        type: "POST",
        async: true,
        url: "/login/login.action",
        data: {
            userName: userName,
            password: password,
            verify: verify
        },
        dataType: "JSON",
        success: function (result) {
            if (result.result == "success") {
                window.location.href = "/main/mainPage.action";
            } else {
                $(".login_phone_result").text(result.data);
                $(".login_phone_result").css("color", "red");
            }
        }
    });
}

//获取验证码
function getVerify() {
    var phoneNum = $("#phoneNum").val();
    $.ajax({
        type: "POST",
        async: true,
        url: "/login/getVerify.action",
        data: {
            phoneNum: phoneNum
        },
        dataType: "JSON",
        success: function (result) {
            $(".login_phone_result").text(result);
            $(".login_phone_result").css("color", "red");
        }
    });
}