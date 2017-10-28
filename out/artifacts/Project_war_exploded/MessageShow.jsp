<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/28
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示会话界面</title>
</head>
<body>
${OutID}Connecting with${RecID}...<br/><br/>
<s:iterator value="#request.listofmessage" var="temp">
    <s:property value="#temp.getOutID()"/>[send-to]<s:property value="#temp.getRecID()"/>:
    <s:property value="#temp.getMessagecol()"/><br/>
</s:iterator>
<form action="MessageInsert.action">
    <input type="hidden" name="OutID" value=${OutID}>
    <input type="hidden" name="RecID" value=${RecID}><br/>
    消息内容<br/>
    <input type="text" name="mess"/> <br/>
    <input type="submit" value="确定发送"><br/>

</form>
</body>
</html>
