<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el标签表达式</title>
</head>
<body>
<%
	pageContext.setAttribute("name", "pageContext");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
%>
${pageScope.name}
<br/>
${requestScope.name}
<br/>
${sessionScope.name}
<br/>
${name }
<h1>-----------------</h1>
${11+11 }
</body>
</html>