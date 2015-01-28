<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<body>
<%--<script src="js/firstScript.js"></script>--%>
<script language="JavaScript">


    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            alert(ajax.responseText);
            document.getElementById('textBox').value = ajax.responseText;

        }

    };
    function ajaxSendRequest() {
       var urlStr = '/ajax?login='+ document.getElementById('login').value + '&pass=' + document.getElementById('pass').value;
        alert(urlStr);
        ajax.open('GET', urlStr/*'/ajax?login=PaHod&pass=qwerty'*/, true);
        ajax.send();
    }

</script>


<%--<h2 onclick="printVect(numVector)">Hello World!</h2>--%>


<%--<form action="hello.jsp" id="form">--%>
    <input type="text" name="name" value="PaHod" id="login"/>
    <input type="password" name="pass" value="qwerty" id="pass"/>
    <input type="button" name="btnLogIn" id="btnLogIn" value="LogIn" onclick="ajaxSendRequest()"/>
    <input type="text" id="textBox"/>
<%--</form>--%>


</body>
</html>
