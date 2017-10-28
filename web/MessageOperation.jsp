<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/28
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会话操作界面</title>
</head>
<body>
${StuID}
<form action="MessageShow.action">
    发送者<input type="text" name="OutID"><br/>
    接受者<input type="text" name="RecID"><br/>
    <input type="submit" value="确定"><br/>
</form>
</body>
</html>
