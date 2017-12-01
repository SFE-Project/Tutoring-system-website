<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/1
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生密码昵称更新</title>
</head>
<body>
<form action="StudentUpdate.action">
    请确认您的账户信息(站内会员ID)<input type="text" name="StuID"><br/>
    请输入新的昵称<input type="text" name="NickName"><br/>
    请输入新的密码<input type="text" name="PassWord"><br>
    <input type="submit" value="确定"><br/>
</form>
</body>
</html>
