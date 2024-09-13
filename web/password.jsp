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
  <jsp:include page="menu.jsp"/>
  <div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">快递管理系统<b>></b><strong>修改密码</strong> </div>
    <div id="manager" class="mainBox"
         style="height:auto!important;height:550px;min-height:550px;">
      <h3><a href="/delivery/index.jsp" class="actionBtn">返回首页</a>修改密码</h3>
      <form action="/delivery/user/change" method="post" onsubmit="return checkForm()">
        <table width="100%" border="0" cellpadding="8" cellspacing="0"
               class="tableBasic">
          <tr>
            <td width="100" align="right">原始密码</td>
            <td>
              <input id="oldPwdInput" type="password" name="oldPassword"
                     size="40"
                     class="inpMain" onchange="checkOldPwd()" />
              &nbsp; &nbsp; <span id="oldPwdMsg"></span>
            </td>
          </tr>
          <tr>
            <td width="100" align="right">新密码</td>
            <td>
              <input id="newPwdInput" type="password" size="40"
                     class="inpMain" onchange="checkNewPwd()" />
              &nbsp; &nbsp; <span id="newPwdMsg"></span>
            </td>
          </tr>
          <tr>
            <td align="right">确认密码</td>
            <td>
              <input id="rePwdInput" type="password" name="newPassword"
                     size="40"
                     class="inpMain"  onchange="checkReUserPwd()"/>
              &nbsp; &nbsp; <span id="rePwdMsg"></span>
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type="submit" name="submit" class="btn" value="提交" />
            </td>
          </tr>
        </table>
        <font color="red">${errorMsg}</font>
        <font color="green">${successMsg}</font>
      </form>
    </div>
  </div>

  <script>
    // 定义正则表示密码字符串的规则
    var  userPwdReg= /^[a-zA-Z0-9]{6,12}$/

    //定义记录账号和密码对应校验状态
    var  oldPwdState = false;
    var  newPwdState = false;
    var  rePwdState  = false;


    function checkOldPwd(){
      var oldPwdInput = document.getElementById("oldPwdInput")
      var oldPwd = oldPwdInput.value
      var oldPwdMsg = document.getElementById("oldPwdMsg")
      if(!userPwdReg.test(oldPwd)){
        oldPwdMsg.innerHTML="<font color='red'>原密码格式错误!</font>"
        oldPwdState = false;
        return;
      }
      oldPwdMsg.innerHTML="<font color='green'>原密码格式正确!</font>"
      oldPwdState = true;
    }
    function checkNewPwd(){
      var newPwdInput = document.getElementById("newPwdInput")
      var newPwd = newPwdInput.value
      var newPwdMsg = document.getElementById("newPwdMsg")
      if(!userPwdReg.test(newPwd)){
        newPwdMsg.innerHTML="<font color='red'>新密码格式错误!</font>"
        newPwdState = false;
        return
      }
      newPwdMsg.innerHTML="<font color='green'>新密码格式正确!</font>"
      newPwdState = true
    }
    function checkReUserPwd(){

      //第一次新密码合理才可以校验确认密码
      if(!newPwdState){
        alert("先输入新密码,再输入确认密码!")
        return;
      }

      // 再次输入的密码的格式
      var rePwdInput = document.getElementById("rePwdInput")
      var rePwd = rePwdInput.value
      var rePwdMsg = document.getElementById("rePwdMsg")
      if(!userPwdReg.test(rePwd)){
        rePwdMsg.innerHTML="<font color='red'>确认密码格式错误!</font>"
        rePwdState = false;
        return
      }
      // 获得上次密码,对比两次密码是否一致
      var newPwdInput = document.getElementById("newPwdInput")
      var newPwd = newPwdInput.value
      if(rePwd != newPwd){
        rePwdMsg.innerHTML="<font color='red'>两次密码格式不一致!</font>"
        rePwdState = false;
        return
      }
      rePwdMsg.innerHTML="<font color='green'>两次密码格式一致!</font>"
      rePwdState = true;
    }
    function checkForm(){
      return oldPwdState && newPwdState && rePwdState
    }
  </script>

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