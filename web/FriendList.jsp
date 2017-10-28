<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/28
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示好友列表界面</title>
</head>
<body>
<table border="10">
    ${StuID}
    <tr>
        <td>好友ID</td>
        <td>好友昵称</td>
    </tr>
    <s:iterator value="#request.listofteacher" var="temp">
        <tr>
            <td><s:property value="#temp.getID"/> </td>
            <td><s:property value="#temp.getNickName()"/> </td>
            <%--<td><a href='MakeFriends.action?StuID=${teaListAndOneStu.getStuID()}&TeaID=<s:property value="#temp.ID"/>'>关注</a></td>--%>
            <td><a href='FriendKill.action?StuID=${StuID}&TeaID=<s:property value="#temp.getID()"/>'>不再关注</a> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
