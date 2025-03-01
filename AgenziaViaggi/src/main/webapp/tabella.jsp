<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabella Prenotazioni</title>
<style>
    body {
        background-color:#5F9EA0;; /* Verde acqua */
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .container {
        background: #B0E0E6;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        width: 90%;
        overflow-x: auto;
    }
    h2 {
        text-align: center;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    th {
        background-color: #5F9EA0; /* Azzurro più scuro */
        color: white;
        padding: 12px;
        text-align: left;
    }
    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #d1e7dd;
    }
    .home-link {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: grey;
        text-decoration: none;
        font-size: 16px;
    }
    .btn {
        background-color: red;
        color: white;
        border: none;
        padding: 8px 12px;
        border-radius: 5px;
        cursor: pointer;
    }
    .btn:hover {
        background-color: darkred;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Tabella Prenotazioni</h2>
    <a href="home.html" class="home-link">Torna nella Home</a>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome Cliente</th>
            <th>Cognome Cliente</th>
            <th>Codice Fiscale</th>
            <th>Compagnia Aerea</th>
            <th>Data Partenza</th>
            <th>Data Arrivo</th>
            <th>Luogo Partenza</th>
            <th>Luogo Arrivo</th>
            <th>Numero Adulti</th>
            <th>Numero Bambini</th>
            <th>Importo Pagato</th>
            <th>Bagagli</th>
            <th>Azione</th>
        </tr>
        <c:forEach var="prenotazione" items="${prenotazioni}">
            <tr>
                <td>${prenotazione.id}</td>
                <td>${prenotazione.nomeCliente}</td>
                <td>${prenotazione.cognomeCliente}</td>
                <td>${prenotazione.cfCliente}</td>
                <td>${prenotazione.compagniaAerea}</td>
                <td>${prenotazione.dataPartenza}</td>
                <td>${prenotazione.dataArrivo}</td>
                <td>${prenotazione.da}</td>
                <td>${prenotazione.a}</td>
                <td>${prenotazione.nAdulti}</td>
                <td>${prenotazione.nBambini}</td>
                <td>${prenotazione.importoPagato}</td>
                <td>${prenotazione.bagagli}</td>
                <td><a href="Avvio?scelta=2&id=${prenotazione.id}"><button class="btn">Annulla</button></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
