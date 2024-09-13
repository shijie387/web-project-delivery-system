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
        <div id="urHere">快递管理系统<b>></b><strong>快递列表</strong> </div>
        <div class="mainBox"
             style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="/delivery/data/addjsp"
                   class="actionBtn add">添加快递</a>快递列表</h3>
            <!--
            本阶段不实现!!
            <div class="filter">
                <form action="#" method="post">
                    物流公司
                    <select name="cat_id">
                        <option value>请选择</option>
                        <option value="1"> 申通快递</option>
                        <option value="2"> 圆通快递</option>
                        <option value="2"> 韵达快递</option>
                    </select>
                    收件人手机号 <input name="keyword" type="text"
                        class="inpMain" value size="20" />
                    签收状态 <select name="cat_id">
                        <option value>请选择</option>
                        <option value="1">已签收</option>
                        <option value="2"> 未签收</option>

                    </select>
                    <input name="submit" class="btnGray" type="submit"
                        value="筛选" />
                </form>

            </div> -->
            <div id="list">

                <table width="100%" border="0" cellpadding="8"
                       cellspacing="0" class="tableBasic">
                    <tr>

                        <th width="40" align="center">编号</th>
                        <th width="80" align="center">物流公司</th>
                        <th width="80" align="center">收件人</th>
                        <th width="80" align="center">手机号</th>
                        <th width="80" align="center">送达日期</th>
                        <th align="center">地址</th>
                        <th width="80" align="center">签收状态</th>
                        <th width="80" align="center">操作</th>
                    </tr>
                    <c:if test="${deliveryList != null && deliveryList.size() > 0}">
                        <c:forEach items="${deliveryList}" var="delivery" varStatus="status">
                            <tr>
                                <td align="center">${delivery.id}</td>
                                <td>${delivery.companyName}</td>
                                <td align="center">${delivery.deliveryName}</td>
                                <td align="center">${delivery.phone}</td>
                                <td align="center">${delivery.sendTime}</td>
                                <td align="center">${delivery.address}</td>
                                <td align="center">${delivery.state == 0 ? "未签收":"已签收"}</td>
                                <td align="center">
                                    <button onclick="editDelivery(${delivery.id})">编辑</button>
                                    |
                                    <button onclick="removeDelivery(${delivery.id})">删除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>

                    <c:if test="${deliveryList == null && deliveryList.size() <= 0}">

                        <tr>
                            <td align="center" colspan="8">没有查到快递信息</td>
                        </tr>

                    </c:if>

                </table>
            </div>
            <div class="clear"></div>
            <div class="pager"> <a href="article.php?page=1">第一页</a>
                <a href="article.php?page=1"> 上一页</a> <a
                        href="article.php?page=1">下一页</a> <a
                        href="article.php?page=1">最末页</a></div> </div>
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
    <div class="clear"></div>
</div>



<script type="text/javascript">

    onload = function()
    {
        document.forms['action'].reset();
    }

    function douAction()
    {
        var frm = document.forms['action'];

        frm.elements['new_cat_id'].style.display = frm.elements['action'].value == 'category_move' ? '' : 'none';
    }

    function removeDelivery(id){
        if(confirm("确定要删除吗?")){
            location.href="/delivery/data/remove?id="+id
        }

    }
    function editDelivery(id){
        location.href="/delivery/data/detail?id="+id
    }



</script>
</body>
</html>