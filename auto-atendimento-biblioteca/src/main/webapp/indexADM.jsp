<!DOCTYPE html>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html data-bs-theme="light" lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Blank Page - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
</head>

<body id="page-top">
    <div id="wrapper">
        <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark" style="background: linear-gradient(rgb(2,72,115), #022840), rgb(2,72,115);">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                    <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-book"></i></div>
                    <div class="sidebar-brand-text mx-3"><span>Biblioteca</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar-1">
                    <li class="nav-item"><a class="nav-link active" href="indexADM.html"><i class="fa fa-book"></i><span>Livros</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="addlivroADM.jsp"><i class="far fa-edit" style="margin-right: 4px;font-size: 12px;"></i><span>Adicionar livro</span></a></li>
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
                    <h3 class="text-dark mb-1">Livros</h3>
                    <div>
                        <div class="card" style="margin-top: 10px;">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th style="width: 120.844px;">Imagem</th>
                                                <th>Titulo</th>
                                                <th style="width: 184.469px;">Quantidade disponível</th>
                                                <th style="width: 104.984px;"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="livro" items="${livros}">
                                            <tr>
                                                <td><img src="${livro.image}" alt="imagem de um livro" style="height: 150px;"></td>
                                                <td>${livro.titulo}</td>
                                                <td>${livro.quantidade}</td>
                                                <td style="text-align: center;">
                                                    <div class="dropdown" style="text-align: right;"><button class="btn btn-primary dropdown-toggle data-bs-container" aria-expanded="false" data-bs-toggle="dropdown" type="button" style="border-color: rgb(2,72,115);background: rgb(2,72,115);overflow: visible;" data-bs-container="body">Ações</button>
                                                        <div class="dropdown-menu">
                                                            <a class="dropdown-item" href="#modal-editar"
                                                               data-bs-toggle="modal"
                                                               data-bs-target="#modal-editar"
                                                               data-tituloEditar="${livro.titulo}"
                                                               data-autorEditar="${livro.autor}"
                                                               data-editoraEditar="${livro.editora}"
                                                               data-anoEditar="${livro.anoPublicacao}"
                                                               data-categoriaEditar="${livro.categoria}"
                                                               data-sinopseEditar="${livro.sinopse}"
                                                               data-unidadesEditar="${livro.quantidade}"
                                                               data-locationEditar="${livro.location}"
                                                               data-idLivroEditar="${livro.id}"
                                                               data-isbnEditar="${livro.isbn}"
                                                               data-imageEditar="${livro.image}"
                                                            >Editar</a>

                                                            <a class="dropdown-item" href="#modal-info"
                                                               data-bs-target="#modal-info"
                                                               data-bs-toggle="modal"
                                                               data-titulo="${livro.titulo}"
                                                               data-imagem="${livro.image}"
                                                               data-autor="${livro.autor}"
                                                               data-editora="${livro.editora}"
                                                               data-ano="${livro.anoPublicacao}"
                                                               data-categoria="${livro.categoria}"
                                                               data-sinopse="${livro.sinopse}"
                                                               data-unidades="${livro.quantidade}"
                                                               data-location="${livro.location}">Mais informações</a>

                                                            <a class="dropdown-item" href="#modal-deletar"
                                                               data-bs-toggle="modal"
                                                               data-bs-target="#modal-deletar"
                                                               data-idLivroDelete="${livro.id}">Deletar</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
        <div class="modal fade" role="dialog" tabindex="-1" id="modal-deletar">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Atenção!</h4><button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <p>Isso apagara permanentemente o livro do banco de dados. Deseja confirmar?</p>
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" type="button" data-bs-dismiss="modal">Fechar</button><form action="/deletelivro" method="post"><input type="hidden" id="modal-idLivroDelete" name="id"><button class="btn btn-primary" type="submit" style="background: var(--bs-red);border-color: var(--bs-red);">Sim</button></form></div>
                </div>
            </div>
        </div>
        <div class="modal fade" role="dialog" tabindex="-1" id="modal-info">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="modal-titulo">Titulo</h4><button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
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
                    <div class="modal-footer"><button class="btn btn-light" type="button" data-bs-dismiss="modal" style="background: rgb(2,72,115);color: var(--bs-btn-bg);">Fechar</button></div>
                </div>
            </div>
        </div>

        <div class="modal fade" role="dialog" tabindex="-1" id="modal-editar">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar</h4><button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form id="form-editar" action="/update-livro" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-tituloEditar"><strong>Titulo</strong></label><input class="form-control" type="text" id="modal-tituloEditar" placeholder="Titulo" name="titulo"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-autorEditar"><strong>Autor</strong></label><input class="form-control" type="text" id="modal-autorEditar" placeholder="Autor" name="autor"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-editoraEditar"><strong>Editora</strong></label><input class="form-control" type="text" id="modal-editoraEditar" placeholder="Editora" name="editora"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-unidadesEditar"><strong>Quantidade</strong></label><input class="form-control" type="text" id="modal-unidadesEditar" placeholder="Quantidade" name="quantidade"></div>
                                </div>
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-anoEditar"><strong>Ano de publicação</strong></label><input class="form-control" type="text" id="modal-anoEditar" placeholder="Ano de publicação" name="anoPublicacao"></div>
                                </div>
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-isbnEditar"><strong>ISBN 10 ou 13</strong></label><input class="form-control" type="text" id="modal-isbnEditar" placeholder="ISBN" name="isbn"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-locationEditar"><strong>Localização</strong></label><input class="form-control" type="text" id="modal-locationEditar" placeholder="Localização" name="location"></div>
                                </div>
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-categoriaEditar"><strong>Categoria</strong></label><input class="form-control" type="text" id="modal-categoriaEditar" placeholder="Categoria" name="categoria"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-sinopseEditar"><strong>Sinopse</strong></label><textarea class="form-control" id="modal-sinopseEditar" style="height: 160px;" name="sinopse"></textarea></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3"><label class="form-label" for="modal-imageEditar"><strong>Imagem de capa</strong></label><input class="form-control" type="file" id="image" name="image"></div>
                                </div>
                            </div>
                            <div><input type="hidden" id="modal-idLivroEditar" name="id">
                                <input type="hidden" id="modal-imageEditar" name="existingImage">
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" type="button" data-bs-dismiss="modal">Fechar</button><button class="btn btn-primary" type="button" onclick="submitForm()" style="background: rgb(2,72,115);border-color: rgb(2,72,115);">Salvar</button></div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function submitForm() {
            document.getElementById("form-editar").submit();
        }
    </script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>
    <script>
        var modal = document.getElementById('modal-info');
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

    <script>
        var modalDeletar = document.getElementById('modal-deletar');
        modalDeletar.addEventListener('show.bs.modal', function (event) {
            var link = event.relatedTarget; // O link que abriu o modal
            var idLivro = link.getAttribute('data-idLivroDelete');

            // Atualiza o conteúdo do modal
            modalDeletar.querySelector('#modal-idLivroDelete').value = idLivro;
        });
    </script>

    <script>
        var modalEditar = document.getElementById('modal-editar');
        modalEditar.addEventListener('show.bs.modal', function (event) {
            var link = event.relatedTarget; // O link que abriu o modal
            var titulo = link.getAttribute('data-tituloEditar');
            var autor = link.getAttribute('data-autorEditar');
            var editora = link.getAttribute('data-editoraEditar');
            var unidades = link.getAttribute('data-unidadesEditar');
            var ano = link.getAttribute('data-anoEditar');
            var isbn = link.getAttribute('data-isbnEditar');
            var location = link.getAttribute('data-locationEditar');
            var categoria = link.getAttribute('data-categoriaEditar');
            var sinopse = link.getAttribute('data-sinopseEditar');
            var idLivro = link.getAttribute('data-idLivroEditar');
            var image = link.getAttribute('data-imageEditar');

            // Atualiza o conteúdo do modal
            modalEditar.querySelector('#modal-tituloEditar').value = titulo;
            modalEditar.querySelector('#modal-autorEditar').value = autor;
            modalEditar.querySelector('#modal-editoraEditar').value = editora;
            modalEditar.querySelector('#modal-unidadesEditar').value = unidades;
            modalEditar.querySelector('#modal-anoEditar').value = ano;
            modalEditar.querySelector('#modal-isbnEditar').value = isbn;
            modalEditar.querySelector('#modal-locationEditar').value = location;
            modalEditar.querySelector('#modal-categoriaEditar').value = categoria;
            modalEditar.querySelector('#modal-sinopseEditar').value = sinopse;
            modalEditar.querySelector('#modal-idLivroEditar').value = idLivro;
            modalEditar.querySelector('#modal-imageEditar').value = image;
        });
    </script>
</body>

</html>