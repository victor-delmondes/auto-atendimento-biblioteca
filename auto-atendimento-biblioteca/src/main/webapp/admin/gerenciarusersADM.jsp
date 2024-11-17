<!DOCTYPE html>
<html data-bs-theme="light" lang="pt-br">
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>biblioteca</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="../assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/fonts/fontawesome5-overrides.min.css">
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
                <li class="nav-item"><a class="nav-link" href="indexADM"><i class="fa fa-book"></i><span>Livros</span></a></li>
                <li class="nav-item"><a class="nav-link" href="addlivroADM.jsp"><i class="far fa-edit" style="margin-right: 4px;font-size: 12px;"></i><span>Adicionar livro</span></a></li>
                <li class="nav-item"><a class="nav-link active" href="gerenciarusersADM"><i class="fas fa-user"></i><span>Gerenciar usuários</span></a></li>
                <li class="nav-item"><a class="nav-link" href="gerenciaremprestimosADM.html"><i class="far fa-calendar-alt"></i><span>Gerenciar empréstimos</span></a></li>
                <li class="nav-item"><a class="nav-link" href="confADM.jsp"><i class="fas fa-user-circle"></i><span>Configurações de ADM</span></a></li>
            </ul>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-expand bg-white shadow mb-4 topbar">
                <div class="container-fluid">
                    <button class="btn btn-primary" type="button" style="width: 100.7656px;background: rgb(2,72,115);border-color: rgb(2,72,115);">Sair</button>
                </div>
            </nav>
            <div class="container-fluid">
                <h3 class="text-dark mb-1">Gestão de usuários</h3>
                <div>
                    <div class="card" style="margin-top: 10px;overflow: visible;">
                        <div class="card-body">
                            <div class="table-responsive" style="overflow: visible;">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th style="width: 300px;">Usuário</th>
                                        <th style="width: 190.312px;">Alugueis ativos</th>
                                        <th style="width: 300.562px;">Email</th>
                                        <th style="width: 41.312px;"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <td>${user.nome}</td>
                                            <td><span style="margin-right: 10px;">Text</span>
                                                <button class="btn btn-primary" type="button" style="background: rgb(2,72,115);border-color: rgb(2,72,115);" data-bs-target="#modal-emprestimos" data-bs-toggle="modal">Ver</button>
                                            </td>
                                            <td>${user.email}</td>
                                            <td>
                                                <div class="dropdown" style="text-align: right;">
                                                    <button class="btn btn-primary dropdown-toggle data-bs-container" aria-expanded="false" data-bs-toggle="dropdown" type="button" style="border-color: rgb(2,72,115);background: rgb(2,72,115);overflow: visible;" data-bs-container="body">Ações</button>
                                                    <div class="dropdown-menu">
                                                        <a class="dropdown-item" href="#modal-editar"
                                                           data-bs-target="#modal-editar"
                                                           data-bs-toggle="modal"
                                                           data-nome="${user.nome}"
                                                           data-email="${user.email}"
                                                           data-senha="${user.senha}"
                                                           data-endereco="${user.endereco}"
                                                           data-telefone="${user.telefone}"
                                                           data-cpf="${user.CPF}"
                                                           data-cidade="${user.cidade}"
                                                           data-estado="${user.estado}"
                                                           data-tipo="${user.tipo}"
                                                           data-id="${user.id}"
                                                        >Editar</a>
                                                        <a class="dropdown-item" href="#modal-exibir"
                                                           data-bs-target="#modal-exibir"
                                                           data-bs-toggle="modal"
                                                           data-email="${user.email}"
                                                           data-nome="${user.nome}"
                                                           data-senha="${user.senha}"
                                                           data-endereco="${user.endereco}"
                                                           data-telefone="${user.telefone}"
                                                           data-cpf="${user.CPF}"
                                                           data-cidade="${user.cidade}"
                                                           data-estado="${user.estado}"
                                                           data-tipo="${user.tipo}"
                                                        >Exibir</a>
                                                        <a class="dropdown-item" href="#modal-deletar"
                                                           data-bs-target="#modal-deletar"
                                                           data-bs-toggle="modal"
                                                           data-id="${user.id}"
                                                        >Deletar</a>
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
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<div class="modal fade modal-xl" role="dialog" tabindex="-1" id="modal-emprestimos">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Empréstimos ativos do usuário&nbsp;</h4>
                <button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Titulo</th>
                            <th style="width: 180px;">Data de empréstimo</th>
                            <th style="width: 180px;">Data de devolução</th>
                            <th style="width: 180px;">Situação</th>
                            <th style="width: 100px;"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Cell 1</td>
                            <td>Cell 2</td>
                            <td>Cell 3</td>
                            <td>Cell 4</td>
                            <td>
                                <button class="btn btn-primary" type="button" style="background: rgb(2,72,115);border-color: rgb(2,72,115);">Devolver</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" style="background: rgb(2,72,115);border-color: rgb(2,72,115);" data-bs-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade modal-lg" role="dialog" tabindex="-1" id="modal-editar">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Editar usuário</h4>
                <button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form id="form-editar" action="/update-users" method="post">
                    <div class="row">
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-nomeEditar"><strong>Nome</strong></label><input class="form-control" type="text" id="modal-nomeEditar" placeholder="Nome" name="nome"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-emailEditar"><strong>Endereço de Email</strong></label><input class="form-control" type="email" id="modal-emailEditar" placeholder="Email" name="email"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="mb-3"><label class="form-label" for="modal-senhaEditar"><strong>Senha</strong></label><input class="form-control" type="password" id="modal-senhaEditar" name="senha"></div>
                        </div>
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-tipoEditar"><strong>Tipo</strong></label><select class="form-select" id="modal-tipoEditar" name="tipo">
                                <optgroup label="Selecione o tipo de usuário">
                                    <option value="true">Admin</option>
                                    <option value="false">Comum</option>
                                </optgroup>
                            </select></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-enderecoEditar"><strong>Endereço</strong></label><input class="form-control" type="text" id="modal-enderecoEditar" placeholder="Endereço" name="endereco"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-cpfEditar"><strong>CPF</strong></label><input class="form-control" type="text" id="modal-cpfEditar" placeholder="CPF" name="cpf"></div>
                        </div>
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-telefoneEditar"><strong>Telefone</strong></label><input class="form-control" type="text" id="modal-telefoneEditar" placeholder="Telefone" name="telefone"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-cidadeEditar"><strong>Cidade</strong></label><input class="form-control" type="text" id="modal-cidadeEditar" placeholder="Cidade" name="cidade"></div>
                        </div>
                        <div class="col">
                            <div class="mb-3"><label class="form-label" for="modal-estadoEditar"><strong>Estado</strong></label><input class="form-control" type="text" id="modal-estadoEditar" placeholder="Estado" name="estado"></div>
                        </div>
                    </div>
                    <input type="hidden" name="id" id="modal-idEditar">
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-light" type="button" data-bs-dismiss="modal">Fechar</button>
                <button class="btn btn-primary" type="button" onclick="submitForm()" style="background: rgb(2,72,115);">Salvar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="modal-exibir">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Informações</h4>
                <button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <p>Nome:&nbsp;<span id="modal-nome"></span></p>
                <p>Email:&nbsp;<span id="modal-email"></span></p>
                <p>Telefone:&nbsp;<span id="modal-telefone"></span></p>
                <p>Cidade:&nbsp;<span id="modal-cidade"></span></p>
                <p>Estado:&nbsp;<span id="modal-estado"></span></p>
                <p>Endereço:&nbsp;<span id="modal-endereco"></span></p>
                <p>CPF:&nbsp;<span id="modal-cpf"></span></p>
                <p>Tipo: <span id="modal-tipo"></span></p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-light" type="button" data-bs-dismiss="modal" style="background: rgb(2,72,115);border-color: rgb(2,72,115);color: var(--bs-body-bg);">Fechar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="modal-deletar">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Atenção</h4>
                <button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <p>Você vai apagar permanentemente o usuário e todas suas informações. Deseja continuar?</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-light" type="button" data-bs-dismiss="modal">Fechar</button>
                <form action="/delete-user" method="post"><input type="hidden" id="modal-idDelete" name="id">
                    <button class="btn btn-primary" type="submit" style="background: var(--bs-danger);border-color: var(--bs-danger);">Sim</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/theme.js"></script>

