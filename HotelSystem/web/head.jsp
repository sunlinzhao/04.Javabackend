
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .x{
            padding: 10px 30px;
            background-color: #2e6da4;
            color:#fff;
            height: 80px;
            line-height: 80px;
            margin-bottom: 15px;
            display: flex;
            justify-content: space-between;
        }
        .y{
            font-family: 华文行楷;
            font-size: 30px;
        }

    </style>
</head>
<body>
    <div class="x">
        <div class="y">酒店管理系统</div>
        <div>欢迎:${admin.name}</div>
    </div>
</body>
</html>
