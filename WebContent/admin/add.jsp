<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加商品页面</title>
    <link rel="stylesheet" href="${path }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${path }/admin/css/amazeui.min.css" />
</head>
<body>

<div class="main_top">
	
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加商品</strong><small></small></div>
    </div>
    <hr>
	
    <div class="edit_content">
	<form action="${path }/GoodsAddServlet" method="post" id="add_form" style="background:none;width:700px;">
        <div class="item1">
            <div>
                <span>商品名称：</span>
                <input type="text" class="am-form-field" name="name">&nbsp;&nbsp;
            </div>
            <div>
                <span>商品价格：</span>
                <input type="text" class="am-form-field" name="price">
            </div>

        </div>

        <div class="item1">
                <span>所属分类：</span>
                 <select  name="cid">&nbsp;&nbsp;
                 	<c:forEach items="${classList }" var="classList">
                 	 <option value="${classList.cid }">${classList.cname }</option>
                 	</c:forEach>
                 </select>
        </div>

        <div class="item1">
                <span>商品图片：</span>
                <input type="file"  name="image"/>
        </div>
        <div class="item1 item_desc">
            <span>商品描述：</span>
            <textarea  rows="4" cols="50" name="gdesc"></textarea>
        </div>
        <button class="am-btn am-btn-default" type="button" id="add_button">添加</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="am-btn am-btn-default" type="reset" >重置</button>
        </form>
    </div>
    


</div>
<script src="${path }/js/jquery.min.js"></script>
<script>
	$("#add_button").click(function(){
		$("#add_form").submit();
	});
</script>

</body>
</html>