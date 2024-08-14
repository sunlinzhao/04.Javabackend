<%@ page import="com.hotel.entity.RoomType" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
       /* RoomType type=new RoomType();
        type.setType("单人间");
        type.setBedNum(3);
        request.setAttribute("t",type);

        RoomType type1=new RoomType();
        type1.setType("双人间");
        type1.setBedNum(2);
        session.setAttribute("t",type1);*/
    %>
    <br>
   <%-- <% String[] strs={"a","b","c"};
    request.setAttribute("strs",strs);%>
    ${strs[0]}<br>
    ${strs[3]}<br>
    &lt;%&ndash;${strs[0]+strs[1]}  会当成数字去运算&ndash;%&gt;
    ${strs[0]}${strs[1]}--%>
    <%--<% String str="";
    request.setAttribute("str",str);%>
    ${str}
    ${empty str}--%>
    <!--判断是否为空 null 或空串-->
    <%--判断是否为null或空串--%>
    <%--运算符--%>
    <%--${"1"=="1"}  ${"1" eq "2"}
    <br>
    ${1!=2}  ${1 ne 2}
    <br>
    ${1<2}  ${1 lt 2}
    <br>
    ${1<=2}  ${1 le 2}
    <br>
    ${1>2}  ${1 gt 2}
    <br>
    ${1>=2}  ${1 ge 2}
    <br>
    ${5>3 && 3>2}  ${5>3 and 3>2}
    <br>
    ${5>3 || 3>2}  ${5>3 or 3>2}
    <br>
    ${!5>3}   ${not 5>3}--%>
    <%--<%
        List<String> list=new ArrayList<>();
        list.add("AAA");
        request.setAttribute("list",list);
    %>
    ${empty list}--%>
   <%-- <%=request.getParameter("name")%>
    <br>
    ${param.name}--%>
    ${param.email}
</body>
</html>
