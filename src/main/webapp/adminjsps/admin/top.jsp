<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background: rgb(78,78,78);color: white;">
<h1 style="text-align: center; ">小吃货零食商城后台管理</h1>
<p style="font-size: 11pt;">管理员：${admin.adminUsername } &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/adminLogout.html" style="background-color: #8BC145;text-decoration: none" target="_top">安全退出</a></p>
  </body>
</html>
