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

    <link href="css/indexbootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/set2.css" />
    <!-- Default-JavaScript-File --> <script type="text/javascript" src="js/jquery.min.js"></script>


</head>
<body>
<!-- //team-->
<h1>进入首页</h1>

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
                                            <input type="checkbox" id="brand2" value="">
                                            <label for="brand2"><span></span>记住我</label>
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
                                            <input type="checkbox" id="brand1" value="">
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
                                        <label>需要教师性别
                                            <select name="stuREIN.SexWanted">
                                                <option value="不限">不限</option>
                                                <option value="男">男性</option>
                                                <option value="女">女性</option>
                                            </select>
                                        </label>
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
                                            年级
                                            <select name="stuREIN.Grade">
                                                <option value="学龄前">学龄前</option>
                                                <option value="小学">小学</option>
                                                <option value="初中">初中</option>
                                                <option value="高中">高中</option>
                                                <option value="大学">大学</option>
                                            </select>
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
                                            时薪要求
                                            <select name="stuREIN.Price">
                                                <option value="0/80">80以下</option>
                                                <option value="80/150">80~150</option>
                                                <option value="150/200">150~200</option>
                                                <option value="200++">200以上</option>
                                            </select>
                                        </label>
                                    </li>
                                    <li>
                                        <label>
                                            地区
                                            <select name="stuREIN.AddressAccess">
                                                <option value="南岗">南岗</option>
                                                <option value="道里">道里</option>
                                                <option value="道外">道外</option>
                                                <option value="平房">平房</option>
                                                <option value="松北">松北</option>
                                                <option value="香坊">香坊</option>
                                                <option value="阿城">阿城</option>
                                                <option value="呼兰">呼兰</option>
                                                <option value="双城">双城</option>
                                            </select>
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
                                        <label>最高学历
                                        <select name="teaREIN.Education">
                                            <option value="本科">本科</option>
                                            <option value="硕士">硕士</option>
                                            <option value="博士">博士</option>
                                            <option value="博士后">博士后</option>
                                        </select>
                                        </label>
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
                                        <select name="teaREIN.Price">
                                            <option value="0/80">80以下</option>
                                            <option value="80/150">80~150</option>
                                            <option value="150/200">150~200</option>
                                            <option value="200++">200以上</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label>可接受地区</label>
                                        <select name="teaREIN.AddressAccess">
                                            <option value="南岗">南岗</option>
                                            <option value="道里">道里</option>
                                            <option value="道外">道外</option>
                                            <option value="平房">平房</option>
                                            <option value="松北">松北</option>
                                            <option value="香坊">香坊</option>
                                            <option value="阿城">阿城</option>
                                            <option value="呼兰">呼兰</option>
                                            <option value="双城">双城</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label>评价密钥</label>
                                        <input type="text"  name="teaREIN.EvaluationPassword" value="1111">初始评价资格密码为您设置为1111,请自行设置！<br>
                                    <a href="http://www.baidu.com">什么是初始评价资格密码?自行设置方式?</a><br></li>
                                    <input type="text"  name="teaREIN.PersionalIntroduction" value="这个人很懒，什么都没留下">
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






</div>
<!-- team -->

<h1>金牌教师</h1>
<div class="jarallax agileits-team agile-section" id="team">
    <div class="grid">
        <s:iterator value="#request.listofbstea" var="temp">
            <figure class="col-md-3 effect-kira">
                <img src="icon/${temp.getTeacher().getID()}.jpg" alt="t1" class="img-responsive"/>
                <figcaption>
                    <h4><s:property value="#temp.getTeacher().getNickName()"/></h4>
                    <h5><s:property value="#temp.getTeaREIN().getSubject()"/></h5>
                    <p>
                        <a href='SingleTea.action?StuID=0&TeaID=<s:property value="#temp.getTeacher().getID()"/>'>个人简介</a>
                    </p>
                </figcaption>
            </figure>
        </s:iterator>
        <div class="clearfix"></div>
    </div>
</div>

</body>
</html>
