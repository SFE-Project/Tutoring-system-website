<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/1
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    当前账号：${TeaID}
    <title>更改评价资格密钥</title>
</head>
<body>
您当前的评价资格密钥是${EvaluationPassword}<br/>
<form action="UpdateEvaluationPassWord.action">
    <input type="text" name="TeaID" hidden="hidden" value=${TeaID}><br>
    请输入新的评价资格密码<input type="text" name="EvaluationPassword"><br/>
    <input type="submit" value="确定">
</form>
</body>
</html>
