<!DOCTYPE html>
<html data-bs-theme="light" lang="pt-br">

<head>
    <%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>

<body class="bg-gradient-primary" style="background: rgb(2,72,115);">
    <div class="container">
        <div class="card shadow-lg o-hidden border-0 my-5">
            <div class="card-body p-0">
                <div class="row" style="height: 677.781px;">
                    <div class="col-lg-5 d-none d-lg-flex">
                        <div class="flex-grow-1 bg-register-image" style="background: url(&quot;assets/img/dogs/books-bookstore-book-reading-159711.jpeg&quot;) center no-repeat, #ffffff;"></div>
                    </div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center" style="margin-bottom: 30px;">
                                <h4 class="text-dark mb-4">Confirme o empréstimo</h4>
                                <div class="row">
                                    <div class="col-xxl-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <h4 class="card-title">${livro.titulo}</h4><img src="${livro.image}" style="width: 200px;height: 300px;">
                                                <p class="card-text" style="margin-top: 16px;">Confirme a data de devolução</p>
                                                <form action="/aluguel-confirm" method="post" id="emprestimoForm">
                                                    <input type="date" name="dataDevolucao" id="datadev" style="height: 50px;width: 220px;text-align: center;">
                                                    <input type="hidden" id="dateini" name="dataEmprestimo">
                                                    <input type="hidden" id="cidlivro" name="idLivro" value="${livro.id}">
                                                    <input type="hidden" id="iduser" name="idUsuario" value="${sessionScope.user.id}">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div style="text-align: center;">
                                <div class="row" style="text-align: center;display: inline-flex;">
                                    <div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 col-xxl-4" style="text-align: center;display: block;"><a href="scanner.jsp"><i class="far fa-arrow-alt-circle-left" style="font-size: 43px;color: rgb(2,72,115);" href="scanner.html"></i></a></div>
                                    <div class="col-7 col-sm-7 col-md-7 col-lg-7 col-xl-7 col-xxl-7" style="text-align: center;"><button class="btn btn-primary" type="button" style="background: rgb(2,72,115);border-color: rgb(2,72,115);text-align: center;overflow: visible;" onclick="document.getElementById('emprestimoForm').submit();">Confirmar</button></div>
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
        const today = new Date();
        const formattedDate = today.toISOString().split('T')[0];
        document.getElementById('dateini').value = formattedDate;
    </script>
</body>

</html>