<script>
    var modal = document.getElementById('modal-exibir');
    modal.addEventListener('show.bs.modal', function (event) {
        var link = event.relatedTarget; // O link que abriu o modal
        var nome = link.getAttribute('data-nome');
        var email = link.getAttribute('data-email');
        var cpf = link.getAttribute('data-cpf');
        var telefone = link.getAttribute('data-telefone');
        var cidade = link.getAttribute('data-cidade');
        var estado = link.getAttribute('data-estado');
        var endereco = link.getAttribute('data-endereco');
        var tipo = link.getAttribute('data-tipo');

        var tipoTexto = tipo === 'true' ? 'Admin' : 'Usuário normal';

        // Atualiza o conteúdo do modal
        modal.querySelector('#modal-nome').textContent = nome;
        modal.querySelector('#modal-email').textContent = email;
        modal.querySelector('#modal-telefone').textContent = telefone;
        modal.querySelector('#modal-cidade').textContent = cidade;
        modal.querySelector('#modal-estado').textContent = estado;
        modal.querySelector('#modal-endereco').textContent = endereco;
        modal.querySelector('#modal-cpf').textContent = cpf;
        modal.querySelector('#modal-tipo').textContent = tipoTexto;
    });
</script>

<script>
    var modalDeletar = document.getElementById('modal-deletar');
    modalDeletar.addEventListener('show.bs.modal', function (event) {
        var link = event.relatedTarget; // O link que abriu o modal
        var id = link.getAttribute('data-id');

        // Atualiza o conteúdo do modal
        modalDeletar.querySelector('#modal-idDelete').value = id;
    });
