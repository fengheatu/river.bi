<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body style="background: rgb(254,238,189);">
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	
	<c:forEach items="${orderList }"  var="order">
	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
		<c:set var="totalprice" value="0"/>
           <c:forEach items="${order.orderitemList }" var="orderitem">
           <c:set var="totalprice" value="${totalprice + orderitem.subtotal} "/>
           </c:forEach>
			订单编号：${order.orderId }　成交时间：<fmt:formatDate value="${order.ordertime }" pattern="yyyy-MM-dd HH:mm:ss"/>　金额：<font color="red"><b>${totalprice }</b></font>　
			<c:if test="${order.state eq 1 }">
				未付款
			</c:if>
			<c:if test="${order.state eq 2 }">
				<a href="<c:url value='/admin/changeOrderState.html?orderId=${order.orderId }&state=3'/>" onclick="return confirm('确认已经发货')">等待发货</a>
			</c:if>
			<c:if test="${order.state eq 3 }">
				已发货
			</c:if>
			<c:if test="${order.state eq 4 }">
				订单完成
			</c:if>
		</td>
	</tr>
	<c:forEach items="${order.orderitemList }" var="orderitem">
	<tr bordercolor="gray" align="center">
		<td width="15%">
			<div><img src="<c:url value='/image/${orderitem.snacks.image }'/>" height="75"/></div>
		</td>
		<td>商品名：${orderitem.snacks.snackName }</td>
		<td>单价：${orderitem.snacks.price }</td>
		<td>数量：${orderitem.count }</td>
		<td>小计：${orderitem.subtotal }元</td>
	</tr>
	</c:forEach>
	</c:forEach>

</table>
  </body>
</html>
