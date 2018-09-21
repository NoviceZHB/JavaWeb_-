<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/footer.css">
</head>
<body>
<div id="header">
    <div class="h_center">

        <img src="images/log.png" height="60">
        <p>为确保您的账户安全及正常使用，依《网络安全法》规定，6月1日起会员需要绑定手机，如您还未绑定，请尽快完成，感谢您的理解和支持</p>
    </div>
</div>
<div id="login_body">
    <div class="login_b_center">
        <div class="login_bg">
            <h4>密码登录</h4>
            <form action="/JavaWeb4/LoginServlet" method="post" id="log_form">
            <div class="userName">
                <span></span>
                <input type="text" placeholder="请输入用户名..."  name="uname">
            </div>
            <div class="password">
                <span></span>
                <input type="password" placeholder="请输密码..." name="pwd">
            </div>
            <div class="hrh">
                <input type="button" value="登录" onclick="checkData()" >
            </div>
            </form>
            <div class="password_forget">
                <a href="">忘记密码</a>
                <a href="">忘记用户名</a>
                <a href="regist.jsp">免费注册</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

<script>
	function checkData(){
		var form = document.getElementById("log_form");
		form.submit();
	}
</script>
</body>
</html>