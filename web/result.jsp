<%--
    Document   : result
    Created on : Feb 17, 2016, 6:12:44 PM
    Author     : Vasil Talkachou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        Очки игрока:  ${playerScore}
        <br>
        Очки сервера: ${serverScore}
        <br>
        <h1>${res}</h1>
        <br>
        <form method=post>
            <input type="submit" name="restart" value="Начать заново">
        </form>
    </body>
</html>
