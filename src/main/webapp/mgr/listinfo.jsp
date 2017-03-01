<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>

</head>
<body>
	<!-- 包含等待框 -->
	<jsp:include page="../waittable.jsp" flush="true" />
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td bgcolor="#FFFFFF"><table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
					<tr align="left" bgcolor="#F2FDFF">
						<td colspan="20" class="optiontitle">车型列表</td>
					</tr>
					
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">车型</td>
						<td align="center" bgcolor="#ebf0f7">车名</td>
						<td align="center" bgcolor="#ebf0f7">价格</td>
						<td align="center" bgcolor="#ebf0f7">数量</td>
						
						
					</tr>

					<c:forEach items="${page.results}" var="carinTmp">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${carinTmp.ctype}</td>
							<td align="center">${carinTmp.cname}</td>	
							<td align="center">${carinTmp.carpric}</td>
							<td align="center">${carinTmp.carconut}</td>	
							
							<td align="center">
							【	<a href="toUpdateUser.do?id=${carinTmp.ctype}">查看</a>】
							<c:if test="${sessionScope.usr.utpye==1}">
									【	<a href="updtUser1.do?tid=${carinTmp.ctype}">编辑</a>】
							
								|【<a href="deleteUser.do?id=${carinTmp.ctype}" class="delete" >删除</a>】
							</c:if> 
							</td>
						</tr>
					</c:forEach>
					<tr align="right" bgcolor="#ebf0f7">

						
							<td colspan="5">
							<df:page totalPage="${page.totalPage}" pageNo="${page.pageNo}" totalRecord="${page.totalRecord}"
									url="/DFS/mgr/listCarinfo.do"/>
	
							</td>

					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>