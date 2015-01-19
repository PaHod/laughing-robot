
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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
