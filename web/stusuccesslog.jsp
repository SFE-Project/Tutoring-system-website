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
个人界面！！！！<br/>
登录成功，你好${studemo.getNickName()}，ID是${studemo.getID()}<br>
<a href="stuREINInsert.jsp">更新学生个人信息</a><br/>
<form action="MatchForStu.action">
    <input name="StuID" type="text" value=${studemo.getID()}><br/>
    <input type="submit" value="一键匹配"><br/>
</form>

<a href='FriendList.action?StuID=${studemo.getID()}'>查看你的朋友圈</a><br/>
<form action="MessageShow.action">
    默认发送者为当前用户<input type="hidden" name="OutID" value=${studemo.getID()}><br/>
    接收者<input type="text" name="RecID"><br>
    <input type="submit" value="进入会话模式"><br/>
</form>


</body>
</html>