</script>

<script>
    var modalEditar = document.getElementById('modal-editar');
    modalEditar.addEventListener('show.bs.modal', function (event) {
        var link = event.relatedTarget; // O link que abriu o modal
        var nome = link.getAttribute('data-nome');
        var email = link.getAttribute('data-email');
        var senha = link.getAttribute('data-senha');
        var cpf = link.getAttribute('data-cpf');
        var endereco = link.getAttribute('data-endereco');
        var telefone = link.getAttribute('data-telefone');
        var cidade = link.getAttribute('data-cidade');
        var estado = link.getAttribute('data-estado');
        var tipo = link.getAttribute('data-tipo');
        var id = link.getAttribute('data-id');

        // Atualiza o conteúdo do modal de edição
        modalEditar.querySelector('#modal-nomeEditar').value = nome;
        modalEditar.querySelector('#modal-emailEditar').value = email;
        modalEditar.querySelector('#modal-senhaEditar').value = senha;
        modalEditar.querySelector('#modal-cpfEditar').value = cpf;
        modalEditar.querySelector('#modal-enderecoEditar').value = endereco;
        modalEditar.querySelector('#modal-telefoneEditar').value = telefone;
        modalEditar.querySelector('#modal-cidadeEditar').value = cidade;
        modalEditar.querySelector('#modal-estadoEditar').value = estado;

        // Lógica para selecionar a opção correta no campo "Tipo"
        var selectTipo = modalEditar.querySelector('#modal-tipoEditar');
        if (tipo === 'true') {
            selectTipo.value = 'true'; // Valor da opção "Admin"
        } else {
            selectTipo.value = 'false'; // Valor da opção "Comum"
        }

        modalEditar.querySelector('#modal-idEditar').value = id;
    });
</script>

<script>
    function submitForm() {
        document.getElementById("form-editar").submit();
    }
</script>

</body>

</html>