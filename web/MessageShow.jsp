<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/10/28
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="localpackage.Dao"%>
<%@ page import="localpackage.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>展示会话界面</title>
    <style type="text/css">

        *{ margin:0; padding:0; border:0; outline:0; font-family:"Microsoft YaHei";}
        body{ font-size:12px;}
        #box{ width:200px; height:200px; background:orange; position:absolute; left:0; top:0;}

        .f-cb{ zoom:1;}
        .f-cb:after,.f-cb:before{ clear:both; content:""; display:table; height:0; }


        ul{ list-style:none;}
        .sublime{
            width:326px;
            background-color:rgba(255,255,255,0.4);

        }
        .input{
            background-color: azure;
            width: 300px;
            height: 30px;
            border: 1px solid #ccc;
            padding: 7px 0px;
            border-radius: 3px;
            padding-left:5px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
        }
        .input:focus{
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
        }
        .null{
            height: 20px;
            width: 300px;
        }
        .sublime{
            width:80px;
            height:40px;
            border: 1px solid #ccc;
            padding: 7px 0px;
            border-radius: 3px;
            padding-left:5px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s

        }
        .send{
            width:700px;
            height: 100px;
            padding:20px;
            border:1px solid  #ccc;
            margin:50px auto;
            background-color: cornflowerblue;

        }
        .main{
            width:700px;
            height: 500px;
            padding:20px;
            border:1px solid  #ccc;
            margin:50px auto;
            background-image: url(Image/Messagebackground.jpeg);
            overflow-y: scroll;
        }
        .m1 { position:relative; }
        .m1:after,.m1:before { clear:both; content:""; display:table; height:0; margin-bottom:20px;}
        .m1 dt a{ width:60px; height:60px; background:#CCC; display:inline-block; text-align:center; line-height:60px; }
        .m1 dd{ max-width:274px; border:1px solid #ccc; border-radius:3px; padding:10px ;  background:#ccc; box-sizing:border-box; position:relative;}
        .m1 dd:before{ position:absolute; bottom:5px;  content:""; border-width:10px; border-style:solid; }
        .m1.he dd:before,.m1.vhe dd:before{ left:-20px; border-color:transparent #ccc  transparent transparent;   }
        .m1.me dd:before,.m1.vme dd:before{ right:-20px; border-color:transparent  transparent transparent  #ccc; }
        .m1.he dt { float:left; }
        .m1.he dd{ margin-left:20px; margin-top:20px ;float:left; }
        .m1.me dt { float:right; margin-left:20px;}
        .m1.me dd { float:right; margin-top:20px;}

        .m1.he dt a{ float:left; }
        .m1.he dt span{ display:block; float:left;  margin-right:-200px; color:#666; margin-left:20px;}

        .m1.me dt a{ float:right; }
        .m1.me dt span{ display:block; float:right;  margin-left:-200px; color:#666; margin-right:20px;}


        .m1.vhe dt a{ position:absolute; bottom:0; }
        .m1.vhe dt span{ padding-left:80px; }
        .m1.vhe dd{ margin-left:80px; margin-top:5px;}

        .m1.vme dt a{ position:absolute; bottom:0; right:0;}
        .m1.vme dt span{ padding-right:80px; text-align:right; display:block; }
        .m1.vme dd{ margin-right:80px; margin-top:5px; float:right;}



        a:link,a:visited {
            color: black;
            text-decoration: none;
        }
        a:hover,a:active {
            text-decoration: underline;
        }
    </style>

    <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
</head>
<body>
<font size="5"><a href="MessageShow.action?RecID=${RecID}&OutID=${OutID}">刷新</a></font> <br/>
<font size="5"><a href="javascript:history.go(-1)">返回上一步</a></font><br/>


<div class="main">
    <font color="#f0ffff" size="3">
        ${OutID}Connecting with${RecID}...<br/>
    </font><br/>
    <a href="#buttom"><font color="red" size="3">一键底端查看最新消息</font></a><br/>

    <div class="refresh">
        <s:iterator value="#request.listofmessage" var="temp">
            <dl class="vhe m1">
                <dt><a> <s:property value="#temp.getOutID()"/>发送</a></dt>
                <dd><s:property value="#temp.getMessagecol()"/><br/></dd>
            </dl>
        </s:iterator>
    </div>
    <h1 id="buttom"><font size="3" color="#f0ffff">用户${RecID}正在等待您的新消息...<font/></h1><br/>
</div>
<div class="send">
    <form action="MessageInsert.action">
        <input type="hidden" name="OutID" value=${OutID}>
        <input type="hidden" name="RecID" value=${RecID}><br/>
        <font color="#f0ffff">消息内容</font>

            <input type="text" name="mess" class="input"/> <br/>
        <div class="null">

        </div>
            <input class="sublime" type="submit" value="确定发送"><br/>




    </form>
</div>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        setInterval(function () { $(".refresh").load(location.href + " .refresh"); }, 1000);
    })
</script>


</html>
