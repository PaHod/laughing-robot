<%--
  Created by IntelliJ IDEA.
  User: PaHod
  Date: 17.07.2014
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/servletOperatorAuth">
    <h3>Login form</h3>
    login: <input type="text" name="login" value="Login"><br/>
    Pass: <input type="password" name="pass" value="Password1"><br/>
    <input type="submit" name="button" value="Login" />
</form>
<%
    String answer = (String) request.getAttribute("answer");

    if (answer!=null){
        out.println(answer);
    }
%>
</body>
</html>
