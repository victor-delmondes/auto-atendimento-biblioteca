<!DOCTYPE html>
<html data-bs-theme="light" lang="pt-br">

<head>
    <%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>biblioteca</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="../assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/fonts/fontawesome5-overrides.min.css">
</head>

<body>

<!-- Toast Notification -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
    <div id="successToast" class="toast align-items-center text-white bg-success border-0" role="alert"
         aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                Dados alterados com sucesso.
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                    aria-label="Close"></button>
        </div>
    </div>
</div>


<!-- Verifica o parâmetro "success" na URL e ativa o toast -->
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.has('success')) {
            const successToast = new bootstrap.Toast(document.getElementById('successToast'));
            successToast.show();
        }
    });
</script>

<div id="wrapper">
    <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark"
         style="background: linear-gradient(rgb(2,72,115), #022840), rgb(2,72,115);">
        <div class="container-fluid d-flex flex-column p-0"><a
                class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
            <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-book"></i></div>
            <div class="sidebar-brand-text mx-3"><span>Biblioteca</span></div>
        </a>
            <hr class="sidebar-divider my-0">
            <ul class="navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item"><a class="nav-link" href="indexADM"><i
                        class="fa fa-book"></i><span>Livros</span></a></li>
                <li class="nav-item"><a class="nav-link" href="addlivroADM.jsp"><i class="far fa-edit"
                                                                                   style="margin-right: 4px;font-size: 12px;"></i><span>Adicionar livro</span></a>
                </li>
                <li class="nav-item"><a class="nav-link" href="gerenciarusersADM"><i class="fas fa-user"></i><span>Gerenciar usuários</span></a>
                </li>
                <li class="nav-item"><a class="nav-link" href="gerenciaremprestimosADM"><i
                        class="far fa-calendar-alt"></i><span>Gerenciar empréstimos</span></a></li>
                <li class="nav-item"><a class="nav-link active" href="confADM.jsp"><i
                        class="fas fa-user-circle"></i><span>Configurações de ADM</span></a></li>
            </ul>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-expand bg-white shadow mb-4 topbar">
                <div class="container-fluid">
                    <button class="btn btn-primary" type="button" onclick="window.location.href='${pageContext.request.contextPath}/logout'" style="width: 100.7656px;background: rgb(2,72,115);border-color: rgb(2,72,115);">Sair</button>
                </div>
            </nav>
            <div class="container-fluid">
                <h3 class="text-dark mb-1">Gerenciar perfil de ADM</h3>
                <div>
                    <div class="card shadow mb-3">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 fw-bold">Dados de ADM</p>
                        </div>
                        <div class="card-body">
                            <form action="/update-user" method="post">
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label"
                                                                 for="nomeinput"><strong>Nome</strong></label><input
                                                class="form-control" type="text" id="nomeinput" placeholder="Nome"
                                                name="nome" value="${sessionScope.user.nome}" required></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label" for="emailinput"><strong>Endereço de
                                            Email</strong></label><input class="form-control" type="email"
                                                                         id="emailinput" placeholder="Email"
                                                                         name="email"
                                                                         value="${sessionScope.user.email}" required</div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label"
                                                                 for="senhainput"><strong>Senha</strong></label><input
                                                class="form-control" type="password" id="senhainput" name="senha"
                                                value="${sessionScope.user.senha}" required></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label"
                                                                 for="enderecoinput"><strong>Endereço</strong></label><input
                                                class="form-control" type="text" id="enderecoinput"
                                                placeholder="Endereço" name="endereco"
                                                value="${sessionScope.user.endereco}" required></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label" for="cpfinput"><strong>CPF</strong></label><input
                                                class="form-control" type="text" id="cpfinput" placeholder="CPF"
                                                name="cpf" value="${sessionScope.user.CPF}" required></div>
                                    </div>
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label"
                                                                 for="telefoneinput"><strong>Telefone</strong></label><input
                                                class="form-control" type="text" id="telefoneinput"
                                                placeholder="Telefone" name="telefone"
                                                value="${sessionScope.user.telefone}" required></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label"
                                                                 for="cidade-input"><strong>Cidade</strong></label><input
                                                class="form-control" type="text" id="cidade-input" placeholder="Cidade"
                                                name="cidade" value="${sessionScope.user.cidade}" required></div>
                                    </div>
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label"
                                                                 for="estadoinput"><strong>Estado</strong></label><input
                                                class="form-control" type="text" id="estadoinput" placeholder="Estado"
                                                name="estado" estado value="${sessionScope.user.estado}" required></div>
                                    </div>
                                </div>
                                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                                <input type="hidden" name="tipo" value="${sessionScope.user.tipo}">
                                <div class="mb-3">
                                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>
                                </div>
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
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/theme.js"></script>
</body>

</html>