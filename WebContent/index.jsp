<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/pageStyle.css">
</head>

<body>

<!--头部-->
<%@ include file="header.jsp" %>
<!--广告-->
<div id="ad">
    <img src="images/goods/ad.jpg" alt="">
</div>
<!--秒杀-->
<div id="ms">
    <div class="ms_top">
        <span>码蚁秒杀</span>
        <span>总有你想不到的低价</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="#">
                    <img src="images/goods/good1.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="images/goods/good1.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="#">
                <img src="images/goods/good1.png" alt="">
                <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                <i class="yuan">￥</i><span class="price">599</span>
            </a></li>
            <li>
                <a href="#">
                    <img src="images/goods/good1.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="#">
                <img src="images/goods/good1.png" alt="">
                <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                <i class="yuan">￥</i><span class="price">599</span>
             </a>
            </li>
        </ul>
    </div>
</div>
<!--热卖-->
<div id="hot_goods">
    <h3>热卖商品</h3>
    <div class="hot_goods_body">
       <ul>
           <li>
               <a href="">
                   <img src="images/goods/goods6.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods7.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods8.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods9.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods10.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods11.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods12.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods13.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
           <li>
               <a href="">
                   <img src="images/goods/goods14.png" alt="">
                   <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                   <i class="yuan">￥</i><span class="price">599</span>
               </a>
           </li>
       </ul>
    </div>
</div>

<div id="page" class="page_div"></div>
<!-- 尾部  -->
<%@ include file="footer.jsp" %>



<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:3,  /*当前选中的是哪一页*/
        totalPage: 15, /*共多少页*/
        totalSize: 300,/*共多少条记录*/
        callback: function(num) {
           console.log(num);
        }
    })
</script>
</body>
</html>