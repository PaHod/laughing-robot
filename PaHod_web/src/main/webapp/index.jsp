
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>

<html>
<body>
<h2>Input login</h2>


<form action="/serv">

<input type="text" name="login" value=""/>
<input type="password" name="pass" value="pass"/>
<input type="submit" value="login"/>

</form>

<p>${return}

</p>

<%! int visits = 0;
%>
<table border="1">
    <tr>
        <td>
            <%


                visits++;
                out.println(visits);
            %>
        </td>
    </tr>
</table>
</body>
</html>
