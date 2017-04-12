<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>'paging.jsp'</title>
	
  </head>
  
  <body>
    <div class="container">
	<div class="row">
		<div class="span12">
		<c:choose>
		<c:when test="${empty pageBean.pageBeanList }">
			<span style="color: red; font-size: 20px; font-weight: bold;">第0页/共0页</span>
		
		</c:when>
		
		<c:otherwise>
			<div align="center">
	 <span style="color: red; font-size: 20px; font-weight: bold;">第${pageBean.page }页/共${pageBean.totalPages }页</span>
  <a href="${pageBean.url }page=1"><button class="button">首页</button></a>
  <c:if test="${pageBean.page > 1 }">
  <a href="${pageBean.url }page=${pageBean.page-1 }"><button class="button">上一页</button></a>
  </c:if>
  <c:choose>
  	<c:when test="${pageBean.totalPages < 10 }">
  		<c:set var="begin" value="1"/>
  		<c:set var="end"   value="${pageBean.totalPages }" />
  		
  	</c:when>
  	
  	<c:otherwise>
  		<c:set var="begin" value="${pageBean.page-5 }"/>
  		<c:set var="end"	value="${pageBean.page+4 }"/>
  		
  		<c:if test="${begin < 1 }">
  		<c:set var="begin" value="1"/>
  		<c:set var="end"	value="10"/>
  		</c:if>
  		
  		<c:if test="${end > pageBean.totalPages }">
  		<c:set var="begin" value="${pageBean.page-9 }"/>
  		<c:set var="end"	value="${pageBean.totalPages }"/>
  		</c:if>
  	
  	</c:otherwise>
  
  </c:choose>
  
  <c:forEach var="i"  begin="${begin }"   end ="${end }">
	<c:choose>
		<c:when test="${i eq pageBean.page }">
			<button class="button">[${i }]</button>
		</c:when>
		<c:otherwise>
			<a href="${pageBean.url }page=${i }"><button class="button">[${i }]</button></a>
		</c:otherwise>
	
	</c:choose>
  
  </c:forEach>
  
  
  
  <c:if test="${pageBean.page < pageBean.totalPages }">
  <a href="${pageBean.url }page=${pageBean.page+1 }"><button class="button">下一页</button></a>
  </c:if>
  <a href="${pageBean.url }page=${pageBean.totalPages }"><button class="button">尾页</button></a>
	</div>
		
		</c:otherwise>
	</c:choose>
		</div>
	</div>
</div>
 
  </body>
</html>
