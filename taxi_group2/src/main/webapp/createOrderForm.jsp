<%--
  Created by IntelliJ IDEA.
  User: PaHod
  Date: 17.07.2014
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>


<html>
<head>
    <title></title>
</head>
<body>
<h3>Create new Order</h3>
<form action="/index.jsp">
    <input type="submit" name="button" value="return to main" />
</form>

<form action="/ServletOrderCreate">

    <input type="text" name="client" value="input Client ID"><br/>
    <input type="text" name="startAddress" value="input StartAddress "><br/>
    <input type="text" name="finishAddress" value="input FinishAddress "><br/>
    <input type="number" name="amount" value="input amount"><br/>
    <input type="date" name="date" value="date"><br/>

    <input type="submit" name="createOrder" value="Create">
</form>
<%
    String answer = (String) request.getAttribute("answer");

    if (answer != null) {
        out.println(answer);
    }
%>
</body>
</html>
