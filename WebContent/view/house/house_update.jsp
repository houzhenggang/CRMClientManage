<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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

		<title>My JSP 'customerCondition_add.jsp' starting page</title>

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
		<form action="<%=basePath%>servlet/HouseUpdateServlet" method="post" name="form2" onsubmit="return checkForm('form2');">
		
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入房屋的详细信息
						<input type="hidden" name="houseId" value="HouseId() %>">
					</td>
				</tr>
				<tr>
					<td width="15%" bgcolor="#FFFDF0">
						<div align="center">
							房屋类型：
						</div>
				  </td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="houseType" style="width: 145px">
							<!-- 循环输出房屋类型下拉列表 -->	
							<option value="1" selected="selected">三室一厅</option>
							<option value="2">三室二厅</option>
							<option value="3">二室一厅</option>
							<option value="4">一室一厅</option>
							
						</select>
						&nbsp;
					</td>
					<td width="17%" bgcolor="#FFFDF0">
						<div align="center">
							房屋地址：
						</div>
				  </td>
					<td width="38%" colspan="3" bgcolor="#FFFFFF">
						<input type="text" check_str="房屋地址"   maxlength="50"  style="width: 145px" value="HouseAddress" name="houseAddress">
						&nbsp;
				  </td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋管理者：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="userName" style="width: 145px">
							<!-- 房屋管理者 -->	
							<option value="1" selected="selected">张三</option>
							<option value="2">张三</option>
							<option value="3">张三</option>
							<option value="4">张三</option>
							
						</select>
						&nbsp;
					</td>
					<td width="17%" bgcolor="#FFFDF0">
						<div align="center">
							房屋价格(每平米)：
						</div>
				  </td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  check_str="房屋价格"  style="width: 145px" check_type="float" value="HousePrice" name="housePrice">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋环境：
						</div>
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<textarea rows="10"   name="houseAmbient" style="width:100%; resize:none; " >HouseAmbient</textarea>
					</td>
				</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
				<td width="36%"></td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
