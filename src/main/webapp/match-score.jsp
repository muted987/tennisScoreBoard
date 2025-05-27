<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Табло теннисного матча</title>
    <style>
        body,
        html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        .scoreboard {
            background-color: white;
            border: 2px solid #333;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 360px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th,
        td {
            border: 2px solid #333;
            padding: 10px;
            font-size: 1.3em;
            background-color: #e8e8e8;
            text-align: center;
        }
        th {
            background-color: #d0f0d0;
            font-weight: bold;
        }
        td.player-name {
            background-color: #c0e0ff;
            font-weight: bold;
            text-align: left;
            padding-left: 15px;
            width: 100px;
        }
        button {
            padding: 10px 15px;
            font-size: 1em;
            cursor: pointer;
            border: 2px solid #333;
            background-color: #4caf50;
            color: white;
            border-radius: 5px;
            transition: background 0.3s;
            margin: 0 5px;
            min-width: 130px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="scoreboard">
    <h2>Табло теннисного матча</h2>
    <table>
        <thead>
        <tr>
            <th>Player</th>
            <th>Sets</th>
            <th>Games</th>
            <th>Points</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="player-name">${player1.name}</td>
            <td id="setsPlayer1">${player1.score.sets}</td>
            <td id="gamesPlayer1">${player1.score.games}</td>
            <td id="pointsPlayer1">${player1.score.points.getPoints()}</td>
        </tr>
        <tr>
            <td class="player-name">${player2.name}</td>
            <td id="setsPlayer2">${player2.score.sets}</td>
            <td id="gamesPlayer2">${player2.score.games}</td>
            <td id="pointsPlayer2">${player2.score.points.getPoints()}</td>
        </tr>
        </tbody>
    </table>
    <form method="POST" action="match-score?uuid=${uuid}">
        <button type="submit" name="scoredPlayerCode" value="0">Player 1 score</button>
        <button type="submit" name="scoredPlayerCode" value="1">Player 2 score</button>
    </form>
</div>
</body>
</html>
