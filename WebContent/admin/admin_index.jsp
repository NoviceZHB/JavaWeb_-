<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<frameset rows="70,*" frameborder=0 border="0" framespacing="0">
    <frame src="${pageContext.request.contextPath }/admin/top.jsp" name="topFrame" scrolling="NO" noresize>
    <frameset cols="250,*" frameborder="0" border="0"  framespacing="10">
        <frame src="${pageContext.request.contextPath }/admin/left.jsp" name="leftFrame"  scrolling="NO">
        <frame src="${pageContext.request.contextPath }/GoodsAllServlet" name="mainFrame" >
    </frameset>
</frameset>



</html>
