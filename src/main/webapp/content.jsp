<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用学员录入系统网站</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td bgcolor="#FFFFFF">
				<table width="40%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">


					<tr align="center" bgcolor="#F2FDFF">
						<th align="center" colspan="2" class="optiontitle">公告</th>
					</tr>

					<tr align="center" bgcolor="#F2FDFF">
						<td width="20%" align="left">靖凯开源查重系统约定：<br> <br> 1.各招生团队本着公平公正，合作共赢的方式有序开展招生工作，靖凯开源将尽量保障招生团队的权益; 
						<br><br> 2.各招生团队、分销代理可以通过联系管路由添加查重系统账号，以方便在招生工作中保障自己团队的权益;
							 -----靖凯开源.软件部 2016-06-27
						</td>
					</tr>


				</table>
				</form></td>
		</tr>
	</table>
</body>
</html>
