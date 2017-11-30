<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DB
  Date: 2017/12/1
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>累计评价</title>
    <h2>${TeaID}</h2>
</head>
<body>

<div>
    <table>
        <tr>
            <th>评价者</th>
            <th>评价信息</th>
            <th>评价星级</th>
        </tr>
        <s:iterator value="#request.stuEvaluationtoTeaList" var="temp">
            <tr>
                <td><s:property value="#temp.getEvaluatorID()"/> </td>
                <td><s:property value="#temp.getEvaluateContent()"/> </td>
                <td><s:property value="#temp.getStar()"/> </td>

            </tr>
        </s:iterator>

    </table>
</div>
        <%--<div class="profile_w3layouts_details">--%>

            <%--<table class="table table-striped">--%>

                <%--<tbody>--%>
                <%--&lt;%&ndash;&ndash;%&gt;--%>
                <%--<s:iterator value="#request.teaListAndOneStu.getTeaREINS()" var="temp">--%>
                    <%--<tr>--%>
                        <%--<td><a href='SingleTea.action?StuID=<a:property value="StuID"/>&TeaID=<s:property value="#temp.ID"/>'><s:property value="#temp.ID"/> </a> </td>--%>
                        <%--<td><s:property value="#temp.Sex"/> </td>--%>
                        <%--<td><s:property value="#temp.Education"/></td>--%>
                        <%--<td><s:property value="#temp.Date"/></td>--%>
                        <%--<td><s:property value="#temp.Time"/> </td>--%>
                        <%--<td><s:property value="#temp.Subject"/> </td>--%>
                        <%--<td><s:property value="#temp.Grade"/> </td>--%>
                        <%--<td><s:property value="#temp.Email"/></td>--%>
                        <%--<td><s:property value="#temp.AddressAccess"/></td>--%>
                        <%--<td><s:property value="#temp.Type"/></td>--%>
                        <%--<td><s:property value="#temp.Price"/></td>--%>
                    <%--</tr>--%>
                <%--</s:iterator>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
</body>
</html>
