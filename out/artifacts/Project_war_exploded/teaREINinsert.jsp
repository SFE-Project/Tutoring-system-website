<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/26
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师个人信息录入界面</title>
</head>
<body>
private int ID;
private int Sex;
private int Education;
private String Time;
private String Subject;
private String Grade;<br/>
${teademo.getID()}<br/>
<form action="TeaREINUpdate.action">
    ID<input type="text" name="teaREIN.ID"><br/>
    性别：<input type="radio" name="teaREIN.Sex" value="男">男性
    <input type="radio" name="teaREIN.Sex" value="女">女性<br/>
    最高学历<input type="radio" name="teaREIN.Education" value="本科">本科
    <input type="radio" name="teaREIN.Education" value="硕士">硕士
    <input type="radio" name="teaREIN.Education" value="博士">博士
    <input type="radio" name="teaREIN.Education" value="博士后">博士后<br/>

    可选时间<input type="checkbox" name="teaREIN.Time" value="上午">上午
    <input type="checkbox" name="teaREIN.Time" value="下午">下午
    <input type="checkbox" name="teaREIN.Time" value="晚上">晚上<br/>
    学科<input type="checkbox" name="teaREIN.Subject" value="数学">数学
    <input type="checkbox" name="teaREIN.Subject" value="语文">语文
    <input type="checkbox" name="teaREIN.Subject" value="外语">外语<br/>
    年级<input type="checkbox" name="teaREIN.Grade" value="小学">小学
    <input type="checkbox" name="teaREIN.Grade" value="初中">初中
    <input type="checkbox" name="teaREIN.Grade" value="高中">高中<br/>

    <input type="submit" value="确定"><br/>
</form>
</body>
</html>
