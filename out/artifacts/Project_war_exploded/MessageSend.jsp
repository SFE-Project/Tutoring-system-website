<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/5
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送消息</title>
</head>
<body>
${RecID}
<form action="MessageInsert.action">
请输入您的ID<input type="text" name="OutID" value=${OutID}>
请输入对方ID<input type="text" name="RecID" value=${RecID}><br/>
此处输入回复内容：<input type="text" name="mess" class="input"/>
<input class="sublime" type="submit" value="确定发送"><br/>
</form>
</body>
</html>
