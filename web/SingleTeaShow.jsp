<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/27
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示某位教师的所有信息</title>
</head>
<body>

<table border="10">
    <tr>
        <td>ID</td>
        <td>昵称</td>
        <td>性别</td>
        <td>学历</td>
        <td>可行时间</td>
        <td>擅长科目</td>
        <td>胜任年级</td>
    </tr>
    <tr>
        <td>${bsTeacher.getTeacher().getID()}</td>
        <td>${bsTeacher.getTeacher().getNickName()}</td>
        <td>${bsTeacher.getTeaREIN().getSex()}</td>
        <td>${bsTeacher.getTeaREIN().getEducation()}</td>
        <td>${bsTeacher.getTeaREIN().getTime()}</td>
        <td>${bsTeacher.getTeaREIN().getSubject()}</td>
        <td>${bsTeacher.getTeaREIN().getGrade()}</td>
    </tr>
</table>

</body>
</html>
