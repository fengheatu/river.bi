<%--
  Created by IntelliJ IDEA.
  User: he.feng
  Date: 2017/5/4
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>404错误页面</title>
    <link href="css/pintuer.css" rel="stylesheet"/>
</head>

<body>
<div class="container" style=" margin-top:8%;">
    <div class="panel margin-big-top">
        <div class="text-center">
            <br>
            <h2 class="padding-top"> <stong>404错误！抱歉您要找的页面不存在</stong> </h2>
            <div class="">
                <div class="float-left">
                    <img src="http://www.pintuer.com/images/ds-1.gif">
                    <div class="alert"> 卧槽！页面不见了！ </div>
                </div>
                <div class="float-right">
                    <img src="http://www.pintuer.com/images/ds-2.png" width="260">
                </div>
            </div>
            <div class="padding-big">
                <a href="${pageContext.request.contextPath}/index.jsp" class="button bg-yellow">返回首页</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
