<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/28
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师个人信息以及操作界面</title>
</head>
<body>
<%--%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>登录成功界面</title>--%>
<%--</head>--%>
<%--<body>--%>
<%----%>
<%----%>
<%--</body>--%>
<%--</html>--%>



个人界面！！！！<br/>
登录成功，你好${teademo.getNickName()}，ID是${teademo.getID()}<br/>
////////////////注销操作/////////////////<br/>
<a href="index.jsp">退出当前账号</a><br/>
//////////////////////////更新教师昵称密码信息//////////////////////////////<br/>
<form action="TeaNickPswdChange.action">
    <input type="hidden" name="teacher.ID" value=${teademo.getID()}><br/>
    昵称<input type="text" name="teacher.NickName"><br/>
    密码<input type="text" name="teacher.PassWord"><br/>
    <input type="submit" value="确定"><br/>
</form>
///////////////////////////更新教师需求信息模块/////////////////////////////////<br/>
<form action="TeaREINUpdate.action">
    <input type="hidden" name="teaREIN.ID" value=${teademo.getID()} ><br/>
    性别：<input type="radio" name="teaREIN.Sex" value="男" checked="checked">男性
    <input type="radio" name="teaREIN.Sex" value="女">女性<br/>
    最高学历<input type="radio" name="teaREIN.Education" value="本科" checked="checked">本科
    <input type="radio" name="teaREIN.Education" value="硕士">硕士
    <input type="radio" name="teaREIN.Education" value="博士">博士
    <input type="radio" name="teaREIN.Education" value="博士后">博士后<br/>
    可选时间<input type="checkbox" name="teaREIN.Time" value="上午" checked="checked">上午
    <input type="checkbox" name="teaREIN.Time" value="下午">下午
    <input type="checkbox" name="teaREIN.Time" value="晚上">晚上<br/>
    学科<input type="checkbox" name="teaREIN.Subject" value="数学" checked="checked">数学
    <input type="checkbox" name="teaREIN.Subject" value="语文">语文
    <input type="checkbox" name="teaREIN.Subject" value="外语">外语<br/>
    年级<input type="checkbox" name="teaREIN.Grade" value="小学">小学
    <input type="checkbox" name="teaREIN.Grade" value="初中">初中
    <input type="checkbox" name="teaREIN.Grade" value="高中" checked="checked">高中<br/>
    <input type="submit" value="确定"><br/>
</form>
//////////////////////////////////教师个人会话模块////////////////////////////////////////
<form action="MessageShow.action">
    默认发送者为当前用户<input type="hidden" name="OutID" value=${teademo.getID()}><br/>
    接收者<input type="text" name="RecID"><br>
    <input type="submit" value="进入会话模式"><br/>
</form>
</body>
</html>


