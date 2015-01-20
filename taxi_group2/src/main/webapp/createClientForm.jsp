<%--
  Created by IntelliJ IDEA.
  User: PaHod
  Date: 17.07.2014
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>Create new Client</h3>
<form action="/index.jsp">
    <input type="submit" name="button" value="return to main" />
</form>
<form action="/servletCreateClient">

    <%--зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)--%>
    <input type="text" name="firstName" value="input First Name"><br/>
    <input type="text" name="lastName" value="input Last Name"><br/>
    <input type="tel" name="phone" value="input phone number"><br/>
    <input type="text" name="address" value="input address "><br/>
    <input type="submit" name="createClient" value="Create"><br/>
</form>
<%
    String answer = (String) request.getAttribute("answer");

    if (answer != null) {
        out.println(answer);
    }
%>

</body>
</html>
