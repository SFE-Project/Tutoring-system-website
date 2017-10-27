<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/26
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功界面</title>
</head>
<body>
登录成功，你好${studemo.getNickName()}，ID是${studemo.getID()}
<a href="stuREINInsert.jsp">更新学生个人信息</a><br/>
<form action="MatchForStu.action">
    <input name="StuID" type="text" value=${studemo.getID()}><br/>
    <input type="submit" value="一键匹配"><br/>
</form>
<a href="AllTheTea.action">预览所有教师信息并操作</a><br/>

</body>
</html>
