<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/26
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生个人信息更新界面</title>
</head>
private int ID;
private int Sex;
private int SexWanted;
private String Time;
private String Subject;
private String Grade;<br/>
<body>
<form action="StuREINUpdate.action">
    ID<input type="text" name="stuREIN.ID"><br/>
    性别：<input type="radio" name="stuREIN.Sex" value="男">男性
    <input type="radio" name="stuREIN.Sex" value="女">女性<br/>
    需要教师性别<input type="radio" name="stuREIN.SexWanted" value="男">男性
    <input type="radio" name="stuREIN.SexWanted" value="女">女性
    <input type="radio" name="stuREIN.SexWanted" value="不限">不限<br/>
    可选时间<input type="checkbox" name="stuREIN.Time" value="上午">上午
    <input type="checkbox" name="stuREIN.Time" value="下午">下午
    <input type="checkbox" name="stuREIN.Time" value="晚上">晚上<br/>
    学科<input type="checkbox" name="stuREIN.Subject" value="数学">数学
    <input type="checkbox" name="stuREIN.Subject" value="语文">语文
    <input type="checkbox" name="stuREIN.Subject" value="外语">外语<br/>
    年级<input type="radio" name="stuREIN.Grade" value="小学">小学
    <input type="radio" name="stuREIN.Grade" value="初中">初中
    <input type="radio" name="stuREIN.Grade" value="高中">高中<br/>

    <input type="submit" value="确定"><br/>
</form>
</body>
</html>
