<!DOCTYPE html>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html data-bs-theme="light" lang="pt-br">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Dashboard - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
</head>

<body id="page-top">
    <div id="wrapper">
        <c:if test="${sessionScope.loggedUser != null}">
            <span>${sessionScope.loggedUser}</span>
            <a href="/logout=">logout</a>
        </c:if>
        <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark" style="background: linear-gradient(rgb(2,72,115), #022840), rgb(2,72,115);">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                    <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-book"></i></div>
                    <div class="sidebar-brand-text mx-3"><span>Biblioteca</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"><a class="nav-link active" href="index"><i class="fa fa-book"></i><span>Livros</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="scanner.html"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-upc-scan" style="margin-right: 4px;font-size: 19px;">
                                <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5M.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5m15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5M3 4.5a.5.5 0 0 1 1 0v7a.5.5 0 0 1-1 0zm2 0a.5.5 0 0 1 1 0v7a.5.5 0 0 1-1 0zm2 0a.5.5 0 0 1 1 0v7a.5.5 0 0 1-1 0zm2 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 1 0v7a.5.5 0 0 1-1 0z"></path>
                            </svg><span>Alugar</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="profile.html"><i class="fas fa-user"></i><span>Perfil</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="login.jsp"><i class="far fa-user-circle"></i><span>Login</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="register.html"><i class="fas fa-user-circle"></i><span>Registro</span></a></li>
                </ul>

            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <nav class="navbar navbar-expand bg-white shadow mb-4 topbar">
                    <div class="container-fluid">
                        <form class="d-none d-sm-inline-block me-auto ms-md-3 my-2 my-md-0 mw-100 navbar-search" method="get" action="index">
                            <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Pesquisar" name="pesquisa"><button class="btn btn-primary py-0" type="submit" style="background: rgb(2,72,115);"><i class="fas fa-search"></i></button></div>
                        </form>
                        <div class="dropdown"><a class="dropdown-toggle" aria-expanded="false" data-bs-toggle="dropdown" href="#" style="color: #3a3b45;margin-left: 10px;">Categorias</a>
                            <div class="dropdown-menu dropdown-menu-lg-end">
                                <a class="dropdown-item" href="index">Todos os Livros</a>
                                <c:forEach var="categoria" items="${categorias}">
                                    <a class="dropdown-item" href="index?categoria=${categoria}">${categoria}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </nav>
                <div class="container-fluid">
                    <h3 class="text-dark mb-0" style="padding-bottom: 12px;">
                        Livros<c:if test="${not empty param.categoria}"> - ${param.categoria}</c:if>
                    </h3>

                    <div class="d-sm-flex justify-content-between align-items-center mb-4">
                        <div class="row">
                            <c:forEach var="livro" items="${livros}">
                                <div class="col-12 col-sm-6 col-md-4 col-lg-3" style="padding-bottom: 12px;width: 300px;;">
                                        <a href="#" class="text-decoration-none"
                                           data-bs-toggle="modal"
                                           data-bs-target="#modal-1"
                                           data-titulo="${livro.titulo}"
                                           data-imagem="${livro.image}"
                                           data-autor="${livro.autor}"
                                           data-editora="${livro.editora}"
                                           data-ano="${livro.anoPublicacao}"
                                           data-categoria="${livro.categoria}"
                                           data-sinopse="${livro.sinopse}"
                                           data-unidades="${livro.quantidade}"
                                           data-location="${livro.location}">
                                    <div class="card" style="text-align: center;">
                                        <div class="card-body">
                                            <h4 class="card-title">${livro.titulo}</h4>
                                            <img src="${livro.image}" alt="imagem de um livro" style="width: 200px; height: 300px;">
                                        </div>
                                    </div>
                                    </a>
                                 </div>
                            </c:forEach>
                        </div>
                    </div>
                        <div id="modal-1" class="modal fade" role="dialog" tabindex="-1">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="modal-titulo">Titulo</h4>
                                        <button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col" style="text-align: center;">
                                                <img id="modal-imagem" style="height: 300px;width: 200px;margin-right: 10px;margin-bottom: 10px;" />
                                            </div>
                                            <div class="col-md-6">
                                                <p>Autor: <span id="modal-autor"></span></p>
                                                <p>Editora: <span id="modal-editora"></span></p>
                                                <p>Ano de publicação: <span id="modal-ano"></span></p>
                                                <p>Categoria: <span id="modal-categoria"></span></p>
                                                <p>Unidades disponíveis: <span id="modal-unidades"></span></p>
                                                <p>Localização: <span id="modal-location"></span></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <h5>Sinopse</h5>
                                                <p><span id="modal-sinopse"></span></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button class="btn btn-light" type="button" data-bs-dismiss="modal" style="background: rgb(2,72,115);color: var(--bs-btn-bg);">Fechar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
            <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span>Biblioteca</span></div>
                </div>
            </footer>
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    <script>
        var modal = document.getElementById('modal-1');
        modal.addEventListener('show.bs.modal', function (event) {
            var link = event.relatedTarget; // O link que abriu o modal
            var titulo = link.getAttribute('data-titulo');
            var imagem = link.getAttribute('data-imagem');
            var autor = link.getAttribute('data-autor');
            var editora = link.getAttribute('data-editora');
            var ano = link.getAttribute('data-ano');
            var categoria = link.getAttribute('data-categoria');
            var unidades = link.getAttribute('data-unidades');
            var sinopse = link.getAttribute('data-sinopse');
            var location = link.getAttribute('data-location');

            // Atualiza o conteúdo do modal
            modal.querySelector('#modal-titulo').textContent = titulo;
            modal.querySelector('#modal-imagem').src = imagem;
            modal.querySelector('#modal-autor').textContent = autor;
            modal.querySelector('#modal-editora').textContent = editora;
            modal.querySelector('#modal-ano').textContent = ano;
            modal.querySelector('#modal-categoria').textContent = categoria;
            modal.querySelector('#modal-unidades').textContent = unidades;
            modal.querySelector('#modal-sinopse').textContent = sinopse;
            modal.querySelector('#modal-location').textContent = location;
        });
    </script>

    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>