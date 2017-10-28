<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/26
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本界面</title>
</head>
<body>
<a href="sturegist.jsp">学生注册</a><br/>
<a href="stulog.jsp">学生登录</a><br/>
<a href="tearegist.jsp">教师注册</a><br/>
<a href="tealog.jsp">教师登录</a><br/>
<br/>
<br/>
展示所有教师信息<br/>
<table border="10">
    <s:iterator value="#request.listofbstea" var="temp">
        <tr>
            <td><a href='SingleTea.action?TeaID=<s:property value="#temp.getTeacher().getID()"/>'><s:property value="#temp.getTeacher().getID()"/></a> </td>
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
</body>
</html>
