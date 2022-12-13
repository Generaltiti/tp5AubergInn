
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>


<br/>
<div class="row">

    <div class="col-10-md" style="align-items: center; width:60%; margin:0 auto 0 auto">
        <h1><%= "Accueil" %></h1>
        <form METHOD="get" action="/tp5/index" style="align-items: center">
            <div class="row">
                <input class="form-control" type="TEXT"  placeholder="Base de donnée">
            </div>
            <br>
            <div class="row">
                <input class="form-control" type="TEXT"  placeholder="Mot de passe">
            </div>
            <br>
            <div class="row" style="width:50%">
                <input class="btn btn-primary" type="SUBMIT" value="Se connecter">
            </div>
        </form>
    </div>
</div>


</body>
</html>
