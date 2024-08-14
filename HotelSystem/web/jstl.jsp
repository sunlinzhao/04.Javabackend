<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.hotel.entity.RoomType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hotel.entity.GoodsType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--循环 从1-10的循环--%>
<%--<%
    for (int i=1;i<=10;i+=2){
        out.print(i+"<br>");
    }
%>--%>
<%-- <c:forEach var="i" begin="20" end="30" step="2">
     &lt;%&ndash;<c:out value="${i}"/><br>&ndash;%&gt;
     ${i}<br>
 </c:forEach>--%>
<%--循环字符串集合--%>
<%--<%
    List<String> list= Arrays.asList("A","B","C");
    request.setAttribute("list",list);
%>
<c:forEach items="${requestScope.list}" var="s" varStatus="vs">
    ${vs.count}&nbsp;${s}<br>
</c:forEach>--%>
<%--引用类型循环集合--%>
<%--<%
    List<GoodsType> list=new ArrayList<>();
    GoodsType type1=new GoodsType(1,"水果");
    GoodsType type2=new GoodsType(2,"饮料");
    GoodsType type3=new GoodsType(3,"洗漱");
    list.add(type1);
    list.add(type2);
    list.add(type3);
    request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="type" varStatus="vs">
    ${vs.count}&nbsp;${type.id}&nbsp;${type.typename}<br>
</c:forEach>--%>

<%--<%
    List<String> list1=(List<String>)request.getAttribute("list");
    int index=1;
    for (String s : list1) {
        System.out.println(index++);
        System.out.println(s);
    }
%>--%>
<%-- <% int x=11;
     request.setAttribute("x",x);
 %>
 <c:if test="${x%2==0}">偶数</c:if>
 <c:if test="${x%2==1}">奇数</c:if>--%>
<%--<% int age = 10;
   request.setAttribute("age",age);
%>
<c:choose>
    <c:when test="${age<18}">少年</c:when>
    <c:when test="${age<30}">青年</c:when>
    <c:when test="${age<45}">中年</c:when>
    <c:otherwise>老年</c:otherwise>
</c:choose>--%>
<%--<c:redirect url="el.jsp">
    <c:param name="email" value="222345345@qq.com"/>
</c:redirect>--%>
<%--<a href="<c:url value="GoodsTypeServlet?flag=selectList"/>">用户管理</a>--%>
<%--<%
    int x=100;
    request.setAttribute("x",x);
%>
<c:set var="x" value="100" scope="request"/>
<c:out value="${x}"/>--%>
<%
    GoodsType type=new GoodsType();
    type.setId(1);
    type.setTypename("水果");
    request.setAttribute("type",type);
%>
没重新设置之前<Br>
${type.typename}<br>
设置之后
<c:set target="${type}" property="typename" value="数码"/>
${type.typename}
</body>
</html>
