<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>center</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <LINK href="<%=basePath%>resource/css/admin.css" type=text/css rel=stylesheet>
	<style type="text/css">
	#div1{
	
		width:100%;
		height:80%;
	
	}
	#div2{
	
		width:100%;
		height:80%;
	
	}

</style>

  </head>
  
  <body>
    <form action="<%=basePath%>servlet/WorkQueryServlet" method="post"  >
	<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
		<tr class=editHeaderTr>
		<td class=editHeaderTd >  关怀提醒
		<td class=editHeaderTd >  联系提醒
  <tr>
    <td width="50%" bgcolor="#FFFDF0">
		<div align="center" id="div1">
		<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			<tr>
					<td bgcolor="#FFFDF0"  colspan="2"><div align="center">查询方式：
						<select name="addTime" style=" width: 145px">
							<option  value="0">当天</option>
							<option  value="7">一周内</option>
							<option  value="15">半月内</option>
							<option  value="30">一月内</option>
						</select>				
					</div></td>
					<td colspan="2" bgcolor="#FFFFFF"><div align="center"><input style=" width: 45px" type="submit"   value="查询"></div></td>
    			</tr>
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">关怀主题</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">关怀时间</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">关怀对象</div></td>
   			 	</tr>
	
    			<!-- 输出客户关怀信息 -->
				<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">纪念日</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">2013-05-28 23:12:34</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">孙悟空</div></td>
				</tr>
				<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">生日</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">2013-05-28 23:12:34</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">猪八戒</div></td>
				</tr>
				<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">会员日</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">2013-05-28 23:12:34</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">孙悟空</div></td>
				</tr>
			   <!-- 输出客户关怀信息结束 -->
			   <!-- 无信息输出以下内容 -->
	     			<tr>
						<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
							<div align="center">
								<span class="STYLE1">没有要关怀的对象！</span>
							</div>
						</td>
					</tr>
          			
          			
   		 </table>
		</div>
	</td>
    <td bgcolor="#FFFDF0">
		<div align="center" id="div2">
			<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			<tr>
					<td bgcolor="#FFFDF0"  colspan="3"><div align="center">查询方式：
						<select name="addTime1" style=" width: 145px">
							<option  value="0">当天</option>
							<option  value="7">一周内</option>
							<option  value="15">半月内</option>
							<option  value="30">一月内</option>
						</select>				
					</div></td>
					<td colspan="3" bgcolor="#FFFFFF"><div align="center"><input style=" width: 45px" type="submit"   value="查询"></div></td>
    			</tr>
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">联系主题</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">联系方式</div></td>
		 			  <td bgcolor="#FFFDF0"><div align="center">应联系时间</div></td>
		 	   		<td bgcolor="#FFFDF0"><div align="center">联系对象</div></td>
   			 </tr>
	
			
    		<!-- 循环输出客户联系信息 -->
		
    		<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"> 过来买房 </div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"> 打电话 </div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"> 2013-05-28 23:15:14 </div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"> 孙悟空 </div></td>
   	 		</tr>
   	 		
   	 		<!-- 无信息输出以下内容 -->
    		<tr>
				<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
					<div align="center">
						<span class="STYLE1">没有要联系的对象！</span>
					</div>
				</td>
			</tr>
          	
   		 </table>
		</div></td>
    </tr>
    <tr class=editHeaderTr>
		<td class=editHeaderTd >  有效公告
		<td class=editHeaderTd >  生日提醒
  <tr>
    <td width="50%" bgcolor="#FFFDF0">
		<div align="center" id="div1">
		<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">公告主题</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">公告内容</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">截止时间</div></td>
		 			  <td bgcolor="#FFFDF0"><div align="center">公告人</div></td>
   			 	</tr>
	
    		
    				<!--循环输出公告信息  -->
					<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">最近要开会</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">记得带钱</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">2013-05-23 23:22:12</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">张三</div></td>
					</tr>
					<!-- 无信息输出以下内容 -->
	     			<tr>
						<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
							<div align="center">
								<span class="STYLE1">没有有效的公告！</span>
							</div>
						</td>
					</tr>
          			
          			
   		 </table>
		</div>
	</td>
    <td bgcolor="#FFFDF0">
		<div align="center" id="div2">
			<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			<tr>
					<td bgcolor="#FFFDF0"  colspan="3"><div align="center">查询方式：
						<select name="addTime2" style=" width: 145px">
							<option  value="0">当天</option>
							<option  value="7">一周内</option>
							<option  value="15">半月内</option>
							<option  value="30">一月内</option>
						</select>				
					</div></td>
					<td colspan="3" bgcolor="#FFFFFF"><div align="center"><input style=" width: 45px" type="submit"   value="查询"></div></td>
    			</tr>
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">过生的人</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">生日时间</div></td>
		 			  <td bgcolor="#FFFDF0"><div align="center">手机号码</div></td>
		 	   		<td bgcolor="#FFFDF0"><div align="center">客户状态</div></td>
   			 </tr>
			
			<!--循环输出客户信息  -->
    		<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">华纳</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">1991-11-03</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center">13854545454</div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"> 潜在客户 </div></td>
   	 		</tr>
   	 		<!-- 无信息输出以下内容 -->
    		<tr>
				<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
					<div align="center">
						<span class="STYLE1">没有要过生日的人！</span>
					</div>
				</td>
			</tr>
          
   		 </table>
		</div></td>
    </tr>
</table>
</form>
  </body>
</html>
