<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/26
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>首页</title>

    <!-- For-Mobile-Apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Classy Forms Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //For-Mobile-Apps -->

    <!-- Style --> <link rel="stylesheet" href="css/login.css" type="text/css" media="all" />
    <!-- Default-JavaScript-File --> <script type="text/javascript" src="js/jquery.min.js"></script>

    <!-- Web-Fonts -->
    <link href='//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
    <!-- //Web-Fonts -->

</head>
<body>

<h1>Classy Forms Widget</h1>

<div class="container">

    <div class="tab">

        <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
            <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#horizontalTab').easyResponsiveTabs({
                        type: 'default', //Types: default, vertical, accordion
                        width: 'auto', //auto or any width like 600px
                        fit: true,   // 100% fit in a container
                        closed: 'accordion', // Start closed if in accordion view
                        activate: function(event) { // Callback function if tab is switched
                            var $tab = $(this);
                            var $info = $('#tabInfo');
                            var $name = $('span', $info);
                            $name.text($tab.text());
                            $info.show();
                        }
                    });

                    $('#verticalTab').easyResponsiveTabs({
                        type: 'vertical',
                        width: 'auto',
                        fit: true
                    });
                });
            </script>

            <div class="tabs">

                <div class="tab-left">
                    <ul class="resp-tabs-list">
                        <li class="resp-tab-item">学生登录</li>
                        <li class="resp-tab-item">教师登录</li>
                        <li class="resp-tab-item">学生注册</li>
                        <li class="resp-tab-item">教师注册</li>
                    </ul>
                </div>

                <div class="tab-right">
                    <div class="resp-tabs-container">
                        <div class="tab-1 resp-tab-content">
                            <div class="w3l-sign-in">
                                <h3>学生登录</h3>
                                <form action="StuLog.action" method="post">
                                    <input type="text" class="name" name="student.ID" placeholder="学生ID" required="">
                                    <input type="password" class="password" name="student.Password" placeholder="密码" required="">
                                    <ul class="w3agile">
                                        <li>
                                            <input type="checkbox" id="brand1" value="">
                                            <label for="brand1"><span></span>记住我</label>
                                        </li>
                                    </ul>
                                    <input type="submit" value="登陆">
                                    <div class="clear"></div>
                                </form>
                            </div>
                        </div>
                        <div class="tab-1 resp-tab-content">
                            <div class="register agileits">
                                <h3>教师登录</h3>
                                <form action="TeaLog.action" method="post">
                                    <input type="text" class="name" name="teacher.ID" placeholder="教师ID" required="">
                                    <input type="password" class="password" name="teacher.Password" placeholder="密码" required="">
                                    <ul class="w3agile">
                                        <li>
                                            <input type="checkbox" id="brand2" value="">
                                            <label for="brand1"><span></span>记住我</label>
                                        </li>
                                    </ul>
                                    <input type="submit" value="登陆">
                                    <div class="clear"></div>
                                </form>
                            </div>
                        </div>
                        <div class="tab-1 resp-tab-content gallery-images">
                            <div class="wthree-subscribe">
                                <h3>学生注册</h3>
                                <form action="StuInsert.action" method="post">
                                    <input type="text" class="name" name="student.NickName" placeholder="昵称" required="">
                                    <input type="password" class="password" name="student.Password" placeholder="密码" required="">
                                    <input type="email" class="email" name="stuREIN.Email" placeholder="邮箱" required="">
                                    <li>
                                        <label>性别：<input type="radio" name="stuREIN.Sex" value="男" checked="checked">男性
                                            <input type="radio" name="stuREIN.Sex" value="女">女性</label><br/>
                                    </li>
                                    <li>
                                        <label>需要教师性别<input type="radio" name="stuREIN.SexWanted" value="男" >男性
                                            <input type="radio" name="stuREIN.SexWanted" value="女">女性
                                            <input type="radio" name="stuREIN.SexWanted" value="不限" checked="checked">不限</label><br/>
                                    </li>

                                    <li>
                                        <label>可选时间<input type="checkbox" name="stuREIN.Time" value="上午" checked="checked">上午
                                            <input type="checkbox" name="stuREIN.Time" value="下午">下午
                                            <input type="checkbox" name="stuREIN.Time" value="晚上">晚上</label><br/>
                                    </li>
                                    <li>
                                        <label>
                                            学科<input type="checkbox" name="stuREIN.Subject" value="数学" checked="checked">数学
                                            <input type="checkbox" name="stuREIN.Subject" value="语文">语文
                                            <input type="checkbox" name="stuREIN.Subject" value="外语">外语<br/>
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            年级<input type="radio" name="stuREIN.Grade" value="小学">小学
                                            <input type="radio" name="stuREIN.Grade" value="初中">初中
                                            <input type="radio" name="stuREIN.Grade" value="高中" checked="checked">高中<br/>
                                        </label>
                                    </li>
                                    <input type="submit" value="注册">
                                </form>
                            </div>
                        </div>
                        <div class="tab-1 resp-tab-content">
                            <div class="agileinfo-recover">
                                <h3>教师注册</h3>
                                <form action="TeaInsert.action" method="post">
                                    <input type="text" class="name" name="teacher.NickName" placeholder="昵称" required="">
                                    <input type="password" class="password" name="teacher.Password" placeholder="密码" required="">
                                    <input type="email" class="email" name="teaREIN.Email" placeholder="邮箱" required="">
                                    <li>
                                        <label>性别：<input type="radio" name="teaREIN.Sex" value="男" checked="checked">男性
                                            <input type="radio" name="teaREIN.Sex" value="女">女性</label><br/>
                                    </li>
                                    <li>
                                        <label>最高学历<input type="radio" name="teaREIN.Education" value="本科" checked="checked">本科
                                            <input type="radio" name="teaREIN.Education" value="硕士">硕士
                                            <input type="radio" name="teaREIN.Education" value="博士">博士
                                            <input type="radio" name="teaREIN.Education" value="博士后">博士后</label><br/>
                                    </li>

                                    <li>
                                        <label>可选时间<input type="checkbox" name="teaREIN.Time" value="上午" checked="checked">上午
                                            <input type="checkbox" name="teaREIN.Time" value="下午">下午
                                            <input type="checkbox" name="teaREIN.Time" value="晚上">晚上</label><br/>
                                    </li>
                                    <li>
                                        <label>
                                            学科<input type="checkbox" name="teaREIN.Subject" value="数学" checked="checked">数学
                                            <input type="checkbox" name="teaREIN.Subject" value="语文">语文
                                            <input type="checkbox" name="teaREIN.Subject" value="外语">外语<br/>
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            年级<input type="radio" name="teaREIN.Grade" value="小学">小学
                                            <input type="radio" name="teaREIN.Grade" value="初中">初中
                                            <input type="radio" name="teaREIN.Grade" value="高中" checked="checked">高中<br/>
                                        </label>
                                    </li>
                                    <input type="submit" value="注册">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="clear"></div>

        </div>

    </div>




    <h3>展示所有教师信息</h3><br/>

    <div class="bs-docs-example">
        <table class="table table-striped">
            <tr>
                <th>昵称</th>
                <th>性别</th>
                <th>学历</th>
                <th>可行时间</th>
                <th>学科</th>
                <th>面向年级</th>
            </tr>
            <tbody>

            <s:iterator value="#request.listofbstea" var="temp">
            <tr>
                <td><a href='SingleTea.action?StuID=0&TeaID=<s:property value="#temp.getTeacher().getID()"/>'>
                    <s:property value="#temp.getTeacher().getNickName()"/>
                </td>
                <td><s:property value="#temp.getTeaREIN().getSex()"/></td>
                <td><s:property value="#temp.getTeaREIN().getEducation()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getTime()"/> </td>
                <td><s:property value="#temp.getTeaREIN().getSubject()"/> </td>
                 <td><s:property value="#temp.getTeaREIN().getGrade()"/> </td>
            </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>


    <div class="footer">
        <p> &copy; 2017 Classy Forms Widget. All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
    </div>


</div>
</body>
</html>
