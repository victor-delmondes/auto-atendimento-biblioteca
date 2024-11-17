<!DOCTYPE html>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html data-bs-theme="light" lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>

<body class="bg-gradient-primary" style="background: rgb(2,72,115);">
<div class="container">
    <div class="row justify-content-center" style="padding-bottom: 0px;">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5" style="height: 552.359px;">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex">
                            <div class="flex-grow-1 bg-login-image" style="background: url(assets/img/dogs/books-bookstore-book-reading-159711.jpeg);"></div>
                        </div>
                        <div class="col-lg-6" style="height: 553.359px;">
                            <div class="p-5">
                                <div class="text-center">
                                    <!-- Mensagem padrão -->
                                    <h4 class="text-dark mb-4" id="welcome-message">Bem vindo de volta</h4>
                                    <!-- Mensagem de logout -->
                                    <h4 class="text-dark mb-4" id="logout-message" style="display: none;">${requestScope.message}</h4>
                                </div>
                                <form class="user" action="/login" method="post">
                                    <div class="mb-3">
                                        <input class="form-control form-control-user" type="email" id="emailinput" aria-describedby="emailHelp" placeholder="Email" name="email">
                                    </div>
                                    <div class="mb-3">
                                        <input class="form-control form-control-user" type="password" id="senhainput" placeholder="Senha" name="senha">
                                    </div>
                                    <div class="mb-3"></div>
                                    <button class="btn btn-primary d-block btn-user w-100" type="submit" style="background: rgb(2,72,115);">Login</button>
                                </form>
                            </div>
                            <div style="text-align: center;">
                                <a href="index"><i class="far fa-arrow-alt-circle-left" style="font-size: 43px;color: rgb(2,72,115);" href="index"></i></a>
                            </div>
                            <div class="d-flex justify-content-center align-items-center" style="margin-top: 30px">
                                <div class="toast align-items-center text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true" id="error-toast">
                                    <div class="d-flex">
                                        <div class="toast-body">
                                        </div>
                                        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Verifica se há uma mensagem de logout
        const message = "${requestScope.message}";
        if (message && message.trim() !== "") {
            document.getElementById("logout-message").style.display = "block";
            document.getElementById("welcome-message").style.display = "none";
        }

        // Verifica a URL para exibir o toast ou mensagem de erro
        const currentUrl = window.location.href;
        const toastEl = document.getElementById('error-toast');
        const toastBodyEl = toastEl.querySelector('.toast-body');

        // Altera a mensagem com base no tipo de erro na URL
        if (currentUrl.includes("/login.jsp?error=unauthorized")) {
            toastBodyEl.textContent = "Acesso não autorizado. Faça login para continuar.";
        } else if (currentUrl.includes("/login.jsp?error=true")) {
            toastBodyEl.textContent = "Email ou senha incorretos. Tente novamente.";
        } else {
            return;
        }

        const toast = new bootstrap.Toast(toastEl);
        toast.show();
    });
</script>

</body>

</html>
