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
	 <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/main/css/style.css"/>
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>

	<script type="text/javascript">
		function checkorder() {
			if(confirm("确定收货后点击")) {
				return true;
			}else {
				return false;
			}
			
		}
	
	</script>
  </head>
  
  <body>
  <div class="example">
    <ul class="nav">
        <li><a href="<c:url value='/showSnacks.html?page=1'/>">首页</a></li>   
        <li>
			<a href="<c:url value='/findOrderByUserId.html'/>">我的订单</a>
	    </li>
		<li>
			<a href="<c:url value='/findOrderByUserIdWithState.html?state=1'/>">未付款订单</a>
		</li>
		<li>
			<a href="<c:url value='/findOrderByUserIdWithState.html?state=2'/>">已付款未发货订单</a>
		</li>
		<li>
			<a href="<c:url value='/findOrderByUserIdWithState.html?state=3'/>">已付款已发货订单</a>
		</li>
		
		<li>
			<a href="<c:url value='/findOrderByUserIdWithState.html?state=4'/>">完成订单</a>
		</li>
				
    </ul>
</div>
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
				<a href="<c:url value='/payOneOrder.html?orderId=${order.orderId }'/>">付款</a>
				<a href="<c:url value='/realDeleteOneOrder.html?orderId=${order.orderId }'/>" onclick="return confirm()">删除</a>
			</c:if>
			<c:if test="${order.state eq 2 }">
				等待发货
			</c:if>
			<c:if test="${order.state eq 3 }">
				<a href="<c:url value='/updateOrderState.html?orderId=${order.orderId }&state=4'/>" onclick="return checkorder()">确认收货</a>
			</c:if>
			<c:if test="${order.state eq 4 }">
				订单完成
				<a href="<c:url value='/deleteOneOrder.html?orderId=${order.orderId }'/>" onclick="return confirm()">删除</a>
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
