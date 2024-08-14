<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%--<%@include file="head.jsp"%>--%>

<jsp:include page="head.jsp"/>
<div class="container">
    <div class="title">
        酒店管理系统-用户管理
    </div>
    <div>
        <a href="admin_save.jsp">新增</a>
        <a href="javascript:;" id="deleteCheck">删除选中</a>
    </div>
    <form action="AdminServlet?flag=deleteCheck" method="post" id="f">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>
                    <input type="checkbox" id="checkAll">
                </td>
                <td>序号</td>
                <td>用户姓名</td>
                <td>最后访问时间</td>
                <td>操作指令</td>
            </tr>
            <c:forEach items="${list}" var="admin" varStatus="vs">
            <tr>
                <td>
                    <input type="checkbox" name="ids" value="${admin.id}">
                </td>
                <td>${vs.count}
                </td>
                <td>${admin.name}
                </td>
                <td><fmt:formatDate
                        value="${dateUtil.format(admin.lasttime)}"
                        type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                    <a href="javascript:;" onclick="del(${admin.id})">删除</a>
                    <a href="AdminServlet?flag=preUpdate&id=${admin.id}">编辑</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </form>
    <div><a href="index.jsp">返回首页</a> </div>
    <script>
        function del(id) {
            if (confirm("确定删除吗?")) {
                location.href = "AdminServlet?flag=delete&id=" + id;
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

