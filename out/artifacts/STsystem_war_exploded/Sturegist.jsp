<%--
  Created by IntelliJ IDEA.
  User: Doobet
  Date: 2017/10/23
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生注册界面</title>
</head>
<body>
<form action="sturegist.action">
    昵称<input name="stuloginfo.NickName" type="text"><br/>
    密码<input type="text" name="stuloginfo.PassWord"><br/>
    手机号<input type="text" name="stuloginfo.PhoneNumber"><br/>
    身份证<input type="text" name="stuloginfo.IDCard"><br/>
    邮箱<input type="text" name="stuloginfo.MailBox"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
