<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>商品详情</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/main/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/main/css/base.css" />
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/snacksdetails_style/shouye.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/common.js"></script>l
	<script type="text/javascript" src="${pageContext.request.contextPath}/main/js/quick_links.js"></script>
	<style>

	.gw_num{border: 1px solid #dbdbdb;width: 110px;line-height: 26px;overflow: hidden;}
	.gw_num em{display: block;height: 26px;width: 26px;float: left;color: #7A7979;border-right: 1px solid #dbdbdb;text-align: center;cursor: pointer;font-style:normal;padding-left:}
	.gw_num .num{display: block;float: left;text-align: center;width: 52px;font-style: normal;font-size: 14px;line-height: 24px;border: 0;}
	.gw_num em.add{float: right;border-right: 0;border-left: 1px solid #dbdbdb;}
	</style>

	<style type="text/css">
		.details{
			border: 1px solid red;
			width: 400px;
			height: 300px;
			float: right;
			margin-top: 80px;
			margin-right: 100px
		}

	</style>

	<script type="text/javascript">
		$(document).ready(function(){
			//加的效果
			$(".add").click(function(){
			var n=$(this).prev().val();
			var num=parseInt(n)+1;
			if(num==0){ return;}
			$(this).prev().val(num);
			});
			//减的效果
			$(".jian").click(function(){
			var n=$(this).next().val();
			var num=parseInt(n)-1;
			if(num==0){ return}
			$(this).next().val(num);
			});
		})
	</script>

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
<div class="Xcontent">
	<ul class="Xcontent01">

		<div class="Xcontent06"><img src="images/shangpinxiangqing/X1.png"></div>
		<ol class="Xcontent08">
			<div class="Xcontent07"><img src="images/shangpinxiangqing/X1.png"></div>
			<div class="Xcontent09"><img src="images/shangpinxiangqing/X7.png"></div>
			<div class="Xcontent10"><img src="images/shangpinxiangqing/X8.png"></div>
			<div class="Xcontent11"><img src="images/shangpinxiangqing/X9.png"></div>
			<div class="Xcontent12"><img src="images/shangpinxiangqing/X10.png"></div>
		</ol>
		<ol class="Xcontent13">
			<div class="Xcontent14"><a href="#"><p>新物品</p></a></div>
			<div class="Xcontent15"><img src="images/shangpinxiangqing/X11.png"></div>
			<div class="Xcontent16"><p>充电5分钟，温暖2小时</p></div>
			<div class="Xcontent17">
				<p class="Xcontent18">售价</p>
				<p class="Xcontent19">￥<span>69.00</span></p>
				<div class="Xcontent20">
					<p class="Xcontent21">促销</p>
					<img src="images/shangpinxiangqing/X12.png">
					<p class="Xcontent22">领610元新年礼券，满再赠好礼</p>
				</div>
				<div class="Xcontent23">
					<p class="Xcontent24">服务</p>
					<p class="Xcontent25">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>
				</div>

			</div>
			<div class="Xcontent26">
				<p class="Xcontent27">颜色</p>
				<div class="Xcontent28"><img  src="images/shangpinxiangqing/X14.png"></div>
				<div class="Xcontent29"><img  src="images/shangpinxiangqing/X1.png"></div>
			</div>
			<div class="Xcontent30">
				<p class="Xcontent31">数量</p>
				<div class="Xcontent32"><img src="images/shangpinxiangqing/X15.png"></div>
				<form>
					<input class="input" value="1"></form>
				<div class="Xcontent33"><img src="images/shangpinxiangqing/16.png"></div>

			</div>
			<div class="Xcontent34"><a href="#"><img src="images/shangpinxiangqing/X17.png"></a></div>
			<div class="Xcontent35"><a href="#"><img src="images/shangpinxiangqing/X18.png"></a></div>

		</ol>



	</ul>

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
					<a href="<c:url value='${pageContext.request.contextPath}/userjsps/userdojsp/cart/list.jsp'/>" class="message_list" ><i class="message"></i><div class="span">购物车</div><span id="cart_num" class="cart_num">${count }</span></a>
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
<script type="text/javascript" src="js/modernizr-custom-v2.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var $miaobian=$('.Xcontent08>div');
		var $huantu=$('.Xcontent06>img');
		var $miaobian1=$('.Xcontent26>div');
		$miaobian.mousemove(function(){miaobian(this);});
		$miaobian1.click(function(){miaobian1(this);});
		function miaobian(thisMb){
			for(var i=0; i<$miaobian.length; i++){
				$miaobian[i].style.borderColor = '#dedede';
			}
			thisMb.style.borderColor = '#cd2426';

			$huantu[0].src = thisMb.children[0].src;
		}
		function miaobian1(thisMb1){
			for(var i=0; i<$miaobian1.length; i++){
				$miaobian1[i].style.borderColor = '#dedede';
			}
//		thisMb.style.borderColor = '#cd2426';
			$miaobian.css('border-color','#dedede');
			thisMb1.style.borderColor = '#cd2426';
			$huantu[0].src = thisMb1.children[0].src;
		}
		$(".Xcontent33").click(function(){
			var value=parseInt($('.input').val())+1;
			$('.input').val(value);
		})

		$(".Xcontent32").click(function(){
			var num = $(".input").val()
			if(num>0){
				$(".input").val(num-1);
			}

		})

	})
</script>
</body>

</html>
