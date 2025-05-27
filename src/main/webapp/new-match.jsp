<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Создание теннисного матча</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .button-group {
            margin-top: 20px;
            text-align: center;
        }
        button {
            padding: 8px 15px;
            margin: 0 5px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .create-btn {
            background-color: #4CAF50;
            color: white;
        }
        .clear-btn {
            background-color: #f44336;
            color: white;
        }
        .home-btn {
            background-color: #2196F3;
            color: white;
        }
        button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Создание нового теннисного матча</h1>

    <form action="new-match" method="post">
        <div class="form-group">
            <label for="player1">Игрок 1:</label>
            <input type="text" id="player1" name="player1" required>
        </div>

        <div class="form-group">
            <label for="player2">Игрок 2:</label>
            <input type="text" id="player2" name="player2" required>
        </div>

        <div class="button-group">
            <button type="submit" class="create-btn">Создать</button>
            <button type="reset" class="clear-btn">Очистить</button>
            <a href="index.jsp"><button type="button" class="home-btn">Вернуться на главную</button></a>
        </div>
    </form>
</div>
</body>
</html>