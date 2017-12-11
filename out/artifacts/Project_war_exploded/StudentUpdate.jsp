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
            <h2>信息更改 </h2><br/>

            <h3>填写前请校验所有信息正确！</h3>

            <form action="StudentUpdate.action" >
                <input type="text" name="StuID" hidden="hidden" value=${UserID}><br/>

                <label>新昵称</label>
                <input type="text" name="NickName">
                <label>新密码：</label>
                <input type="text" name="PassWord">
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

