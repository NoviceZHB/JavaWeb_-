<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/detail.css">
    <link rel="stylesheet" href="css/footer.css">

</head>
<body>
<!--头部-->
<div id="header">
    <!--顶部-->
    <div class="header_top">
        <div class="header_top_center">
            <div class="h_top_left">
                欢迎来到码蚁商城
            </div>
            <div class="h_top_right">
                <a href="login.jsp">登录</a>
                <a href="regist.jsp">免费注册</a>
                <a href="#">购物车</a>
                <a href="#">我的订单</a>
            </div>
        </div>
    </div>
    <!--中部搜索-->
    <div class="header_center">
        <div class="h_c_logo">
            <img src="images/logo.png" alt="">
        </div>

        <div class="h_c_search">
            <form action="#" >
                <input type="text" placeholder="输入一些内容。。。" class="t_input">
                <input type="submit" class="t_button">
            </form>
            <div class="hot">
                <a href="#">新款连衣裙</a>
                <a href="#">四件套</a>
                <a href="#">潮流T恤</a>
                <a href="#">时尚女鞋</a>
                <a href="#">短裤半身裙</a>
            </div>
        </div>

        <div class="h_c_code">
            <img src="images/pcode.png" alt="">
        </div>
    </div>
    <!--导航-->
    <div class="nav">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="goods_list.jsp">电脑办公</a></li>
            <li><a href="#">家具家居</a></li>
            <li><a href="#">鲜果时光</a></li>
            <li><a href="#">图书音像</a></li>
            <li><a href="#">母婴孕婴</a></li>
        </ul>
    </div>

</div>
<!--面包屑导航-->
<div id="bread_crumb">
    <div class="bread_center">

        <a href="index.jsp">首页</a>
        <small>&gt</small>
        <a href="#">运动户外</a>
        <small>&gt</small>
        <a href="#">运动服饰</a>
    </div>
</div>
<!--详情展示-->
<div id="detail">
    <!--左侧-->
    <div class="detail_img">
        <img src="images/goods/bigPic.png" alt="">
    </div>
    <!--右侧-->
    <div class="detail_price">
        <h3>小米 红米5A 全网通版 2GB+16GB 浅蓝色 移动联通电信4G手机 双卡双待</h3>
        <div class="goods_price">
            <p class="ori_price">原价：￥699.00  <em></em></p>
            <p> 价格： <i class="yuan">￥</i><span class="price">599</span></p>
        </div>
         <div class="goods_count">
             购买数量 <input type="text" value="1">
         </div>

        <div class="goods_buy mt50 ml5">
            <input type="submit" value="加入购物车">
        </div>

    </div>
    
</div>

<!--商品介绍-->
<div id="introduce">
    <h3>商品详情</h3>
    <div class="introduce_body">
        <img src="images/detail_pic1.png" alt="">
        <img src="images/detail_pic2.png" alt="">
    </div>
</div>

<!--尾部-->
<%@ include file="footer.jsp" %>


</body>
</html>