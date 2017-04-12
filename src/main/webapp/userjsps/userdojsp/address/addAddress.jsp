<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>添加地址</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">
    	function checkPhone(){
				var phone=$("#phone").val();
				var regex = new RegExp("1(3|4|5|7|8)\\d{9}");
	
				if(!regex.test(phone)) {
	                  $("#phoneMsg").text("手机号码格式有误");
	                  return false;
                }else {
                	return true;
                }
             }
    </script> 
	
  </head>
  
  <body>
   	<h1>添加新地址信息</h1>
   	<form action="<c:url value='/addAddress.html'/>" method="post">
   		<table>
   			<tr>
   				<td>收货人：</td>
   				<td><input type="text" name="consignee" /></td>
   			</tr>
   			<tr>
   				<td>手机号码：</td>
   				<td><input type="text" name="phone"	id="phone" onblur="return checkPhone()"/>
   					<span style="color:red;" id="phoneMsg"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>详细地址</td>
   				<td><input type="text" name="address"	id="address"/></td>
   			</tr>
   			<tr>
   				<td>邮政编码</td>
   				<td><input type="text" name="zipcode" id="zipcode"/></td>
   			</tr>
   			<tr>
   				<td><input type="submit" value="添加"/></td>
   				<td><input type="reset"	value="重置地址信息"/></td>
   			</tr>
   		</table>
   	</form>
  </body>
</html>
