<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {background: rgb(254,238,189);}
	table {font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  width: 80%;}
	#th {
		background: rgb(78,78,78);

	}
</style>
  </head>
  
  <body>
    <h2 style="text-align: center;">用户列表</h2>
	<div style="text-align: center;">
	   <form action="<c:url value='/admin/findByPhone.html'/>" method="post">
	     <input type="text" name="phone" placeholder="手机号查询……"/>
	      <input type="submit" value="查询"/>
	   </form>
	</div>
    <table align="center" border="1" cellpadding="0" cellspacing="0">
    	<tr id="th" bordercolor="rgb(78,78,78)">
    		<th>用户ID</th>
    		<th>用户名</th>
    		<th>密码</th>
    		<th>手机号码</th>
    		<th>邮箱</th>
    		<th>操作</th>

    	</tr>
    	<c:forEach items="${userList }" var="user">
    	<tr bordercolor="rgb(78,78,78)">
    		<td>${user.userId }</td>
    		<td>${user.username }</td>
    		<td>${user.password }</td>
    		<td>${user.phone }</td>
    		<td>${user.email }</td>
    		<td>
    		  <a href="<c:url value='/admin/findUserByUserId.html?userId=${user.userId }'/>">修改</a>
    		</td>
    	</tr>
    	</c:forEach>
    </table>



  </body>
</html>
