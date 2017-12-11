<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/3
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    当前账号：${TeaID}
    <title>展示教师的followers</title>
    <style>
    table {

    border-collapse: collapse;

    font-family: Futura, Arial, sans-serif;

    }

    caption {

    font-size: larger;

    margin: 1em auto;

    }

    th,td {

    padding: .65em;

    }

    th {

    background: #555 nonerepeat scroll 0 0;

    /* border: 1px solid #777; */

    color: #fff;

    }

    td {

    /* border: 1px solid #777; */

    }

    tbody tr:nth-child(odd) {

    background: #ccc;

    }

    th:first-child {

    border-radius: 9px 0 0 0;

    }

    th:last-child {

    border-radius: 0 9px 0 0;

    }

    tr:last-child td:first-child {

    border-radius: 0 0 0 9px;

    }

    tr:last-child td:last-child {

    border-radius: 0 0 9px 0;

    }
    </style>
</head>
<body>
<table border="10">
    <tr>
        <td>Follower-ID</td>
        <td>Follower-昵称</td>
    </tr>
    <s:iterator value="#request.listofstudent" var="temp">
        <tr>
            <td><a href="SingleStudent.action?TeaID=${TeaID}&StuID=<s:property value="#temp.getID()"/>"><s:property value="#temp.getID()"></s:property></a></td>
            <%--<td><s:property value="#temp.getID()"></s:property> </td>--%>
            <td><s:property value="#temp.getNickName()"></s:property> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
