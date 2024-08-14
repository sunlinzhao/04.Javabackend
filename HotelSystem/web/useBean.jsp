<%@ page import="com.hotel.entity.GoodsType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--调用GoodsType类的无参构造方法，创建对象--%>
    <jsp:useBean id="type" class="com.coder.entity.GoodsType" scope="request"/>
    <%--使用value写死数据--%>
   <%-- <jsp:setProperty name="type" property="typename" value="水果"/>
    <jsp:setProperty name="type" property="id" value="1"/>--%>
    <%--从表单提取数据--%>
    <%--<jsp:setProperty name="type" property="typename" param="typename"/>
    <jsp:setProperty name="type" property="id" param="id"/>--%>
    <%--当表单控件名和实体类属性名完全相同，可以使用通配符，调用了对象的setter方法--%>
    <jsp:setProperty name="type" property="*"/>
    <%--调用了对象的getter方法--%>
    <jsp:getProperty name="type" property="typename"/><br>
    <jsp:getProperty name="type" property="id"/>
<%
/*    GoodsType type = new GoodsType();
    request.setAttribute("type",type);
    type.setTypename("");
    type.setId(1);
    */
%>
<%--<%=type.getTypename()%>
<%=type.getId()%>--%>
</body>
</html>
