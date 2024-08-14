<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>
<div class="title">酒店管理系统</div>

<div class="user">
    <c:if test="${empty admin}">
        <a href="login_ajax.jsp">登录</a>
    </c:if>
    <c:if test="${!empty admin}">
        欢迎:${admin.name} [<a href="AdminServlet?flag=logout">退出</a>]
    </c:if>
</div>
<div class="container">
    <div class="item">
        <img src="assets/img/类型.png">
        <div>
            <a href="RoomTypeServlet?flag=selectList">
                房间类型
            </a>
        </div>
    </div>
    <div class="item">
        <img src="assets/img/商品管理.png">
        <div>
            <a href="GoodsTypeServlet?flag=selectList">
                商品分类
            </a>
        </div>
    </div>
    <div class="item">
        <img src="assets/img/用户管理.png">
        <div>
            <a href="AdminServlet?flag=selectList">
                用户管理
            </a>
        </div>
    </div>
    <div class="item">
        <img src="assets/img/等级.png">
        <div>
            <a href="MemberLevelServlet?flag=selectList">
                会员等级
            </a>
        </div>
    </div>
    <div class="item">
        <img src="assets/img/房间.png">
        <div>
            <a href="RoomInfoServlet?flag=selectList">
                房间管理
            </a>
        </div>
    </div>
</div>
</body>
</html>
