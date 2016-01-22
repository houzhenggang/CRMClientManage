<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户关怀查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}
A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}

-->
</style>

<script>
var  highlightcolor='#c1ebff';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
    return;
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor){
//source.style.backgroundColor=originalcolor
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor="";
	}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD"){
	source=source.parentElement;
	source=source.parentElement;
	cs  =  source.children;
}
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc"){
    for(i=0;i<cs.length;i++){
	     cs[i].style.backgroundColor=clickcolor;
    }
}else{
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor="";
	}
}
</script>
<script type="text/javascript">
	function add(){  
			location.href="view/customerCare/customerCare_add.jsp";
		}
	
	function upd(careId){
		location.href="CustCareQueryByIdServlet?id=" + careId;
	}
	
	function del(careId){
		var flag = window.confirm("您确定要删除第" + careId + "记录吗？");
		if(flag){
			location.href="CustomerCareDeleteServlet?id=" + careId;
		}
	}
	
	function jumpto(){
		var pagenum = document.getElementById("jump").value;
		location.href="CustomerCareQueryServlet?pagenum=" + pagenum;
	}

	function query(){
		var query = document.getElementById("customerInput").value;
		if(query == null || query == ""){
			return false;
		}else{
			document.forms[0].action="CustomerCareQueryServlet?idcheck=2";
			return true;
		}
	}

</script>
  </head>
  
  <body>
  
  <form method="post" onsubmit="return query()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=basePath%>resource/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath%>resource/images/tab_03.gif" width="12" height="30" /></td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：
               <input id="customerInput" type="text" name="customerInput" style="width: 290px"/>
            </td>
            <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：
                <select name="queryType" style="width: 100px" >
      					<option value="1" >关怀客户</option>
     				 	<option value="2" >关怀主题</option>
     				 	<option value="3" >关怀方式</option>
   				 </select>            
   			</td>
   			
            <td class="STYLE4">&nbsp;&nbsp;
                <input  type="submit" value="查询" style="width:50px"/>
            </td>           
          <td class="STYLE4">&nbsp;&nbsp;
          <c:if test="${sessionScope.slevel==1 }">
          <input  type="button"  onclick="javascript:add()" value="添加"  style="width:50px"/></td>   
          </c:if>        
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  

    <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath%>resource/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="2%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="3%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">客户</span></div></td>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀主题</span></div></td>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀方式</span></div></td>
				
	    <td width="5%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀时间</span></div></td>
	    <td width="5%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">下次关怀时间</span></div></td>
	    
		<td width="10%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">备注</span></div></td>
 	<td width="3%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀人</span></div></td>
           <c:if test="${sessionScope.slevel==1 }">
	   		<td  width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
           </c:if>
</tr>

<!-- 循环输出客户信息 -->
<c:forEach items="${requestScope.Cares }" var="oneRow">
 <tr>
        <td height="20" bgcolor="#FFFFFF">
        <div align="center" class="STYLE1">
             <div align="center">${oneRow.care_id }</div>
        </div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.customer_id }</span></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.care_theme }</span></div></td>
   	    <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.care_way }</span></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.care_time }</span></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.care_nexttime }</span></div></td>
		<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.care_remark } </span></div></td>
		<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${oneRow.care_people }</span></div></td>
		<c:if test="${sessionScope.slevel==1 }">
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
        <img src="<%=basePath%>resource/images/edt.gif" width="16" height="16" />
        <a href="javascript:upd(${oneRow.care_id })">编辑</a>&nbsp; &nbsp;
        <img src="<%=basePath%>resource/images/del.gif" width="16" height="16" />
        <a href="javascript:del(${oneRow.care_id })">删除</a></span></div></td>
        </c:if>
 </tr>
</c:forEach>
          <!-- 无数据输出以下内容 -->
		<tr>
		<c:if test="${requestScope.nowPage==requestScope.pageCount }">
			<td height="20" bgcolor="#FFFFFF" colspan="21"  align="center">
				<div align="center">
					<span class="STYLE1">没有员工相关信息</span>
				</div>
			</td>
		</c:if>
		</tr>
          
        </table></td>
        <td width="8" background="<%=basePath%>resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="<%=basePath%>resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=basePath%>resource/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有 ${requestScope.rowCount }条记录，当前第 ${nowPage }/${requestScope.pageCount } 页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40">
                     <a href="CustomerCareQueryServlet?pagenum=1">
                     <img src="<%=basePath%>resource/images/first.gif" width="37" height="15" /></a>
                  </td>
                  <td width="45">
                  
                     <a href="CustomerCareQueryServlet?pagenum=${requestScope.nowPage-1 }">
                     <img src="<%=basePath%>resource/images/back.gif" width="43" height="15" />
                     </a></td>
                  
                  <td width="45">
                  <c:choose>
                     <c:when test="${requestScope.mark==2 }"> 
                     <a href="CustomerCareQueryServlet?idcheck=2&queryType=${requestScope.queryType }&customerInput=${requestScope.customerInput}&pagenum=${requestScope.nowPage+1 }">
                     <img src="<%=basePath%>resource/images/next.gif" width="43" height="15" />
                     </a>
                     </c:when>
                     <c:otherwise>
                     <a href="CustomerCareQueryServlet?pagenum=${requestScope.nowPage+1 }">
                     <img src="<%=basePath%>resource/images/next.gif" width="43" height="15" />
                     </a>
                     </c:otherwise>
                  </c:choose>
                  </td>   
                  <td width="40">
                     <a href="CustomerCareQueryServlet?pagenum=${requestScope.pageCount }">
                     <img src="<%=basePath%>resource/images/last.gif" width="37" height="15" />
                  </a></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input id="jump" name="textfield" type="text" size="4" style="height:16px; width:20px; border:1px solid #999999;" /> 
                    页 </span></div></td>
                  <td width="40">
                      <a href="javascript:jumpto()">
                         <img src="<%=basePath%>resource/images/go.gif" width="37" height="15" />
                      </a>
                  </td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
  </body>
 
</html>
