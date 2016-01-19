<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改员工信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
			rel=stylesheet>
			<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
			

	</head>

	<body>
		<form action=" <%=basePath%>servlet/UserUpdateServlet" method="get" name="form2"  >
			
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						用户的详细信息
						<input type="hidden" name="id" value="1234"readonly="readonly">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">姓名：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">张三</td>
					<td bgcolor="#FFFDF0"><div align="center">年龄：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"> 32 </td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="height: 21px"><div align="center">性别：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" style="height: 21px" align="center"> 男 </td>
					<td bgcolor="#FFFDF0"><div align="center">民族：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"> 汉 </td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">学历：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">本科 </td>
					<td bgcolor="#FFFDF0"><div align="center">婚姻：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">末婚</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">部门：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">销售部</td>
					<td bgcolor="#FFFDF0"><div align="center">角色：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">管理员</td>
	
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">座机：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">52000112</td>
					<td bgcolor="#FFFDF0"><div align="center">爱好：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">吃</td>
				</tr>
			
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">工资卡号：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">500234154545745474</td>
					<td bgcolor="#FFFDF0"><div align="center">手机：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">13525452584</td>

				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">身份证：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">500234154545745474</td>
					<td bgcolor="#FFFDF0"><div align="center">添加时间：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">2013-05-25 09:37:18</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">添加人：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">李四</td>
					<td bgcolor="#FFFDF0"><div align="center">修改人：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">admin</td>
				</tr>

				<tr>

					<td bgcolor="#FFFDF0"><div align="center">E_mail：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">23432@qq.com</td>
					<td bgcolor="#FFFDF0"><div align="center">修改时间：</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center">2015-05-25 09:37:18</td>
				</tr>
				
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">地址：</div></td>
					<td colspan="5" bgcolor="#FFFFFF" align="center">大连市沙河口区</td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"></td>
					
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>

	</body>
</html>
