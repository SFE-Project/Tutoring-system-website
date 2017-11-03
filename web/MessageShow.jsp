<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/28
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="localpackage.Dao"%>
<%@ page import="localpackage.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>展示会话界面</title>
</head>
<body>
<a href="MessageShow.action?RecID=${RecID}&OutID=${OutID}">刷新</a><br/>
${OutID}Connecting with${RecID}...<br/><br/>
<div class="refresh">
    <s:iterator value="#request.listofmessage" var="temp">
        <s:property value="#temp.getOutID()"/>[send-to]<s:property value="#temp.getRecID()"/>:
        <s:property value="#temp.getMessagecol()"/><br/>
    </s:iterator>
</div>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        setInterval(function () { $(".refresh").load(location.href + " .refresh"); }, 1000);
    })
</script>

<form action="MessageInsert.action">
    <input type="hidden" name="OutID" value=${OutID}>
    <input type="hidden" name="RecID" value=${RecID}><br/>
    消息内容<br/>
    <input type="text" name="mess"/> <br/>
    <input type="submit" value="确定发送"><br/>
    <a href="javascript:history.go(-1)">返回上一步</a><br/>

</form>
</html>
