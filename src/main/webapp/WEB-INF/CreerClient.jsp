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
    <jsp:include page="/WEB-INF/messageErreur.jsp" />
</body>
</html>
