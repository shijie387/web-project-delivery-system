<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>快递管理系统</title>
    <meta name="Copyright" content="Douco Design." />
    <jsp:include page="resource.jsp"/>
</head>
<body>
<div id="dcWrap">
    <jsp:include page="head.jsp" />
    <!-- dcHead 结束 -->
    <jsp:include page="menu.jsp"/>



    <div id="dcMain">
        <!-- 当前位置 -->
        <div id="urHere">快递管理系统<b>></b><strong>添加快递</strong> </div> <div
            id="manager" class="mainBox"
            style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="index.html" class="actionBtn">返回首页</a>添加快递</h3>
        <form action="/delivery/data/save" method="post">
            <table width="100%" border="0" cellpadding="8"
                   cellspacing="0" class="tableBasic">
                <tr>
                    <td width="100" align="right">收件人</td>
                    <td>
                        <input type="text" name="deliveryName"
                               size="40" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td width="100" align="right">快递公司</td>
                    <td>
                        <select name="companyId">
                            <option value = "0">请选择</option>
                            <c:forEach items="${companyList}" var="company">
                                <option value="${company.id}">${company.companyName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="100" align="right">手机号</td>
                    <td>
                        <input type="text" size="40" name="phone"
                               class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">收货地址</td>
                    <td>
                        <input type="text" name="address" size="40"
                               class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">收货日期</td>
                    <td>
                        <input type="text" name="sendTime" size="40"
                               class="inpMain"
                               placeholder="yyyy-MM-dd" />
                    </td>
                </tr>
                <tr>
                    <td align="right">收货状态</td>
                    <td>
                        <input type="radio" name="state" size="40" value="1"
                               checked /> 已签收
                        <input type="radio" name="state" size="40" value="0" />
                        未签收
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <!-- <input type="hidden" name="token"
                            value="5a58b748" /> -->
                        <input type="submit" name="submit"
                               class="btn" value="提交" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </div>
    <div class="clear"></div>
    <div id="dcFooter">
        <div id="footer">
            <div class="line"></div>
            <ul>
                版权所有 © 2024-2025 尚硅谷教育，并保留所有权利。
            </ul>
        </div>
    </div><!-- dcFooter 结束 -->
    <div class="clear"></div> </div>
</body>
</html>