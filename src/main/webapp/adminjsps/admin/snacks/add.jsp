<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
</style>

	  <style type="text/css">
		  body { font-family:Arial, Verdana, sans-serif; width:330px; margin:0 auto; margin-top:10px; }

		  .uploader { position:relative; display:inline-block; overflow:hidden; cursor:default; padding:0; margin:5px 0px; -moz-box-shadow:0px 0px 5px #ddd; -webkit-box-shadow:0px 0px 5px #ddd; box-shadow:0px 0px 5px #ddd; -moz-border-radius:5px; -webkit-border-radius:5px; border-radius:5px; }
		  .filename { float:left; display:inline-block; outline:0 none; height:32px; width:180px; margin:0; padding:8px 10px; overflow:hidden; cursor:default; border:1px solid; border-right:0; font:9pt/100% Arial, Helvetica, sans-serif; color:#777; text-shadow:1px 1px 0px #fff; text-overflow:ellipsis; white-space:nowrap; -moz-border-radius:5px 0px 0px 5px; -webkit-border-radius:5px 0px 0px 5px; border-radius:5px 0px 0px 5px; background:#f5f5f5; background:-moz-linear-gradient(top, #fafafa 0%, #eee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #f5f5f5)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa', endColorstr='#f5f5f5', GradientType=0);
			  border-color:#ccc; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; -moz-box-sizing:border-box; -webkit-box-sizing:border-box; box-sizing:border-box; }
		  .button { float:left; height:32px; display:inline-block; outline:0 none; padding:8px 12px; margin:0; cursor:pointer; border:1px solid; font:bold 9pt/100% Arial, Helvetica, sans-serif; -moz-border-radius:0px 5px 5px 0px; -webkit-border-radius:0px 5px 5px 0px; border-radius:0px 5px 5px 0px; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; }
		  .uploader input[type=file] { position:absolute; top:0; right:0; bottom:0; border:0; padding:0; margin:0; height:30px; cursor:pointer; filter:alpha(opacity=0); -moz-opacity:0; -khtml-opacity: 0; opacity:0; }
		  input[type=button]::-moz-focus-inner {
			  padding:0;
			  border:0 none;
			  -moz-box-sizing:content-box;
		  }
		  input[type=button]::-webkit-focus-inner {
			  padding:0;
			  border:0 none;
			  -webkit-box-sizing:content-box;
		  }
		  input[type=text]::-moz-focus-inner {
			  padding:0;
			  border:0 none;
			  -moz-box-sizing:content-box;
		  }
		  input[type=text]::-webkit-focus-inner {
			  padding:0;
			  border:0 none;
			  -webkit-box-sizing:content-box;
		  }
		  /* White Color Scheme ------------------------ */

		  .white .button { color:#555; text-shadow:1px 1px 0px #fff; background:#ddd; background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #eeeeee), color-stop(100%, #dddddd)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd', GradientType=0);
			  border-color:#ccc; }
		  .white:hover .button { background:#eee; background:-moz-linear-gradient(top, #dddddd 0%, #eeeeee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #dddddd), color-stop(100%, #eeeeee)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dddddd', endColorstr='#eeeeee', GradientType=0);
		  }
		  /* Blue Color Scheme ------------------------ */

		  .blue .button { color:#fff; text-shadow:1px 1px 0px #09365f; background:#064884; background:-moz-linear-gradient(top, #3b75b4 0%, #064884 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #3b75b4), color-stop(100%, #064884)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#3b75b4', endColorstr='#064884', GradientType=0);
			  border-color:#09365f; }
		  .blue:hover .button { background:#3b75b4; background:-moz-linear-gradient(top, #064884 0%, #3b75b4 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #064884), color-stop(100%, #3b75b4)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#064884', endColorstr='#3b75b4', GradientType=0);
		  }
		  /* Green Color Scheme ------------------------ */

		  .green .button { color:#fff; text-shadow:1px 1px 0px #6b7735; background:#7d8f33; background:-moz-linear-gradient(top, #93aa4c 0%, #7d8f33 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #93aa4c), color-stop(100%, #7d8f33)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#93aa4c', endColorstr='#7d8f33', GradientType=0);
			  border-color:#6b7735; }
		  .green:hover .button { background:#93aa4c; background:-moz-linear-gradient(top, #7d8f33 0%, #93aa4c 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #7d8f33), color-stop(100%, #93aa4c)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7d8f33', endColorstr='#93aa4c', GradientType=0);
		  }
		  /* Red Color Scheme ------------------------ */

		  .red .button { color:#fff; text-shadow:1px 1px 0px #7e0238; background:#90013f; background:-moz-linear-gradient(top, #b42364 0%, #90013f 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #b42364), color-stop(100%, #90013f)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#b42364', endColorstr='#90013f', GradientType=0);
			  border-color:#7e0238; }
		  .red:hover .button { background:#b42364; background:-moz-linear-gradient(top, #90013f 0%, #b42364 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #90013f), color-stop(100%, #b42364)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#90013f', endColorstr='#b42364', GradientType=0);
		  }
		  /* Orange Color Scheme ------------------------ */

		  .orange .button { color:#fff; text-shadow:1px 1px 0px #c04501; background:#d54d01; background:-moz-linear-gradient(top, #f86c1f 0%, #d54d01 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #f86c1f), color-stop(100%, #d54d01)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f86c1f', endColorstr='#d54d01', GradientType=0);
			  border-color:#c04501; }
		  .orange:hover .button { background:#f86c1f; background:-moz-linear-gradient(top, #d54d01 0%, #f86c1f 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #d54d01), color-stop(100%, #f86c1f)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#d54d01', endColorstr='#f86c1f', GradientType=0);
		  }
		  /* Black Color Scheme ------------------------ */

		  .black .button { color:#fff; text-shadow:1px 1px 0px #111111; background:#222222; background:-moz-linear-gradient(top, #444444 0%, #222222 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #444444), color-stop(100%, #222222)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#444444', endColorstr='#222222', GradientType=0);
			  border-color:#111111; }
		  .black:hover .button { background:#444444; background:-moz-linear-gradient(top, #222222 0%, #444444 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #222222), color-stop(100%, #444444)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#222222', endColorstr='#444444', GradientType=0);
		  }
	  </style>

	  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
	  <script type="text/javascript">
		  $(function(){

			  $("input[type=file]").change(function(){
				  $(this).parents(".uploader").find(".filename").val($(this).val());
			  });

			  $("input[type=file]").each(function(){
				  if($(this).val()==""){
					  $(this).parents(".uploader").find(".filename").val("请选择文件...");
				  }
			  });

		  });
	  </script>
  </head>
  
  <body>
    <h1>添加商品</h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form action="<c:url value='/admin/adminAddSnacks.html'/>" method="post" enctype="multipart/form-data">
          商品名称：<input type="text" name="snackName"/><br/>
          商品图片：<br/>
		<div class="uploader white">
			<input type="text" class="filename" readonly/>
			<input type="button" name="file" class="button" value="上传..."/>
			<input type="file"  name="file" size="30"/>
		</div>
		<br/>
		<div class="uploader blue">
			<input type="text" class="filename" readonly/>
			<input type="button" name="file" class="button" value="上传..."/>
			<input type="file"  name="file" size="30"/>
		</div>
		<br/>
		<div class="uploader green">
			<input type="text" class="filename" readonly/>
			<input type="button" name="file" class="button" value="上传..."/>
			<input type="file"  name="file" size="30"/>
		</div>
		<br/>
		<div class="uploader red">
			<input type="text" class="filename" readonly/>
			<input type="button" name="file" class="button" value="上传..."/>
			<input type="file"  name="file" size="30"/>
		</div>
		<div class="uploader orange">
			<input type="text" class="filename" readonly/>
			<input type="button" name="file" class="button" value="上传..."/>
			<input type="file"  name="file" size="30"/>
		</div>
		<div class="uploader black">
			<input type="text" class="filename" readonly/>
			<input type="button" name="file" class="button" value="上传..."/>
			<input type="file"   name="file" size="30"/>
		</div><br/>
  	商品单价：<input type="text" name="price"/>元<br/>
  	商品描述：<textarea rows="5" cols="21" name="description"></textarea><br/>
  	商品分类：<select style="width: 150px; height: 20px;" name="categoryId">
  			<c:forEach items="${categoryList }" var="category">
  				<option value="${category.categoryId }">${category.categoryName }</option>
  			</c:forEach>
    	</select><br/>	
    	
         商品状态：<select style="width: 150px; height: 20px;" name="state">
            <option value="1" selected='selected'>上架</option>
  		    <option value="0">下架</option>
    	</select><br/>	
    	<br/>
    	<input type="submit" value="添加商品"/>
    </form>
  </body>
</html>
