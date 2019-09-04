<%--
  Created by IntelliJ IDEA.
  User: 石立山
  Date: 2019/1/15
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="chartServlet">
    <input type="text" value="1" name="num" id="num">
    <input type="submit" value="提交">
</form>
<%
    String graphURL=(String) request.getAttribute("graphURL");

    System.out.println(graphURL );
    graphURL="image/"+graphURL;
    System.out.println(graphURL );
    if(graphURL!=null){
%>

<img src="<%=graphURL%> ">
<img src="image/1.png" >
<%}

%>
</body>
</html>
