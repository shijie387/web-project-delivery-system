<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="dcHead" style="background-color: #9a9afb">
    <div id="head">
        <div class="logo">
            <a href="/delivery/index.jsp">
                <img width="100px"
                     height="25px"
                     src="/delivery/images/dclogo.gif"
                     alt="logo">
            </a>
        </div>
        <div class="nav">
            <ul class="navRight">
                <li class="M noLeft">
                    <a href="JavaScript:void(0);">
                        您好，${sessionScope.user.nickname}
                    </a>
                    <div class="drop mUser">
                        <a href="/delivery/password.jsp">
                            修改密码
                        </a>
                    </div>
                </li>
                <li class="noRight">
                    <a href="/delivery/user/logout" onclick="logoutConfirm()">
                        退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<script>
    function logoutConfirm(){
        if(!confirm("确定要退出吗?")){
            event.preventDefault()
        }
    }


</script>
