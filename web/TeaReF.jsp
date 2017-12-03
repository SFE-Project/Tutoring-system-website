<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: sshss
  Date: 2017/11/9
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<!-- html -->
<html>
<!-- head -->
<head>
    <title>Match a Matrimonial Category Bootstrap Responsive Web Template | Assisted Services :: w3layouts</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!-- bootstrap-CSS -->
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /><!-- Fontawesome-CSS -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
    <!-- Custom Theme files -->
    <link href="css/menu.css" rel="stylesheet" type="text/css" media="all" /> <!-- menu style -->
    <!--theme-style-->
    <link href="css/profile.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
    <!--meta data-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Match Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--//meta data-->
    <!-- online fonts -->
    <link href="//fonts.googleapis.com/css?family=Poppins:300,400,500,600,700&amp;subset=devanagari,latin-ext" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <!-- /online fonts -->
    <!-- nav smooth scroll -->
    <script>
        $(document).ready(function(){
            $(".dropdown").hover(
                function() {
                    $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
                    $(this).toggleClass('open');
                },
                function() {
                    $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
                    $(this).toggleClass('open');
                }
            );
        });
    </script>
    <!-- //nav smooth scroll -->
</head>
<!-- //head -->
<!-- body -->
<body>


<!-- inner banner -->
<div class="w3layouts-inner-banner">
    <div class="container">
        <div class="logo">
            <h1><a class="cd-logo link link--takiri" href="javascript:history.go(-1);">返回<span><i class="fa fa-heart" aria-hidden="true"></i>回到上一页</span></a></h1>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //inner banner -->


<!-- Assisted Services -->
<div class="w3ls-assisted_Services">
    <div class="container">
        <div class="assisted_Services-agileits">
            <h2>个人资料修改 </h2>
            <h2>当前账号：${TeaID}</h2>
            <form action="TeaREINUpdate.action">
                <input type="hidden" name="TeaREIN.ID" value='<s:property value="TeaID"/>'>
                <label>性别：</label>
                <input type="radio" name="teaREIN.Sex" value="男" checked="checked">男性
                <input type="radio" name="teaREIN.Sex" value="女">女性
                <label> 最高学历</label><input type="radio" name="teaREIN.Education" value="本科" checked="checked">本科
                    <input type="radio" name="teaREIN.Education" value="硕士">硕士
                    <input type="radio" name="teaREIN.Education" value="博士">博士
                    <input type="radio" name="teaREIN.Education" value="博士后">博士后
                <%--大致时间--%>
                <label>大致时间</label>
                <input type="checkbox" name="teaREIN.Date" value="寒假" checkout="checked">寒假
                <input type="checkbox" name="teaREIN.Date" value="平时">平时
                <input type="checkbox" name="teaREIN.Date" value="暑假">暑假


                <label>具体时间：</label><input type="checkbox" name="teaREIN.Time" value="上午" checked="checked">上午
                <input type="checkbox" name="teaREIN.Time" value="下午">下午
                <input type="checkbox" name="teaREIN.Time" value="晚上">晚上
                <label>学科</label><input type="checkbox" name="teaREIN.Subject" value="数学" checked="checked">数学
                <input type="checkbox" name="teaREIN.Subject" value="语文">语文
                <input type="checkbox" name="teaREIN.Subject" value="外语">外语
                <input type="checkbox" name="teaREIN.Subject" value="物理">物理
                <input type="checkbox" name="teaREIN.Subject" value="化学">化学
                <input type="checkbox" name="teaREIN.Subject" value="政治">政治
                <input type="checkbox" name="teaREIN.Subject" value="地理">地理
                <input type="checkbox" name="teaREIN.Subject" value="历史">历史
                <label>年级</label>
                <input type="checkbox" name="teaREIN.Grade" value="学龄前">学龄前
                <input type="checkbox" name="teaREIN.Grade" value="小学">小学
                <input type="checkbox" name="teaREIN.Grade" value="初中">初中
                <input type="checkbox" name="teaREIN.Grade" value="高中" checked="checked">高中
                <input type="checkbox" name="teaREIN.Grade" value="大学">大学
                <%--补习类别--%>
                <label>补习类别</label>
                <input type="checkbox" name="teaREIN.Type" value="一对一" checked="checked">一对一
                <input type="checkbox" name="teaREIN.Type" value="一对多">一对多
                <%--时薪--%>
                <label>时薪</label>
                <input type="radio" name="teaREIN.Price" value="0/80" checked="checked">80以下
                <input type="radio" name="teaREIN.Price" value="80/150">80~150
                <input type="radio" name="teaREIN.Price" value="150/200">150~200
                <input type="radio" name="teaREIN.Price" value="200++">200以上
                <%--地点设置--%>
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



                <input type="submit" value="提交修改" />
            </form>
        </div>
    </div>

    <!-- Modal -->
    <div id="myModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Login to Continue</h4>
                </div>
                <div class="modal-body">
                    <div class="login-w3ls">
                        <form id="signin" action="#" method="post">
                            <label>User Name </label>
                            <input type="text" name="User Name" placeholder="Username" required="">
                            <label>Password</label>
                            <input type="password" name="Password" placeholder="Password" required="">
                            <div class="w3ls-loginr">
                                <input type="checkbox" id="brand" name="checkbox" value="">
                                <span> Remember me ?</span>
                                <a href="#">Forgot password ?</a>
                            </div>
                            <div class="clearfix"> </div>
                            <input type="submit" name="submit" value="Login">
                            <div class="clearfix"> </div>
                            <div class="social-icons">
                                <ul>
                                    <li><a href="#"><span class="icons"><i class="fa fa-facebook" aria-hidden="true"></i></span><span class="text">Facebook</span></a></li>
                                    <li class="twt"><a href="#"><span class="icons"><i class="fa fa-twitter" aria-hidden="true"></i></span><span class="text">Twitter</span></a></li>
                                </ul>
                                <div class="clearfix"> </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- //Modal -->
</div>
<script src="js/easyResponsiveTabs.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $('#parentHorizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            tabidentify: 'hor_1', // The tab groups identifier
            activate: function (event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#nested-tabInfo');
                var $name = $('span', $info);

                $name.text($tab.text());

                $info.show();
            }
        });

    });
</script>
<!-- //Assisted Services -->


<!-- menu js aim -->
<script src="js/jquery.menu-aim.js"> </script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
<!-- //menu js aim -->
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
        var defaults = {
              containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
         };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- for smooth scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!-- //for smooth scrolling -->
</body>
<!-- //body -->
</html>
<!-- //html -->

