<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>修改密码</title>
<title>密码强度/Password Strength Demo</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets_changepwd/css/style.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		function checkPassword() {
			var password = $("#password").val();
			if(password.length < 6) {

				$("#passwordMsg").text("密码长度大于等于6");
				return false;
			} 
			
			var confirmPassword = $("#password2").val();

			if(password != confirmPassword) {
				$("#passwordMsg").text("两次输入密码不一致");
				return false;
			}else{
				return true;
			}
			
		}
		</script>


</head>

<body>

	<div id="page-wrap">
		<div id="title"> 重置密码</div>
		<form action="<c:url value='/user/changePassword.html'/>" method="post">
		<input type="text" name="phone" placeholder="手机号码" value="${phone }" readonly="readonly"/>
		<input type="password" name="password" id="password" placeholder="输入密码"/>
		<input type="password" name="password2" id="password2" placeholder="确认密码"/>
		<span style="color: red" id="passwordMsg"></span>
		<input type="submit" value="确定重置" onclick="return checkPassword()"/>
		</form>
	</div>



</body>
</html>
