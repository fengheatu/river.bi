<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>购物车</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/cart_style/etao.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/cart_style/cart.js"></script>
	<link href="${pageContext.request.contextPath}/cart_style/cart.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/cart_style/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css" />
  </head>
  <script type="text/javascript">
  	function delconfirm() {
  		if(confirm("是否删除此订单项")) {
  			return true;
  		}else {
  	    	return false;
  		}
  	}
  </script>
  
 <body class="container">
	<div class="row hidden-print">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<ol class="breadcrumb">
				<li><a href="<%=application.getContextPath()%>">首页</a></li>
                <li class="active">查看购物车</li>
			</ol>
		</div>
	</div>
    <div class="cart-wrap">
		<table id="cartTable" class="cart table table-condensed">
			<thead>
				<tr>
					<th class="t-goods text-center"><label>零食信息</label></th>
					<th class="text-center"></th>
					<th class="t-selling-price text-center"><label>销售单价</label></th>
					<th class="t-qty text-center"><label>采购数量</label></th>
					<th class="t-subtotal text-center"><label>金额小计</label></th>
					<th class="t-action"><label>操作</label></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartitemList }" var="cartitem">
					<tr>
					<td colspan="1" class="goods"><label>
					<input type="checkbox" checked="checked" style="display:none;" class="check-one check" /><img width="100px" height="80px" src="<c:url value='/snacksImages/${cartitem.snacks.image }'/>"/></label></td>
					<td>${cartitem.snacks.snackName }</td>
					<td class="selling-price number small-bold-red text-right"
								style="padding-top: 1.1rem;" data-bind="${cartitem.snacks.price }"></td>
					<td>
						<div class="input-group input-group-sm">
							<a href="<c:url value='/reduceSnacks.html?snacksId=${cartitem.snacks.snacksId }'/>"><button >-</button></a>
							<input id="amount" size="5" type="text" value="${cartitem.amount }" onblur="changAmount('<c:url value='/changAmount.html?snacksId=${cartitem.snacks.snacksId}'/>')"/>
							<a href="<c:url value='/addSnacks.html?snacksId=${cartitem.snacks.snacksId }'/>"><button >+</button></a>
							
						</div>
					</td>
					<td class="subtotal number small-bold-red text-right"></td>
					<td class="action" style="padding-top: 1.1rem;"><span
								class="delete btn btn-xs btn-warning">
								<a  href="<c:url value='/deleteCartitem.html?cartitemId=${cartitem.cartitemId }'/>" onclick="return delconfirm()">删除</a>
								</span></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
					
				
				
				
		<div class="row">
			<div class="col-md-12 col-lg-12 col-sm-12">
				<div class="cart-summary">
					<div style="margin-left: 2rem;" class="pull-right">
						<a href="<c:url value='/addOrder.html'/>" id="btn_settlement" type="button" class="btn btn-primary" >提交订单</a>
					</div>
					<div style="margin-left: 1rem; margin-top: 0.4rem;" class="pull-right total">
						<label>金额合计:<span id="priceTotal" class="price-total large-bold-red">0.00</span></label>
					</div>
					<div style="margin-top: 4px;" class="pull-right">
						<label>共<span id="itemCount" class="large-bold-red" style="margin: 0 4px;"></span>种商品，共计<span id="qtyCount" class="large-bold-red" style="margin: 0 4px;"></span>件
						</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
