<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="lib/css/login.css" rel="stylesheet" type="text/css"/>
<div class="alert alert-info" role="alert">
    <h3 style="text-align: center;margin:0">Gestion des stages</h3>
    <br>
    Vous n'êtes pas connecté.
    <br>
    Identifiez-vous pour poursuivre la navigation.
</div>

<form class="p-3 mb-2 bg-info text-white"; style="margin:50px;text-align: center" action="connecter.log" method="post">
    <div class="form-group row">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Login</label>
        <div class="col-sm-10">
            <input type="text" name="login" class="form-control" id="inputEmail3" placeholder="Login">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPassword3" class="col-sm-2 col-form-label">Mot de passe</label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
        </div>
    </div>
    <fieldset class="form-group">
        <div class="row">
            <label class="col-form-label col-sm-2 pt-0">Vous êtes :</label>
            <div class="col-sm-10" style="text-align:left">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="statut" id="gridRadios1" value="E" checked>
                    <label class="form-check-label" for="gridRadios1">
                        Etudiant
                    </label>
                </div>
                <div class="form-check" >
                    <input class="form-check-input" type="radio" name="statut" id="gridRadios2" value="P">
                    <label class="form-check-label" for="gridRadios2">
                        Professeur
                    </label>
            </div>
        </div>
    </fieldset>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Connexion</button>
        </div>
    </div>
</form>
