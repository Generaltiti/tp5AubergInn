<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 2022-12-07
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Membre</title>
</head>
<body>

<h1>Créer un client</h1>
    <form method="POST" action="/tp5_war_exploded/CreerClient">
        <div class="form-group">
            <label for="idClient">Id du client</label>
            <input class="form-control" type="TEXT" name="idClient" value="<%= request.getAttribute("idClient") != null ? (String)request.getAttribute("idClient") : "" %>">
        </div>
        <div class="form-group">
            <label for="prenom">Prenom du client</label>
            <input class="form-control" type="TEXT" name="prenom" value="<%= request.getAttribute("prenom") != null ? (String)request.getAttribute("prenom") : "" %>">
        </div>
        <div class="form-group">
            <label for="nom">Nom du client</label>
            <input class="form-control" type="TEXT" name="nom" value="<%= request.getAttribute("nom") != null ? (String)request.getAttribute("nom") : "" %>">
        </div>
        <div class="form-group">
            <label for="age">Age du client</label>
            <input class="form-control" type="TEXT" name="age" value="<%= request.getAttribute("age") != null ? (String)request.getAttribute("age") : "" %>">
        </div>
        <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Créer le client">
    </form>

<br>
<br>
<h1>Supprimer un client</h1>
    <form method="POST" action="/tp5_war_exploded/SupprimerClient">
        <div class="form-group">
            <label for="idClient">Id du client</label>
            <input class="form-control" type="TEXT" name="idClient" value="<%= request.getAttribute("idClient") != null ? (String)request.getAttribute("idClient") : "" %>">
        </div>

        <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Effacer le client">
    </form>

    <br>
    <br>
<h1>Réserver une chambre</h1>
<form method="POST" action="/tp5_war_exploded/Reserver">
    <div class="form-group">
        <label for="idClient">Id du client</label>
        <input class="form-control" type="TEXT" name="idClient" value="<%= request.getAttribute("idClient") != null ? (String)request.getAttribute("idClient") : "" %>">
    </div>
    <div class="form-group">
        <label for="idChambre">Id de la chambre</label>
        <input class="form-control" type="TEXT" name="idChambre" value="<%= request.getAttribute("idChambre") != null ? (String)request.getAttribute("idChambre") : "" %>">
    </div>
    <div class="form-group">
        <label for="debut">Date de début</label>
        <input class="form-control" type="DATE" name="debut" value="<%= request.getAttribute("debut") != null ? (String)request.getAttribute("debut") : "" %>">
    </div>
    <div class="form-group">
        <label for="fin">Date de fin</label>
        <input class="form-control" type="DATE" name="fin" value="<%= request.getAttribute("fin") != null ? (String)request.getAttribute("fin") : "" %>">
    </div>
    <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Réserver une chambre">
</form>
<br>
<br>
    <jsp:include page="/WEB-INF/messageErreur.jsp" />
</body>
</html>
