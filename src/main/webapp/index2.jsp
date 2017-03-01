<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html lang="zh_cn">
<head>
<meta charset="utf-8">
<title>游客网页</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" >
    $(function(){


     });
</script>
</head>
<body>
		<form action="listPro.do">
		<table border="1">
			<c:forEach items="${allpro}" var="bgtmp" >
					<tr><td>商品ID</td><td>商品价格</td><td>商品图片</td></tr>
					<tr><td>${bgtmp.productId}</td><td>${bgtmp.productPrice}</td><td>${bgtmp.headImage}</td></tr>
			</c:forEach>
		</table>
		</form>	
</body>
</html>