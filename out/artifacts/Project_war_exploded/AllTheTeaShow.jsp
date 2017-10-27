<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/27
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有教师界面</title>
</head>
<body>
<table border="10">
    ${studemo.getID()}
        <s:iterator value="#request.listofbstea" var="temp">
            <tr>
                <td><s:property value="#temp.getTeacher().getID()"/> </td>
                <td><s:property value="#temp.getTeacher().getNickName()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getSex()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getEducation()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getTime()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getSubject()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getGrade()"/> </td>
            </tr>

        </s:iterator>


</table>
<%--${listofbstea.get(0).getTeacher().getNickName()}--%>

</body>
</html>
