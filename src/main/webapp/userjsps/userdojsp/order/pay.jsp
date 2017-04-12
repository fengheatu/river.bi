 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>支付页面</title>
        <link href="${pageContext.request.contextPath}/order_style/css/public.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/order_style/css/base.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/order_style/js/jquery_cart.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/order_style/css/buyConfirm.css" />
		 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
   		 <script src="${pageContext.request.contextPath}/order_style/js/unslider.min.js" type="text/javascript"></script>
  	     <script src="${pageContext.request.contextPath}/order_style/js/index.js" type="text/javascript"></script>
<script type="text/javascript">

window.onload = function(){
new tab('test4-input-input_tab1-input_tab2', '-');
}
function tab(o, s, cb, ev){ //tab换类
var $ = function(o){return document.getElementById(o)};
var css = o.split((s||'_'));
if(css.length!=4)return;
this.event = ev || 'onclick';
o = $(o);
if(o){
this.ITEM = [];
o.id = css[0];
var item = o.getElementsByTagName(css[1]);
var j=1;
for(var i=0;i<item.length;i++){
if(item[i].className.indexOf(css[2])>=0 || item[i].className.indexOf(css[3])>=0){
if(item[i].className == css[2])o['cur'] = item[i];
item[i].callBack = cb||function(){};
item[i]['css'] = css;
item[i]['link'] = o;
this.ITEM[j] = item[i];
item[i]['Index'] = j++;
item[i][this.event] = this.ACTIVE;
}
}
return o;
}
}
tab.prototype = {
ACTIVE:function(){
var $ = function(o){return document.getElementById(o)};
this['link']['cur'].className = this['css'][3];
this.className = this['css'][2];
try{
$(this['link']['id']+'_'+this['link']['cur']['Index']).style.display = 'none';
$(this['link']['id']+'_'+this['Index']).style.display = 'block';
}catch(e){}
this.callBack.call(this);
this['link']['cur'] = this;
}
}
</script>
</head>

<body>

    
 <!--订单提交body部分开始-->  


<div class="border_top_cart">

        <div class="container payment-con">
    <form  target="_blank" action="<c:url value='/payToBank.html'/>"  method="post">
            <div class="order-info">
                <div class="msg">
                    <h3>您的订单已提交成功！付款咯～</h3>
                    <p></p>
                     <p class="post-date">成功付款后，7天发货</p>
                </div>
                <div class="info">
                 <p>金额：<span class="pay-total">${totalprice }</span></p>
                 		<input type="hidden" name="orderId" value="${order.orderId }"/>
                    <p>订单：${order.orderId }</p>
                    <p> 配送：${order.address.consignee }   <span class="line">/</span>${order.address.phone }<span class="line">/</span>${order.address.address }  </p>
                </div>
                <div class="icon-box">
                    <i class="iconfont"><img src="images/yes_ok.png"></i>
                </div>
            </div>
            
            <div class="xm-plain-box">
                  <!-- 选择支付方式 -->
                <div class="box-hd bank-title clearfix">
                    <div id="titleWrap" class="title-wrap">
                        <h2 class="title">选择支付方式</h2>
                        <h2 class="title hide " >你还需要继续支付 <em>49.00</em> 元</h2>
                        <span class="tip-tag"></span>
                    </div>
                </div>
                <div class="box-bd" id="bankList">
                    <div class="payment-bd">
                    <form name="ck">
                    <dl class="clearfix payment-box" >
                    <dt>
                                <strong>支付平台</strong>
                                <p>手机等大额支付推荐使用支付宝快捷支付</p>
                            </dt>
                            <dd>
                        <fieldset id="test4-input-input_tab1-input_tab2" style=" border:none;">
                        <ul class="payment-list clearfix" >
                           
                            <li><input class="input_tab2" name="myradio" id="r2" type="radio" /><label for="r2" ><img src="${pageContext.request.contextPath}/order_style/images/zfb.png" alt=""/></label></li>
                           
                             </ul>
                        <div >
              
                        <div  id="test4_2" style="display:none;">
                        	
                        </div>
                        <div  id="test4_3" style="display:none;">
                        	
                        </div>
                        <div  id="test4_4" style="display:none;">
                        	
                        </div>

                       

                        </div>
                        </fieldset>
                        </dd>
                        </dl>
                        </form>

                        <dl class="clearfix payment-box" >
                            <dt>
                                <strong>银行网银</strong>
                                <p>支持以下各银行借记卡及信用卡</p>
                                
                            </dt>
                            <dd>
                                                                <ul class="payment-list clearfix">
                                 
                                    <li><label  for="ICBC-NET-B2C "><input type="radio" name="pd_FrpId" id="ICBC-NET-B2C" value="ICBC-NET-B2C" /> <img src="http://s1.mi.com/images/payOnline_gsyh.gif" alt=""/></label></li>
                                    <li><label  for="CCB-NET-B2C "><input type="radio" name="pd_FrpId" id="CCB-NET-B2C" value="CCB-NET-B2C" /> <img src="http://s1.mi.com/images/payOnline_jsyh.gif" alt=""/></label></li>
                                    <li><label  for="ABC-NET-B2C "><input type="radio" name="pd_FrpId" id="ABC-NET-B2C" value="ABC-NET-B2C" /> <img src="http://s1.mi.com/images/payOnline_nyyh.gif" alt=""/></label></li>
                                       </ul>
                            </dd>
                        </dl>
                        

                                                
                                                
                    </div>
                            </div>
            <div class="box-ft clearfix">
                    <input type="submit" class="btn btn-primary" value="下一步" id="payBtn">
                    <a href="#" class="btn btn-lineDakeLight">修改订单</a>
                    <span class="tip"></span>
                </div>
            </div>
</form>  
</div>
<!-- 支付弹框 -->
<div class="modal hide to-pay-tip" id="toPayTip">
    <div class="modal-header">
        <span class="close" id="toPayTipClose">
            <i class="iconfont">&#xe617;</i>
        </span>
        <h3>正在支付...</h3>
    </div>
    <div class="modal-body">
        <div class="pay-tip clearfix">
            <div class="fail">
                <h4>如果支付失败...</h4>
                <p>额度问题，推荐<a href="#" id="alipayTrigger">支付宝快捷支付 &gt;</a></p>
                <p>其他问题，查看<a href="#">支付常见问题 &gt;</a></p>
            </div>
            <div class="success">
                <h4>支付成功了</h4>
                <p>立即查看<a href="#" target="_blank">订单详情 &gt;</a></p>
            </div>
        </div>
    </div>
</div>
    </div>
    
</div>



    <script src="js/base.min.js"></script>

        <script type="text/javascript" src="js/buyConfirm.js"></script>
   
</div>


</body>
</html>
