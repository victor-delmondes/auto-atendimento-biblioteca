<!DOCTYPE html>
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
                                        <h4 class="text-dark mb-4">Bem vindo de volta</h4>
                                    </div>
                                    <form class="user" action="/login">
                                        <span>${requestScope.message}</span>
                                        <div class="mb-3"><input class="form-control form-control-user" type="email" id="emailinput" aria-describedby="emailHelp" placeholder="Email" name="email"></div>
                                        <div class="mb-3"><input class="form-control form-control-user" type="password" id="senhainput" placeholder="Senha" name="senha"></div>
                                        <div class="mb-3"></div><button class="btn btn-primary d-block btn-user w-100" type="submit" style="background: rgb(2,72,115);">Login</button>
                                    </form>
                                </div>
                                <div style="text-align: center;"><a href="index"><i class="far fa-arrow-alt-circle-left" style="font-size: 43px;color: rgb(2,72,115);" href="index"></i></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>