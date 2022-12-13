<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ajouter chambre</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="row">
  <div class="col">
    <h1>Ajouter une chambre</h1>
    <form method="POST" action="/tp5/AjouterChambre">
      <div class="form-group">
        <label for="idChambre">Id de la chambre</label>
        <input class="form-control" type="TEXT" name="idChambre" value="<%= request.getAttribute("idChambre") != null ? (String)request.getAttribute("idChambre") : "" %>">
      </div>
      <div class="form-group">
        <label for="nom_de_la_chambre">Nom de la chambre</label>
        <input class="form-control" type="TEXT" name="nom_de_la_chambre" value="<%= request.getAttribute("nom_de_la_chambre") != null ? (String)request.getAttribute("nom_de_la_chambre") : "" %>">
      </div>
      <div class="form-group">
        <label for="type_de_lit">Type de lit</label>
        <input class="form-control" type="TEXT" name="type_de_lit" value="<%= request.getAttribute("type_de_lit") != null ? (String)request.getAttribute("type_de_lit") : "" %>">
      </div>
      <div class="form-group">
        <label for="prix">Prix de base</label>
        <input class="form-control" type="TEXT" name="prix" value="<%= request.getAttribute("prix") != null ? (String)request.getAttribute("prix") : "" %>">
      </div>
      <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Créer la chambre">
    </form>

    <br>
    <br>
    <h1>Supprimer une chambre</h1>
    <form method="POST" action="/tp5/SupprimerChambre">
      <div class="form-group">
        <label for="idChambre">Id de la chambre</label>
        <input class="form-control" type="TEXT" name="idChambre" value="<%= request.getAttribute("idChambre") != null ? (String)request.getAttribute("idChambre") : "" %>">
      </div>

      <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Supprimer la chambre">
    </form>

    <br>
    <br>
    <h1>Inclure une commodite</h1>
    <form method="POST" action="/tp5/InclureCommodite">
      <div class="form-group">
        <label for="idChambre">Id de la chambre</label>
        <input class="form-control" type="TEXT" name="idChambre" value="<%= request.getAttribute("idChambre") != null ? (String)request.getAttribute("idChambre") : "" %>">
      </div>
      <div class="form-group">
        <label for="idCommodite">Id de la commodite</label>
        <input class="form-control" type="TEXT" name="idCommodite" value="<%= request.getAttribute("idCommodite") != null ? (String)request.getAttribute("idCommodite") : "" %>">
      </div>
      <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Inclure une commodite">
    </form>

    <br>
    <br>
    <h1>Enlever une commodite</h1>
    <form method="POST" action="/tp5/EnleverCommodite">
      <div class="form-group">
        <label for="idChambre">Id de la chambre</label>
        <input class="form-control" type="TEXT" name="idChambre" value="<%= request.getAttribute("idChambre") != null ? (String)request.getAttribute("idChambre") : "" %>">
      </div>
      <div class="form-group">
        <label for="idCommodite">Id de la commodite</label>
        <input class="form-control" type="TEXT" name="idCommodite" value="<%= request.getAttribute("idCommodite") != null ? (String)request.getAttribute("idCommodite") : "" %>">
      </div>
      <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Enlever une commodite">
    </form>

    <br>
    <br>
  </div>
  <div class="col">
    <h1>Recherche Chambre</h1>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">idChambre</th>
        <th scope="col">Nom Chambre</th>
        <th scope="col">Type de lit</th>
        <th scope="col">Prix</th>
      </tr>
      </thead>
      <tbody id="chambresTable">
      ${tableChambre}
      </tbody>
    </table>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">idCommodite</th>
        <th scope="col">Surplus</th>
        <th scope="col">Nom Commodite</th>

      </tr>
      </thead>
      <tbody>
      ${tableCommo}
      </tbody>
    </table>
    <form action="/tp5/afficherChambre" method="POST">
      <input name="idChambre" type="TEXT" class="form-control" placeholder="idChambre" id="idChambre">
      <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="afficher la chambre">
    </form>

    <h1>Chambres libres</h1>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">id</th>
        <th scope="col">Nom</th>
        <th scope="col">Type</th>
        <th scope="col">Prix</th>
      </tr>
      </thead>
      <tbody id="chambresLibresTable">
        ${tableChambresLibres}
      </tbody>
    </table>
    <form action="/tp5/afficherChambresLibres" method="POST">
      <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="update">
    </form>
  </div>
</div>
<jsp:include page="/WEB-INF/messageErreur.jsp" />
</body>
</html>
