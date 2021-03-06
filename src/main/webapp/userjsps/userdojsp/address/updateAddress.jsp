<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>更新地址信息</title>
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

  <body style="background-color: #4d4d4d">
  <div style="margin-top: 200px">
   	<h1 style="text-align: center">更新地址信息</h1>
	  <div style="position:relative;width:760px;left:50%;margin-left:-125px">
    	<form action="<c:url value='/updateAddress.html'/>" method="post">
   		 <table>
   		 <tr>
   				<td></td>
   				<td><input type="hidden" name="addressId" value="${address.addressId }"/></td>
   			</tr>
   			<tr>
   				<td>收货人：</td>
   				<td><input type="text" name="consignee" value="${address.consignee }"/></td>
   			</tr>
   			<tr>
   				<td>手机号码：</td>
   				<td><input type="text" name="phone"	id="phone" value="${address.phone }" onblur="return checkPhone()"/>
   					<span style="color:red;" id="phoneMsg"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>详细地址</td>
   				<td><input type="text" name="address"	id="address" value="${address.address }"/></td>
   			</tr>
   			<tr>
   				<td>邮政编码</td>
   				<td><input type="text" name="zipcode" id="zipcode" value="${address.zipcode }"/></td>
   			</tr>
   			<tr>
   				<td><input type="submit" value="更新"/></td>
   				<td><input type="reset"	value="重置地址信息"/></td>
   			</tr>
   		</table>
   	</form>
	  </div>
  </div>
  </body>
</html>
