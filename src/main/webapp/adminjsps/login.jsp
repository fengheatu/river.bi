<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #93a1a1">
<h1 align="center" style="color: #1B6AAA">管理员登录页面</h1>
<hr/>
<div align="center">
  <p style="font-weight: 900; color: red">${adminMsg }</p>
<form action="<c:url value='/admin/adminLogin.html'/>" method="post">
	管理员账户：<input type="text" name="adminUsername" value=""/><br/>
	密　　　码：<input type="password" name="adminPassword"/><br/>
	<input type="submit" value="进入后台"/>
</form>
</div>
  </body>
</html>
