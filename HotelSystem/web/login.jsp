<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>酒店管理系统</title>
  <link rel="stylesheet" href="assets/css/login.css">
</head>

<body>
<div class="x">
  <div class="title">用户登录</div>
  <div class="content">
    <div class="left">
      <img src="assets/img/login.png">
    </div>
    <div class="right">
      <form action="AdminServlet?flag=login" method="post">
        <div class="item">
          帐号:
          <input type="text" name="name" class="input" placeholder="请输入登录帐号">
        </div>
        <div class="item">
          密码:
          <input type="password" name="pwd" class="input" placeholder="请输入登录密码">
        </div>
        <%--<div class="item">
          角色:
          <select>
            <option>超级管理员</option>
            <option>普通管理员</option>
            <option>操作员</option>
          </select>
        </div>--%>
        <div class="item">
          <input type="submit" value="登录" class="btn">
        </div>
        <div class="item" style="color:red">
          <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
        </div>
      </form>
    </div>
  </div>
</div>
</body>

</html>