
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>Match a Matrimonial Category Bootstrap Responsive Web Template | Groom Profile :: w3layouts</title>
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



<!-- Bridegroom Profile Details -->
<div class="w3ls-list">
    <div class="container">
        <h2>功能</h2>
        <div class="col-md-9 profiles-list-agileits">
            <div class="single_w3_profile">
                <div class="agileits_profile_image">
                    <img src="images/touxiang.jpg" alt="profile image" />
                </div>
                <div class="w3layouts_details">
                    <h4>ID : ${teademo.getID()}  昵称 :${teademo.getNickName()}</h4>
                    <a href='ShowTheFollowers.action?TeaID=${teademo.getID()}' data-toggle="modal" data-target="#myModal">关注我的</a>
                    <a href="TeaReF.action?TeaID=${teademo.getID()}" data-toggle="modal" data-target="#myModal">修改需求</a>
                    <a href='MatchFOrTeaPlus.action?TeaID=${teademo.getID()}' data-toggle="modal" data-target="#myModal">一键匹配</a>
                    <a href='EvaluationPasswordShow.action?TeaID=${teademo.getID()}'  data-toggle="modal" data-target="#myModal">更改评价密钥</a>
                    <a href='PushUserIDofTea.action?UserID=${teademo.getID()}' data-toggle="modal" data-target="#myModal">更改资料</a>
                    <a href="SingleTea.action?StuID=0&TeaID=${teademo.getID()}" data-toggle="modal" data-target="#myModal">游客视角个人界面</a>
                    <a href="GetListofMessageUser.action?RecID=${teademo.getID()}" data-toggle="modal" data-target="#myModal">历史消息记录/所有联系用户/未读信息</a>
                    <a href="Jump.action?OutID=${teademo.getID()}">发送消息</a>
                    <form action="TeaEditPersionalIntroduction.action">
                       此处编辑个人介绍（限定100字）<br/>
                        <input type="text" name="TeaID" value="${teademo.getID()}" hidden="hidden">
                        <textarea rows="10" cols="60" name="TeaPersionalIntroduction" required></textarea>
                        <input type="submit" value="确定">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="profile_w3layouts_details">
                <div class="profile_w3layouts_details">
                    <div class="agileits_aboutme">
                        <h4>坚持梦想</h4>
                        <p>Live for your dream, and even if you do not get there, you still have lived.</p>
                        <p>梦想还是要有的，万一明天就实现了呢。</p>
                        <p>                              ---- Jack Ma</p>

                    </div>
                    <div class="agileits_aboutme">
                        <h4>天道酬勤</h4>
                        <p>Book Hill road for the path, learn from the sea bitter boat.</p>
                        <p>书山有路勤为径，学海无涯苦作舟。</p>
                        <p>                              ---- O.SeaSide</p>

                    </div>
                    <div class="agileits_aboutme">
                        <h4>师道长存</h4>
                        <p>Teacher, so preach demystified also.</p>
                        <p>师者，所以传道受业解惑也。</p>
                        <p>                              ---- 韩愈</p>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3 w3ls-aside">
            <div class="view_profile">
                <h3>同行</h3>
                <s:iterator value="#request.listofbstea" var="temp">
                    <ul class="profile_item">
                        <a href='SingleTea.action?StuID=0&TeaID=<s:property value="#temp.getTeacher().getID()"/>'>
                            <li class="profile_item-img">
                                <img src="images/p1.jpg" class="img-responsive" alt="">
                            </li>
                            <li class="profile_item-desc">
                                <h6>ID : <s:property value="#temp.getTeaREIN().getID()"/></h6>
                                <p><s:property value="#temp.getTeacher().getNickName()"/>,<s:property value="#temp.getTeaREIN().getSex()"/>,<s:property value="#temp.getTeaREIN().getEducation()"/>,
                                    <s:property value="#temp.getTeaREIN().getTime()"/>,<s:property value="#temp.getTeaREIN().getSubject()"/>
                                    <s:property value="#temp.getTeaREIN().getGrade()"/> ...</p>
                            </li>
                            <div class="clearfix"> </div>
                        </a>
                    </ul>
                </s:iterator>
            </div>
        </div>
        <div class="clearfix"></div>
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
<!-- //Bridegroom Profile Details -->

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
