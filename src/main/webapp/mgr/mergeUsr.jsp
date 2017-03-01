<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<link href="../css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/jquery.metadata.js"></script>
<script type="text/javascript">
	/* $(function() {
	
	} */
</script>

</head>

<body>


<!-- 包含等待框 -->
	<jsp:include page="../waittable.jsp" flush="true"/> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td bgcolor="#FFFFFF">
				<form
					action="updtUser2.do"
					name="myform" id="myform">
					<table width="40%" border="0" align="center" cellpadding="4"
						cellspacing="1" bgcolor="#aec3de">
						<tr align="center" bgcolor="#F2FDFF">
							<td align="left" colspan="2" class="optiontitle">
							
							
						
							
							修改用户:${toUpdateUser.userName} <input type="hidden" name="userId" value="${toUpdateUser.userId}" />
							</td>
	</tr>
							
	
	
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">用户名</td>
							<td align="left"><input
									type="text" name="userName" style="width:160px"
									value="${toUpdateUser.userName}" />
							</td>
						</tr>
							<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">密码</td>
							<td align="left"><input
									type="text" name="userPwd" style="width:160px"
									value="${toUpdateUser.userPwd}" />
							</td>
						</tr>
							<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">类型</td>
							<td align="left"><input
									type="text" name="userType" style="width:160px"
									value="${toUpdateUser.userType}" />
							</td>
						</tr>
							<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">EMail</td>
							<td align="left"><input
									type="text" name="mail" style="width:160px"
									value="${toUpdateUser.mail}" />
							</td>
						</tr>
						
						
							<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">电话</td>
							<td align="left"><input
									type="text" name="phone" style="width:160px"
									value="${toUpdateUser.phone}" />
							</td>
							</tr>
						
							<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">本地IP</td>
							<td align="left"><input
									type="text" name="ip_location" style="width:160px"
									value="${toUpdateUser.ip_location}" />
							</td>
							</tr>
							
						  <tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">IP地址</td>
							<td align="left"><input
									type="text" name="ip_address" style="width:160px"
									value="${toUpdateUser.ip_address}" />
							</td>
							</tr>
							
							 <tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">说明</td>
							<td align="left"><input
									type="text" name="signature" style="width:160px"
									value="${toUpdateUser.signature}" />
							</td>
							</tr>
							
							
						
							
						
						
						
						

				
						<tr align="center" bgcolor="#ebf0f7">
							<td colspan="2"><input type="submit" name="Submit" id="Submit"
								value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"
								name="Submit2" value="重置" />
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>