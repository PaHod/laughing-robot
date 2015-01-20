<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<body>
<%
    String answer = (String) request.getAttribute("answer");

    if (answer != null) {
        out.println(answer);
    }
%>
<h2>Welcome to taxi management system</h2>

<form action="/clientManager.jsp">
    <input type="submit" name="createClient" value="Client Manager">
</form>

<form action="/orderManager.jsp">
    <input type="submit" name="createClient" value="Order Manager">
</form>

<form action="/registrationForm.jsp">
    <input type="submit" name="button" value="register new operator" />
</form>
</body>
</html>
