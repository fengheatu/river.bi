<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>主页</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/main/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/main/css/base.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/quick_links.js"></script>
	
	
	
  </head>
  
<body id="home" style="height:1000px;">
<form action="<c:url value='/keywordSearch.html'/>" method="get">
	<div class="example" style="position:fixed ;">
    <ul class="nav">
        <li><a href="<c:url value='/showSnacks.html?page=1'/>">首页</a></li>
        <li><a href="#">分类</a>
            <ul class="subs">
                <li>
					<a href="<c:url value='/showSnacks.html?page=1'/>">全部商品</a>
				</li>
				<c:forEach items="${categoryList }" var="category">
				<li>
					<a href="<c:url value='/findByCategoryId.html?categoryId=${category.categoryId }&page=1'/>">${category.categoryName }</a>
				</li>
				</c:forEach>
            </ul>
        </li>
        
        <li style="padding-top: 40px">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			关键字：<input type="text" name="keyword"/>
			<button type="submit" class="btn btn-default">确定</button>
	    </li>
		<li style="padding-top: 40px">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			价格范围：<input type="text" name="startPrice" size="4"/>--
			<input type="text" name="endPrice" size="4"/>
			<input type="hidden" name="page" value="1"/>
			<button type="submit" class="btn btn-default">确定</button>
		</li>
				
    </ul>
    <div style="clear:both"></div>
</div>
</form>
<!--左侧产品parabola.js控制-->
<div style="height: 50px"></div>
<div class="main">
    <div id="plist">  
    <input type="hidden" id="addToCartUrl" value="<c:url value='/addToCart.html'/>"/>
        <ul>
  			<c:forEach items="${pageBean.pageBeanList }" var="pageBean">
            <li>
                <div class="lh_wrap" style="margin: 20px">
                    <div class="p-img"><a href="<c:url value='/snacksdetails.html?snacksId=${pageBean.snacksId }'/>"><img alt="${pageBean.snackName }" src="${pageContext.request.contextPath}/snacksImages/${pageBean.image}" title="${pageBean.snackName }" width="240" height="240"></a></div>
                    <div><a href="<c:url value='/snacksdetails.html?snacksId=${pageBean.snacksId }'/>" style="color: red">${pageBean.description }</a></div>
                    <div class="p-name"><a href="#" title="${pageBean.snackName }">${pageBean.snackName }</a></div>
                    <div class="p-price"><strong>￥${pageBean.price }</strong><span id="p200"></span></div>
                    <c:choose>
                    	<c:when test="${pageBean.state eq 1}">
                    		<div class="extra"><span style="color: red">有货</span></div><br/>
                    <div class="btns">
                    	<input type="hidden"  id="amount"  value="1"/>
                        <a  href="javascript:void(0);" onclick="addToCart('${pageBean.snacksId }')" class="add_cart_large btnCart">加入购物车</a>     
                    </div>
                    	</c:when>
                    	
                    	<c:otherwise>
                    		<div class="extra"><span style="color: red"></span>该商品以下架</div><br/>
                    	</c:otherwise>
                    </c:choose>
                    
                   
                </div>
            </li>
            <div id="flyItem" class="fly_item"><img src="${pageContext.request.contextPath}/image/${pageBean.image}" width="40" height="40"></div>
            </c:forEach>
            <li style="width: 100%; clear: both;">
            <div align="center"><%@ include file="jspsutils/paging.jsp" %></div>
            </li>
        </ul>
    </div>
    
</div>


<!--右侧贴边导航quick_links.js控制-->
<div class="mui-mbar-tabs">
	<div class="quick_link_mian">
		<div class="quick_links_panel">
			<div id="quick_links" class="quick_links">
				<li>
					<a href="#" class="my_qlinks"><i class="setting"></i></a>
					<div class="ibar_login_box status_login">
						<div class="avatar_box">
						<c:if test="${not empty user }">
							<p class="avatar_imgbox"><img src="main/images/no-img_mid_.jpg" /></p>
							<ul class="user_info">
								<li>用户名：${user.username }</li>
								<li>级&nbsp;别：普通会员</li>
							</ul>
							</c:if>
						</div>
						<div class="login_btnbox">
						<c:choose>
					        <c:when test="${empty user }">        
					        	<a href="<c:url value='/userjsps/loginregist.jsp'/>" class="login_order">登录</a>
							    <a href="<c:url value='/userjsps/loginregist.jsp'/>" class="login_favorite">注册</a>	
					     </c:when>
					     	<c:otherwise>
					     		<a href="<c:url value='/findOrderByUserId.html'/>" class="login_order">我的订单</a>
							<a href="<c:url value='/user/logout.html'/>" class="login_favorite">注销</a>
					     	</c:otherwise>
					     </c:choose>
							
						</div>
						<i class="icon_arrow_white"></i>
					</div>
				</li>
				<li id="shopCart">
					<a href="<c:url value='userjsps/userdojsp/cart/list.jsp'/>" class="message_list" ><i class="message"></i><div class="span">购物车</div><span id="cart_num" class="cart_num">${count }</span></a>
				</li>
				
			</div>
			<div class="quick_toggle">
				
				<li><a href="#top" class="return_top"><i class="top"></i></a></li>
			</div>
		</div>
		<div id="quick_links_pop" class="quick_links_pop hide"></div>
	</div>
</div>




<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/parabola.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>
