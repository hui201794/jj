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
						<td colspan="20" class="optiontitle">人员列表</td>
					</tr>
					
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">用户</td>
						<td align="center" bgcolor="#ebf0f7">类型</td>
						<td align="center" bgcolor="#ebf0f7">性别</td>
						<td align="center" bgcolor="#ebf0f7">操作</td>
					</tr>

					<c:forEach items="${page.results}" var="userTmp">
						<tr align="center" bgcolor="#FFFFFF">

							<td align="center">${userTmp.userName}</td>
							<td align="center">${userTmp.userType}</td>	
							<td align="center">${userTmp.sex}</td>
						
							
							<td align="center">
							【	<a href="toUpdateUser.do?userId=${userTmp.userId}">查看</a>】
							<c:if test="${sessionScope.usr.userType==1}">
									【	<a href="updtUser1.do?userId=${userTmp.userId}">编辑</a>】
							
						
								|【<a href="deleteUser.do?userld=${userTmp.userId}" class="delete" >删除</a>】
							</c:if> 
							</td>
						</tr>
					</c:forEach>
					<tr align="right" bgcolor="#ebf0f7">

						
							<td colspan="5">
							<df:page totalPage="${page.totalPage}" pageNo="${page.pageNo}" totalRecord="${page.totalRecord}"
									url="/YiYU/mgr/listUsr.do" />
	
							</td>

					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>