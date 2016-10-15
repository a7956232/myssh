<%--
  Created by IntelliJ IDEA.
  User: 95
  Date: 2016/10/12
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
    <style type="text/css">
        .div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
    </style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
    欢迎您：<s:property value="#session.existEmployee.ename"/>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/employee_logout.action" target="_top">安全退出</a>
</div>
</body>
</html>
