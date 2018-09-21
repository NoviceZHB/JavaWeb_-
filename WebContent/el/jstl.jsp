<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.hk.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl标签表达式</title>
</head>
<body>
<% 
	request.setAttribute("count", 100);
%>
<!-- el表达式 -->
<c:if test="${count > 50}"><h1>count > 50</h1></c:if>
<c:if test="${count < 50}"><h1>count < 50</h1></c:if>
<c:if test="${count == 50}"><h1>count = 50</h1></c:if>

<%
	List<String> List = new ArrayList<String>();
	List.add("aaa");
	List.add("bbb");
	List.add("ccc");
	request.setAttribute("userList", List);
%>
<c:forEach items="${userList }" var="user">
	${user }
</c:forEach>
<hr/>
<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("name", "张三");
	map.put("age", "11");
	map.put("sex", "男");
	request.setAttribute("map", map);
%>
<c:forEach items="${map }" var="map">
	${map.key }:${map.value }
</c:forEach>
</body>
</html>