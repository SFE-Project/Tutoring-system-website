<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/4
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息展示界面</title>
</head>
<body>
<table border="10">
    发送者${OutID}
    接收者${RecID}
    当前用户${UserID}

    <tr>
        <td>信息编码</td>
        <td>是否已读</td>
        <td>发送者</td>
        <td>接收者</td>
        <td>操作</td>
        <%--<td>消息内容</td>--%>
    </tr>

    <%--#request.listofmessage--%>
    <s:iterator value="#request.listofmessage" var="temp">
        <tr>
            <td><s:property value="#temp.getMessageID()"/> </td>
            <td><s:property value="#temp.getRON()"/> </td>
            <td><s:property value="#temp.getOutID()"/> </td>
            <td><s:property value="#temp.getRecID()"/> </td>
            <td><a href='SingleMessageShowPlus.action?WantOutID=${OutID}&messageID=<s:property value="#temp.getMessageID()"/>&IDnow=${UserID}'>查看内容</a></td>
            <%--<td><s:property value="#temp.getMessagecol()"/> </td>--%>
        </tr>
    </s:iterator>
</table>
</body>
</html>
