
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
        <h2>Bridegroom Profile Details</h2>
        <div class="col-md-9 profiles-list-agileits">
            <div class="single_w3_profile">
                <div class="agileits_profile_image">
                    <img src="images/profile-image-men.jpg" alt="profile image" />
                </div>
                <div class="w3layouts_details">
                    <h4>ID : ${teademo.getID()}  昵称 :${teademo.getNickName()}</h4>
                    <a href='FriendList.action?StuID=${teademo.getID()}' data-toggle="modal" data-target="#myModal">我的关注</a>
                    <a href="TeaReF.action?TeaID=${teademo.getID()}" data-toggle="modal" data-target="#myModal">修改需求</a>
                    <a href='MatchFOrTeaPlus.action?TeaID=${teademo.getID()}' data-toggle="modal" data-target="#myModal">一键匹配</a>
                    <a href='EvaluationPasswordShow.action?TeaID=${teademo.getID()}'  data-toggle="modal" data-target="#myModal">更改评价密钥</a>
                    <a href='PushUserIDofTea.action?UserID=${teademo.getID()}' data-toggle="modal" data-target="#myModal">更改资料</a>
                    <a href="SingleTea.action?StuID=0&TeaID=${teademo.getID()}" data-toggle="modal" data-target="#myModal">游客视角个人界面</a>
                    <form action="TeaEditPersionalIntroduction.action">
                       此处编辑个人介绍（限定100字）<br/>
                        <input type="text" name="TeaID" value="${teademo.getID()}" hidden="hidden">
                        <textarea rows="10" cols="60" name="TeaPersionalIntroduction"></textarea>
                        <input type="submit" value="确定">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="profile_w3layouts_details">
                <div class="agileits_aboutme">
                    <h4>About me</h4>
                    <h5>Brief about me:</h5>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    <p>when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                    <p>It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                    <h5>Family Details:</h5>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Mother : </label>
                        <div class="col-sm-9 w3_details">
                            Housewife
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Father : </label>
                        <div class="col-sm-9 w3_details">
                            Govt. Employee
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Sister's : </label>
                        <div class="col-sm-9 w3_details">
                            Not Specified
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Brother's : </label>
                        <div class="col-sm-9 w3_details">
                            Not Specified
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Family Income : </label>
                        <div class="col-sm-9 w3_details">
                            Not Specified
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Stay : </label>
                        <div class="col-sm-9 w3_details">
                            sed, USA
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Family Values : </label>
                        <div class="col-sm-9 w3_details">
                            Moderate
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <h5>Education Details:</h5>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Highest Education : </label>
                        <div class="col-sm-9 w3_details">
                            MBA/PGDM
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">UG Degree : </label>
                        <div class="col-sm-9 w3_details">
                            B.Tech
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">School : </label>
                        <div class="col-sm-9 w3_details">
                            Not Filled in
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">PG Degree : </label>
                        <div class="col-sm-9 w3_details">
                            Not Specified
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">PG College : </label>
                        <div class="col-sm-9 w3_details">
                            Not Specified
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Occupation : </label>
                        <div class="col-sm-9 w3_details">
                            Not Specified
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Annual Income : </label>
                        <div class="col-sm-9 w3_details">
                            Not Filled in
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <h5>Lifestyle:</h5>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Appearance : </label>
                        <div class="col-sm-9 w3_details">
                            Fair, 55kg
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Assets : </label>
                        <div class="col-sm-9 w3_details">
                            Not Filled in
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Habits : </label>
                        <div class="col-sm-9 w3_details">
                            Vegetarian, Doesn't Drink, Doesn't Smoke
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Languages Known : </label>
                        <div class="col-sm-9 w3_details">
                            English, Hindi, Urdu
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Blood Group : </label>
                        <div class="col-sm-9 w3_details">
                            AB+
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Stay : </label>
                        <div class="col-sm-9 w3_details">
                            sed, USA
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Family Values : </label>
                        <div class="col-sm-9 w3_details">
                            Moderate
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <h5>Desired Partner:</h5>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Age : </label>
                        <div class="col-sm-9 w3_details">
                            20 - 23 Years
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Height : </label>
                        <div class="col-sm-9 w3_details">
                            5' 2" to 5' 6"
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Marital Status : </label>
                        <div class="col-sm-9 w3_details">
                            Never Married
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Religion : </label>
                        <div class="col-sm-9 w3_details">
                            Doesn't Matter
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Caste : </label>
                        <div class="col-sm-9 w3_details">
                            Doesn't Matter
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Education : </label>
                        <div class="col-sm-9 w3_details">
                            Lorem ipsum dolor sit amet
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Occupation : </label>
                        <div class="col-sm-9 w3_details">
                            IT Software
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="form_but1">
                        <label class="col-sm-3 control-label1" for="Relation">Income : </label>
                        <div class="col-sm-9 w3_details">
                            No Income
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3 w3ls-aside">
            <h3>会话模式:</h3>
            <form action="MessageShow.action" method="get">
                <input class="text" type="text" name="RecID" placeholder="对方ID" required="">
                <p hidden><input name="OutID" type="text" value="${teademo.getID()}"></p>
                <input type="submit" value="开始会话">
                <div class="clearfix"></div>
            </form>
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
