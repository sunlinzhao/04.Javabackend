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
<%
   /* Cookie[] cookies=request.getCookies();
    String name="";
    String pwd="";
    if (cookies!=null)
        for(Cookie cookie:cookies){
            //System.out.println(cookie.getName()+"\t"+cookie.getValue());
            if (cookie.getName().equals("nameCookie")){
                name=cookie.getValue();
            }
            if (cookie.getName().equals("pwdCookie")){
                pwd=cookie.getValue();
            }
        }*/
%>
<div class="x">
    <div class="title">用户登录</div>
    <div class="content">
        <div class="left">
            <img src="assets/img/login.png">
        </div>
        <div class="right">
            <div class="item">
                帐号:
                <input type="text" id="name" name="name" value="${cookie.nameCookie.value}" class="input" placeholder="请输入登录帐号">
            </div>
            <div class="item">
                密码:
                <input type="password" id="pwd" name="pwd" value="${cookie.pwdCookie.value}" class="input" placeholder="请输入登录密码">
            </div>
            <div class="item">
                <input type="checkbox" id="rem">记住我十天
            </div>
            <div class="item">
                <input type="button" value="登录" class="btn" id="submitBtn">
            </div>
            <div class="item" id="result">
            </div>
        </div>
    </div>
</div>

<script src="assets/js/jquery-3.6.4.min.js"></script>
<script>
    $(function(){
        $("#submitBtn").click(function(){
            $.ajax({
                url:"AdminServlet?flag=loginAjax",
                type:"post",
                data:{
                    name:$("#name").val(),
                    pwd:$("#pwd").val(),
                    rem:$("#rem").prop("checked")
                },
                dataType:"json",
                success:function (data){
                    let v=data.msg;
                    if (v==="success"){
                        location.href="index.jsp";
                    }else{
                        $("#result").html("帐号或密码错误").css("color","red");
                    }
                },
                error:function (){alert("error")}
            })
        })
    })
</script>
</body>

</html>