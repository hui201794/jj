<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<base href="<%=basePath%>" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ecf4ff;
}

.dtree {
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #0000ff;
	white-space: nowrap;
}

.dtree img {
	border: 0px;
	vertical-align: middle;
}

.dtree a {
	color: #333;
	text-decoration: none;
}

.dtree a.node,.dtree a.nodeSel {
	white-space: nowrap;
	padding: 1px 2px 1px 2px;
}

.dtree a.node:hover,.dtree a.nodeSel:hover {
	color: #0000ff;
}

.dtree a.nodeSel {
	background-color: #AED0F4;
}

.dtree .clip {
	overflow: hidden;
}
-->
</style>
<link href="css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/dtree.js"></script>
</head>
<body>
	<table width="96%" border="0" cellpadding="10" cellspacing="0"
		align="center">
		<tr>
			<td valign="top">
				<div class="menu">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><script type="text/javascript">
								var role = '${sessionScope.usr.userType}';
								d = new dTree('d');
								d.config.target = "main";
								d.add(0, -1, '功能菜单');
								d.add(1, 0, '用户管理', '');
								d.add(11, 1, '用户列表', 'mgr/listUsr.do');
								if (role == 1) {
									d.add(12, 1, '用户地址', 'team/toAddTeam.do');
								}
								d.add(2, 0, '产品管理', '');
								d.add(21, 2, '产品列表', 'mgr/listPro.do');
								if (role >= 1) {
									d.add(22, 2, '新增人员', 'user/toAddUser.do');
								}
								d.add(3, 0, '学校专业管理', '');
								d.add(31, 3, '学校专业列表', 'school/getAllSchool.do');
								d.add(32, 3, '新增学校专业', 'school/toAddSchool.do');
								d.add(4, 0, '学员管理', '');
								d.add(41, 4, '学员列表','student/getAllStudent.do');
								d.add(42, 4, '新增学员', 'student/toAddStudent.do');
								d.add(43, 4, '批量添加', 'student/tobatchStudent.do');
								document.write(d);
							</script>
							</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>