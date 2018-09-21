<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/regist.css">
    <link rel="stylesheet" href="css/footer.css">
</head>
<body>
<!--头部-->
<%@ include file="header.jsp" %>
<!--表单内容-->
<div id="reg_content">
    <div class="reg_content_left">
        <form action="/JavaWeb4/RegistServlet" id="reg_form" method="post">
            <div>
                <label>用户名</label>
                <input type="text" placeholder="请输入用户名..." id="reg_name" name="uname">
            </div>
            <div>
                <label>密码</label>
                <input type="text" placeholder="请输入密码..." id="reg_pwd" name="pwd">
            </div>
            <div>
                <label>确认密码</label>
                <input type="text" placeholder="请确认密码..." id="reg_pwd2">
            </div>
            <div>
                <label>电话</label>
                <input type="text" placeholder="请输入电话..." id="reg_phone" name="phone">
            </div>
            <div class="check_box">
                <label>验证码</label>
                <input type="text" id="reg_code" name="code">
                <img src="/JavaWeb4/CheckCodeServlet" onclick="change(this)">
            </div>
            <div class="submit_button">
                <input type="button" value="立即注册" onclick="checkData()">
            </div>

        </form>
    </div>
    <div class="reg_content_right">
        <a href="#">
            <img src="images/reg_right.png" alt="">
        </a>
    </div>
</div>

<!--尾部-->
<%@ include file="footer.jsp" %>
<script>
	function change(obj){
		obj.src = "/JavaWeb4/CheckCodeServlet?time="+new Date().getTime();
	}
	function checkData(){
		//检查注册时是否有空值
		var reg_name = document.getElementById("reg_name");
		var reg_pwd = document.getElementById("reg_pwd");
		var reg_pwd2 = document.getElementById("reg_pwd2");
		var reg_phone = document.getElementById("reg_phone");
		var reg_form = document.getElementById("reg_form");
		var reg_code = document.getElementById("reg_code");
		if(reg_name.value == ""){
			alert("请输入账号");
			return;
		}
		if(reg_pwd.value == ""){
			alert("请输入密码");
			return;
		}
		if(reg_pwd2.value == ""){
			alert("请确认密码");
			return;
		}
		if(reg_phone.value == ""){
			alert("请输入电话");
			return;
		}
		if(reg_code.value == ""){
			alert("请输入验证码");
			return;
		}
		if(reg_pwd.value == reg_pwd2.value){
			//获取表单并且提交表单
			var form = document.getElementById("reg_form");
			form.submit();
		}else{
			alert("密码不一致");
		}
	}
	
	
	
	
	
	
	
	
	
</script>
</body>
</html>