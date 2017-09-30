$(document).ready(function () {
    //默认查询第一个导航栏
    var pid = 1;
    //加载导航栏
    loadNavigateBar();
    //加载左侧菜单列表
    loadLeftMenus(pid);
    //加载用户信息
    loadSysUser();
});

//加载用户信息
function loadSysUser() {
    $.ajax({
        type: "POST",
        async: true,
        url: "/sysUser/querySysUserList.action",
        dataType: "json",
        success: function (result) {
            var flag = result.result;
            if (flag == "success") {
                var str = '<table>';
                var data = result.data;
                str += "<tr><th>用户名</th><th>密码</th></tr>";
                for (var i = 0; i < data.length; i++) {
                    str += "<tr><td>"+data[i].userName+"</td><td>"+data[i].password+"</td></tr>";
                }
                str += "</table>";
                $(".main_body .main_right .main_table").html(str);
                $(".main_body .main_left ul li").css("background-color", "beige");
                $(".main_body .main_left ul li:first").css("background-color", "#40b9ff");
            } else {
                $(".main_body .main_header").text("数据暂不能提供");
            }
        }
    });
}

//加载导航栏
function loadNavigateBar() {
    $.ajax({
        type: "POST",
        async: true,
        url: "/menu/menuList.action",
        data: {
            pid: "root"
        },
        dataType: "json",
        success: function (result) {
            var flag = result.result;
            if (flag == "success") {
                var str = '<ul>';
                var data = result.data;
                for (var i = 0; i < data.length; i++) {
                    str += "<li onclick='loadLeftMenus(" + data[i].id + ")'>" + data[i].menuName + "</li>";
                }
                str += "</ul>";
                $(".main_body .main_header").html(str);
                $(".main_body .main_header ul li").css("background-color", "beige");
                $(".main_body .main_header ul li:first").css("background-color", "#40b9ff");
            } else {
                $(".main_body .main_header").text("数据暂不能提供");
            }
        }
    });
}

//加载菜单列表
function loadLeftMenus(pid) {
    $.ajax({
        async: true,
        type: "POST",
        url: "/menu/menuList.action",
        data: {
            pid: pid
        },
        dataType: "json",
        success: function (result) {
            var flag = result.result;
            if (flag == "success") {
                var str = '<ul class=\"main_menus\">';
                var data = result.data;
                for (var i = 0; i < data.length; i++) {
                    str += "<li>" + data[i].menuName + "</li>";
                }
                str += "</ul>";
                $(".main_body .main_left").html(str);
            } else {
                $(".main_body .main_left").text("数据暂不能提供");
            }
            $(".main_body .main_header ul li").css("background-color", "beige");
            $(".main_body .main_header ul li").eq(parseInt(pid) - 1).css("background-color", "#40b9ff");
            $(".main_body .main_left ul li").css("background-color", "beige");
            $(".main_body .main_left ul li:first").css("background-color", "#40b9ff");
        }
    });
}