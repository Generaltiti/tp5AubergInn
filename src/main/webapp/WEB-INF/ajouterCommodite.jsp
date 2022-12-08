<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ajouter commodite</title>
</head>
<body>
<form method="POST" action="/tp5_war_exploded/AjouterCommodite">
  <div class="form-group">
    <label for="idCommodite">Id de la commodite</label>
    <input class="form-control" type="TEXT" name="idCommodite" value="<%= request.getAttribute("idCommodite") != null ? (String)request.getAttribute("idCommodite") : "" %>">
  </div>
  <div class="form-group">
    <label for="description">Description</label>
    <input class="form-control" type="TEXT" name="description" value="<%= request.getAttribute("description") != null ? (String)request.getAttribute("description") : "" %>">
  </div>
  <div class="form-group">
    <label for="surplus">Surplus</label>
    <input class="form-control" type="TEXT" name="surplus" value="<%= request.getAttribute("surplus") != null ? (String)request.getAttribute("surplus") : "" %>">
  </div>

  <input class="btn btn-primary" type="SUBMIT" name="inscrire" value="Créer la commodite">
</form>

<br>
<br>
<jsp:include page="/WEB-INF/messageErreur.jsp" />
</body>
</html>