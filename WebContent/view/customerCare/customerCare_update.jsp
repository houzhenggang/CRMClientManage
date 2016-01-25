<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>关怀修改</title>

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
		<style type="text/css">
.auto-style1 {
	margin-left: 0px;
}
</style>
<script type="text/javascript">
    function checkForm(){
    	document.forms[0].action="CustomerCareUpdateServlet?care_id=" + ${careUpdBean.care_id};
    }
</script>

	</head>

	<body>
		<form method="post" name="form1" onsubmit="checkForm()">
		
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7 style="height: 49px">
						请输入详细信息
						<input type="hidden" name="careId" value="${careUpdBean.care_id }"
							readonly="readonly">
					</td>
				</tr>

				<tr>
					<td width="21%" bgcolor="#FFFDF0" style="width: 9%">
						<div align="center">
							关怀主题：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="20" name="careTheme" check_str="关怀主题"
							value="${careUpdBean.care_theme}" />
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0" style="width: 13%">
						<div align="center">
							关怀对象：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerId" style="width: 145px">
							
							<!-- 循环输出客户下拉列表 -->
							<% 
							ResultSet rs = (ResultSet) request.getAttribute("customers");
							while(rs.next()){
								
							%>
							    <option value="<%=rs.getInt(1) %>"  >
							    <%=rs.getString(2) %></option>

						   <% } %>
						</select>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0" style="width: 13%">
						<div align="center">
							关怀时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  name="careTime"
							value="${careUpdBean.care_time }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0" style="width: 13%">
						<div align="center">
							下次关怀时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="careNexttime"
							value="${careUpdBean.care_nexttime }" check_str="下次关怀时间"
							readonly="readonly" id="careNexttime"
							onclick="WdatePicker({el:careNexttime,dateFmt:'yyyy-MM-dd HH:mm:ss '})">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="width: 13%">
						<div align="center">
							是谁关怀的：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="20" name="carePeople"
							value="${careUpdBean.care_people }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0" style="width: 13%">
						<div align="center">
							关怀方式：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="careWay" value=""
							style="width: 145px">
							<option <c:if test="${careUpdBean.care_way=='发短信' }"> selected="selected" </c:if> >
								发短信
							</option>
							<option <c:if test="${careUpdBean.care_way=='送礼品' }"> selected="selected" </c:if> >
								送礼品
							</option>
							<option <c:if test="${careUpdBean.care_way=='电话问候' }"> selected="selected" </c:if> >
								电话问候
							</option>
							<option <c:if test="${careUpdBean.care_way=='上门拜访' }"> selected="selected" </c:if> >
								上门拜访
							</option>
							<option >
								其他
							</option>
						</select>
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="width: 13%">
						<div align="center">
							关怀备注：
						</div>
					</td>
					<td colspan="7" bgcolor="#FFFFFF">
						<textarea name="careRemark" style="width: 100%; resize: none;"
							rows="10">${careUpdBean.care_remark }</textarea>
					</td>
				</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="40%"></td>
					<td width="10%"><input type="submit" name="submit"  value="提交"></td>
					<td width="5%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="40%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
