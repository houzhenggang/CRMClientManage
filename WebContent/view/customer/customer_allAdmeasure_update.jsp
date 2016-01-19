<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户分配</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>resource/js/CheckForm.js"></script>
	
<LINK href="<%=basePath%>resource/css/admin.css" type=text/css  rel=stylesheet>
			
	<script type="text/javascript" src="<%=basePath%>resource/js/CheckForm.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
  </head>
  
  <body>


<form action="<%=basePath%>servlet/CustomerUpdateAllNoAdmeasureServlet1" method="post" onSubmit="return check(this)">


<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
<tr class=editHeaderTr>
<td class=editHeaderTd colSpan=7>  请分配客户
</td>
</tr>  
 
<!-- 循环输出客户信息 -->
	<tr>
    		<td width="19%" bgcolor="#FFFDF0"><div align="center">客户1：</div></td>
    			<td colspan="3" bgcolor="#FFFFFF"><input type="text"  style=" width: 145px" name="customerName"  disabled="disabled"  value="CustomerName"   >
      			<input type="hidden" name="customerId" value="111" />
     		 </td>
    </tr>  	 
<!-- 分配给那个员工 -->     	
  <tr>
    <td width="12%" bgcolor="#FFFDF0"><div align="center">分配给那个员工：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><select  style=" width: 145px" name="customerForUser" style=" width: 145px">
			<!-- 循环输出员工列表 -->		
			<option  value="1">张三</option>	
			</select>		
		</td>
    </tr>
  
</table>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
  <tr bgcolor="#ECF3FD">
    <td width="10%"></td>
					<td width="10%"><input type="submit" name="submit"  value="提交"></td>
					<td width="5%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="75%"></td>
  </tr>
</table>

</form>
</body>
</html>
