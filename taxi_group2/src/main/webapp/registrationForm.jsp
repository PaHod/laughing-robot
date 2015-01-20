<%--
  Created by IntelliJ IDEA.
  User: PaHod
  Date: 17.07.2014
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/servletOperatorRegistration">
    <h3>Registration form</h3>
   login: <input type="text" name="login" value="Login"><br/>
   IPN: <input type="number" name="ipn" value="1234567"><br/>
   Pass: <input type="password" name="pass" value="Password1"><br/>
   Pass confirm:  <input type="password" name="confirmPass" value="Password1"><br/>
    <input type="submit" name="button" value="Register" />
</form>
<%
    String answer = (String) request.getAttribute("answer");

if (answer!=null){
    out.println(answer);
}
%>
</body>
</html>
