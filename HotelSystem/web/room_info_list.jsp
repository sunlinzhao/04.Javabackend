<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
        酒店管理系统-房间管理
    </div>
    <div>
        <a href="RoomInfoServlet?flag=preSave">新增</a>
        <a href="javascript:;" id="deleteCheck">删除选中</a>
    </div>
    <form action="RoomInfoServlet?flag=deleteCheck" method="post" id="f">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>
                    <input type="checkbox" id="checkAll">
                </td>
                <td>序号</td>
                <td>所在楼层</td>
                <td>房间类型</td>
                <td>房间号码</td>
                <td>房间单价</td>
                <td>房间押金</td>
                <td>房间电话</td>
                <td>房间状态</td>
                <td>房间图片</td>
                <td>下载图片</td>
                <td>备注</td>
                <td>操作指令</td>
            </tr>
            <c:forEach items="${list}" var="roomInfo" varStatus="vs">
                <tr>
                    <td>
                        <input type="checkbox" name="ids" value="${roomInfo.id}">
                    </td>
                    <td>${vs.count}
                    </td>
                    <td>${roomInfo.level}
                    </td>
                    <td>${roomInfo.type}
                    </td>
                    <td>${roomInfo.roomnum}
                    </td>
                    <td>${roomInfo.price}
                    </td>
                    <td>${roomInfo.deposit}
                    </td>
                    <td>${roomInfo.tel}
                    </td>
                    <td>${roomInfo.status}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}${roomInfo.pic}" title="点击看大图" target="_blank">
                        <img src="${pageContext.request.contextPath}${roomInfo.pic}" width="100">
                        </a>
                    </td>
                    <td>
                        <a href="RoomInfoServlet?flag=download&path=${roomInfo.pic}">下载图片</a>
                    </td>
                    <td>${roomInfo.remark}
                    </td>
                    <td>
                        <a href="javascript:;" onclick="del(${roomInfo.id})">删除</a>
                        <a href="RoomTypeServlet?flag=preUpdate&id=${roomInfo.id}">编辑</a>
                    </td>
                </tr>
            </c:forEach>
            <%--<%}%>--%>
        </table>
    </form>
    <div><a href="index.jsp">返回首页</a> </div>
    <script>
        function del(id) {
            if (confirm("确定删除吗?")) {
                location.href = "RoomInfoServlet?flag=delete&id=" + id;
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
            $("#deleteCheck").click(function(){
                if (confirm("确定删除选中的数据吗?")){
                    $("#f").submit();
                }
            })
        })
    </script>
</div>
</body>
</html>