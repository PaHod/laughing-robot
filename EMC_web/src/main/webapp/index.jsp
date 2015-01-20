<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<body>
<h2>Input login</h2>

<%
    String answer = (String) request.getAttribute("answer");
    if (answer == null) {

%>
<form action="/serv">

    <input type="text" name="login" value="log"/>
    <input type="password" name="pass" value="pass"/>
    <input type="submit" value="login"/>

</form>

<%
    } else {
        out.println(answer);
    }
%>

<%! int visits = 0;
%>
<table border="1">
    <tr>
        <td>
            <%
                visits++;
                out.println("visits: " + visits);
            %>
        </td>
    </tr>
</table>
</body>
</html>
