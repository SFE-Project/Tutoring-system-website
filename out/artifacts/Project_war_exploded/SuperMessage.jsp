<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/4
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看消息具体内容界面</title>
</head>
<body>
当前账号${IDnow}
发送方${SuperOutID}
接收方${SuperRecID}
<table  border="10">
    <tr>
        <td>消息编码</td>
        <td>${message.getMessageID()}</td>
    </tr>
    <tr>
        <td>消息发送者</td>
        <td>${message.getOutID()}</td>
    </tr>
    <tr>
        <td>消息接收者</td>
        <td>${message.getRecID()}</td>
    </tr>

    <tr>
        <td>内容</td>
        <td>${message.getMessagecol()}</td></td>
    </tr>
</table>
<

</body>
</html>
