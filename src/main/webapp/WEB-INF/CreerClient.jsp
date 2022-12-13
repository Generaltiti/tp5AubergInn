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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="row">
        <div class="col">
            <h1>Créer un client</h1>
            <form method="POST" action="/tp5/CreerClient">
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
            <form method="POST" action="/tp5/SupprimerClient">
                <div class="form-group">
                    <label for="idClient">Id du client</label>
                    <input class="form-control" type="TEXT" name="idClient" value="<%= request.getAttribute("idClient") != null ? (String)request.getAttribute("idClient") : "" %>">
                </div>

                <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Effacer le client">
            </form>

            <br>
            <br>
            <h1>Réserver une chambre</h1>
            <form method="POST" action="/tp5/Reserver">
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
        </div>
        <div class="col">
            <h1>Recherche Client</h1>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Prénom</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Age</th>
                    <th scope="col">Début</th>
                    <th scope="col">Fin</th>
                    <th scope="col">Nom chambre</th>
                    <th scope="col">Type de lit</th>
                    <th scope="col">Prix réservation</th>
                </tr>
                </thead>
                <tbody id="clientTable">
                    ${table}
                </tbody>
            </table>
            <form action="/tp5/afficherClient" method="POST">
                <input name="idClient" type="TEXT" class="form-control" placeholder="idClient" id="idClient">
                <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="afficher le client">
            </form>



        </div>
    </div>

    <jsp:include page="/WEB-INF/messageErreur.jsp" />
</body>
</html>
