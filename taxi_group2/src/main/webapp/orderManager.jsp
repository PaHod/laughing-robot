<%@ page import="domain.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: PaHod
  Date: 17.07.2014
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Order Manager</title>
</head>
<body>
<h3>Order Manager</h3>
<form action="/index.jsp">
    <input type="submit" name="button" value="return to main" />
</form>

<form action="/ServletOrderCreate">

    <input type="text" name="client" value="input Client ID"><br/>
    <input type="text" name="startAddress" value="input StartAddress "><br/>
    <input type="text" name="finishAddress" value="input FinishAddress "><br/>
    <input type="number" name="amount" value="input amount"><br/>
    <input type="date" name="date" value="date"><br/>
    <input type="submit" name="createOrder" value="Create"><br/>
</form>
-------------------------------------
<form action="/servletOrderEdit">

    <input type="number" name="id" value="id">
    <input type="date" name="date" value="date">
    <input type="text" name="client" value="input Client ID">
    <input type="number" name="amount" value="input amount">
    <input type="text" name="startAddress" value="input StartAddress ">
    <input type="text" name="finishAddress" value="input FinishAddress ">
    <input type="submit" name="editOrder" value="edit Order">
</form>
-------------------------------------
<form action="/servletOrderShowList">
    <input type="submit" name="showOrders" value="Show orders">
    <%
        List<Order> clients;
        clients = (List<Order>) request.getAttribute("Clients");
        if (clients != null) {
            Iterator<Order> iterator = clients.iterator();
    %>
    <table border="1">
        <tr>
            <td>id</td>
            <td>Date</td>
            <td>Client FirstName()</td>
            <td>Amount</td>
            <td>StartAddress</td>
            <td>FinishAddress</td>
        </tr>
        <%
//                дата, клиент, сумма, адрес подачи, адрес назначения)
                while (iterator.hasNext()) {
                    Order order = iterator.next();
                    out.println(" <tr>" +
                            "<td>" + order.getId() + "</td>" +
                            "<td>" + order.getDate() + "</td>" +
                            "<td>" + order.getClient().getFirstName() + "</td>" +
                            "<td>" + order.getAmount() + "</td>" +
                            "<td>" + order.getStartAddress() + "</td>" +
                            "<td>" + order.getFinishAddress() + "</td></tr>");
                }
            } else {
                out.println("No one order");
            }
        %>
    </table>
</form>
</body>
</html>
