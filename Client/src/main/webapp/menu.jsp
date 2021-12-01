<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bg-dark" style="width: 200px">
    <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
            <li class="nav-item">
                <a href="#" class="nav-link align-middle px-0">
                    <span class="glyphicon glyphicon-home"></span>
                    <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline"> Accueil </span>
                </a>
            </li>
            <li>
                <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                    <span class="glyphicon glyphicon-list"></span>
                    <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Entreprise</span> </a>
                <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                </ul>
            </li>
            <li>
                <a href="#" class="nav-link px-0 align-middle">
                    <span class="glyphicon glyphicon-user"></span>
                    <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Stagiaire</span></a>
            </li>
            <li>
                <a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                    <span class="glyphicon glyphicon-edit"></span>
                    <i class="fs-4 bi-bootstrap"></i> <span class="ms-1 d-none d-sm-inline">Inscription</span></a>
                <ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">
                </ul>
            </li>
            <li>
                <a href="#" class="nav-link px-0 align-middle">
                    <span class="glyphicon glyphicon-question-sign"></span>
                    <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Aide</span> </a>
            </li>
        </ul>
        <hr>
    </div>
</div>
