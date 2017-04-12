<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
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
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body>
  <div>
    <img src="<c:url value='/image/${snacks.image}'/>" border="0" width="103px" height="147px"/>
  </div>
  <form   action="<c:url value='/admin/adminUpdateSnacksById.html'/>" method="post" enctype="multipart/form-data">
           商品图片：<input style="width: 223px; height: 20px;" type="file" name="image"/><br/>
  			<input type="hidden" name="snacksId" value="${snacks.snacksId }"/>
  			<input type="hidden" name="image" value="${snacks.image}"/>
  	商品名称：<input type="text" name="snackName" value="${snacks.snackName }"/><br/>
  	商品单价：<input type="text" name="price" value="${snacks.price }"/>元<br/>
  	商品描述：<textarea rows="5" cols="21" name="description">${snacks.description }</textarea><br/>
  	商品分类：<select style="width: 150px; height: 20px;" name="categoryId">
  			<c:forEach items="${categoryList }" var="category">
  			<c:choose>
  				<c:when test="${category.categoryId eq snacks.category.categoryId }">
  					<option value="${category.categoryId }" selected='selected'>${category.categoryName }</option>
  				</c:when>
  				
  				<c:otherwise>
  				
  				<option value="${category.categoryId }">${category.categoryName }</option>
  				</c:otherwise>
  			</c:choose>
  			</c:forEach>
    	</select><br/>	
    	
    	商品状态：<select style="width: 150px; height: 20px;" name="state">
    			<c:choose>
    				<c:when test="${snacks.state eq 1 }">
    					<option value="1" selected='selected'>上架</option>
  				         <option value="0">下架</option>
    				</c:when>
    				
    				<c:otherwise>
    				    <option value="1" >上架</option>
  				        <option value="0" selected='selected'>下架</option>
    				</c:otherwise>
    			</c:choose>
 
    	</select><br/>	
  	    <input type="submit"  value="修改"/>
  </form>
  </body>
</html>
