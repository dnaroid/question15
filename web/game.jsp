<%--
    Document   : title
    Created on : Feb 17, 2016, 2:19:07 PM
    Author     : Vasil Talkachou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game 21</title>
    </head>
    <body>
        <form method=post>
            Очки игрока:  ${playerScore}
            <br>
            Очки сервера: ${serverScore}
            <br>
            <input type="submit" name="take" value="Взять карту">
            <input type="submit" name="pass" value="Пасс">
            <input type="submit" name="restart" value="Начать заново">
        </form>
    </body>
</html>
