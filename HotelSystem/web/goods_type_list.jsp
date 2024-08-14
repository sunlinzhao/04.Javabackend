
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/web.css">
</head>
<body>
<%@include file="head.jsp"%>
<div class="container">
    <div class="title">
        酒店管理系统-商品类别管理
    </div>
    <div>
        <a href="goods_type_save.jsp">新增</a>
        <a href="javascript:;" id="deleteCheck">删除选中</a>
    </div>
    <form action="GoodsTypeServlet?flag=deleteCheck" method="post" id="f">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>
                    <input type="checkbox" id="checkAll">
                </td>
                <td>序号</td>
                <td>商品类型</td>
                <td>操作指令</td>
            </tr>
            <c:forEach items="${list}" var="goodsType" varStatus="vs">
            <tr>
                <td>
                    <input type="checkbox" name="ids" value="${goodsType.id}">
                </td>
                <td>${vs.count}
                </td>
                <td>${goodsType.typename}
                </td>
                <td>
                    <a href="javascript:;" onclick="del(${goodsType.id})">删除</a>
                    <a href="GoodsTypeServlet?flag=preUpdate&id=${goodsType.id}">编辑</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </form>
    <div><a href="index.jsp">返回首页</a> </div>
    <script>
        function del(id) {
            if (confirm("确定删除吗?")) {
                location.href = "GoodsTypeServlet?flag=delete&id=" + id;
            }
        }
    </script>
    <script src="assets/js/jquery-3.6.4.min.js"></script>
    <script>
        $(function () {
            $("#checkAll").click(function () {
                let f = $(this).prop("checked");
                $("[type='checkbox']").prop("checked", f);
            })
            $("#deleteCheck").click(function () {
                if (confirm("确定删除选中的数据吗?")) {
                    $("#f").submit();
                }
            })
        })
    </script>
</div>
</body>
