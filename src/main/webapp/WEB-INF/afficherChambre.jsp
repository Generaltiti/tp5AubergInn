<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ajouter chambre</title>
</head>
<body>
<form method="POST" action="/tp5_war_exploded/AjouterChambre">
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
<jsp:include page="/WEB-INF/messageErreur.jsp" />
</body>
</html>
