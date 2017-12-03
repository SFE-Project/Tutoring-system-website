<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/3
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    当前账号：${TeaID}
    ${listofstudent.get(1).getID()}
    ${listofstudent.get(1).getNickName()}
    <title>展示教师的followers</title>
</head>
<body>
<table border="10">
    <tr>
        <td>Follower-ID</td>
        <td>Follower-昵称</td>
    </tr>
    <s:iterator value="#request.listofstudent" var="temp">
        <tr>
            <td><a href="SingleStudent.action?TeaID=${TeaID}&StuID=<s:property value="#temp.getID()"/>"><s:property value="#temp.getID()"></s:property></a></td>
            <%--<td><s:property value="#temp.getID()"></s:property> </td>--%>
            <td><s:property value="#temp.getNickName()"></s:property> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
