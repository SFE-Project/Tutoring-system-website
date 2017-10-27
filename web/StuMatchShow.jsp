<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/26
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示为学生匹配家教信息</title>
</head>
<body>

<table border="1">
    ${teaListAndOneStu.getStuID()}
    <tr>
        <td>ID</td>
        <td>Sex</td>
        <td>Education</td>
        <td>Time</td>
        <td>Subject</td>
        <td>Grade</td>
    </tr>
    <s:iterator value="#request.teaListAndOneStu.getTeaREINS()" var="temp">
        <tr>
            <%--<td><a href='ABshow.action?ISBN=<s:property value="ISBN"/>'><s:property value="#temp.Title"/></a></td>--%>
            <td><a href='SingleTea.action?TeaID=<s:property value="#temp.ID"/>'><s:property value="#temp.ID"/> </a> </td>
            <td><s:property value="#temp.Sex"/> </td>
            <td><s:property value="#temp.Education"/></td>
            <td><s:property value="#temp.Time"/> </td>
            <td><s:property value="#temp.Subject"/> </td>
            <td><s:property value="#temp.Grade"/> </td>
            <td><a href='MakeFriends.action?StuID=${teaListAndOneStu.getStuID()}&TeaID=<s:property value="#temp.ID"/>'>关注</a></td>
        </tr>
    </s:iterator>
</table>


</body>
</html>
