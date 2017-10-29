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
            <td><a href='SingleTea.action?TeaID=<s:property value="#temp.getID()"/>'><s:property value="#temp.getID()"/></a> </td>
            <td><s:property value="#temp.getNickName()"/> </td>
            <%--<td><a href='MakeFriends.action?StuID=${teaListAndOneStu.getStuID()}&TeaID=<s:property value="#temp.ID"/>'>关注</a></td>--%>
            <td><a href='FriendKill.action?StuID=${StuID}&TeaID=<s:property value="#temp.getID()"/>'>不再关注</a> </td>
        </tr>
    </s:iterator>
</table>
【提示：网络浩渺相遇是缘，不再关注再难相见，且行且珍惜】<br/>
【千万不要删除默认ROOT好友！！！！】
【"不再关注"属于敏感操作，操作后请重新登录！】<br>
<a href="javascript:history.go(-1)">返回上一步</a><br/>
</body>
</html>
