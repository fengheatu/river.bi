<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
<script language="javascript">
var bar1 = new Q6MenuBar("bar1", "小吃货网络零食商城");
function load() {
	bar1.colorStyle = 2;
	bar1.config.imgDir = "<c:url value='/menu/img/'/>";
	bar1.config.radioButton=false;
	bar1.add("分类管理", "查看分类", "<c:url value='/admin/adminFindAllCategory.html'/>", "body");
	bar1.add("分类管理", "添加分类", "<c:url value='/adminjsps/admin/category/add.jsp'/>", "body");

	bar1.add("商品管理", "查看商品", "<c:url value='/admin/showSnacks.html?page=1'/>", "body");
	bar1.add("商品管理", "添加商品", "<c:url value='/admin/adminFindAllCategoryToAdd.html'/>", "body");

	bar1.add("订单管理", "所有订单", "<c:url value='/admin/adminFindAllOrder.html'/>", "body");
	bar1.add("订单管理", "未付款订单", "<c:url value='/admin/addminFindOrderByState.html?state=1'/>", "body");
	bar1.add("订单管理", "已付款订单", "<c:url value='/admin/addminFindOrderByState.html?state=2'/>", "body");
	bar1.add("订单管理", "未收货订单", "<c:url value='/admin/addminFindOrderByState.html?state=3'/>", "body");
	bar1.add("订单管理", "已完成订单", "<c:url value='/admin/addminFindOrderByState.html?state=4'/>", "body");

	bar1.add("用户管理", "所有用户", "<c:url value='/admin/findAllUser.html'/>", "body");

	var d = document.getElementById("menu");
	d.innerHTML = bar1.toString();
}
</script>

</head>

<body onload="load()" style="margin: 0px; background: rgb(254,238,189);">
<div id="menu"></div>

</body>
</html>
