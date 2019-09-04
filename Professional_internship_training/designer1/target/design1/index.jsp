<%@ page import="java.sql.*" language="java"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<table border=2>
    <%


        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/d_student","root","");
        Statement statement = conn
                .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = statement.executeQuery("select * from grade");
        rs.last();
        int totalRows = rs.getRow();
        int totalPages = totalRows % 10==0?totalRows / 10:totalRows / 10+1;

        while (rs.next()) {

            out.print("<tr>");
            out.print("<td>" + rs.getString(1) + "</td>");
            out.print("<td>" + rs.getString(2) + "</td>");
            out.print("<td>" + rs.getString(3) + "</td>");
            out.print("<td>" + rs.getString(4) + "</td>");
            out.print("<td>" + rs.getString(5) + "</td>");
            out.print("</tr>");
        }
    %>
</table>


<h2>浓泡泡</h2>
</body>
</html>