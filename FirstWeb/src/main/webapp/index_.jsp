<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<body>
<%--<script src="js/firstScript.js"></script>--%>
<script language="JavaScript">

    document.write('Hello JS<br>');

    var vector = ['qwer0', 'qwe1', 'qwert2', 'qw3', 'qwerty4', 'q5', 'qwertyu6', 'qw7', 'qwertyui8'];
    function printVect(vect) {
        for (var i = 0; i < vect.length; i++) {
            if (vect[i] % 2 === 0) {
                document.write('<b>' + vect[i] + '</b>');
            } else {
                document.write(vect[i]);

            }

        }

    }
    var numVector = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
    printVect(numVector);

    function coup(vect) {
        var tempvect = '';
        for (var e = 0; e < vect.length; e++) {
            tempvect = '';
            for (var t = vect[e].length; t >= 0; t--) {

                tempvect = tempvect + vect[e].substring(t - 1, t);

            }
            vect[e] = tempvect;
        }

    }
    coup(vector);
    for (var i = 0; i < vector.length; i++) {
//        if (vector[i].length >= vector[0].length) {
        document.write('<br>');
        document.write(vector[i]);

    }
    //        }
    console.log('Hello JS console')

    // есть массив строк вывести на экран те  строки которые не короче чем первая строка
    //    назначаем переменной функцию
    var print = function print(str) {
        document.write('<br>');
        console.log(str);
    };
    print = function (any) {
        document.write('<br>');
        document.write(any);
    }
    print();
    print(222);
    print('anything');
    //пользователь вводит логин и пароль в форм. если логин и пароль не заданы вывести ошибку,
    // а если заданы отправлять на сервер
    function check() {
        console.log('invoke check()')
        if (document.getElementById('login').value == '') {
            alert('login empty');
            return false;
        }
        if (document.getElementById('pass').value == '') {
            alert('pass empty');
            return false;
        }

return true;
    }


</script>


<h2 onclick="printVect(numVector)">Hello World!</h2>
<%--<h2 onmouseover="window.alert('Hello Web')">Hello World!</h2>--%>

<form action="hello.jsp" onsubmit="return check()" id="form">
    <input type="text" name="name" value="PaHod" id="login"/>
    <input type="password" name="pass" value="qwerty" id="pass"/>
    <input type="submit" name="btnLogIn" value="LogIn"/>


</form>
</body>
</html>
