<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/4
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有有过交流历史的用户以及目前是否有该用户新消息提示界面</title>
</head>
<body>
当前账号：${RecID}
<table border="10">
    <tr>
        <td>对方用户类型</td>
        <td>通讯对象账号</td>
        <td>通讯对象昵称</td>
        <td>未读通知</td>
        <td>操作</td>

    </tr>
    <s:iterator value="#request.listofuser" var="temp">
        <tr>
            <td><s:property value="#temp.getUserType()"></s:property> </td>
            <td><s:property value="#temp.getUserID()"></s:property> </td>
            <td><s:property value="#temp.getNickName()"></s:property> </td>
            <td><s:property value="#temp.getRON()"></s:property> </td>
            <td><a href="MessageShow.action?RecID=${RecID}&UserID=${RecID}&OutID=<s:property value='#temp.getUserID()'></s:property>">查看</a>
                <a href="Jump.action?OutID=${RecID}&RecID=<s:property value='#temp.getUserID()'></s:property>">回复</a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
