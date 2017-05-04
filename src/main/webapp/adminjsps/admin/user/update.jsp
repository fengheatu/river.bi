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
	table {
		font-family: 宋体;
		font-size: 11pt;
		border-color: rgb(78,78,78);
		width: 100%;
		align-content: center;
		margin-left: 100px;
	}
	input {

	}
</style>
<script type="text/javascript">
	function getMsg(data) {

			if(data !== null && data !== ''){
				alert(data);
			}

	}

</script>
 </head>
  
  <body onload="getMsg('${msg}')">
  	<h2 style="text-align: center;">修改用户信息</h2>
		<form action="<c:url value='/admin/updateUserInfo.html'/> " method="post">
			<input type="hidden" name="userId" value="${user.userId}"/>
			<table  cellpadding="0" cellspacing="0" >
				<tr>
					<td style="text-align: right;">用户名：</td>
					<td style="text-align: left;"><input type="text" name="username" value="${user.username}"/></td>
				</tr>

				<tr>
					<td style="text-align: right;">重置密码：</td>
					<td style="text-align: left;"><input type="text" name="password"/></td>
				</tr>

				<tr>
					<td style="text-align: right;">手机号码：</td>
					<td style="text-align: left;"><input type="text" name="phone" value="${user.phone}"/></td>
				</tr>

				<tr>
					<td style="text-align: right;">邮箱：</td>
					<td style="text-align: left;"><input type="text" name="email" value="${user.email}"/></td>
				</tr>

				<tr>
					<td></td>
					<td style="text-align: left;"><input type="submit" value="确认修改"/></td>
				</tr>

			</table>
		</form>
  </body>
</html>
