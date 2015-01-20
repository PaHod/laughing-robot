<%@ page import="domain.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: PaHod
  Date: 17.07.2014
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Manager</title>
</head>
<body>
<h3>Client Manager</h3>
<form action="/index.jsp">
    <input type="submit" name="button" value="return to main" />
</form>
<%
    String answer = (String) request.getAttribute("answer");

    if (answer != null) {
        out.println(answer);
    }
%>
-------------------------------------

<form action="/servletCreateClient">
<h3>Create client</h3>
    <%--зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)--%>
    <input type="text" name="firstName" value="input First Name"><br/>
    <input type="text" name="lastName" value="input Last Name"><br/>
    <input type="tel" name="phone" value="input phone number"><br/>
    <input type="text" name="address" value="input address "><br/>
    <input type="submit" name="createClient" value="Create"><br/>
</form>
-------------------------------------

<form action="/showClientList">
    <input type="submit" name="showClients" value="Show clients">
    <%
        List<Client> clients;
        clients = (List<Client>) request.getAttribute("Clients");
        if (clients != null) {
            Iterator<Client> iterator = clients.iterator();
    %>
    <table border="1">
        <tr>
            <td>id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>phone</td>
            <td>address</td>
            <td>amount</td>
            <td>lastDate</td>
        </tr>
        <%
                while (iterator.hasNext()) {
                    Client client = iterator.next();
                    out.println(" <tr>" +
                            "<td>" + client.getId() + "</td>" +
                            "<td>" + client.getFirstName() + "</td>" +
                            "<td>" + client.getLastName() + "</td>" +
                            "<td>" + client.getPhone() + "</td>" +
                            "<td>" + client.getAddress() + "</td>" +
                            "<td>" + client.getAmount() + "</td>" +
                            "<td>" + client.getLastDate() + "</td></tr>");
                }
            } else {
                out.println("No one client");
            }
        %>
    </table>
</form>

</body>
</html>
