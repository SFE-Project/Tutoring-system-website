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

    <title>Classy Forms Widget A Flat Responsive Widget Template :: W3layouts</title>

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
                                        <label>具体时间<input type="checkbox" name="stuREIN.Time" value="上午" checked="checked">上午
                                            <input type="checkbox" name="stuREIN.Time" value="下午">下午
                                            <input type="checkbox" name="stuREIN.Time" value="晚上">晚上</label><br/>
                                    </li>
                                    <li>
                                        <label>大致时间<input type="checkbox" name="stuREIN.Date" value="寒假" checked="checked">寒假
                                            <input type="checkbox" name="stuREIN.Date" value="暑假">暑假
                                            <input type="checkbox" name="stuREIN.Date" value="平时">平时</label><br/>
                                    </li>
                                    <li>
                                        <label>
                                            学科<input type="checkbox" name="stuREIN.Subject" value="数学" checked="checked">数学
                                            <input type="checkbox" name="stuREIN.Subject" value="语文">语文
                                            <input type="checkbox" name="stuREIN.Subject" value="外语">外语
                                            <input type="checkbox" name="stuREIN.Subject" value="物理">物理
                                            <input type="checkbox" name="stuREIN.Subject" value="化学">化学
                                            <input type="checkbox" name="stuREIN.Subject" value="政治">政治
                                            <input type="checkbox" name="stuREIN.Subject" value="地理">地理
                                            <input type="checkbox" name="stuREIN.Subject" value="历史">历史<br/>
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            年级<input type="radio" name="stuREIN.Grade" value="学龄前">学龄前
                                            <input type="radio" name="stuREIN.Grade" value="小学">小学
                                            <input type="radio" name="stuREIN.Grade" value="初中">初中
                                            <input type="radio" name="stuREIN.Grade" value="高中" checked="checked">高中
                                            <input type="radio" name="stuREIN.Grade" value="大学">大学<br/>
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            补习类别<input type="radio" name="stuREIN.Type" value="一对一">一对一
                                            <input type="radio" name="stuREIN.Type" value="一对多" checked="checked">一对多
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            时薪要求<input type="radio" name="stuREIN.Price" value="0/80" checked="checked">80以下
                                            <input type="radio" name="stuREIN.Price" value="80/150">80~150
                                            <input type="radio" name="stuREIN.Price" value="150/200">150~200
                                            <input type="radio" name="stuREIN.Price" value="200++">200以上
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            可接受地点设置
                                            <input type="radio" name="stuREIN.AddressAccess" value="南岗" checked="checked">南岗
                                            <input type="radio" name="stuREIN.AddressAccess" value="道里">道里
                                            <input type="radio" name="stuREIN.AddressAccess" value="道外">道外
                                            <input type="radio" name="stuREIN.AddressAccess" value="平房">平房
                                            <input type="radio" name="stuREIN.AddressAccess" value="松北">松北
                                            <input type="radio" name="stuREIN.AddressAccess" value="香坊">香坊
                                            <input type="radio" name="stuREIN.AddressAccess" value="阿城">阿城
                                            <input type="radio" name="stuREIN.AddressAccess" value="呼兰">呼兰
                                            <input type="radio" name="stuREIN.AddressAccess" value="双城">双城
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
                                        <label>具体时间<input type="checkbox" name="teaREIN.Time" value="上午" checked="checked">上午
                                            <input type="checkbox" name="teaREIN.Time" value="下午">下午
                                            <input type="checkbox" name="teaREIN.Time" value="晚上">晚上</label><br/>
                                    </li>
                                    <li>
                                        <label>大致时间</label>
                                        <input type="checkbox" name="teaREIN.Date" value="寒假" checked="checked">寒假
                                        <input type="checkbox" name="teaREIN.Date" value="平时">平时
                                        <input type="checkbox" name="teaREIN.Date" value="暑假">暑假
                                    </li>
                                    <li>
                                        <label>
                                            <label>学科</label><input type="checkbox" name="teaREIN.Subject" value="数学" checked="checked">数学
                                            <input type="checkbox" name="teaREIN.Subject" value="语文">语文
                                            <input type="checkbox" name="teaREIN.Subject" value="外语">外语
                                            <input type="checkbox" name="teaREIN.Subject" value="物理">物理
                                            <input type="checkbox" name="teaREIN.Subject" value="化学">化学
                                            <input type="checkbox" name="teaREIN.Subject" value="政治">政治
                                            <input type="checkbox" name="teaREIN.Subject" value="地理">地理
                                            <input type="checkbox" name="teaREIN.Subject" value="历史">历史
                                        </label>
                                    </li>
                                    <li>
                                        <label>年级</label>
                                        <input type="checkbox" name="teaREIN.Grade" value="学龄前">学龄前
                                        <input type="checkbox" name="teaREIN.Grade" value="小学">小学
                                        <input type="checkbox" name="teaREIN.Grade" value="初中">初中
                                        <input type="checkbox" name="teaREIN.Grade" value="高中" checked="checked">高中
                                        <input type="checkbox" name="teaREIN.Grade" value="大学">大学
                                    </li>
                                    <li>
                                        <label>补习类别</label>
                                        <input type="checkbox" name="teaREIN.Type" value="一对一" checked="checked">一对一
                                        <input type="checkbox" name="teaREIN.Type" value="一对多">一对多
                                    </li>
                                    <li>
                                        <label>时薪</label>
                                        <input type="radio" name="teaREIN.Price" value="0/80" checked="checked">80以下
                                        <input type="radio" name="teaREIN.Price" value="80/150">80~150
                                        <input type="radio" name="teaREIN.Price" value="150/200">150~200
                                        <input type="radio" name="teaREIN.Price" value="200++">200以上
                                    </li>
                                    <li>
                                        <label>可接受地点(目前仅支持哈尔滨市内地区)</label>
                                        <input type="radio" name="teaREIN.AddressAccess" value="南岗" checked="checked">南岗
                                        <input type="radio" name="teaREIN.AddressAccess" value="道里" checked="checked">道里
                                        <input type="radio" name="teaREIN.AddressAccess" value="道外" checked="checked">道外
                                        <input type="radio" name="teaREIN.AddressAccess" value="平房" checked="checked">平房
                                        <input type="radio" name="teaREIN.AddressAccess" value="松北" checked="checked">松北
                                        <input type="radio" name="teaREIN.AddressAccess" value="香坊" checked="checked">香坊
                                        <input type="radio" name="teaREIN.AddressAccess" value="阿城" checked="checked">阿城
                                        <input type="radio" name="teaREIN.AddressAccess" value="呼兰" checked="checked">呼兰
                                        <input type="radio" name="teaREIN.AddressAccess" value="双城" checked="checked">双城
                                    </li>
                                    <input type="text"  name="teaREIN.EvaluationPassword" value="1111">初始评价资格密码为您设置为1111,请自行设置！<br>
                                    <a href="http://www.baidu.com">什么是初始评价资格密码?自行设置方式?</a><br>
                                    <input type="text"  name="teaREIN.PersionalIntroduction" value="暂无个人评价"><br/>
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
