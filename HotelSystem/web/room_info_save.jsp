<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        酒店管理系统-房间管理
    </div>
    <form action="RoomInfoServlet?flag=save" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="tid">房间类型</label>
            <select class="form-control" id="tid" name="tid">
                <option value="">--请选择房间类型--</option>
                <c:forEach items="${list}" var="roomType">
                    <option value="${roomType.id}">${roomType.type}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="level">所在楼层</label>
            <input type="number" class="form-control" id="level"
                   placeholder="请填写房间楼层" name="level">
        </div>
        <div class="form-group">
            <label for="roomnum">房间号码</label>
            <input type="number" class="form-control" id="roomnum"
                   placeholder="请填写房间楼层" name="roomnum">
        </div>
        <div class="form-group">
            <label for="price">房间单价</label>
            <input type="number" class="form-control" id="price"
                   placeholder="请填写房间单价" name="price">
        </div>
        <div class="form-group">
            <label for="deposit">房间押金</label>
            <input type="number" class="form-control" id="deposit"
                   placeholder="请填写房间押金" name="deposit">
        </div>
        <div class="form-group">
            <label for="tel">电话号码</label>
            <input type="tel" class="form-control" id="tel" name="tel"
                   placeholder="请填写电话号码" >
        </div>
        <div class="form-group">
            <label for="tel">房间状态</label>
            <div class="form-control">
                <c:forEach items="${map}" var="m">
                    <input type="radio" name="status" value="${m.key}">${m.value}
                </c:forEach>
            <%--<input type="radio" name="status" value="1" checked>空
            <input type="radio" name="status" value="2">有客
            <input type="radio" name="status" value="3">空脏--%>
            </div>
           <%-- <input type="tel" class="form-control" id="tel" name="tel"
                   placeholder="请填写电话号码" >--%>
        </div>
        <div class="form-group">
            <label for="remark">房间备注</label>
            <textarea id="remark" class="form-control" name="remark"></textarea>
        </div>
        <div class="form-group">
            <label for="pic">房间图片</label>
            <input type="file" name="pic" id="pic" placeholder="请上传图片">
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
        <button type="reset" class="btn btn-warning">重置</button>
    </form>
</div>
<script src="assets/js/jquery-3.6.4.min.js"></script>
<script>
    $(function (){
        $("#roomnum").blur(function(){
            $("#tel").val($(this).val())
        })
        $("#tid").change(function(){
            let v=$(this).val();
            if (v!=""){
                $.ajax({
                    url:"RoomTypeServlet?flag=selectByTid",
                    type:"get",
                    data:{
                        tid:v
                    },
                    dataType:"json",
                    success:function(result){
                       $("#price").val(result.price);
                       $("#deposit").val(result.deposit);
                    },
                    error:function(){}
                })
            }else{
                $("#price").val("");
                $("#deposit").val("");
            }

        })
    })
</script>
</body>
</html>
