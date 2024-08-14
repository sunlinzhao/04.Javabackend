
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/web.css">
</head>
<body>
<%@include file="head.jsp"%>
<div class="container">
    <div class="title">
        酒店管理系统-房型管理
    </div>
    <form action="RoomTypeServlet?flag=save" method="post">
        <div class="form-group">
            <label for="type">房间类型</label>
            <input type="text" name="type"
                   class="form-control" id="type" placeholder="请填写房间类型">
        </div>
        <div class="form-group">
            <label for="price">房型单价</label>
            <input type="number" class="form-control" id="price"
                   placeholder="请填写房型单价" name="price">
        </div>
        <div class="form-group">
            <label for="deposit">房型押金</label>
            <input type="number" class="form-control" id="deposit"
                   placeholder="请填写房型押金" name="deposit">
        </div>
        <div class="form-group">
            <label for="bedNum">床位数量</label>
            <input type="number" class="form-control" id="bedNum" name="bedNum"
                   placeholder="请填写床位数量" >
        </div>
        <div class="form-group">
            <label for="remark">房型备注</label>
            <textarea id="remark" class="form-control" name="remark"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
        <button type="reset" class="btn btn-warning">重置</button>
    </form>
</div>
</body>
</html>
