<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>订单</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/order_style/css/base.css"/> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/order_style/js/jquery_cart.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/order_style/css/checkOut.css" />
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
  </head>
  

<body>
    
    
 <!--收货地址body部分开始-->  
<div class="container">
	<form action="<c:url value='/commitorder.html'/>" method="post">
    <div class="checkout-box">
            <div class="checkout-box-bd">
                <div class="xm-box">
                    <div class="box-hd ">
    <h2 class="title">收货地址</h2>
</div>
<div class="box-bd">
    <div class="clearfix xm-address-list" id="checkoutAddrList">
          <c:forEach items="${addressList }" var="address">
          <dl class="item" >
            <dt>
                <strong class="itemConsignee">${address.consignee }</strong>
                                <span class="itemTag tag">收货人</span>
                            </dt>
            <dd>
                <p class="tel itemTel">手机号码：${address.phone }</p>
                <p class="itemRegion"> 地        址：${address.address }</p>
                <p class="itemStreet"> 邮        编：${address.zipcode }</p>
                 <a href="<c:url value='/findByAddressId.html?addressId=${address.addressId }'/>"><span class="edit-btn J_editAddr">编辑</span></a>
                 <a href="<c:url value='/deleteAddress.html?addressId=${address.addressId }'/>"><span class="edit-btn J_editAddr">删除</span></a>
                 </dd>
            <dd style="display:none">
                <input type="radio" name="addressId" class="addressId" value="${address.addressId }">
            </dd>
        </dl>
        </c:forEach>
    		  <a href="<c:url value='/userjsps/userdojsp/address/addAddress.jsp'/>">
            <div class="item use-new-addr"  id="J_useNewAddr" data-state="off">
             <span class="iconfont icon-add"><img src="${pageContext.request.contextPath}/order_style/images/add_cart.png" /></span> 
                                    添加新地址                     
             </div>
               </a>
       </div>
       </div>
     
            <div class="checkout-box-ft">
                 <!-- 商品清单 -->
                <div id="checkoutGoodsList" class="checkout-goods-box">
                 <div class="xm-box">
                    <div class="box-hd">
                        <h2 class="title">确认订单信息</h2>
                    </div>
                    <c:forEach items="${orderList }" var="order">
                    <input type="hidden" name="orderId" value="${order.orderId }"/>
                    <div class="box-bd">
                        <dl class="checkout-goods-list">
                            <dt class="clearfix">
                                <span class="col col-1">商品名称</span>
                                <span class="col col-2">购买价格</span>
                                <span class="col col-3">购买数量</span>
                                <span class="col col-4">小计（元）</span>
                            </dt>
                            <c:forEach items="${order.orderitemList }" var="orderitem">
                             <dd class="item clearfix">
                                <div class="item-row">
                                    <div class="col col-1">
                                        <div class="g-pic">
                                            <img src="<c:url value='/image/${orderitem.snacks.image }'/>"  width="40" height="40" />
                                        </div>
                                        <div class="g-info">
                                    <a href="http://item.mi.com/1151500067.html" target="_blank">${orderitem.snacks.snackName }</a>
                                     </div>
                                    </div>
                
                                    <div class="col col-2">${orderitem.snacks.price }元</div>
                                    <div class="col col-3">${orderitem.count }</div>
                                    <div class="col col-4">${orderitem.subtotal }元</div>
                                    </c:forEach>  
                                </div>
                            </dd>
                                     <div class="checkout-price">
                                     <c:set var="totalprice" value="0"/>
                                     <c:forEach items="${order.orderitemList }" var="orderitem">
                                     	<c:set var="totalprice" value="${totalprice + orderitem.subtotal} "/>
                                     </c:forEach>
                                <ul>
                                    <li>
                                    	 <input type="hidden" name="totalprice" value="${totalprice }"/>
                                                                                                      订单总额：<span>${totalprice }元</span>
                                    </li>    
                                </ul>
                            </div>                 
                         </c:forEach>
                            <!-- checkout-count-extend -->
                        </div>
                        <div class="checkout-confirm">
                     <input type="submit" class="btn btn-primary" value="立即下单" id="checkoutToPay" />
                         </div>
                    </div>
                </div>
              </div>
              </div>
             </div>
             </form>
             </div>
             </div>
    <script src="${pageContext.request.contextPath}/order_style/js/base.min.js"></script>

     <script type="text/javascript" src="${pageContext.request.contextPath}/order_style/js/checkout.min.js"></script> 
     <script src="${pageContext.request.contextPath}/order_style/js/index.js" type="text/javascript"></script>
</div>
 
 <!--收货地址body部分结束-->
    

</body>
</html>
