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

		<title>修改客户信息</title>

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
<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>
	</head>

	<body>
		<form action="<%=basePath%>servlet/CustomerUpdateServlet"
			method="post" name="form2" onsubmit="return validator(this)" >


			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改客户信息
						<input type="hidden" name="customerId"
							value="CustomerId()%>" />
					</td>
				</tr>
				<tr>
					<td width="12%" bgcolor="#FFFDF0"><div align="center">负责员工：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><select     name="customerForUser" style=" width: 145px">
			<!-- 循环输出员工信息 -->		
			<option    value="1" selected="selected" >张三</option>
			<option    value="2" selected="selected" >张三</option>
			<option    value="3" selected="selected" >张三</option>
			
			</select>		</td>
					<td width="12%" bgcolor="#FFFDF0">
						<div align="center">
							客户来源：
						</div>
					</td>
					<td width="37%" colspan="3" bgcolor="#FFFFFF">
						<select name="customerSource" style="width: 145px">
						<!-- 循环输出客户来源 -->
						<option value="1" selected="selected" >自己上门</option>
						<option value="2" selected="selected" >朋友介绍</option>
						<option value="3" selected="selected" >百度推广</option>
						</select>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" disabled="disabled"   name="customerName"
							value="CustomerName()%>">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户状态：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerCondition" style="width: 145px">
						
							<option value="1" >潜在客户</option>
											
						</select>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="radio" name="customerSex" value="男"
							>
							checked="checked" />
						男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="customerSex" value="女"
							>
							
						女
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerType" style="width: 145px">
							<!-- 循环输出客户类型 -->
							<option value="1" selected="selected" > 客户类型</option>
							
						</select>
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							出生日期：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"style=" width: 145px"  disabled="disabled" name="customerBirthday"
							value="CustomerBirthday()%>"
							readonly="readonly" id="customerBirthday"
							onclick="WdatePicker({el:customerBirthday,dateFmt:'yyyy-MM-dd HH:mm:ss '})">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"    valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!"   name="customerMobile"
							value="CustomerMobile()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户QQ：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"   valid="isQQ"   errmsg="请输入正确的QQ号码!"  name="customerQq"
							value="CustomerQq()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerAddress"
							value="CustomerAddress()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户邮箱：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerEmail"  valid="required|isEmail"  errmsg="Email不能为空|Email格式不对!" value="CustomerEmail()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户职位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerJob"
							value="CustomerJob()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户微博：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" maxlength="50"  name="customerBlog"
							value="CustomerBlog()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" valid="isPhone"   errmsg="请输入正确的座机号码!" name="customerTel"
							value="CustomerTel()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户MSN：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" maxlength="50"  name="customerMsn"
							value="CustomerMsn()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户公司：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerCompany"
							value="CustomerCompany()%>">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							创建人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" disabled="disabled" name="customerAddMan"
							value="CustomerAddMan()%>">
						<input type="hidden"
							value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date())%>"
							name="customerChangeTime">
						<input type="hidden" name="customerAddTime"
							value="CustomerAddTime()%>"
							readonly="readonly" id="customerAddTime">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerChangeMan"
							value="CustomerChangeMan()%>">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							备注：
						</div>
					</td>
					<td colspan="6" bgcolor="#FFFFFF">
						<textarea rows="10" name="customerRemark"
							style="width: 100%; resize: none;">
			CustomerRemark()%>
		</textarea>
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
