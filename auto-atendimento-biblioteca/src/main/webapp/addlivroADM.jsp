<!DOCTYPE html>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-bs-theme="light" lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>biblioteca</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
</head>

<body>
    <div id="wrapper">
        <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark" style="background: linear-gradient(rgb(2,72,115), #022840), rgb(2,72,115);">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                    <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-book"></i></div>
                    <div class="sidebar-brand-text mx-3"><span>Biblioteca</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"><a class="nav-link" href="indexADM.jsp"><i class="fa fa-book"></i><span>Livros</span></a></li>
                    <li class="nav-item"><a class="nav-link active" href="addlivroADM.html"><i class="far fa-edit" style="margin-right: 4px;font-size: 12px;"></i><span>Adicionar livro</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="gerenciarusersADM.html"><i class="fas fa-user"></i><span>Gerenciar usuários</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="gerenciaremprestimosADM.html"><i class="far fa-calendar-alt"></i><span>Gerenciar empréstimos</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="confADM.html"><i class="fas fa-user-circle"></i><span>Configurações de ADM</span></a></li>
                </ul>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <nav class="navbar navbar-expand bg-white shadow mb-4 topbar">
                    <div class="container-fluid"><button class="btn btn-primary" type="button" style="width: 100.7656px;background: rgb(2,72,115);border-color: rgb(2,72,115);">Sair</button></div>
                </nav>
                <div class="container-fluid">
                    <h3 class="text-dark mb-1">Adicionar livro</h3>
                    <div>
                        <div class="card shadow mb-3">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 fw-bold">Dados do livro</p>
                            </div>
                            <div class="card-body">
                                <form action="/create-livro" method="post" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="titulo"><strong>Titulo</strong></label><input class="form-control" type="text" id="titulo" placeholder="Titulo" name="titulo"></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="autor"><strong>Autor</strong></label><input class="form-control" type="text" id="autor" placeholder="Autor" name="autor"></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="editora"><strong>Editora</strong></label><input class="form-control" type="text" id="editora" placeholder="Editora" name="editora"></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="quantidade"><strong>Quantidade</strong></label><input class="form-control" type="text" id="quantidade" placeholder="Quantidade" name="quantidade"></div>
                                        </div>
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="anoPublicacao"><strong>Ano de publicação</strong></label><input class="form-control" type="text" id="anoPublicacao" placeholder="Ano de publicação" name="anoPublicacao"></div>
                                        </div>
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="isbn"><strong>ISBN 10 ou 13</strong></label><input class="form-control" type="text" id="isbn" placeholder="ISBN" name="isbn"></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="location"><strong>Localização</strong></label><input class="form-control" type="text" id="location" placeholder="Localização" name="location"></div>
                                        </div>
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="categoria"><strong>Categoria</strong></label><input class="form-control" type="text" id="categoria" placeholder="Categoria" name="categoria"></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label" for="sinopse"><strong>Sinopse</strong></label><textarea class="form-control" id="sinopse" style="height: 160px;" name="sinopse"></textarea></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="mb-3"><label class="form-label"><strong>Imagem de capa</strong></label><input class="form-control" type="file" name="image" id="image"></div>
                                        </div>
                                    </div>
                                    <div class="mb-3"><button class="btn btn-primary btn-sm" type="submit">Salvar</button></div>
                                </form>
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
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>