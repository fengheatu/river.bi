<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>用户收货信息</title>
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

      <style type="text/css">
           body {
               background: url('/images/welcome.jpg')top center no-repeat;
               background-size:cover;
           }
      </style>
	
  </head>
  
  <body>
  <div style="margin-top: 100px">
   	<h1 style="text-align: center">用户收货信息</h1>
    <div style="position:relative;width:760px;left:50%;margin-left:-125px">
   		<table>
			<tr>
				<td>订单号：</td>
				<td>${order.orderId}</td>
			</tr>
   			<tr>
   				<td>收货人：</td>
   				<td>${order.address.consignee}</td>
   			</tr>
   			<tr>
   				<td>手机号码：</td>
   				<td>${order.address.phone}</td>
   			</tr>
   			<tr>
   				<td>详细地址</td>
   				<td>${order.address.address}</td>
   			</tr>
   			<tr>
   				<td>邮政编码</td>
   				<td>${order.address.zipcode}</td>
   			</tr>

			<tr>
				<td><button onclick="location.href='javascript:history.go(-1);'">返回</button></td>
			</tr>
   		</table>

  </div>
  </div>
  </body>
</html>
