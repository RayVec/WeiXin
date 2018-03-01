<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/14
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交结果</title>
    <%
       String result=request.getAttribute("result").toString();
    %>
</head>
<body>
<div align="center"><%=result%></div>
</body>
</html>
